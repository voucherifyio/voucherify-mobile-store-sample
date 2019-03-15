package io.voucherify.android.sample.store.utils.views

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SimpleDividerItemDecoration : RecyclerView.ItemDecoration {
    private var divider: Drawable? = null
    private var orientation: Int = 0
    private val leftPadding: Int
    private val rightPadding: Int

    constructor(divider: Drawable?) {
        this.divider = divider
        this.leftPadding = 0
        this.rightPadding = 0
    }

    constructor(divider: Drawable?, leftPadding: Int, rightPadding: Int) {
        this.divider = divider
        this.leftPadding = leftPadding
        this.rightPadding = rightPadding
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            drawHorizontalDividers(canvas, parent)
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            drawVerticalDividers(canvas, parent)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) {
            return
        }

        orientation = (parent.layoutManager as LinearLayoutManager).orientation

        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.left = divider!!.intrinsicWidth
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.top = divider!!.intrinsicHeight
        }
    }

    private fun drawHorizontalDividers(canvas: Canvas, parent: RecyclerView) {
        val parentTop = parent.paddingTop
        val parentBottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount

        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val parentLeft = leftPadding + child.right + params.rightMargin
            val parentRight = rightPadding + parentLeft + divider!!.intrinsicWidth

            divider!!.setBounds(parentLeft, parentTop, parentRight, parentBottom)
            divider!!.draw(canvas)
        }
    }

    private fun drawVerticalDividers(canvas: Canvas, parent: RecyclerView) {
        val parentLeft = leftPadding + parent.paddingLeft
        val parentRight = parent.width - rightPadding - parent.paddingRight

        val childCount = parent.childCount

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val parentTop = child.bottom + params.bottomMargin
            val parentBottom = parentTop + divider!!.intrinsicHeight

            divider!!.setBounds(parentLeft, parentTop, parentRight, parentBottom)
            divider!!.draw(canvas)
        }
    }
}
