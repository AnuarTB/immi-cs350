package com.immi.thebrogrammers.immi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_compare_cities.*

class CompareCities : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_compare_cities)
    inputCity1.setText(intent.getStringExtra("GEO_OBJECT_NAME")!!)
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter.createFromResource(
      this,
      R.array.indexArray,
      android.R.layout.simple_spinner_item
    ).also { adapter ->
      // Specify the layout to use when the list of choices appears
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      // Apply the adapter to the spinner
      indexSpinner.adapter = adapter
    }
  }

  fun compareTwoCities(view: View) {
    val cityInput1: EditText = findViewById<EditText>(R.id.inputCity1)
    val cityInput2: EditText = findViewById<EditText>(R.id.inputCity2)

    val cityName1 = cityInput1.text.toString()
    val cityName2 = cityInput2.text.toString()

    println(cityName1)
    println(cityName2)
    val spinnerText = indexSpinner.selectedItem.toString()
    val indMap = mapOf(
      "Healthcare quality" to "health_care_index",
      "Cost of groceries" to "groceries_index",
      "Pollution level" to "pollution_index",
      "Crime level" to "crime_index",
      "Traffic" to "traffic_index")
    val qindexString = indMap[spinnerText]
    val city1 = ImmIDatabase.getCityByName(cityName1)
    val city2 = ImmIDatabase.getCityByName(cityName2)
    val qindex = ImmIDatabase.getQIndexByName(qindexString!!)
    val ans = city1?.compareCities(city2!!, qindex!!)
    answerText.text = ans
  }
}
