package mx.udg.cuvalles.mynotesapp

import android.app.Application
import androidx.room.Room

class NotaApp:Application() {
    val room= Room.databaseBuilder(this, NotasDb::class.java, "notas_db").build()

}