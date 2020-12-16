package mx.udg.cuvalles.mynotesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val app= applicationContext as NotaApp
    var fabAdd: FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd = findViewById(R.id.fabAdd)

        fabAdd!!.setOnClickListener {
            val i = Intent(this, AddNotasActivity::class.java)
            startActivity(i)
        }
    }
    override fun onResume() {
            super.onResume()
            lifecycleScope.launch{
                val notas = app.room.notaDao().getAll()
                for (nota in notas){
                    Log.d("Prueba", "${nota.titulo}")
                }

            }
    }

}