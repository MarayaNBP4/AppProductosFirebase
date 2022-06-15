package mx.ipn.cic.appproductosfirebase.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ValueEventListener
import mx.ipn.cic.appproductosfirebase.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        @IgnoreExtraProperties
        data class Producto(val nombre: String? = null, val talla: String? = null, val color: String? = null, val precio: String? = null) {
            // Null default values create a no-argument default constructor, which is needed
            // for deserialization from a DataSnapshot.
        }

        binding.buttonRegistrar.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val referencia = database.getReference("Producto")
            val prod = Producto(binding.nombreProducto.text.toString(), binding.tallaProducto.text.toString(), binding.colorProducto.text.toString(), binding.precioProducto.text.toString())
            if(binding.nombreProducto.text.toString().isEmpty() || binding.tallaProducto.text.toString().isEmpty() || binding.colorProducto.text.toString().isEmpty() ||binding.precioProducto.text.toString().isEmpty()){
                Toast.makeText(context, "Complete los campos faltantes", Toast.LENGTH_SHORT).show()
            }else {
                referencia.push().setValue(prod).addOnCompleteListener{
                    if(it.isSuccessful) {
                        binding.nombreProducto.text = null
                        binding.tallaProducto.text = null
                        binding.colorProducto.text = null
                        binding.precioProducto.text = null
                        Toast.makeText(context, "Registro adecuado", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

