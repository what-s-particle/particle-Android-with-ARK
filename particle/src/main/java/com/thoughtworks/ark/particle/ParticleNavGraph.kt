import android.annotation.SuppressLint
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.ark.particle.ParticleViewModel
import com.thoughtworks.ark.particle.presenter.ErrorScreen
import com.thoughtworks.ark.particle.presenter.ParticleScreen
import com.thoughtworks.ark.particle.presenter.model.Action
import com.thoughtworks.ark.particle.presenter.scaffold.ParticleModalDrawer
import com.yunlong.particle.proto.NavGraphComponent
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ParticleNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navGraph: NavGraphComponent,
    viewModel: ParticleViewModel
) {
    val startDestination = navGraph.startDestination.ifBlank { "error" }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navGraph.screens.forEach { particle ->
            if (particle.screen?.route!!.isNotBlank())
                if (particle.screen.modalDrawer != null) {
                    composable(particle.screen.route) {
                        ParticleModalDrawer(
                            drawerState = drawerState,
                            contract = viewModel.contract
                        ) {
                            ParticleScreen(particle, navController, viewModel.contract)
                        }
                    }
                } else {
                    composable(particle.screen.route) {
                        ParticleScreen(particle, navController, viewModel.contract)
                    }
                }
        }

        composable("error") {
            ErrorScreen(navController, viewModel.contract)
        }
    }

    val action by viewModel.action.collectAsState()
    when (action) {
        is Action.OpenDrawer -> coroutineScope.launch {
            drawerState.open()
        }
        is Action.NavigateTo -> navController.navigate((action as Action.NavigateTo).route)
        is Action.NavigateUp -> navController.navigateUp()
        else -> {}
    }
}
