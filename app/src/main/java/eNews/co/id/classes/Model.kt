package eNews.co.id.classes

import com.google.gson.annotations.SerializedName
//data class ModelNews(val title: String, val description: String, val urlToImage: String)
class ModelNews {
    @SerializedName("title")
    private var title: String? = null

    @SerializedName("description")
    private var description: String? = null

    @SerializedName("urlToImage")
    private var image: String? = null

    @SerializedName("url")
    private var url: String? = null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getImage(): String? {
        return image
    }

    fun setImage(image: String?) {
        this.image = image
    }
    fun getURL(): String? {
        return url
    }

    fun setURL(url: String?) {
        this.url = url
    }
}
class Result {
    @SerializedName("articles")
    var result: List<ModelNews>? = null
    @JvmName("getResult1")
    fun getResult(): List<ModelNews>? {
        return result
    }
    @JvmName("setResult1")
    fun setResult(result: List<ModelNews>?) {
        this.result = result
    }
}