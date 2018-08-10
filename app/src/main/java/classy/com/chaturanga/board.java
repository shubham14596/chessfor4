package classy.com.chaturanga;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public class board extends Drawable {
    Context c;
    Bitmap  back,boat,rook,knight,king,pawn,rboat,rrook,rknight,rking,rpawn,gboat,grook,gknight,gking,gpawn,yboat,yrook,yknight,yking,ypawn,bboat,brook,bknight,bking,bpawn;
    static int wide;
    static int step;
    static Bitmap moves=null;
    board(Context cxt, int size){
        c= cxt;
        Resources r = c.getResources();
        wide = size;
        alphabeta.init();
        boat =Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.boat),wide/8,wide/8,true);
        rook=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.rook),wide/8,wide/8,true);
        knight=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.knight),wide/8,wide/8,true);
        king=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.king),wide/8,wide/8,true);
        pawn=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.pawn),wide/8,wide/8,true);
        back = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r,R.drawable.backsq),wide,wide,true);
        grook = tintImage(rook, Color.GREEN);
        gknight = tintImage(knight, Color.GREEN);
        gking = tintImage(king, Color.GREEN);
        gboat = tintImage(boat, Color.GREEN);
        gpawn = tintImage(pawn, Color.GREEN);
        yrook = tintImage(rook, Color.YELLOW);
        yknight = tintImage(knight, Color.YELLOW);
        yking = tintImage(king, Color.YELLOW);
        yboat = tintImage(boat, Color.YELLOW);
        ypawn = tintImage(pawn, Color.YELLOW);
        brook = tintImage(rook, Color.BLACK);
        bknight = tintImage(knight, Color.BLACK);
        bking = tintImage(king, Color.BLACK);
        bboat = tintImage(boat, Color.BLACK);
        bpawn = tintImage(pawn, Color.BLACK);
    }

    @SuppressLint("Range")
    @Override
    public void draw(Canvas canvas) {
        // draw board

        // background

        canvas.drawBitmap(back,0,0,null);
        if(moves!=null)
        canvas.drawBitmap(moves,0,0,null);

        int border=6;
        Paint p = new Paint();
        p.setStrokeWidth(border);
        float points[]=new float[72];   // horizon. and vertical lines coordinates

        p.setARGB(255,0,200,0);
        step = wide/8;

        points[2]=points[39]=step*8;
        for(int i=1; i<=8;i++){
            points[i*4]=points[i*4+33]=i*step;
            points[i*4+2]=points[i*4+35]=i*step;
            points[i*4+3]=points[i*4+34]=step*8;
        }

        canvas.drawLines(points,p);

        // pieces

        Bitmap piece;
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                piece =null;
            switch(alphabeta.Chessboard[j][i]){
                case ' ': break;
                case 'p': piece = pawn;   break;
                case 'b': piece = boat;   break;
                case 'r': piece = rook;   break;
                case 'n': piece = knight; break;
                case 'k': piece = king;   break;
                case 'P': piece = gpawn;   break;
                case 'B': piece = gboat;   break;
                case 'R': piece = grook;   break;
                case 'N': piece = gknight; break;
                case 'K': piece = gking;   break;
                case 's': piece = ypawn;   break;
                case 'j': piece = yboat;   break;
                case 'h': piece = yrook;   break;
                case 'g': piece = yknight; break;
                case 'm': piece = yking;   break;
                case 'S': piece = bpawn;   break;
                case 'J': piece = bboat;   break;
                case 'H': piece = brook;   break;
                case 'G': piece = bknight; break;
                case 'M': piece = bking;   break;

            }
            if(piece!=null)
                canvas.drawBitmap(piece,i*step,j*step,null);
            }
        }
    }

    @Override
    public void setAlpha(int alpha) {    }
    @Override
    public void setColorFilter(ColorFilter colorFilter) { }
    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    public static Bitmap tintImage(Bitmap bitmap, int color) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        Bitmap bitmapResult = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapResult);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bitmapResult;
    }
}
