package sc.tengsem.com.mykotlinonedemo.bigimageslook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.activity_images_one_big_look.*
import sc.tengsem.com.mykotlinonedemo.R

class ImagesOneBigLookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images_one_big_look)
        ImageLoader.getInstance().displayImage("http://img1.3lian.com/2015/w8/31/d/101.jpg", photoView_main)
    }
}
