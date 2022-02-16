package uz.pdp.phoneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.phoneapp.R
import uz.pdp.phoneapp.model.Phone

class CustomAdapter(var items: ArrayList<Phone>, var listener: MyListener):RecyclerView.Adapter<CustomAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.p_name.text = item.phone_type

        holder.item_linear.setOnClickListener {
            listener.onClick(item,position)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    interface MyListener{
        fun onClick(phone: Phone, position: Int)
    }
    inner class VH(view: View): RecyclerView.ViewHolder(view){
        val p_name: TextView
       val item_linear: LinearLayout
        init {
            p_name = view.findViewById(R.id.p_name)
           item_linear = view.findViewById(R.id.item_linear)
        }
    }
}