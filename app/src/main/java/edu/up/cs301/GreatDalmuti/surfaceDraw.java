package edu.up.cs301.GreatDalmuti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;

public class surfaceDraw extends SurfaceView {
    public surfaceDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){

        //Create a bitmap that contains image
        Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.abbess);

        test = Bitmap.createScaledBitmap(test, 100, 100, false);

        //canvas.drawBitmap(test);
        canvas.drawBitmap(test,0, 0, Color.BLACK);
    }
}
