package com.immi.thebrogrammers.immi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

val db = ImmIDatabase()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val geoNames = arrayListOf<String>()

        geoNames += db.cities.map({ c -> c.geo_name }).toTypedArray()
        //geoNames += db.countries.map({c -> c.geo_name}).toTypedArray()
        val adapter = ArrayAdapter<String>(
          this,
          android.R.layout.simple_list_item_1,
          geoNames)
        searchBar.setAdapter(adapter)*/
    }

    fun showInfo(view: View) {
        Log.d("debug", "go to info page")
    }
}
