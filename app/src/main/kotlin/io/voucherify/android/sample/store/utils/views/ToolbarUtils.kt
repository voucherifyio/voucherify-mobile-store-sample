package io.voucherify.android.sample.store.utils.views

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import io.voucherify.android.sample.store.R

object ToolbarUtils {

    @IdRes
    private val TOOLBAR_ID = R.id.toolbar

    fun initActionBar(activity: AppCompatActivity) {
        initActionBarWithTitle(activity, "")
    }

    fun initActionBarWithTitle(activity: AppCompatActivity, @StringRes titleRes: Int, backArrow: Boolean = false) {
        initActionBarWithTitle(activity, activity.getString(titleRes), backArrow)
    }

    fun initActionBarWithTitle(activity: AppCompatActivity, title: CharSequence, backArrow: Boolean = false) {
        activity.setSupportActionBar(activity.findViewById(TOOLBAR_ID))
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(backArrow)
        activity.supportActionBar!!.title = title
    }

    fun hideActionBar(activity: AppCompatActivity) {
        activity.findViewById<Toolbar>(TOOLBAR_ID).visibility = View.GONE
    }

}