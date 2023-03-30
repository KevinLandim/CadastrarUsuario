package br.edu.puc.cadastrodeusuarios.cadastrodeusuarios.formcadastro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.puc.cadastrodeusuarios.databinding.ActivityFormCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {

    private lateinit var binding:ActivityFormCadastroBinding
    private val auth= FirebaseAuth.getInstance()  //Referencia do authentication, depois de ter adicionado o link das dependencias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityFormCadastroBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.btnCadastrar.setOnClickListener{btn ->

            val email= binding.editEmail.text.toString()
            val senha= binding.editSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                val snackbar=Snackbar.make(btn,"Preencha todos os campos!",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.createUserWithEmailAndPassword("kevinb.landim@gmail.com","121212").addOnCompleteListener { cadastro -> //Criando usuário
                    if(cadastro.isSuccessful){
                        val snackbar=Snackbar.make(btn,"Sucesso ao cadastrar usuário",Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        binding.editEmail.setText("")
                        binding.editSenha.setText("")
                    }

                }
                
            }



        }
    }
}