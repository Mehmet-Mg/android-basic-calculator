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

        for (button in buttons) {
            button.setOnClickListener {

                if (metin == "0") {
                    metin = ""
                    metin = button.text.toString()
                } else if (button.text == "+") {
                    if (!metin.contains("+") && metin != "0")
                        metin += button.text.toString()
                } else {
                    metin += button.text.toString()
                }
                tasarim.sonucEkrani.text = metin
            }
        }

        tasarim.buttonEsittir.setOnClickListener {
            val c = metin.substring(metin.length-1)
            if((c != "+") && (metin.contains("+")))
                metin = topla(metin)
            tasarim.sonucEkrani.text = metin
        }

        tasarim.buttonTemizle.setOnClickListener {
            metin = "0"
            tasarim.sonucEkrani.text = metin
        }

        tasarim.buttonGerial.setOnClickListener {

            tasarim.sonucEkrani.text = metin
            if (tasarim.sonucEkrani.text.isEmpty())
                tasarim.sonucEkrani.text = "0"
            else
                metin = metin.substring(0, metin.length-1)

        }
    }

    private fun topla(islem: String): String {
        val indeksArtı = islem.indexOf("+")
        if(indeksArtı == islem.length)
            return islem
        val kisim1 = islem.subSequence(0, indeksArtı).toString()
        val kisim2 = islem.subSequence(indeksArtı+1, islem.length).toString()
        val sonuc = kisim1.toInt() + kisim2.toInt()

        return sonuc.toString()
    }
}