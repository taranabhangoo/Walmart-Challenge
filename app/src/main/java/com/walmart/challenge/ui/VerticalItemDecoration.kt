package com.walmart.challenge.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.walmart.challenge.R
import com.walmart.challenge.common.dpToPx

class VerticalItemDecoration(
    private val context: Context,
    private val spacing: Int = 8,
    private val lineHeight: Int = 2,
    private val lineColor: Int = ContextCompat.getColor(context, R.color.line_color)
) : RecyclerView.ItemDecoration() {

    private val linePaint = Paint().apply {
        color = lineColor
        strokeWidth = lineHeight.toFloat()
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val top = child.bottom + spacing.dpToPx(context)
            val bottom = top + lineHeight.dpToPx(context)
            canvas.drawLine(
                left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(),
                linePaint!!
            )
        }
    }
}