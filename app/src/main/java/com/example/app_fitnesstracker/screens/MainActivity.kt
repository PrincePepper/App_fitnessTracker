package com.example.app_fitnesstracker.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.app_fitnesstracker.R
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    //TODO: нужно проверить правильность написания coroutine
    fun main() = runBlocking {
        val aaa = async {
            printHello()
        }
        return@runBlocking aaa
    }

    suspend fun printHello() {
        delay(delay)
        println("какое то действие")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        main().onAwait
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        main().cancel()

    }

    override fun onPause() {
        super.onPause()
        main().cancel()
    }


    companion object {
        private const val delay = 1500L
    }
}