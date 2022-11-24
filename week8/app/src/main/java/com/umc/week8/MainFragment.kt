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
import com.umc.week8.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding : MainFragmentBinding
    private var roomDb : AppDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //해당 클래스와 연결될 xml레이아웃을 넣어준다
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        roomDb = context?.let { AppDatabase.getInstance(it) }

        val raa = Runnable {
            //최근에 작성한 메모가 위에 올라올 수 있도록
            val memoList = roomDb?.memoDao()!!.selectAll()
            //memoList.reverse()
            val memoRVAdapter = MemoListRVAdapter(memoList)
            binding.memoListView.adapter = memoRVAdapter
        }
        
        val thread = Thread(raa)
        thread.start()

        //새 메모 작성하는 버튼 -> WriteFragment로 이동
        val mActivity = activity as MainActivity?
         binding.writeBtn.setOnClickListener {
             mActivity?.changeFragment(2)
         }

        val sharedPrefs = context?.getSharedPreferences("fav", Context.MODE_PRIVATE)
        val editor = sharedPrefs?.edit()

        //즐겨찾기에 추가하기
        binding.memoListView.setOnItemClickListener { parent, view, position, id ->
            editor?.putString("favID", "${position}")
            editor?.apply()
            Toast.makeText(context, "${position + 1}번째 글이 즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
        }

        //즐겨찾기 fragment로 이동
        binding.myFavBtn.setOnClickListener {
            mActivity?.changeFragment(3)
        }
        return binding.root
    }
}