package com.example.internal_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnInsert.setOnClickListener{
            var name = edtFrName.text.toString()
            var desc = edtFrDesc.text.toString()
            var price = edtFrPrice.text.toString().toInt()
            var fruit = Fruit(name,desc,price)
            var db = DBHelper(this)
            var flag = db.insert(fruit)
            if(flag)
            {
                Toast.makeText(this, "Record Inserted Successfully", Toast.LENGTH_SHORT).show()
            }
        }

        btnViewAll.setOnClickListener{
            var intent = Intent(this,ViewAllActivity::class.java)
            startActivity(intent)
        }

    }
}