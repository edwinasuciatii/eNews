package eNews.co.id.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eNews.co.id.R
import eNews.co.id.databinding.SplashBinding
import eNews.co.id.classes.PropertyStatusBar

class Splash: AppCompatActivity() {
    private lateinit var binding : SplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        PropertyStatusBar().changeColor(R.color.blue, this)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep((800).toLong())
                    setContent()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
    private fun setContent(){
        startActivity(Intent(this, ListNews::class.java))
        finish()
    }
}