package uz.pdp.phoneapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import uz.pdp.phoneapp.model.Phone


class InfoFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_info, container, false)
        val type:Phone = arguments?.getSerializable("phone") as Phone
        activity?.setTitle(type.phone_type)
        activity?.titleColor = (Color.BLACK)
        val tv_info = root.findViewById<TextView>(R.id.tv_info)
        tv_info.setText(type.features)
        return root
    }
}