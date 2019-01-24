package sc.tengsem.com.mykotlinonedemo.bigimageslook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import kotlinx.android.synthetic.main.activity_images_big_look.*
import sc.tengsem.com.mykotlinonedemo.App
import sc.tengsem.com.mykotlinonedemo.R
import sc.tengsem.com.mykotlinonedemo.User

/**
 * 查看大图界面
 */
class ImagesBigLookActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    lateinit var photos_data: ArrayList<User>
    var curr_position: Int = 0//当前位置
    var total_position: Int = 0//总长度
    lateinit var photo_views: ArrayList<View>
    lateinit var photoAdapter: PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images_big_look)
        photos_data = ArrayList()
        //获取数据源
        photos_data.clear()
        photos_data.addAll(App.instance.getData())
        total_position = photos_data.size//获取总数
        //获取当前点击位置
        curr_position = intent.getIntExtra("position", 0)
        //适配器
        photo_views = ArrayList()
        if (photos_data != null) {
            for (i in 0 until photos_data.size) {
                var view: View = View.inflate(this, R.layout.gallery_xml_adpter, null)
                photo_views.add(view)
            }
        }
        photoAdapter = PhotoAdapter(photos_data, photo_views)
        photos.adapter = photoAdapter
        //设置当前图片显示的位置
        crunnt_now_number.text = (curr_position + 1).toString()
        //设置当前图片总数的位置
        crunnt_zong_number.text = total_position.toString()
        //绑定指示器与viewpager点击的当前位置
        photos.currentItem = curr_position
        photos.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(p0: Int) {
        crunnt_now_number.text = ((p0 % photos_data.size + 1).toString())
    }
}
