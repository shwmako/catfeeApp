package com.example.catfeeapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catfeeapp.databinding.ActivityLoginBinding
import com.example.catfeeapp.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    lateinit var binding: ActivityPerfilBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.mi_color_status_bar)
        }
        sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", "Usuario")
        binding.tvNombreUser.text = userName

        val userId = sharedPreferences.getString("user_id", "default")
        when (userId) {
            "user1" -> binding.ivPerfil.setImageResource(R.drawable.p2)
            "user2" -> binding.ivPerfil.setImageResource(R.drawable.p1)
        }
        binding.btnCerrarSesion.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("user_id")
            editor.putBoolean("is_logged_in", false)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        binding.btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}