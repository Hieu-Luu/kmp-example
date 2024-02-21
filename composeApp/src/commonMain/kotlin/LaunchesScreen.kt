import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.SpaceXSDK
import com.example.entity.RocketLaunch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LaunchesScreen(sdk: SpaceXSDK) {
    val mainScope = rememberCoroutineScope()
    var launches by remember { mutableStateOf(emptyList<RocketLaunch>()) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        displayLaunches(
            sdk,
            false, onLaunchesLoaded = {
                launches = it
            }, onLoading = {
                isLoading = it
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SpaceX Launches") },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        content = {
            LaunchesList(
                launches = launches,
                isLoading = isLoading,
                onRefresh = {
                    mainScope.launch {
                        displayLaunches(
                            sdk,
                            true, onLaunchesLoaded = {
                                launches = it
                            }, onLoading = {
                                isLoading = it
                            })
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LaunchesList(
    launches: List<RocketLaunch>,
    isLoading: Boolean,
    onRefresh: () -> Unit
) {
    val refreshing by remember { mutableStateOf(isLoading) }
    val pullRefreshState = rememberPullRefreshState(refreshing, onRefresh = onRefresh)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(Modifier.pullRefresh(pullRefreshState)) {
            LazyColumn {
                items(launches) { launch ->
                    LaunchItem(launch = launch)
                }
            }

            PullRefreshIndicator(refreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
        }
    }
}

@Composable
fun LaunchItem(launch: RocketLaunch) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Mission name: ${launch.missionName}")
            Text(text = "Launch Year: ${launch.launchYear}")
            Text(text = "Details: ${launch.details ?: "N/A"}")
            Text(
                text = "Launch Success: ${launch.launchSuccess?.let { if (it) "Successful" else "Unsuccessful" } ?: "N/A"}",
                color = when (launch.launchSuccess) {
                    true -> MaterialTheme.colors.primary
                    false -> MaterialTheme.colors.error
                    else -> MaterialTheme.colors.secondary
                }
            )
        }
    }
}

private suspend fun displayLaunches(
    sdk: SpaceXSDK,
    needReload:Boolean,
    onLaunchesLoaded: (List<RocketLaunch>) -> Unit,
    onLoading: (Boolean) -> Unit
) {
    delay(2000)
    onLoading(true)
    try {
        val launches = sdk.getLaunches(needReload)
        onLaunchesLoaded(launches)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        onLoading(false)
    }
}