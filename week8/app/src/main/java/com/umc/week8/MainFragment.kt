package com.umc.week8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.RoomDatabase
import com.umc.week8.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding : MainFragmentBinding
    private var roomDb : AppDatabase? = null
    private val MemoDataList = mutableListOf<MemoModel>()
    private val memoIdList = mutableListOf<String>()

    //private lateinit var memoRVAdapter : MemoListRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //해당 클래스와 연결될 xml레이아웃을 넣어준다
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        roomDb = context?.let { AppDatabase.getInstance(it) }

        val raa = Runnable {
            val memo = Memo("한비2", "우하하")
            //roomDb?.memoDao()?.insert(memo)!!

            val memoList = roomDb?.memoDao()!!.selectAll()
            Log.d("db", "Memo List : ${memoList}")

            memoList.reverse()

            val memoRVAdapter = MemoListRVAdapter(memoList)
            binding.memoListView.adapter = memoRVAdapter
        }
        val thread = Thread(raa)
        thread.start()


        //return inflater.inflate(R.layout.main_fragment, container, false)
//        val memoList = mutableListOf<MemoModel>()
//        memoList.add(MemoModel("제목1","내용1"))
//        memoList.add(MemoModel("제목2","내용2"))
//        memoList.add(MemoModel("제목3","내용3"))
//        memoList.add(MemoModel("제목4","내용4"))

        val mActivity = activity as MainActivity?
         binding.writeBtn.setOnClickListener {
             mActivity?.changeFragment(2)
         }

        return binding.root
    }

}