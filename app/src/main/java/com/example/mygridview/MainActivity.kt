package com.example.mygridview

import android.content.Context
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mygridview.model.MenuModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //созднание списка картинок и названий

    var modelList = ArrayList<MenuModel>()

    var names = arrayOf(

        "Профиль",
        "Новости",
        "Информация",
        "Отзывы",
        "Путёвка",
        "Галерея",
        "Организациям",
        "Сотрудники",
        "Обратная связь",
        "Функции",
        "Контакты",
        "Разработчики"

    )


    var img = intArrayOf(
        R.drawable.ic_profile_c,
        R.drawable.ic_news,
        R.drawable.ic_info,
        R.drawable.ic_otzv,
        R.drawable.ic_tickets,
        R.drawable.ic_gallery,
        R.drawable.ic_organize,
        R.drawable.ic_personal,
        R.drawable.ic_link,
        R.drawable.ic_ability,
        R.drawable.ic_contacts,
        R.drawable.ic_dev
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in names.indices){
            modelList.add(MenuModel(names[i],img[i]))
        }
        var customAdapter = CustomAdapter(modelList, this)

        gridView.adapter = customAdapter




    }


    @Suppress("NAME_SHADOWING")
    class CustomAdapter(
        var itemModal : ArrayList<MenuModel>,
        context : Context
    ): BaseAdapter(){

        // не поняла эту строчку
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //создание отдельных элиментов списка
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            if (view == null)
                view = layoutInflater.inflate(R.layout.row_items,viewGroup, false)

            val tvImageName = view?.findViewById<TextView>(R.id.image_name)
            val imageView = view?.findViewById<ImageView>(R.id.image)

           tvImageName?.text = itemModal[position].name
            imageView?.setImageResource(itemModal[position].img!!)


            return view!!



        }

        override fun getItem(position: Int): Any {
            return itemModal[position]
        }

        override fun getItemId(position: Int): Long {
          return position.toLong()
        }

        // Количество выводимых объектов
        override fun getCount(): Int {
            return itemModal.size
        }

    }
}