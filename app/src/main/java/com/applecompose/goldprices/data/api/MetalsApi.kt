package com.applecompose.goldprices.data.api

import com.applecompose.goldprices.data.api.model.Rates
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MetalsApi {

	@GET(ApiConstants.END_POINT)
	suspend fun getRates(): List<Rates>

	companion object{
		var apiService: ApiConstants? = null
		fun getInstance(): ApiConstants {
			if (apiService == null) {
				apiService = Retrofit.Builder()
					.baseUrl(ApiConstants.BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.build()
					.create(ApiConstants::class.java)
			}
			return apiService!!
		}
	}
}