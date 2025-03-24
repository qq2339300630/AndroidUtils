package com.example.androidutils.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.androidutils.R
import androidx.core.content.withStyledAttributes

class CircleView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet, 0) {
    var mColor = Color.RED

    val mPaint = Paint()
    init {
        context.withStyledAttributes(attributeSet, R.styleable.CircleView) {
            mColor = getColor(R.styleable.CircleView_circleColor, mColor)
            mPaint.setColor(mColor)
        }
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // super 中兼容了EXACTLY
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val minWidth = 200
        val minHeight = 200
        // 兼容 wrap_content
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST && MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
           setMeasuredDimension(minWidth.toInt(), minHeight.toInt())
        } else if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(minWidth,heightMeasureSpec)
        } else if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpec,minHeight)
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        // 兼容 padding
        val radius = (width - paddingStart - paddingEnd).coerceAtMost(height - paddingTop - paddingBottom) / 2f
        canvas.drawCircle((width - paddingStart - paddingEnd) / 2f + paddingStart, (height - paddingTop - paddingBottom) / 2f + paddingTop, radius, mPaint)
    }
}