package com.umc.week8

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.umc.week8.databinding.FavFragmentBinding
import com.umc.week8.databinding.MainFragmentBinding
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences




class FavFragment : Fragment() {

    private lateinit var binding : FavFragmentBinding
    private var roomDb : AppDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //해당 클래스와 연결될 xml레이아웃을 넣어준다
        binding = DataBindingUtil.inflate(inflater, R.layout.fav_fragment, container, false)
        roomDb = context?.let { AppDatabase.getInstance(it) }
        val sharedPrefs = context?.getSharedPreferences("fav",MODE_PRIVATE)
        val fID = sharedPrefs?.getString("favID","")

        val raa = Runnable {
            //최근에 작성한 메모가 위에 올라올 수 있도록
            val memoList = roomDb?.memoDao()!!.selectByMemoId(fID!!.toInt()+1)
            //memoList.reverse()
            val memoRVAdapter = MemoListRVAdapter(memoList)
            binding.favListView.adapter = memoRVAdapter
        }
        val thread = Thread(raa)
        thread.start()

        //전체목록으로 돌아가는 버튼 -> MainFragment로 이동
        val mActivity = activity as MainActivity?
         binding.goBackBtn.setOnClickListener {
             mActivity?.changeFragment(1)
         }
        return binding.root
    }

}