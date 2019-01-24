package sc.tengsem.com.mykotlinonedemo

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import sc.tengsem.com.mykotlinonedemo.bigimageslook.ImagesBigLookActivity

@Suppress("UNREACHABLE_CODE")
class ImagesListAdapter(context: Context) : RecyclerView.Adapter<ImagesListAdapter.ImagesLookHolder>() {
    var context: Context = context
    var datas: ArrayList<User> = ArrayList()

    fun setData(data: List<User>) {
        datas.addAll(data)
        App.instance.setData(datas)
        notifyDataSetChanged()
    }

    fun getData(): ArrayList<User> {
        return datas
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesLookHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_images_look, parent, false)
        return ImagesLookHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ImagesLookHolder, position: Int) {
        Glide.with(context).load(datas[position].imagesUrl).into(holder.images_look)
        holder.text_look.text = datas[position].name
        holder.linear_look_potion.setOnClickListener {
            var intent = Intent()
            intent.setClass(context, ImagesBigLookActivity::class.java)
            intent.putExtra("position", position)
            /*  if(position==0){
                  intent.setClass(context,ImagesOneBigLookActivity::class.java)
              }else{

              }*/
            context.startActivity(intent)
        }
    }

    class ImagesLookHolder(view: View) : RecyclerView.ViewHolder(view) {
        var images_look: ImageView = view.findViewById(R.id.images_look)
        var text_look: TextView = view.findViewById(R.id.text_look)
        var linear_look_potion: LinearLayout = view.findViewById(R.id.linear_look_potion)
    }
}

