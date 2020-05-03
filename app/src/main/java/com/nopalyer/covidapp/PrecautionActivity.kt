package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precaution.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter
    }
}
