package com.example.exifinterfacedemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.exifinterface.media.ExifInterface
import com.example.exifinterfacedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bmp:Bitmap
    lateinit var scaledBitmap:Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bmp = BitmapFactory.decodeResource(resources,R.drawable.shibba)
        val nh = ((bmp.height) * 512.0/ bmp.width)
        scaledBitmap = Bitmap.createScaledBitmap(bmp,512,nh.toInt(),true)
        binding.original.setImageBitmap(scaledBitmap)

        binding.btnClick.setOnClickListener {

            letsCompress()
        }

    }

    private fun letsCompress() {



    }


}