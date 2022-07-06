package lazycoder21.droid.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lazycoder21.droid.myapplication.model.PixelBay
import lazycoder21.droid.myapplication.data.repository.PixelRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PixelRepository
) : ViewModel() {

    private val _items: MutableLiveData<PixelBay?> = MutableLiveData()
    val items: LiveData<PixelBay?> = _items

    fun getItems() {
        viewModelScope.launch {
            val data = repository.getPixelsImage()
            _items.postValue(data)
        }
    }
}