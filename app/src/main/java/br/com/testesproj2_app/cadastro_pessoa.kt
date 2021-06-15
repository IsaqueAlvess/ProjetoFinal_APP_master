package br.com.testesproj2_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro_pessoa.*


class cadastro_pessoa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_pessoa)

        fun validateInput(): Boolean{
            if (TextUtils.isEmpty(cadNome.getText())){
                cadNome.setError("Nome obrigatório")
                cadNome.requestFocus()
                return false
            }

            if (TextUtils.isEmpty(cadEmail.getText())){
                cadEmail.setError("Email obrigatório")
                cadEmail.requestFocus()
                return false
            }

            if (TextUtils.isEmpty(cadTelefone.getText())){
                cadTelefone.setError("telefone obrigatório")
                cadTelefone.requestFocus()
                return false
            }

            return true

        }
        fun validatee():Boolean{if(cadEmail.getText().contains("@") != true){
            cadEmail.setError("Email deve ter @")
            cadEmail.requestFocus()
            return false
        }
            return true
        }

            btnCadastrar.setOnClickListener {
                if(validateInput()) {
                if (validatee()) {
                    val sharedPreference = getSharedPreferences(
                        "preferencias",
                        MODE_PRIVATE
                    )

                    val ed = sharedPreference.edit()
                    val nome = findViewById(R.id.cadNome) as EditText
                    val email = findViewById(R.id.cadEmail) as EditText
                    val telefone = cadTelefone.text.toString()//<Int>(R.id.cadTelefone)

                    ed.putString("nome", nome.getText().toString())
                    ed.putString("email", email.getText().toString())
                    ed.putString("telefone", telefone.toLong().toString())
                    Toast.makeText(getBaseContext(), "Gravado com sucesso", Toast.LENGTH_SHORT)
                        .show()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("cadastro", btnCadastrar.toString())
                    startActivity(intent)
                }
            }
       }
    }
}