package academy.learnprogramming.vismahomeassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.core.content.ContextCompat
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonString = this.assets.open("dog_urls.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val dogUrls = gson.fromJson(jsonString, DogImgUri::class.java)
        gridView = findViewById(R.id.dogGridView)
        val imgAdapter = DogGridAdapter(dogUrls.urls)
        gridView.adapter = imgAdapter
        gridView.numColumns = 2
        gridView.setOnItemClickListener { parent, view, position, id ->
            displayImageFromUrl(dogUrls.urls[position])
        }

    }

    fun displayImageFromUrl(url: String){

        val intent = Intent(this, OnClickImage::class.java).apply {
            putExtra("IMAGE_URL", url)
        }
        ContextCompat.startActivity(this, intent, null)
    }

}
