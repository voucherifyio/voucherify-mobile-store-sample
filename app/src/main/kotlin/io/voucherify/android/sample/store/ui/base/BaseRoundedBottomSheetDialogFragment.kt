package io.voucherify.android.sample.store.ui.base

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.voucherify.android.sample.store.R

open class RoundedBottomSheetDialogFragment : DaggerBottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.Voucherify_BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)
}