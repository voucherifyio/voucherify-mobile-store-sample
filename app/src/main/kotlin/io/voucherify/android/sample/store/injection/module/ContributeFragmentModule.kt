package io.voucherify.android.sample.store.injection.module

import dagger.Module
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomerDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.customers.admin.CustomersAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.order.OrderFragmentModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductAdminDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.products.admin.ProductsAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.products.customer.CustomerProductsFragmentModule
import io.voucherify.android.sample.store.injection.module.products.customer.details.CustomerProductDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.settings.admin.SettingsAdminFragmentModule
import io.voucherify.android.sample.store.injection.module.settings.admin.UserSwitchFragmentModule
import io.voucherify.android.sample.store.injection.module.settings.customer.SettingsCustomerFragmentModule
import io.voucherify.android.sample.store.injection.module.shoppingcart.list.ShoppingCartListFragmentModule
import io.voucherify.android.sample.store.injection.module.vouchers.admin.VoucherAdminDetailsFragmentModule
import io.voucherify.android.sample.store.injection.module.vouchers.admin.VouchersAdminFragmentModule

@Module(
    includes = [
        SettingsAdminFragmentModule::class,
        CustomersAdminFragmentModule::class,
        CustomerDetailsFragmentModule::class,
        ProductsAdminFragmentModule::class,
        ProductAdminDetailsFragmentModule::class,
        VouchersAdminFragmentModule::class,
        VoucherAdminDetailsFragmentModule::class,
        UserSwitchFragmentModule::class,
        SettingsCustomerFragmentModule::class,
        CustomerProductsFragmentModule::class,
        CustomerProductDetailsFragmentModule::class,
        ShoppingCartListFragmentModule::class,
        OrderFragmentModule::class
    ]
)
abstract class ContributeFragmentModule