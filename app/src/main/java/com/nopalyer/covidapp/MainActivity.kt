package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList = ArrayList<SymptomsModel>()
        symptomsList.add(SymptomsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(SymptomsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(SymptomsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(SymptomsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter


        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionsList = ArrayList<PrecautionsModel>()
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(PrecautionsModel(0,"dry cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter
    }
}
