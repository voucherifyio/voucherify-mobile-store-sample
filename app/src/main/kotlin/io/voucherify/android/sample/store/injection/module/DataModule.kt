package io.voucherify.android.sample.store.injection.module

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.voucherify.android.sample.store.data.local.AccountLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.SettingsLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.UserLocalPreferencesStorable
import io.voucherify.android.sample.store.data.local.persistence.customers.CustomersLocalPersistence

@Module
object DataModule {

    @Provides
    @Reusable
    fun provideUserLocalPreferences(sharedPreferences: SharedPreferences): UserLocalPreferencesStorable =
        UserLocalPreferencesStorable(sharedPreferences = sharedPreferences)

    @Provides
    @Reusable
    fun provideAccountLocalPreferences(sharedPreferences: SharedPreferences): AccountLocalPreferencesStorable =
        AccountLocalPreferencesStorable(sharedPreferences = sharedPreferences)

    @Provides
    @Reusable
    fun provideSettingsLocalPreferences(sharedPreferences: SharedPreferences): SettingsLocalPreferencesStorable =
        SettingsLocalPreferencesStorable(sharedPreferences = sharedPreferences)

    @Provides
    @Reusable
    fun provideCustomersLocalPersistence(sharedPreferences: SharedPreferences): CustomersLocalPersistence =
        CustomersLocalPersistence(sharedPreferences = sharedPreferences)

}