package com.threedee.data.source

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.threedee.data.model.BufferooEntity
import com.threedee.data.repository.BufferooCache
import com.threedee.data.test.factory.BufferooFactory
import io.reactivex.Completable
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BufferooCacheDataStoreTest {

    private lateinit var bufferooCacheDataStore: BufferooCacheDataStore

    private lateinit var bufferooCache: BufferooCache

    @Before
    fun setUp() {
        bufferooCache = mock()
        bufferooCacheDataStore = BufferooCacheDataStore(bufferooCache)
    }

    //<editor-fold desc="Clear Bufferoos">
    @Test
    fun clearBufferoosCompletes() {
        stubBufferooCacheClearBufferoos(Completable.complete())
        val testObserver = bufferooCacheDataStore.clearBufferoos().test()
        testObserver.assertComplete()
    }
    //</editor-fold>

    //<editor-fold desc="Save Bufferoos">
    @Test
    fun saveBufferoosCompletes() {
        stubBufferooCacheSaveBufferoos(Completable.complete())
        val testObserver = bufferooCacheDataStore.saveBufferoos(
            BufferooFactory.makeBufferooEntityList(2)
        ).test()
        testObserver.assertComplete()
    }
    //</editor-fold>

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getBufferoosCompletes() {
        stubBufferooCacheGetBufferoos(Flowable.just(BufferooFactory.makeBufferooEntityList(2)))
        val testObserver = bufferooCacheDataStore.getBufferoos().test()
        testObserver.assertComplete()
    }
    //</editor-fold>

    //<editor-fold desc="Stub helper methods">
    private fun stubBufferooCacheSaveBufferoos(completable: Completable) {
        whenever(bufferooCache.saveBufferoos(any()))
            .thenReturn(completable)
    }

    private fun stubBufferooCacheGetBufferoos(single: Flowable<List<BufferooEntity>>) {
        whenever(bufferooCache.getBufferoos())
            .thenReturn(single)
    }

    private fun stubBufferooCacheClearBufferoos(completable: Completable) {
        whenever(bufferooCache.clearBufferoos())
            .thenReturn(completable)
    }
    //</editor-fold>

}