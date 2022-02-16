package uz.pdp.phoneapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

class PhonesFragment : Fragment() {
    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("Phones")
        activity?.titleColor = (Color.BLACK)
        root = inflater.inflate(R.layout.fragment_phones, container, false)

        val iphone = root.findViewById<CardView>(R.id.iphone1)
        val samsung = root.findViewById<CardView>(R.id.samsung1)
        val artel = root.findViewById<CardView>(R.id.artel1)
        val sony = root.findViewById<CardView>(R.id.sony1)
        val mi = root.findViewById<CardView>(R.id.mi1)
        val huawei = root.findViewById<CardView>(R.id.huawei1)
        val bundle = Bundle()
        iphone.setOnClickListener {
            bundle.putString("phone","iPhone")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        samsung.setOnClickListener {
            bundle.putString("phone","Samsung")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        artel.setOnClickListener {
            bundle.putString("phone","Artel")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        sony.setOnClickListener {
            bundle.putString("phone","Sony")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        mi.setOnClickListener {
            bundle.putString("phone","Mi")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        huawei.setOnClickListener {
            bundle.putString("phone","Huawei")
            findNavController().navigate(R.id.phoneTypeFragment,bundle)
        }
        return root
    }
}