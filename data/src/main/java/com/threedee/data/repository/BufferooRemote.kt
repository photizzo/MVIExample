package com.threedee.data.repository

import com.threedee.data.model.BufferooEntity
import io.reactivex.Flowable

/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface BufferooRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getBufferoos(): Flowable<List<BufferooEntity>>

}