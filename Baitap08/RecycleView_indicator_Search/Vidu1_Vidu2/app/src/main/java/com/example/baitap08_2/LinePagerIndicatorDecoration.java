package com.example.baitap08_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final int indicatorHeight;
    private final int indicatorItemPadding;
    private final float indicatorItemWidth;
    private final Paint paint = new Paint();

    public LinePagerIndicatorDecoration(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        indicatorHeight = (int) (density * 16);
        indicatorItemWidth = density * 16;
        indicatorItemPadding = (int) (density * 4);

        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);

        int itemCount = parent.getAdapter().getItemCount();
        if (itemCount <= 1) return;

        float totalLength = indicatorItemWidth * itemCount;
        float paddingBetweenItems = Math.max(0, itemCount - 1) * indicatorItemPadding;
        float indicatorTotalWidth = totalLength + paddingBetweenItems;
        float indicatorStartX = (parent.getWidth() - indicatorTotalWidth) / 2f;
        float indicatorPosY = parent.getHeight() - indicatorHeight / 2f;

        for (int i = 0; i < itemCount; i++) {
            float centerX = indicatorStartX + indicatorItemWidth / 2f + i * (indicatorItemWidth + indicatorItemPadding);
            canvas.drawCircle(centerX, indicatorPosY, indicatorItemWidth / 4, paint);
        }
    }
}