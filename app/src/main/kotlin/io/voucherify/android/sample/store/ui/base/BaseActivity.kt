package io.voucherify.android.sample.store.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R

open class BaseActivity : DaggerAppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

    protected fun clearBackStack() {
        while (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
    }

    protected open fun initActionBar(activity: AppCompatActivity) {
        setSupportActionBar(activity.findViewById(R.id.toolbar))
    }

    protected fun addFragment(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerId, fragment, tag)
        transaction.commit()
    }

    protected fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(containerId, fragment, tag)
            .commit()
    }

    protected fun replaceFragmentWithBackStack(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(containerId, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}