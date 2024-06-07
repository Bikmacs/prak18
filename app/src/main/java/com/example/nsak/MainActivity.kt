package com.example.nsak

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.log)
        password = findViewById(R.id.pass)
        findViewById<View>(R.id.loadbutton).setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Загрузить данные?")
                .setPositiveButton("Да") { dialog, which ->
                    pref = getPreferences(MODE_PRIVATE)
                    login.setText(pref.getString("login", ""))
                    password.setText(pref.getString("password", ""))
                }
                .setNegativeButton("Нет") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }

        findViewById<View>(R.id.nextc).setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun handler(view: View) {
        if (view.id == R.id.savebutton) {
            pref = getPreferences(MODE_PRIVATE)
            val ed = pref.edit()
            ed.putString("login", login.text.toString())
            ed.putString("password", password.text.toString())
            ed.apply()
        }
    }
}
