package com.varunsen.newcards

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import android.widget.ArrayAdapter
import android.widget.TextView
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.varunsen.newcards.R
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import java.util.*

class MainActivity : AppCompatActivity() {

    var swipeRefreshLayout: SwipeRefreshLayout? = null
    var listView: ListView? = null
    var list: ArrayList<Int>? = null
    var adapter: ArrayAdapter<Int>? = null
    var cardCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout = findViewById(R.id.refreshLayout)
        cardCount = findViewById(R.id.card_count)
        listView = findViewById(R.id.listView)

        list = ArrayList()
        list!!.add(1)
        list!!.add(2)
        list!!.add(3)
        list!!.add(4)

        cardCount?.setText("Total Cards : " + list!!.size)
        adapter = ArrayAdapter(this, R.layout.card, list!!)
        listView?.setAdapter(adapter)

        swipeRefreshLayout?.setOnRefreshListener(OnRefreshListener {
            list!!.add(list!!.size + 1)
            adapter!!.notifyDataSetChanged()
            cardCount?.setText("Total Cards : " + list!!.size)
            swipeRefreshLayout?.setRefreshing(false)
        })
    }
}
