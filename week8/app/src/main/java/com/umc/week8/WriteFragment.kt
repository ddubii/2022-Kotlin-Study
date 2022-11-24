package com.umc.week8

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.umc.week8.databinding.WriteFragmentBinding

class WriteFragment : Fragment() {
    private lateinit var binding : WriteFragmentBinding
    private var roomDb : AppDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.write_fragment, container, false)

        val mActivity = activity as MainActivity?
        binding.saveBtn.setOnClickListener {
            //저장 버튼을 누를 경우
            val title_s = binding.memoTitle.text.toString()
            val content_s = binding.memoText.text.toString()

            roomDb = context?.let { AppDatabase.getInstance(it) }

            val raa = Runnable {
                val memo = Memo("${title_s}", "${content_s}")
                roomDb?.memoDao()?.insert(memo)!!
                //val memoList = roomDb?.memoDao()!!.selectAll()
                Log.d("db", "Memo List : ${memo}")
            }

            val thread = Thread(raa)
            thread.start()
            mActivity?.changeFragment(1)
        }


        return binding.root
    }

}
