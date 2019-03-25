package io.voucherify.android.sample.store.data.local.persistence

interface LocalPersistence<T> {

    fun save(items: List<T>)

    fun loadAll(): List<T>

}