package com.threedee.data.source

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.threedee.data.model.BufferooEntity
import com.threedee.data.repository.BufferooRemote
import com.threedee.data.test.factory.BufferooFactory
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BufferooRemoteDataStoreTest {

    private lateinit var bufferooRemoteDataStore: BufferooRemoteDataStore

    private lateinit var bufferooRemote: BufferooRemote

    @Before
    fun setUp() {
        bufferooRemote = mock()
        bufferooRemoteDataStore = BufferooRemoteDataStore(bufferooRemote)
    }

    //<editor-fold desc="Clear Bufferoos">
    @Test(expected = UnsupportedOperationException::class)
    fun clearBufferoosThrowsException() {
        bufferooRemoteDataStore.clearBufferoos().test()
    }
    //</editor-fold>

    //<editor-fold desc="Save Bufferoos">
    @Test(expected = UnsupportedOperationException::class)
    fun saveBufferoosThrowsException() {
        bufferooRemoteDataStore.saveBufferoos(BufferooFactory.makeBufferooEntityList(2)).test()
    }
    //</editor-fold>

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getBufferoosCompletes() {
        stubBufferooCacheGetBufferoos(Flowable.just(BufferooFactory.makeBufferooEntityList(2)))
        val testObserver = bufferooRemote.getBufferoos().test()
        testObserver.assertComplete()
    }
    //</editor-fold>

    //<editor-fold desc="Stub helper methods">
    private fun stubBufferooCacheGetBufferoos(single: Flowable<List<BufferooEntity>>) {
        whenever(bufferooRemote.getBufferoos())
            .thenReturn(single)
    }
    //</editor-fold>

}