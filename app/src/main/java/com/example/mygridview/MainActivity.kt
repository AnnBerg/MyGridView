package com.example.mygridview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.mygridview.model.MenuModel
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
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
        val customAdapter = CustomAdapter(modelList, this)

        gridView.adapter = customAdapter

        gridView.onItemClickListener =
            OnItemClickListener { parent, v, position, id ->
                // ClickLog
                Log.e("name",modelList[position].name)

              val intentProfile = Intent(this,ProfileActivity::class.java)
                intent.putExtra("data",modelList[position])

                when (modelList[position].name) {
                  "Профиль"  ->  startActivity(intentProfile)

                  }
                      


            }



    }



}

