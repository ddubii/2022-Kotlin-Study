package com.umc.week8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText

class MemoListRVAdapter(val memoList : MutableList<Memo>) : BaseAdapter() {

    override fun getCount(): Int {
        return memoList.size
    }

    override fun getItem(position: Int): Any {
        return memoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.memo_item, parent, false)
        }

        val title = view?.findViewById<TextView>(R.id.titleArea)
        val content = view?.findViewById<TextView>(R.id.contentArea)

        title!!.text = memoList[position].title
        content!!.text = memoList[position].content

        return view!!
    }
}