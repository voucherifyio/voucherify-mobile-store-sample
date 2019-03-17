package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.remote.api.VoucherifyAuthApi
import io.voucherify.android.sample.store.data.remote.api.VoucherifyCustomersApi
import io.voucherify.android.sample.store.data.remote.api.VoucherifyProductsApi
import io.voucherify.android.sample.store.data.repository.LoginRepository
import io.voucherify.android.sample.store.data.repository.VoucherifyLoginRepository
import io.voucherify.android.sample.store.data.repository.customers.CustomersRepository
import io.voucherify.android.sample.store.data.repository.customers.VoucherifyCustomersRepository
import io.voucherify.android.sample.store.data.repository.products.ProductsRepository
import io.voucherify.android.sample.store.data.repository.products.VoucherifyProductsRepository

@Module
class RepositoryModule {

    @Provides
    @Reusable
    fun provideLoginRepository(loginApi: VoucherifyAuthApi): LoginRepository =
        VoucherifyLoginRepository(loginApi = loginApi)

    @Provides
    @Reusable
    fun provideCustomersRepository(customersApi: VoucherifyCustomersApi): CustomersRepository =
        VoucherifyCustomersRepository(customersApi = customersApi)

    @Provides
    @Reusable
    fun provideProductsRepository(productsApi: VoucherifyProductsApi): ProductsRepository =
        VoucherifyProductsRepository(productsApi = productsApi)
}