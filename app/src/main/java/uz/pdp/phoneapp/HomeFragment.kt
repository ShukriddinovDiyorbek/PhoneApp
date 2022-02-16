package uz.pdp.phoneapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("Home")
        activity?.titleColor = (Color.BLACK)
        root = inflater.inflate(R.layout.fragment_home, container, false)
        val open_btn = root.findViewById<Button>(R.id.open_btn)
        val add_btn = root.findViewById<Button>(R.id.add_btn)

        open_btn.setOnClickListener {
            findNavController().navigate(R.id.phonesFragment)
        }
        add_btn.setOnClickListener {
            findNavController().navigate(R.id.phonesAddFragment)
        }
        return root
    }
}