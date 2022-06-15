package eNews.co.id.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import eNews.co.id.R
import eNews.co.id.classes.PropertyStatusBar
import eNews.co.id.databinding.NewsDetailBinding


class Detail: AppCompatActivity() {
    private lateinit var binding : NewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PropertyStatusBar().changeColor(R.color.blue, this)
        val url = intent?.getStringExtra("url")
        val webView = findViewById<View>(R.id.webView) as WebView
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}