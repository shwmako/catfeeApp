package com.example.catfeeapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catfeeapp.Model.Productos
import com.example.catfeeapp.databinding.ActivityCartaBinding

class CartaActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartaBinding
    lateinit var producto: MutableList<Productos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa 'producto' antes de usarla
        producto = mutableListOf()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.mi_color_status_bar)
        }

        // Obtén la lista de productos
        producto = getProductos()
        val adaptador = AdapterProductos(producto, this)

        // Configura el RecyclerView
        binding.rvCarta.layoutManager = GridLayoutManager(this, 2)
        binding.rvCarta.adapter = adaptador

        binding.ivLogoInicio.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getProductos(): MutableList<Productos> {
        producto.add(Productos(R.drawable.prd1, "Pochacco cookie", "S/ 8.00",
            "Dos deliciosas galletas sándwich, cada una formada por suaves galletas de mantequilla que encierran un cremoso " +
                    "relleno de malvavisco. El diseño encantador de perrito, con orejas de chocolate y una carita simpática, hace que sean " +
                    "irresistibles tanto para la vista como para el paladar. Perfectas para disfrutar en cualquier momento del día, estas " +
                    "galletas ofrecen un equilibrio perfecto entre dulzura y ternura."))
        producto.add(Productos(R.drawable.prd2, "Pancakes Heart", "S/ 12.00",
            "Tres panqueques esponjosos en forma de corazón, con mantequilla y almíbar. Acompañados de frutas frescas y una taza de té aromático. " +
                    "Un desayuno encantador y dulce."))
        producto.add(Productos(R.drawable.prd3, "Macarrons x8", "S/ 12.00",
            "Deleita tu paladar con estas macarons en forma de corazón, perfectas para cualquier ocasión.\n" +
                    "Suave, delicado y delicioso, cada macaron es una obra de arte.\n" +
                    "\n" +
                    "Ideal para:\n" +
                    "\n" +
                    "Regalar a alguien especial\n" +
                    "Disfrutar en una tarde de té\n" +
                    "Endulzar cualquier celebración\n" +
                    "Decorar tu mesa con un toque elegante\n" +
                    "¡No te quedes sin probarlos!"))
        producto.add(Productos(R.drawable.prd4, "Catcookie", "S/ 2.00",
            "¡Dale un toque de dulzura a tu día con nuestras deliciosas galletas de gatitos! Hechas a mano con amor y decoradas con " +
                    "glaseado artesanal, estas galletas son perfectas para cualquier ocasión. Son tan tiernas que no podrás resistirte a probarlas. ¡" +
                    "Pídelas ahora y endulza tu vida!"))

        producto.add(Productos(R.drawable.prd5, "BiscuitLemon uni", "S/ 4.00 ", "¡Delicias de limón que te harán sonreír!" +
                "¿Te apetece un bocado de felicidad? Estos pastelitos de limón, con su delicioso glaseado blanco, son la combinación perfecta de dulzura y " +
                "sabor cítrico. Son tan esponjosos y suaves que se derriten en tu boca. " +
                "\n" +
                "Perfectos para:\n" +
                "\n" +
                "Un capricho dulce.\n" +
                "Una merienda especial.\n" +
                "Un regalo para alguien especial.\n" +
                "No te quedes sin probarlos!"
        ))
        producto.add(Productos(R.drawable.prd6, "CakeKitty", "S/ 15.00 ", "¡Endulza tu día con nuestra rebanada de pastel de vainilla inspirada en un" +
                " adorable personaje! Capas suaves de bizcocho con relleno cremoso y frutas frescas, cubiertas con un delicado glaseado rosa. Perfecto para consentirte o " +
                "sorprender a alguien especial. ¡Ven a probarlo!"
        ))
        producto.add(Productos(R.drawable.prd7, "Duo Catfee", "S/ 10.00 ", "Disfruta de un latte único que no solo es delicioso, sino también una obra de " +
                "arte en sí mismo. Presentado en una taza, nuestro latte está decorado con espuma cremosa que forma la figura de un adorable gatito que parece jugar con la espuma " +
                "en la superficie del café. Además, dos elegantes peces koi nadan grácilmente en el latte, capturando la esencia de la serenidad y el arte japonés. Es la combinación " +
                "perfecta de sabor y estética, ideal para aquellos que buscan una experiencia inolvidable."
        ))
        producto.add(Productos(R.drawable.prd8, "Cattow", "S/ 5.00 ", "¡Descubre la magia en una taza! Nuestro café latte viene con una espuma encantadora " +
                "en forma de dos gatitos juguetones, que harán de cada sorbo una experiencia única. Delicioso, suave, y lleno de ternura. ¡Ven y disfruta de esta adorable creación!"
        ))
        producto.add(Productos(R.drawable.prd9, "Cafe Espumiau", "S/ 4.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd10, "DuoBear", "S/ 15.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd11, "Desayuno Kitty", "S/ 15.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd12, "Apple Tea", "S/ 5.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd13, "Tea", "S/ 2.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd14, "MochiCinamorroll", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd15, "Waffle", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd16, "Bunny Muuffin x4", "S/ 16.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd17, "Cheesecake", "S/ 10.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd18, "StrawCake", "S/ 7.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd19, "Pieces of Cake", "S/ 9.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd20, "Macarrons x4", "S/ 6.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd21, "Creamcake", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd22, "Pompompurin M", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd23, "Macarrons x uni", "S/ 4.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd24, "WafflesBerry", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd25, "Cookies x un", "S/ 2.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd26, "BunnyTea", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd27, "Tea", "S/ 8.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd28, "Breakfast for 2", "S/ 20.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd29, "BubbleBear", "S/ 14.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd30, "Cofee", "S/ 3.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd31, "BubbleTea", "S/ 9.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd32, "Pack Cookies", "S/ 20.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd33, "Cookies esp.", "S/ 5.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd34, "Cake s.", "S/ 25.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd35, "HeartDn¨", "S/ 5.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd37, "Cake s.", "S/ 3.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd38, "MacarronStraw", "S/ 7.00 ", ""
        ))
        producto.add(Productos(R.drawable.prd39, "Cofee", "S/ 3.00 ", ""
        ))





















        return producto
    }
}
