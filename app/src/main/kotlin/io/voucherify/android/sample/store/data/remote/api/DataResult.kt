package io.voucherify.android.sample.store.data.remote.api

class DataResult<T>(val status: Status, val data: T? = null, val error: Throwable? = null) {

    companion object {
        fun <T> succes(data: T?) = DataResult(Status.SUCCESS, data)
        fun <T> error(error: Throwable?) = DataResult<T>(Status.ERROR, null, error)
    }

    enum class Status {
        SUCCESS, ERROR
    }
}