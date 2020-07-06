package com.ejemplo.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ejemplo.recyclerview.R
import com.ejemplo.recyclerview.models.User
import com.ejemplo.recyclerview.utilidades.CellClickListener
import com.squareup.picasso.Picasso

class CustomAdapter(val context: Context, val userList: ArrayList<User>, val cellClickListener: CellClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //este método devuelve la vista para cada elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //Este método vincula los datos en la lista
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener()
        }
    }

    // Este método está dando el tamaño de la lista
    override fun getItemCount(): Int {
        return userList.size
    }

    // la clase está ocultando la vista de lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            val myImageView: ImageView = itemView.findViewById<ImageView>(R.id.myImageView)

            textViewName.text = user.name
            textViewAddress.text = user.address
            Picasso.get().load(user.imagen).into(myImageView)

        }
    }

}