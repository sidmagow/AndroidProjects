package com.example.hardwaresensors

import android.graphics.Color
import android.graphics.ColorSpace
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SensorEventListener {

 //   lateinit var sensorEventListener: SensorEventListener
    lateinit var sensorManager: SensorManager
    lateinit var proxSensor: Sensor
    lateinit var accelSensor: Sensor

    val colors = arrayOf(Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,Color.GREEN,Color.YELLOW)

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        //Log.d("HWSENS", "onSensorChanged: ${event!!.values[0]} ")

//        if(event!!.values[0]>0) {
//            flProx.setBackgroundColor(colors[Random.nextInt(6)])
//        }

//        Log.d("HWSENS", """
//            - - -
//            ax = ${event!!.values[0]}
//            ay = ${event!!.values[1]}
//            az =${event!!.values[2]}
//            - - -
//        """.trimMargin())

        val bgColor= Color.rgb(
                accToCol(event!!.values[0]),
                accToCol(event!!.values[1]),
                accToCol(event!!.values[2])
        )

        flAcc.setBackgroundColor(bgColor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager= getSystemService<SensorManager>()!!


//        if(sensorManager==null){
//            Toast.makeText(this, "could not get sensors", Toast.LENGTH_SHORT).show()
//            finish()
//        }

    //        val sensors = sensorManager.getSensorList(Sensor.TYPE_ALL)

//            sensors.forEach {
//                Log.d("HWSENS", """
//                    ${it.name}|${it.stringType}|${it.vendor}
//                """.trimIndent())


                proxSensor =sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
                accelSensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


    }

    override fun onResume() {
        super.onResume()

       // sensorManager.registerListener(this,proxSensor,1000*1000)
        sensorManager.registerListener(this,accelSensor,1000*1000)
    }

    override fun onPause() {
        sensorManager.unregisterListener(this)
        super.onPause()
    }

    private fun accToCol(accel:Float) = (((accel+12)/24)*255).roundToInt()
}