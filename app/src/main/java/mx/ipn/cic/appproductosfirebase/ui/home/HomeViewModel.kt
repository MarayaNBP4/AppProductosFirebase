package mx.ipn.cic.appproductosfirebase.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Este es un inventario de productos"
    }
    val text: LiveData<String> = _text
}