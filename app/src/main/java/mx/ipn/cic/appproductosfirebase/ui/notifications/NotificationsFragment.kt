package mx.ipn.cic.appproductosfirebase.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mx.ipn.cic.appproductosfirebase.ProdlistActivity
import mx.ipn.cic.appproductosfirebase.databinding.FragmentNotificationsBinding


class NotificationsFragment: Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewbtn.setOnClickListener {
            val intent = Intent (activity, ProdlistActivity::class.java)
            activity?.startActivity(intent)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}