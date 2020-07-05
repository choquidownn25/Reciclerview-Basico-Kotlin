package com.ejemplo.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ejemplo.recyclerview.adapter.CustomAdapter
import com.ejemplo.recyclerview.models.User

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Obteniendo una vista de reciclaje de xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        // Agregar un administrador de diseño
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        // Crear una lista de arrays para almacenar usuarios utilizando el usuario de la clase de datos
        val users = ArrayList<User>()

        //Agregar algunos datos ficticios a la lista
        users.add(User("Belal Khan", "Ranchi Jharkhand","https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg" ))
        users.add(User("Ramiz Khan", "Ranchi Jharkhand","https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_1.jpg"))
        users.add(User("Faiz Khan", "Ranchi Jharkhand","https://raw.githubusercontent.com/sayyam/carouselview/master/sample/src/main/res/drawable/image_2.jpg"))
        users.add(User("Yashar Khan", "Ranchi Jharkhand","https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg"))

        //Creando nuestro adaptador
        val adapter = CustomAdapter(users)

        //Ahora agregando el adaptador a la vista de reciclaje
        recyclerView.adapter = adapter
    }
}
