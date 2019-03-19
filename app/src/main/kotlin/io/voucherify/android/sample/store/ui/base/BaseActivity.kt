package io.voucherify.android.sample.store.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R

open class BaseActivity : DaggerAppCompatActivity() {

    open protected fun initActionBar(activity: AppCompatActivity) {
        setSupportActionBar(activity.findViewById(R.id.toolbar))
    }

    protected fun addFragment(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerId, fragment, tag)
        transaction.commit()
    }
}