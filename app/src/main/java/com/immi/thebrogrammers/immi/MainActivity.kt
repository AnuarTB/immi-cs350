package com.immi.thebrogrammers.immi

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

val db = ImmIDatabase()

class MainActivity : AppCompatActivity() {

  lateinit var toolbar: Toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)

    val geoNames = arrayListOf<String>()

    geoNames += db.cities.map({ c -> c.geo_name }).toTypedArray()
    //geoNames += db.countries.map({c -> c.geo_name}).toTypedArray()
    val adapter = ArrayAdapter<String>(
      this,
      android.R.layout.simple_list_item_1,
      geoNames)
    searchBar.setAdapter(adapter)
  }

  fun onClickSearch(view: View) {
    val infoShowIntent = Intent(this, InfoShowActivity::class.java)
    infoShowIntent.putExtra("GEO_OBJECT_NAME", searchBar.text.toString())
    startActivity(infoShowIntent)
  }
}
