package wang.xiaop.movieplay.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * 为了测试  Canvas.rotate()。  回答网友的质疑，确认自己代码没有问题
 * Created by 王攀 on 2017/8/23.
 */
class CanvesView : View {
    constructor(context: Context) : super(context) {
        initView(context)
    }


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    val mPaint: Paint = Paint()
    private fun initView(context: Context) {
        mPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var rect = Rect(0, 0, 200, 200)
        mPaint.color = Color.BLUE
        canvas?.drawRect(rect, mPaint)
        mPaint.color = Color.RED
        canvas?.rotate(30F)
        canvas?.drawRect(rect, mPaint)
    }
}