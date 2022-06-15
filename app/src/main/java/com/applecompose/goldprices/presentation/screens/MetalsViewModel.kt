package com.applecompose.goldprices.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applecompose.goldprices.data.api.model.Rates
import com.applecompose.goldprices.data.repository.MetalsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MetalsViewModel @Inject constructor(
	private val metalsRepo: MetalsRepo
): ViewModel() {

	private val _state = MutableStateFlow(emptyList<Rates>())
	val state: StateFlow<List<Rates>>
	get() = _state

	init {
		viewModelScope.launch {
			val metals = metalsRepo.getRates()
			_state.value = metals
		}
	}


}