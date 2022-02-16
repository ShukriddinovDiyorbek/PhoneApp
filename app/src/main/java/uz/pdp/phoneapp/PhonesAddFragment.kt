package uz.pdp.phoneapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

class PhonesAddFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("Phone types")
        activity?.titleColor = (Color.BLACK)
        root = inflater.inflate(R.layout.fragment_phones_add, container, false)
        val iphone = root.findViewById<CardView>(R.id.iphone)
        val samsung = root.findViewById<CardView>(R.id.samsung)
        val artel = root.findViewById<CardView>(R.id.artel)
        val sony = root.findViewById<CardView>(R.id.sony)
        val mi = root.findViewById<CardView>(R.id.mi)
        val huawei = root.findViewById<CardView>(R.id.huawei)
        val bundle = Bundle()
        iphone.setOnClickListener {
            bundle.putString("phone","iPhone")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        samsung.setOnClickListener {
            bundle.putString("phone","Samsung")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        artel.setOnClickListener {
            bundle.putString("phone","Artel")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        sony.setOnClickListener {
            bundle.putString("phone","Sony")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        mi.setOnClickListener {
            bundle.putString("phone","Mi")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        huawei.setOnClickListener {
            bundle.putString("phone","Huawei")
            findNavController().navigate(R.id.addFragment,bundle)
        }
        return root
    }
}