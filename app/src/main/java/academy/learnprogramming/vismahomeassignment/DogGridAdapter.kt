package academy.learnprogramming.vismahomeassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DogGridAdapter(var urls: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return urls.size
    }

    override fun getItem(position: Int): Any {
        return urls[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.dog_img_rows,null)
        val img = view.findViewById<ImageView>(R.id.imageViewOne)
        Picasso.get().load(urls[position]).into(img)

        return view
    }


}