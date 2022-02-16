package uz.pdp.phoneapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.phoneapp.adapter.CustomAdapter
import uz.pdp.phoneapp.db.MyDatabaseHelper
import uz.pdp.phoneapp.model.Phone

class PhoneTypeFragment : Fragment() {
    lateinit var root: View
    lateinit var customAdapter: CustomAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var myDatabaseHelper: MyDatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_phone_type, container, false)
        if (arguments != null){
            val type = arguments?.getString("phone")
            activity?.setTitle(type)
                    activity?.titleColor = (Color.BLACK)
            recyclerView = root.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(context,1)

            customAdapter = CustomAdapter(myDatabaseHelper.getPhoneTypes(type.toString()),object :CustomAdapter.MyListener{
                override fun onClick(phone: Phone, position: Int) {
                    val bundle = Bundle()
                    bundle.putSerializable("phone",phone)
                    findNavController().navigate(R.id.infoFragment,bundle)
                }

            })
            recyclerView.adapter = customAdapter
        } else {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myDatabaseHelper = MyDatabaseHelper(context)
    }
}