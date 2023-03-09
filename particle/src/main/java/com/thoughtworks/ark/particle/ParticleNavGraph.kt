import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.ark.particle.ParticleContract
import com.thoughtworks.ark.particle.presenter.ParticleScreen
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.CoroutineScope

@Composable
fun ParticleNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    treeState: Particle,
    contract: ParticleContract
) {
    val startDestination = treeState.navigation?.let {
        it.startDestination
    } ?: "particle"

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("particle") {
            ParticleScreen(navController, treeState, contract)
        }

        treeState.navigation?.destinations?.forEach { destination ->
            destination.layout?.destination?.let {
                if (it.route.isNotBlank())
                    composable(it.route) {
                        ParticleScreen(navController, destination, contract)
                    }
            }
        }
    }
}
