package eNews.co.id.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import eNews.co.id.R
import eNews.co.id.activity.Detail
import eNews.co.id.classes.ModelNews

class News(private var data: List<ModelNews>, private val activity: FragmentActivity):
    RecyclerView.Adapter<News.ViewHolder>(){

    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val getData: ModelNews = data[p1]
        p0.title.text = getData.getTitle()
        p0.desc.text = getData.getDescription()
        val url = getData.getImage()
        Glide.with(activity)
            .load(url)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(40)))
            .into(p0.image)
        p0.itemView.setOnClickListener{
            val i = Intent(activity, Detail::class.java)
            i.putExtra("url",getData.getURL())
            activity.startActivity(i)
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view : View = LayoutInflater.from(p0.context).inflate(R.layout.news_card, p0, false)
        return ViewHolder(view)
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.imageView)
        var title: TextView = itemView.findViewById(R.id.title)
        var desc: TextView = itemView.findViewById(R.id.desc)
    }
}