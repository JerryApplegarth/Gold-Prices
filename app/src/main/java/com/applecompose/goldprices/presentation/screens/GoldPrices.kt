package com.applecompose.goldprices.presentation.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.goldprices.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GoldPrices() {


	val scaffoldState = rememberScaffoldState()
	val scope = rememberCoroutineScope()

	Scaffold(
		scaffoldState = scaffoldState,
		topBar = { TopBar(scaffoldState = scaffoldState, scope = scope) },
		drawerContent = { DrawerContent() },
		bottomBar = { SimpleBottomBar() }

	) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp)

		) {
			Text(
				modifier = Modifier
					.fillMaxWidth(),
				text = "Current Gold Prices!!",
				fontSize = 24.sp,
				fontStyle = FontStyle.Normal,
				fontWeight = FontWeight.Bold,
				fontFamily = FontFamily.Monospace,
				textAlign = TextAlign.Center
			)
		}
	}
}


@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
	TopAppBar(
		title = { Text(text = "Scaffold Example", color = Color.White) },
		navigationIcon = {
			IconButton(onClick = {
				scope.launch {
					scaffoldState.drawerState.open()
				}
			}) {
				Icon(
					painter = painterResource(id = R.drawable.ic_menu),
					contentDescription = "menu"
				)
			}
		},
		elevation = 8.dp
	)
}

@Composable
fun DrawerContent() {
	for (i in 0 until 5) {
		Text(text = "Item $i")
	}
}

	data class BottomBarItem(val title: String, @DrawableRes val icon: Int)

@Composable
fun SimpleBottomBar() {
	val items = listOf(
		BottomBarItem("Home", R.drawable.ic_home),
		BottomBarItem("Favourite", R.drawable.ic_person),
		BottomBarItem("Profile", R.drawable.ic_person),
		BottomBarItem("Search", R.drawable.ic_search),
	)
	BottomNavigation(elevation = 8.dp) {
		items.map {
			BottomNavigationItem(
				selected = false,
				onClick = { },
				icon = {
					Icon(
						painter = painterResource(id = it.icon),
						contentDescription = it.title
					)
				},
				label = { Text(text = it.title) },
				selectedContentColor = Color.White,
				unselectedContentColor = Color.White.copy(0.4f)

			)
		}
	}
}


	@Preview(showBackground = true)
	@Composable
	fun ScaffoldExamplesPreview() {
		GoldPrices()
	}

