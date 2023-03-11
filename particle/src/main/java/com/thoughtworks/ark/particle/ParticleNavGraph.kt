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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.ark.particle.ParticleViewModel
import com.thoughtworks.ark.particle.presenter.AppModalDrawer
import com.thoughtworks.ark.particle.presenter.ErrorScreen
import com.thoughtworks.ark.particle.presenter.ParticleScreen
import com.thoughtworks.ark.particle.presenter.model.Event
import com.yunlong.particle.proto.NavGraphComponent
import kotlinx.coroutines.launch
import kotlin.contracts.contract

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
        navGraph.screens.forEach { screen ->
            if (screen.layout?.screen?.route!!.isNotBlank())
                if (screen.layout.screen.modalDrawer != null) {
                    composable(screen.layout.screen.route) {
                        AppModalDrawer(drawerState = drawerState, contract = viewModel.contract) {
                            ParticleScreen(navController, screen, viewModel.contract)
                        }
                    }
                } else {
                    composable(screen.layout.screen.route) {
                        ParticleScreen(navController, screen, viewModel.contract)
                    }
                }
        }

        composable("error") {
            ErrorScreen(navController, viewModel.contract)
        }
    }

    val event by viewModel.event.collectAsState()
    when (event) {
        is Event.OpenDrawer -> coroutineScope.launch {
            drawerState.open()
        }
        is Event.NavigateTo -> navController.navigate((event as Event.NavigateTo).route)
        is Event.NavigateUp -> navController.navigateUp()
        else -> {}
    }
}
