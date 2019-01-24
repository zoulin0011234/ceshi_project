package sc.tengsem.com.mykotlinonedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.CompoundButton
import android.widget.GridView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.liaoinstan.springview.container.DefaultFooter
import com.liaoinstan.springview.container.DefaultHeader
import com.liaoinstan.springview.widget.SpringView
import com.liaoinstan.springview.widget.SpringView.OnFreshListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var lis_date: List<User?>
    private lateinit var imagesAdpter: ImagesListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //绑定布局
        recycler_view_list.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        //数据源
        getData()
        //加载适配器
        imagesAdpter = ImagesListAdapter(this)
        recycler_view_list.adapter = imagesAdpter
        //加载数据
        imagesAdpter.setData(lis_date as List<User>)
        //刷新加载数据
        spring_view.header = DefaultHeader(this)
        spring_view.footer = DefaultFooter(this)
        spring_view.type = SpringView.Type.FOLLOW
        spring_view.setListener(object:SpringView.OnFreshListener{
            override fun onLoadmore() {
                imagesAdpter.setData(lis_date as List<User>)
                if (spring_view!=null){
                    spring_view.onFinishFreshAndLoad()
                    toast("刷新加载完成")
                }
            }

            override fun onRefresh() {
                imagesAdpter.getData().clear()
                imagesAdpter.setData(lis_date as List<User>)
                if (spring_view!=null){
                    spring_view.onFinishFreshAndLoad()
                    toast("刷新数据完成")
                }
            }

        })
    }

    private fun getData() {
        // lis_date=ArrayList()
        val user: User? = User("龙女", "http://img1.3lian.com/2015/w8/31/d/101.jpg")
        val user1: User? = User("神雕侠侣", "http://pic34.nipic.com/20131009/13856848_092147728175_2.jpg")
        val user2: User? = User("古装剧照", "http://img1.3lian.com/2015/w8/31/d/106.jpg")
        val user3: User? = User("神雕侠侣", "http://y0.ifengimg.com/a/2014_50/42255a1a268405e.jpg")
        val user4: User? =
            User("功夫之王", "http://img.article.pchome.net/00/30/34/75/pic_lib/s960x639/gfzwbz_07s960x639.jpg")
        val user6: User? = User("三生三世十里桃花", "http://img5.duitang.com/uploads/item/201508/28/20150828105628_fixsN.jpeg")
        val user7: User? = User("古装剧照", "http://img3.duitang.com/uploads/item/201501/17/20150117224236_vYFmL.jpeg")
        val user8: User? = User("仙剑奇侠传", "https://i04picsos.sogoucdn.com/c22c6852707862f1")
        val user9: User? = User("浮生劫", "http://img1.3lian.com/2015/w8/31/d/103.jpg")
        val user10: User? = User(
            "神雕侠侣",
            "http://www.people.com.cn/mediafile/pic/20170727/3/1862992322915870199.jpg"
        )
        val user11: User? =
            User("神雕侠侣", "http://imgmini.dfshurufa.com/mobile/20160124080648_41ae9d6afc5da2b22c225f06a745dbcd_5.jpeg")
        val user12: User? = User("大雪", "http://img4q.duitang.com/uploads/item/201504/12/20150412H5412_jnG2s.jpeg")
        val user13: User? = User("神雕侠侣", "http://cdn.duitang.com/uploads/item/201404/07/20140407103812_cLN2r.jpeg")
        lis_date = listOf(user, user1, user2, user3, user4, user6, user7, user8, user9, user10, user11, user12, user13)
    }
}
