package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.fever,"Fever","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}
