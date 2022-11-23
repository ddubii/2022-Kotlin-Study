package com.umc.week8

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {

 @Insert
 fun insert(memo: Memo)

 @Delete
 fun delete(memo: Memo)

// @Query("DELETE * FROM MEMO")
// fun deleteAll() : MutableList<Memo>

 @Query("SELECT * FROM MEMO")
 fun selectAll() : MutableList<Memo>

 @Query("SELECT * FROM MEMO WHERE memoId = :memoId")
 fun selectByMemoId(memoId: Int): Memo

}
