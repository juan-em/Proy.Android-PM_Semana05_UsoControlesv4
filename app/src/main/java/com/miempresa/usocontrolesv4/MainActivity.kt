package com.miempresa.usocontrolesv4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.propuesto.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    fun pc_prom(a:Double,b:Double,c:Double,d:Double):Double{
        var res:Double = 0.0
        var lista:MutableList<Double> = mutableListOf(a,b,c,d)
        var min = lista[0]
        for (i in 0..lista.size-1){
            if (min<=lista[i]){
                min = min
            }
            else{
                min = lista[i]
            }
        }
        lista.remove(min)
        for(i in lista){
            res = res + i
        }
        return res/3
    }
    fun condicion(a:Double):String{
        var res:String
        if(a>=12.5){
            res = "¡APROBADO! FS:"+((a * 100.0).roundToInt() / 100.0).toString()
            result.setBackgroundColor(Color.parseColor("#51FF26"))
            img.setImageResource(R.drawable.alegre)
        }
        else{
            res = "DESAPROBADO FS:"+((a * 100.0).roundToInt() / 100.0).toString()
            result.setBackgroundColor(Color.parseColor("#FF2626"))
            img.setImageResource(R.drawable.triste)
        }
        return res
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.propuesto)
        btn_go.setOnClickListener(){
            var lab_prom = lab_prom.text.toString().toDouble()
            var pc_1 = pc_1.text.toString().toDouble()
            var pc_2 = pc_2.text.toString().toDouble()
            var pc_3 = pc_3.text.toString().toDouble()
            var pc_4 = pc_4.text.toString().toDouble()
            var rpta = pc_prom(pc_1,pc_2,pc_3,pc_4)*0.3 + lab_prom*0.7
            result.setText(condicion(rpta))
        }
        /*
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener(){
            var usuario = txtusuario.text.toString()
            var clave = txtclave.text.toString()

            if (tglOnOff.isChecked){
                lblVer.setText(clave)
            }else{
                lblVer.setText(usuario+" no tiene permisos para ver la clave")
            }
        }*/
    }
}