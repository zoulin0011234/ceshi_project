package sc.tengsem.com.mykotlinonedemo

import android.app.Application
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType

class App : Application() {
    lateinit var data_lists: ArrayList<User>

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        initImageLoader()
        data_lists = ArrayList()
    }

    fun setData(data: ArrayList<User>) {
        data_lists.clear()
        data_lists.addAll(data)
    }

    fun getData(): ArrayList<User> {
        return data_lists
    }

    private fun initImageLoader() {
        var config = ImageLoaderConfiguration.Builder(this)
        config.threadPriority(Thread.NORM_PRIORITY - 2)
        config.denyCacheImageMultipleSizesInMemory()
        config.diskCacheFileNameGenerator(Md5FileNameGenerator())
        config.diskCacheSize(50 * 1024 * 1024)
        config.tasksProcessingOrder(QueueProcessingType.LIFO)
        config.writeDebugLogs()
        ImageLoader.getInstance().init(config.build())
    }

    companion object {
        lateinit var instance: App
    }
}