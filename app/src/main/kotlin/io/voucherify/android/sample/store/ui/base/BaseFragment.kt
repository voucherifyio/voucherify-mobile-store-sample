package io.voucherify.android.sample.store.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

abstract class BaseFragment : Fragment() {

    @LayoutRes
    protected abstract fun fragmentLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(fragmentLayoutId(), container, false)
    }
}