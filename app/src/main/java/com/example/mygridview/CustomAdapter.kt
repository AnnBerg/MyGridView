package com.example.mygridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mygridview.model.MenuModel

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