package com.free.testeconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.free.adapters.PacoteAdapter
import com.free.models.Pacotes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listaPacotes : MutableList<Pacotes> = mutableListOf(
            Pacotes(
                "@android:color/holo_red_light",
            "São Paulo",
            "1 diária",
            "350,00"),
            Pacotes(
            "@android:color/holo_green_dark",
            "Campinas",
            "2 diárias",
            "500,00"),
            Pacotes(
            "@android:color/holo_blue_dark",
            "São Carlos",
            "1 diária",
            "250,00"),
            Pacotes(
            "@android:color/holo_purple",
            "Rolândia",
            "1 diária",
            "100,00")
        )



        recyclerView = lista_Pacotes_RecyclerView
        val adapter = PacoteAdapter(this, listaPacotes)



        recyclerView.adapter = adapter
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}