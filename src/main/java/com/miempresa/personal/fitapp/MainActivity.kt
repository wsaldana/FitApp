package com.miempresa.personal.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var i = 0
        get() = field
        set(value) {
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtNumero: TextView = findViewById(R.id.idTextView)
        val btnVuelta: Button = findViewById(R.id.button)
        val btnReinicio: Button = findViewById(R.id.button2)
        val imgView: ImageView = findViewById(R.id.imageView)

        btnVuelta.setOnClickListener{
            if(i<20){ i++ }
            txtNumero.setText(i.toString())

            if(i>=10 && i<20){
                imgView.setImageResource(R.drawable.silver)
                Toast.makeText(this,"FELICIDADES LLEVAS 10 VUELTAS",Toast.LENGTH_SHORT).show()
            }else if(i == 20){
                imgView.setImageResource(R.drawable.gold)
                Toast.makeText(this,"FELICIDADES LO LOGRASTE",Toast.LENGTH_LONG).show()
            }else{
                imgView.setImageResource(R.drawable.blank)
            }
        }
        btnVuelta.setOnLongClickListener {
            var res = 10
            if(i<10){
                res = 10-i
            }else{
                res = 20-i
            }
            Toast.makeText(this,"Faltan $res vueltas",Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
        btnReinicio.setOnClickListener(){
            i = 0
            imgView.setImageResource(R.drawable.blank)
        }
    }
}
