package mx.udg.cuvalles.mynotesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddNotasActivity : AppCompatActivity() {

    var etTitulo: EditText?=null
    var etContenido: EditText?=null
    var btnGuardar: Button?=null

    val app= applicationContext as NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notas)

        etTitulo = findViewById(R.id.etTitulo)
        etContenido = findViewById(R.id.etContenido)
        btnGuardar = findViewById(R.id.btnGuardar)

        btnGuardar!!.setOnClickListener{
            val title = etTitulo!!.text.toString()
            val content = etContenido!!.text.toString()

            val nota= Nota(0, title, content)
            val notas = listOf<Nota>(nota)

            lifecycleScope.launch{
                app.room.notaDao().insert(notas)
            }

            etTitulo!!.setText("")
            etContenido!!.setText("")
        }

    }
}