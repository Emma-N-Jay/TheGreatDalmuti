package edu.up.cs301.GreatDalmuti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class surfaceDraw extends SurfaceView {
    public surfaceDraw(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas){

        //Paint pallette
        Paint purple = new Paint(0xFF402264);
        purple.setColor(0xFF402264);
        purple.setStyle(Paint.Style.FILL);

        //Create a bitmap that contains image
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.card_back);
        Bitmap backleft = BitmapFactory.decodeResource(getResources(), R.drawable.card_leftside);
        Bitmap backright = BitmapFactory.decodeResource(getResources(), R.drawable.card_rightside);

        back = Bitmap.createScaledBitmap(back, 250, 350, false);
        backleft = Bitmap.createScaledBitmap(backleft, 350, 250, false);
        backright = Bitmap.createScaledBitmap(backright, 350, 250, false);

        //draw the top hand
        canvas.drawBitmap(back,650, 10, null);
        canvas.drawBitmap(back,750, 10, null);
        canvas.drawBitmap(back,850, 10, null);
        canvas.drawBitmap(back,950, 10, null);
        canvas.drawBitmap(back,1050, 10, null);
        canvas.drawBitmap(back,1150, 10, null);
        canvas.drawBitmap(back,1250, 10, null);
        canvas.drawBitmap(back,1350, 10, null);
        canvas.drawBitmap(back,1450, 10, null);
        canvas.drawBitmap(back,1550, 10, null);

        //draw the left players hand
        canvas.drawBitmap(backleft,10, 200, null);
        canvas.drawBitmap(backleft,10, 250, null);
        canvas.drawBitmap(backleft,10, 300, null);
        canvas.drawBitmap(backleft,10, 350, null);
        canvas.drawBitmap(backleft,10, 400, null);
        canvas.drawBitmap(backleft,10, 450, null);
        canvas.drawBitmap(backleft,10, 500, null);
        canvas.drawBitmap(backleft,10, 550, null);
        canvas.drawBitmap(backleft,10, 600, null);
        canvas.drawBitmap(backleft,10, 650, null);


        //draw the right players hand
        canvas.drawBitmap(backright,2160, 200, null);
        canvas.drawBitmap(backright,2160, 250, null);
        canvas.drawBitmap(backright,2160, 300, null);
        canvas.drawBitmap(backright,2160, 350, null);
        canvas.drawBitmap(backright,2160, 400, null);
        canvas.drawBitmap(backright,2160, 450, null);
        canvas.drawBitmap(backright,2160, 500, null);
        canvas.drawBitmap(backright,2160, 550, null);
        canvas.drawBitmap(backright,2160, 600, null);
        canvas.drawBitmap(backright,2160, 650, null);

        canvas.drawText("# played:", 1500, 1500, purple);

    }
}
