package com.applecompose.goldprices.di

import com.applecompose.goldprices.data.api.ApiConstants
import com.applecompose.goldprices.data.api.MetalsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MetalsApiModule {

	@Provides
	@Singleton
	fun provideApi(builder:Retrofit.Builder): MetalsApi {
		return builder
			.build()
			.create(MetalsApi::class.java)
	}

	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit.Builder{
		return Retrofit.Builder()
			.baseUrl(ApiConstants.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())



	}
}