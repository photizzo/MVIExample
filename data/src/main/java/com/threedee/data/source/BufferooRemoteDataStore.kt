package com.threedee.data.source

import com.threedee.data.model.BufferooEntity
import com.threedee.data.repository.BufferooDataStore
import com.threedee.data.repository.BufferooRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class BufferooRemoteDataStore @Inject constructor(private val bufferooRemote: BufferooRemote) :
    BufferooDataStore {

    override fun clearBufferoos(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveBufferoos(bufferoos: List<BufferooEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getBufferoos(): Flowable<List<BufferooEntity>> {
        return bufferooRemote.getBufferoos()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

}