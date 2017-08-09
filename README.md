# TipRadioButton
RadioButton添加消息提醒（小红点）

#### 效果图

废话很多！！！直接上图好吧

![Demo.gif](http://upload-images.jianshu.io/upload_images/4037756-715fbc19417d1f57.gif?imageMogr2/auto-orient/strip)


#### 代码实现

首先，需求很简单，只需要能多显示一个小红点就 OK 了，所以我们只需要在原本的 RadioButton 控件上绘制一个圆型的、红色的一个图案就可以了。

自定义一个 TipRadioButton 直接继承 RadioButton ，然后再 onDraw() 方法中绘制一个我们需要的小红点，并为其设置一个绘制开关。

* 定义小红点对象，设置圆角和红点显示的位置

```
private class Dot {
    int color;
    int radius;
    int marginTop;
    int marginRight;

    Dot() {
        float density = getContext().getResources().getDisplayMetrics().density;
        radius = (int) (5 * density);
        marginTop = (int) (3 * density);
        marginRight = (int) (3 * density);
        color = getContext().getResources().getColor(R.color.red);
    }

}
```

* 绘制 RadioButton

```
@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    if (isTipOn) {
        float cx = getWidth() - mDot.marginRight - mDot.radius;
        float cy = mDot.marginTop + mDot.radius;

        Drawable drawableTop = getCompoundDrawables()[1];
        if (drawableTop != null) {
            int drawableTopWidth = drawableTop.getIntrinsicWidth();
            if (drawableTopWidth > 0) {
                int dotLeft = getWidth() / 2 + drawableTopWidth / 2;
                cx = dotLeft + mDot.radius;
            }
        }

        Paint paint = getPaint();
        //save
        int tempColor = paint.getColor();

        paint.setColor(mDot.color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, mDot.radius, paint);

        //restore
        paint.setColor(tempColor);
    }
}
```

#### 打开方式

使用方法很简单，简单到你不需要看

```
<com.dreamfisn.tipdemo.TipRadioButton
        android:id="@+id/tip_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="50dp"
        />
```
