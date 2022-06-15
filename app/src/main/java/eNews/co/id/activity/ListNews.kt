package eNews.co.id.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import eNews.co.id.R
import eNews.co.id.adapter.News
import eNews.co.id.classes.ApiInterface
import eNews.co.id.classes.PropertyStatusBar
import eNews.co.id.classes.Result
import eNews.co.id.databinding.NewsListBinding
import retrofit2.Call
import retrofit2.Callback


class ListNews: AppCompatActivity(){
    private lateinit var binding : NewsListBinding
    private lateinit var adapter: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PropertyStatusBar().changeColor(R.color.blue, this)
        initContent()
    }
    private fun initContent() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvJob.layoutManager = linearLayoutManager
        showLoading()
        val apiInterface = ApiInterface.create().getNews("d87364728cb240ff8c99c839a3333877", "id")

        apiInterface.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                hideLoading()
            }

            override fun onResponse(
                call: Call<Result>,
                response: retrofit2.Response<Result>
            ) {
                Log.i("cek","response"+response)
                val list = response.body()?.getResult()
                adapter = list?.let { News(it,this@ListNews) }!!
                binding.rvJob.adapter = adapter
                hideLoading()
            }
        })
    }
    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }
}