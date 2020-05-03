package com.nopalyer.covidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.fever,"Fever","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter


        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
     
        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter

        txtViewSymptoms.setOnClickListener {
            var intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener {
            var intent = Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }


        getGlobalData()
    }

    fun getGlobalData(){
        val url:String ="https://corona.lmao.ninja/v2/all/"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview
                txtInfected.text = jsonObject.getString("cases")
                txtRecoverd.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecoverd.text = "-"
                txtDeceased.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}
