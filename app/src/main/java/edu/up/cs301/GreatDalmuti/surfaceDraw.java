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

    //Paint pallette
    public Paint purple = new Paint();
    private GDState state;


    public surfaceDraw(Context context, AttributeSet attr) {
        super(context, attr);
        setWillNotDraw(false);
    }

    public void setCurrentGameState(GDState state){
        this.state = state;
    }
    @Override
    protected void onDraw(Canvas canvas){

        //set the purple color
        purple.setColor(0xFF402264);
        purple.setTextSize(50);
        //purple.setStyle(Paint.Style.FILL);



        //Create a bitmap that contains image
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.card_back);
        Bitmap backleft = BitmapFactory.decodeResource(getResources(), R.drawable.card_leftside);
        Bitmap backright = BitmapFactory.decodeResource(getResources(), R.drawable.card_rightside);
        Bitmap dalmuti = BitmapFactory.decodeResource(getResources(), R.drawable.great_dalmuti);


        //scale the bitmap
        back = Bitmap.createScaledBitmap(back, 50, 150, false);
        backleft = Bitmap.createScaledBitmap(backleft, 50, 150, false);
        backright = Bitmap.createScaledBitmap(backright, 50, 150, false);
        dalmuti = Bitmap.createScaledBitmap(dalmuti, 50, 100, false);

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

        //Draw text??
        canvas.drawText("# played:" + state.getNumInPile() , 1500, 1500, purple);

        //Time to do the pile!
        canvas.drawBitmap(dalmuti,1500, 1500, null);

    }
}
