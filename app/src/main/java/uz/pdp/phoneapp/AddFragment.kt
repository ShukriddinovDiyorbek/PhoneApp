package uz.pdp.phoneapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.pdp.phoneapp.db.MyDatabaseHelper
import uz.pdp.phoneapp.model.Phone

class AddFragment : Fragment() {
    lateinit var root: View
    lateinit var myDatabaseHelper: MyDatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_add, container, false)
        if (arguments != null) {
            activity?.setTitle("Add phone")
            activity?.titleColor = (Color.BLACK)
            val phone = arguments?.getString("phone")
            val phone_name = root.findViewById<EditText>(R.id.phone_name)
            val add_btn = root.findViewById<Button>(R.id.add_btn)
            val phone_features = root.findViewById<EditText>(R.id.phone_features)
            add_btn.setOnClickListener {
                if (phone_name.text.length>0 && phone_features.text.length>0){
                    val item = Phone(phone!!,phone_name.text.toString(),phone_features.text.toString())
                    myDatabaseHelper.addPhone(item)
                    Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(context, "To'liq to'ldiring", Toast.LENGTH_SHORT).show()
                }
            }

        } else {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myDatabaseHelper = MyDatabaseHelper(context)
    }
}