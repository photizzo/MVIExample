package com.threedee.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.threedee.cache.db.constants.BufferooConstants
import com.threedee.cache.model.CachedBufferoo

@Dao
abstract class CachedBufferooDao {

    @Query(BufferooConstants.QUERY_BUFFEROOS)
    abstract fun getBufferoos(): List<CachedBufferoo>

    @Query(BufferooConstants.DELETE_ALL_BUFFEROOS)
    abstract fun clearBufferoos()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBufferoo(cachedBufferoo: CachedBufferoo)

}