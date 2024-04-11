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

            //Bitmaps for the pile
            Bitmap deckDal;
            Bitmap deckArch;
            Bitmap deckEarl;
            Bitmap deckBaron;
            Bitmap deckAbb;
            Bitmap deckKnight;
            Bitmap deckSeam;
            Bitmap deckMason;
            Bitmap deckCook;
            Bitmap deckShep;
            Bitmap deckStonecut;
            Bitmap deckPeasant;
            Bitmap deckJester;

            //set the purple color
            purple.setColor(0xFF402264);
            purple.setTextSize(25);
            this.setBackgroundColor(0Xffffffff);
            purple.setStyle(Paint.Style.FILL);


            //Create a bitmap that contains image
            //back of the cards
            Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.card_back);
            Bitmap backleft = BitmapFactory.decodeResource(getResources(), R.drawable.card_leftside);
            Bitmap backright = BitmapFactory.decodeResource(getResources(), R.drawable.card_rightside);

            //Player cards
            Bitmap dalmuti = BitmapFactory.decodeResource(getResources(), R.drawable.great_dalmuti);
            Bitmap archbish = BitmapFactory.decodeResource(getResources(), R.drawable.arch_bishop);
            Bitmap earlmarsh = BitmapFactory.decodeResource(getResources(), R.drawable.earl_marshal);
            Bitmap baroness = BitmapFactory.decodeResource(getResources(), R.drawable.baroness);
            Bitmap abbess = BitmapFactory.decodeResource(getResources(), R.drawable.abbess);
            Bitmap knight = BitmapFactory.decodeResource(getResources(), R.drawable.knight);
            Bitmap seamstress = BitmapFactory.decodeResource(getResources(), R.drawable.seamstress);
            Bitmap mason = BitmapFactory.decodeResource(getResources(), R.drawable.mason);
            Bitmap cook = BitmapFactory.decodeResource(getResources(), R.drawable.cook);
            Bitmap shepherdess = BitmapFactory.decodeResource(getResources(), R.drawable.sheperdess);
            Bitmap stone_cutter = BitmapFactory.decodeResource(getResources(), R.drawable.stonecutter);
            Bitmap peasant = BitmapFactory.decodeResource(getResources(), R.drawable.peasant);


            //scale the bitmaps
            //back of the card
            back = Bitmap.createScaledBitmap(back, 125, 175, false);
            backleft = Bitmap.createScaledBitmap(backleft, 175, 125, false);
            backright = Bitmap.createScaledBitmap(backright, 175, 125, false);

            //Player cards
            dalmuti = Bitmap.createScaledBitmap(dalmuti, 125, 175, false);
            archbish = Bitmap.createScaledBitmap(archbish, 125, 175, false);
            earlmarsh = Bitmap.createScaledBitmap(earlmarsh,125, 175, false);
            baroness = Bitmap.createScaledBitmap(baroness, 125, 175, false);
            abbess = Bitmap.createScaledBitmap(abbess, 125, 175, false);
            knight = Bitmap.createScaledBitmap(knight, 125, 175, false);
            seamstress = Bitmap.createScaledBitmap(seamstress, 125, 175, false);
            mason = Bitmap.createScaledBitmap(mason, 125, 175, false);
            cook = Bitmap.createScaledBitmap(cook, 125, 175, false);
            shepherdess = Bitmap.createScaledBitmap(shepherdess, 125, 175, false);
            stone_cutter = Bitmap.createScaledBitmap(stone_cutter, 125, 175, false);
            peasant = Bitmap.createScaledBitmap(peasant, 125, 175, false);

            //scale the play pile cards
            deckDal = Bitmap.createScaledBitmap(dalmuti, 175, 225, false);

            //draw the top hand
            canvas.drawBitmap(back, 450, 10, null);
            canvas.drawBitmap(back, 550, 10, null);
            canvas.drawBitmap(back, 650, 10, null);
            canvas.drawBitmap(back, 750, 10, null);
            canvas.drawBitmap(back, 850, 10, null);
            canvas.drawBitmap(back, 950, 10, null);
            canvas.drawBitmap(back, 1050, 10, null);
            canvas.drawBitmap(back, 1150, 10, null);
            canvas.drawBitmap(back, 1250, 10, null);
            canvas.drawBitmap(back, 1350, 10, null);

            //draw the left players hand
            canvas.drawBitmap(backleft, 10, 100, null);
            canvas.drawBitmap(backleft, 10, 125, null);
            canvas.drawBitmap(backleft, 10, 150, null);
            canvas.drawBitmap(backleft, 10, 175, null);
            canvas.drawBitmap(backleft, 10, 200, null);
            canvas.drawBitmap(backleft, 10, 225, null);
            canvas.drawBitmap(backleft, 10, 250, null);
            canvas.drawBitmap(backleft, 10, 275, null);
            canvas.drawBitmap(backleft, 10, 300, null);
            canvas.drawBitmap(backleft, 10, 325, null);


            //draw the right players hand
            canvas.drawBitmap(backright, 1785, 100, null);
            canvas.drawBitmap(backright, 1785, 125, null);
            canvas.drawBitmap(backright, 1785, 150, null);
            canvas.drawBitmap(backright, 1785, 175, null);
            canvas.drawBitmap(backright, 1785, 200, null);
            canvas.drawBitmap(backright, 1785, 225, null);
            canvas.drawBitmap(backright, 1785, 250, null);
            canvas.drawBitmap(backright, 1785, 275, null);
            canvas.drawBitmap(backright, 1785, 300, null);
            canvas.drawBitmap(backright, 1785, 325, null);

            //Draw text for num card
            canvas.drawText("# played:" + state.getNumInPile(),  750, 500, purple);

            //Time to do the pile!
            canvas.drawBitmap(deckDal, 900, 250, null);

            //TODO Fix what card is placed on the pile based on what card was just played
            if(state.getRankInPile() == 0){
                canvas.drawBitmap(dalmuti, 900, 250, null);
            }

    }
}
