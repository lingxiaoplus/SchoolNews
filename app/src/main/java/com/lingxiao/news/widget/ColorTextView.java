package com.lingxiao.news.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.lingxiao.news.R;

import java.util.Random;

public class ColorTextView extends View{
    /**
     * 文本内容
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;

    private int ctvBackgroundColor;

    /**
     * 圆角大小
     */
    private int mCornerSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mtitleBound;
    private Paint mtitlePaint;
    private Paint mBackgroundPaint;
    private String[] colors = {"#4CAF50","#E57373","#64B5F6","#7986CB","#9575CD","#F06292","#ffb74d","#4db6ac","#4fc3f7","#4dd0e1"};
    public ColorTextView(Context context) {
        this(context,null);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColorTextView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ColorTextView_ctvText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.ColorTextView_ctvTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.ColorTextView_ctvTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.ColorTextView_ctvBackground:
                    //默认为白色
                    ctvBackgroundColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.ColorTextView_ctvCornerSize:
                    //默认圆角为0
                    mCornerSize = a.getInteger(attr, 0);
                    break;

            }

        }
        a.recycle();

        Random random = new Random();
        int ret = random.nextInt(colors.length-1);
        ctvBackgroundColor = Color.parseColor(colors[ret]);
        mtitlePaint = new Paint();
        mtitlePaint.setTextSize(mTitleTextSize);
        mtitleBound = new Rect();
        mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);

        mBackgroundPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setColor(ctvBackgroundColor);

    }


    public void setCtvBackgroundColor(int ctvBackgroundColor) {
        this.ctvBackgroundColor = ctvBackgroundColor;
    }

    public void setText(String text){
        this.mTitleText = text;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mtitlePaint.setTextSize(mTitleTextSize);
            mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);
            //measureText 是字体整体宽度 getTextBounds获得的是字符串的最小矩形区域
            int desired = (int) (getPaddingLeft() + mtitleBound.width() + getPaddingRight());
            width = Math.min(desired,widthSize);
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mtitlePaint.setTextSize(mTitleTextSize);
            mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);
            int desired = getPaddingTop() + mtitleBound.height() + getPaddingBottom();
            height = Math.max(desired,heightSize);
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rec = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(rec, mCornerSize, mCornerSize, mBackgroundPaint);
        mtitlePaint.setColor(mTitleTextColor);
        Paint.FontMetricsInt fontMetrics = mtitlePaint.getFontMetricsInt();
        int baseline = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(mTitleText, getPaddingLeft(), baseline, mtitlePaint);
    }
}
