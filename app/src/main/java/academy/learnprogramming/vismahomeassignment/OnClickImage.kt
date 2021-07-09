package academy.learnprogramming.vismahomeassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class OnClickImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_click_image)

        val imageView = findViewById<ImageView>(R.id.onClickImage)
        val imgUrl = intent.extras?.getString("IMAGE_URL")
        Picasso.get().load(imgUrl).into(imageView)
    }
}