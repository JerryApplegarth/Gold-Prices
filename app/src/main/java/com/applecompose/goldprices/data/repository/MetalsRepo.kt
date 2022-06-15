package com.applecompose.goldprices.data.repository

import com.applecompose.goldprices.data.api.MetalsApi
import com.applecompose.goldprices.data.api.model.Rates
import javax.inject.Inject

class MetalsRepo @Inject constructor(
	private val metalsApi: MetalsApi
){
	suspend fun getRates():List<Rates> {
		return metalsApi.getRates()
	}
}