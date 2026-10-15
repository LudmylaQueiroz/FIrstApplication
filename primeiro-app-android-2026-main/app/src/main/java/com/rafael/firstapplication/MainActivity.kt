package com.rafael.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication.databinding.ActivityMainBinding

/**
 * Tela principal do app.
 * Exibe campos de e-mail e senha e, ao clicar em "Entrar",
 * mostra os dois valores digitados em um Toast.
 */
class MainActivity : AppCompatActivity() {

    // Classe gerada automaticamente pelo ViewBinding a partir do activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout XML usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        // Ajusta o espaçamento para a tela não ficar embaixo das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pega os componentes do layout via ViewBinding
        val editText = binding.editText                   // campo de e-mail
        val editTextPassword = binding.editTextPassword   // campo de senha
        val button = binding.button                       // botão "Entrar"

        // Ao clicar no botão, lê os dois campos e mostra num Toast
        button.setOnClickListener {
            val email = editText.text.toString()
            val senha = editTextPassword.text.toString()

            Toast.makeText(
                this,
                "Email: $email\nSenha: $senha",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}