package com.example.catfeeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.catfeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.mi_color_status_bar)
        }
        binding.btnCarta.setOnClickListener(){
            val intent = Intent(this, CartaActivity::class.java)
            startActivity(intent)
        }
        binding.btnNosotros.setOnClickListener(){
            val intent = Intent(this, NosotrosActivity::class.java)
            startActivity(intent)
        }
        binding.ivLogoInicio.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE)

        val userId = sharedPreferences.getString("user_id", "default")
        when (userId) {
            "user1" -> binding.ivPerfil.setImageResource(R.drawable.p2)
            "user2" -> binding.ivPerfil.setImageResource(R.drawable.p1)
        }
        binding.ivPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra("userProfile", "user1")
            startActivity(intent)
        }


    }
}