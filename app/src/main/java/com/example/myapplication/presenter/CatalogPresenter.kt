package com.example.myapplication.presenter

import com.example.myapplication.ui.CatalogView
import moxy.MvpPresenter

class CatalogPresenter : MvpPresenter<CatalogView>() {

    private val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компютеры",
        "Ноутбуки"
    )

    fun setData() {
        viewState.setCategories(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

}