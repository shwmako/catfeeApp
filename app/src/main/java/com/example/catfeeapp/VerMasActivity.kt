package com.example.catfeeapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catfeeapp.databinding.ActivityVerMasBinding

class VerMasActivity : AppCompatActivity() {
    lateinit var binding: ActivityVerMasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerMasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.mi_color_status_bar)
        }

        // Recupera los datos del Intent
        val nombre = intent.getStringExtra("Nombre")
        val precio = intent.getStringExtra("Precio")
        val descripcion = intent.getStringExtra("Descripcion")
        val foto = intent.getIntExtra("Foto", 0)

        binding.ivProducto.setImageResource(foto)
        binding.tvNombre.text = nombre
        binding.tvPrecio.text = precio
        binding.tvDescripcion.text = descripcion

        binding.btnAtras.setOnClickListener{
            val intent = Intent(this, CartaActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}