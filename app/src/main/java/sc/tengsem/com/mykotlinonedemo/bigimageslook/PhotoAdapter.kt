package sc.tengsem.com.mykotlinonedemo.bigimageslook

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.nostra13.universalimageloader.core.ImageLoader
import sc.tengsem.com.mykotlinonedemo.R
import sc.tengsem.com.mykotlinonedemo.User

import uk.co.senab.photoview.PhotoView


class PhotoAdapter(
    var photos_data: ArrayList<User>,
    var photo_views: ArrayList<View>
) :
    PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: View = photo_views[position]
        var photoViewmain: PhotoView = view.findViewById(R.id.photoView_main)
        var url_str: String = photos_data[position].imagesUrl
        ImageLoader.getInstance().displayImage(url_str, photoViewmain)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(photo_views[position])
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return photo_views.size
    }

}