package io.voucherify.android.sample.store.data.local

interface LocalPreferencesStorable<T> {
    fun save(data: T?)

    fun load(): T?
}