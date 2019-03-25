package io.voucherify.android.sample.store.data.local.persistence.customers

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistence
import io.voucherify.android.sample.store.utils.extensions.get
import io.voucherify.android.sample.store.utils.extensions.set
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistenceKey

class CustomersLocalPersistence(private val sharedPreferences: SharedPreferences) : LocalPersistence<LocalCustomer> {

    override fun save(items: List<LocalCustomer>) {

        val type = Types.newParameterizedType(List::class.java, LocalCustomer::class.java)
        val jsonAdapter: JsonAdapter<List<LocalCustomer>> = Moshi.Builder().build().adapter(type)
        val json = jsonAdapter.toJson(items)

        sharedPreferences[LocalPersistenceKey.Customers.customers] = json
    }

    override fun loadAll(): List<LocalCustomer> {
        val type = Types.newParameterizedType(List::class.java, LocalCustomer::class.java)
        val jsonAdapter: JsonAdapter<List<LocalCustomer>> = Moshi.Builder().build().adapter(type)

        val json = sharedPreferences[LocalPersistenceKey.Customers.customers, "[]"] ?: ""

        return jsonAdapter.fromJson(json) ?: emptyList()
    }

}