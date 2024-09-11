package com.example.catfeeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catfeeapp.Model.Productos

class AdapterProductos(
    private val productos: MutableList<Productos>,
    private val context: Context
) : RecyclerView.Adapter<AdapterProductos.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_productos_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productos[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class ViewHolder(vista: View) : RecyclerView.ViewHolder(vista) {
        private val nombreProductos = vista.findViewById<TextView>(R.id.tvNombre)
        private val precio = vista.findViewById<TextView>(R.id.tvPrecio)
        private val foto = vista.findViewById<ImageView>(R.id.ivProducto)
        private val btnVermas = vista.findViewById<Button>(R.id.btnVermas)

        fun bind(productos: Productos, context: Context) {
            nombreProductos.text = productos.Nombre
            precio.text = productos.Precio
            foto.setImageResource(productos.Foto)

            btnVermas.setOnClickListener {
                val intent = Intent(context, VerMasActivity::class.java).apply {
                    putExtra("Nombre", productos.Nombre)
                    putExtra("Precio", productos.Precio)
                    putExtra("Descripcion", productos.Despcripcion)
                    putExtra("Foto", productos.Foto)
                }
                context.startActivity(intent)
            }
        }
    }
}
