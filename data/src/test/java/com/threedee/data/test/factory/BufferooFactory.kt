package com.threedee.data.test.factory

import com.threedee.data.model.BufferooEntity
import com.threedee.data.test.factory.DataFactory.Factory.randomLong
import com.threedee.data.test.factory.DataFactory.Factory.randomUuid
import com.threedee.domain.model.Bufferoo

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooEntity(): BufferooEntity {
            return BufferooEntity(randomLong(), randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferoo(): Bufferoo {
            return Bufferoo(randomLong(), randomUuid(), randomUuid(), randomUuid())
        }

        fun makeBufferooEntityList(count: Int): List<BufferooEntity> {
            val bufferooEntities = mutableListOf<BufferooEntity>()
            repeat(count) {
                bufferooEntities.add(makeBufferooEntity())
            }
            return bufferooEntities
        }

        fun makeBufferooList(count: Int): List<Bufferoo> {
            val bufferoos = mutableListOf<Bufferoo>()
            repeat(count) {
                bufferoos.add(makeBufferoo())
            }
            return bufferoos
        }

    }

}