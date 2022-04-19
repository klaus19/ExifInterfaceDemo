package com.example.exifinterfacedemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.exifinterface.media.ExifInterface
import com.example.exifinterfacedemo.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream

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

            var convertedImage:Bitmap = getResizedImage(scaledBitmap,500)
            binding.alpha.setImageBitmap(convertedImage)

        }

    }


    //Resizing and compressing the image
    fun getResizedImage(image: Bitmap,maxSize: Int): Bitmap{
        var width = image.width
        var height = image.height
        var bimMapRatio:Float = width.toFloat() / height.toFloat()

        if(bimMapRatio> 1){
            width = maxSize
            height =((width / bimMapRatio).toInt())
        }else{
            height = maxSize
            width = ((height * bimMapRatio).toInt())
        }
        return Bitmap.createScaledBitmap(image, height,width,true)
    }




}