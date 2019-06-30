package io.voucherify.android.sample.store.injection.module

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.VoucherifyApplication
import io.voucherify.android.sample.store.ui.flow.AppNavigator
import io.voucherify.android.sample.store.ui.flow.Navigator
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: VoucherifyApplication): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideResources(application: VoucherifyApplication): Resources {
        return application.resources
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(application: VoucherifyApplication): SharedPreferences =
        application.getSharedPreferences("voucherify_prefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = AppNavigator()
}