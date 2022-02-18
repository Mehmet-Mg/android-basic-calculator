package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var tasarim: ActivityMainBinding
    private var metin = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val buttons = butonListe()

        for (button in buttons) {
            button.setOnClickListener {
                sayıGir(button);
            }
        }

        tasarim.buttonEsittir.setOnClickListener {
            topla()
        }

        tasarim.buttonTemizle.setOnClickListener {
            temizle()
        }

        tasarim.buttonGerial.setOnClickListener {
            geriAl()
        }
    }

    private fun sayıGir(button: Button) {
        if (metin == "0") {
            metin = button.text.toString()
        } else if (button.text == "+") {
            if (!metin.contains("+") && metin != "0")
                metin += button.text.toString()
        } else {
            metin += button.text.toString()
        }
        tasarim.sonucEkrani.text = metin
    }

    private fun geriAl() {
        tasarim.sonucEkrani.text = metin
        if (tasarim.sonucEkrani.text.isEmpty())
            tasarim.sonucEkrani.text = "0"
        else
            metin = metin.substring(0, metin.length-1)
    }

    private fun temizle() {
        metin = "0"
        tasarim.sonucEkrani.text = "0"
    }

    private fun topla() {
        val c = metin.substring(metin.length-1)

        if((c != "+") && (metin.contains("+"))) {
            val indeksArtı = metin.indexOf("+")
            if(indeksArtı == metin.length)
                tasarim.sonucEkrani.text = metin
            val kisim1 = metin.subSequence(0, indeksArtı).toString()
            val kisim2 = metin.subSequence(indeksArtı+1, metin.length).toString()
            metin = (kisim1.toInt() + kisim2.toInt()).toString()

            tasarim.sonucEkrani.text = metin
        }
    }

    private fun butonListe() : ArrayList<Button> {
        val buttons = ArrayList<Button>()

        buttons.add(tasarim.buton0)
        buttons.add(tasarim.buton1)
        buttons.add(tasarim.buton2)
        buttons.add(tasarim.buton3)
        buttons.add(tasarim.buton4)
        buttons.add(tasarim.buton5)
        buttons.add(tasarim.buton6)
        buttons.add(tasarim.buton7)
        buttons.add(tasarim.buton8)
        buttons.add(tasarim.buton9)
        buttons.add(tasarim.buttonTopla)

        return buttons
    }
}