package io.voucherify.android.sample.store.data.local.persistence.customers

import android.content.SharedPreferences
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistence
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistenceKey
import io.voucherify.android.sample.store.utils.extensions.get
import io.voucherify.android.sample.store.utils.extensions.set
import java.util.*

class CustomersLocalPersistence(private val sharedPreferences: SharedPreferences) : LocalPersistence<LocalCustomer> {

    private var moshi: Moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()

    override fun save(items: List<LocalCustomer>) {

        val type = Types.newParameterizedType(List::class.java, LocalCustomer::class.java)
        val jsonAdapter: JsonAdapter<List<LocalCustomer>> = moshi.adapter(type)
        val json = jsonAdapter.toJson(items)

        sharedPreferences[LocalPersistenceKey.Customers.customers] = json
    }

    override fun loadAll(): List<LocalCustomer> {
        val type = Types.newParameterizedType(List::class.java, LocalCustomer::class.java)
        val jsonAdapter: JsonAdapter<List<LocalCustomer>> = moshi.adapter(type)

        val json = sharedPreferences[LocalPersistenceKey.Customers.customers, "[]"] ?: ""

        return jsonAdapter.fromJson(json) ?: emptyList()
    }

}