package io.voucherify.android.sample.store.utils.views

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.DrawableCompat

object DrawableUtils {

    fun tintMyDrawable(drawable: Drawable, color: Int): Drawable {
        var drawable = drawable
        drawable = DrawableCompat.wrap(drawable)
        DrawableCompat.setTint(drawable, color)
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
        return drawable
    }
}