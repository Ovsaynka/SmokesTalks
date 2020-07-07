package com.example.smokestalks

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView

class VerticalTextView: AppCompatTextView {

    private val topDown: Boolean

    init {
        gravity.let {
            if (Gravity.isVertical(it) && (it and Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
                gravity = (it and Gravity.HORIZONTAL_GRAVITY_MASK) or Gravity.TOP
                topDown = false
            } else {
                topDown = true
            }
        }
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(canvas: Canvas) {
        val textPaint = paint
        textPaint.color = currentTextColor
        textPaint.drawableState = drawableState

        canvas.save()

        if (topDown) {
            canvas.translate(width.toFloat(), 0f)
            canvas.rotate(90f)
        } else {
            canvas.translate(0f, height.toFloat())
            canvas.rotate(-90f)
        }

        canvas.translate(
            compoundPaddingLeft.toFloat(),
            extendedPaddingTop.toFloat())

        layout.draw(canvas)
        canvas.restore()
    }
}