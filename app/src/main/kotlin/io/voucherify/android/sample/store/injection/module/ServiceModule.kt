package io.voucherify.android.sample.store.injection.module

import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.persistence.customers.CustomersLocalPersistence
import io.voucherify.android.sample.store.data.repository.LoginRepository
import io.voucherify.android.sample.store.data.repository.customers.CustomersRepository
import io.voucherify.android.sample.store.data.repository.products.ProductsRepository
import io.voucherify.android.sample.store.data.repository.vouchers.VouchersRepository
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.data.service.customers.ProductsService
import io.voucherify.android.sample.store.data.service.customers.VoucherifyCustomersService
import io.voucherify.android.sample.store.data.service.customers.VoucherifyProductsService
import io.voucherify.android.sample.store.data.service.login.LoginService
import io.voucherify.android.sample.store.data.service.login.VoucherifyLoginService
import io.voucherify.android.sample.store.data.service.logout.LogoutService
import io.voucherify.android.sample.store.data.service.logout.VoucherifyLogoutService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.data.service.user.VoucherifyUserService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.data.service.user.perspective.VoucherifyCustomerPerspectiveService
import io.voucherify.android.sample.store.data.service.vouchers.VoucherifyVouchersService
import io.voucherify.android.sample.store.data.service.vouchers.VouchersService
import javax.inject.Singleton

@Module
object ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(userLocalPreferences: UserLocalPreferencesStorable): UserService =
        VoucherifyUserService(userLocalPreferences = userLocalPreferences)

    @Provides
    @Singleton
    fun provideLoginService(
        loginRepository: LoginRepository,
        userLocalPreferences: UserLocalPreferencesStorable,
        accountLocalPreferences: AccountLocalPreferencesStorable
    ): LoginService =
        VoucherifyLoginService(
            loginRepository = loginRepository,
            userLocalPreferences = userLocalPreferences,
            accountLocalPreferences = accountLocalPreferences
        )

    @Provides
    @Singleton
    fun provideLogoutService(
        userLocalPreferences: UserLocalPreferencesStorable,
        accountLocalPreferences: AccountLocalPreferencesStorable
    ): LogoutService =
        VoucherifyLogoutService(
            userLocalPreferences = userLocalPreferences,
            accountLocalPreferences = accountLocalPreferences
        )

    @Provides
    @Singleton
    fun provideCustomersService(customersRepository: CustomersRepository): CustomersService =
        VoucherifyCustomersService(customersRepository = customersRepository)

    @Provides
    @Singleton
    fun provideProductsService(productsRepository: ProductsRepository): ProductsService =
        VoucherifyProductsService(productsRepository = productsRepository)

    @Provides
    @Singleton
    fun provideVouchersService(vouchersRepository: VouchersRepository): VouchersService =
        VoucherifyVouchersService(vouchersRepository = vouchersRepository)

    @Provides
    @Singleton
    fun provideUserPerspectiveService(customersLocalPersistence: CustomersLocalPersistence): CustomerPerspectiveService =
        VoucherifyCustomerPerspectiveService(customersLocalPersistence = customersLocalPersistence)
}