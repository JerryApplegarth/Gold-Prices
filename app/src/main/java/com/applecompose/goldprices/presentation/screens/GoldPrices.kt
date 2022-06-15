package com.applecompose.goldprices.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applecompose.goldprices.data.api.model.Rates
import com.applecompose.goldprices.ui.theme.newBackgroundColor

@Composable
fun GoldPrices() {

	val metalsViewModel = viewModel(modelClass = MetalsViewModel::class.java)
	val state by metalsViewModel.state.collectAsState()

	LazyColumn {
		if (state.isEmpty()) {
			item {
				CircularProgressIndicator(
					modifier = Modifier
						.fillMaxSize()
						.wrapContentSize(align = Alignment.Center)
				)
			}
			items(state) {rates: Rates ->
				MetalImageCard(rates = rates)

			}

		}
	}
}

@Composable
fun MetalImageCard(rates: Rates) {

	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)
			.background(MaterialTheme.colors.newBackgroundColor),
		shape = RoundedCornerShape(16.dp)
	) {
		Text(
			text = "Gold: ${rates.XAU}",
			fontSize = 20.sp,
			fontFamily = FontFamily.Monospace,
			fontWeight = FontWeight.Bold
			)
		Text(
			text = "Gold: ${rates.XAG}",
			fontSize = 20.sp,
			fontFamily = FontFamily.Monospace,
			fontWeight = FontWeight.Bold
		)


	}




}

