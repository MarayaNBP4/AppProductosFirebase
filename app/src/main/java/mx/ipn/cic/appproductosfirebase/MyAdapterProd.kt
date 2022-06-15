package mx.ipn.cic.appproductosfirebase


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapterProd(private val userList : ArrayList<Producto>) : RecyclerView.Adapter<MyAdapterProd.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {



        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.prod_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.nombre.text = currentitem.nombre
        holder.talla.text = currentitem.talla
        holder.color.text = currentitem.color
        holder.precio.text = currentitem.precio

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nombre : TextView = itemView.findViewById(R.id.tvnombre)
        val talla : TextView = itemView.findViewById(R.id.tvtalla)
        val color : TextView = itemView.findViewById(R.id.tvcolor)
        val precio : TextView = itemView.findViewById(R.id.tvprecio)

    }

}