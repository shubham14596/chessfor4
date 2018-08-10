package classy.com.chaturanga;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import static classy.com.chaturanga.board.step;

public class alphabeta {
    static boolean touch1 =false;
    static int px=-1,py=-1,x,y;
    static boolean redturn=true;
    static int  moveslist[][] = new int[8][8];
    static Paint p = new Paint();
    static int kingposC;

    static void init(){

        p.setStrokeWidth(6);
        p.setARGB(255,255,0,0);
    }

static char[][] Chessboard = {
        {'B','P',' ',' ','m','h','g','j'},
        {'N','P',' ',' ','s','s','s','s'},
        {'R','P',' ',' ',' ',' ',' ',' '},
        {'K','P',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ','S','M'},
        {' ',' ',' ',' ',' ',' ','S','H'},
        {'p','p','p','p',' ',' ','S','G'},
        {'b','n','r','k',' ',' ','S','J'}};


    public static void movespawn1(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        // capture
        for(int j=-1; j<=1; j+=2) {
            try{
            if (Character.isUpperCase(Chessboard[y-1][x+j])){
                old = Chessboard[y-1][x+j];
                Chessboard[y][x]=' ';
                Chessboard[y-1][x+j]= piece;
                 if(kingsafe()) {moveslist[y-1][x+j]=1;
                 genmove.drawCircle((step/2)+(x+j)*step,(step/2)+(y-1)*step,20,p);

                 }
                Chessboard[y][x]=piece;
                Chessboard[y-1][x+j]=old;
            }
            } catch (Exception e){}

        }
        // move one up
        if(Chessboard[y-1][x]==' '){
            old = Chessboard[y-1][x];
            Chessboard[y][x]=' ';
            Chessboard[y-1][x]= piece;
            if(kingsafe()) {moveslist[y-1][x]=1;
                genmove.drawCircle((step/2)+x* step,(step/2)+(y-1)*step,20  ,p);
            }
            Chessboard[y][x]=piece;
            Chessboard[y-1][x]=old;
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }
    public static void movespawn2(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        // capture
        for(int j=-1; j<=1; j+=2) {
            try{
            if (Character.isLowerCase(Chessboard[y+j][x+1]) ){
                old = Chessboard[y+j][x+1];
                Chessboard[y][x]=' ';
                Chessboard[y+j][x+1]= piece;
                 if(kingsafe()) {moveslist[y+j][x+1]=1;
                     genmove.drawCircle((step/2)+(x+1)*step,(step/2)+(y+j)*step,20,p);

                 }
                Chessboard[y][x]=piece;
                Chessboard[y+j][x+1]=old;
            }
            } catch (Exception e){}

        }
        // move one up
        if(Chessboard[y][x+1]==' '){
            old = Chessboard[y][x+1];
            Chessboard[y][x]=' ';
            Chessboard[y][x+1]= piece;
            if(kingsafe()) {moveslist[y][x+1]=1;
                genmove.drawCircle((step/2)+(x+1)*step,(step/2)+y*step,20,p);
            }
            Chessboard[y][x]=piece;
            Chessboard[y][x+1]=old;
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }
    public static void movespawn3(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        // capture
        for(int j=-1; j<=1; j+=2) {
            try{
            if (Character.isUpperCase(Chessboard[y+1][x+j])){
                old = Chessboard[y+1][x+j];
                Chessboard[y][x]=' ';
                Chessboard[y+1][x+j]= piece;
                 if(kingsafe()) {moveslist[y+1][x+j]=1;
                     genmove.drawCircle((step/2)+(x+j)*step,(step/2)+(y+1)*step,20,p);
                 }
                Chessboard[y][x]=piece;
                Chessboard[y+1][x+j]=old;
            }
            } catch (Exception e){}

        }
        // move one up
        if(Chessboard[y+1][x]==' '){
            old = Chessboard[y+1][x];
            Chessboard[y][x]=' ';
            Chessboard[y+1][x]= piece;
            if(kingsafe()) {
                moveslist[y + 1][x] = 1;
                genmove.drawCircle((step / 2) + x * step, (step / 2) + (y + 1) * step, 20, p);
            }
            Chessboard[y][x]=piece;
            Chessboard[y+1][x]=old;
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }
    public static void movespawn4(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        // capture
        for(int j=-1; j<=1; j+=2) {
            try{
            if (Character.isLowerCase(Chessboard[y+j][x-1]) ){
                old = Chessboard[y+j][x-1];
                Chessboard[y][x]=' ';
                Chessboard[y+j][x-1]= piece;
                 if(kingsafe()) {moveslist[y+j][x-1]=1;
                     genmove.drawCircle((step/2)+(x-1)*step,(step/2)+(y+j)*step,20,p);
                 }
                Chessboard[y][x]=piece;
                Chessboard[y+j][x-1]=old;
            }
            } catch (Exception e){}

        }
        // move one up
        if(Chessboard[y][x-1]==' '){
            old = Chessboard[y][x-1];
            Chessboard[y][x]=' ';
            Chessboard[y][x-1]= piece;
            if(kingsafe()) {moveslist[y][x-1]=1;
                genmove.drawCircle((step/2)+(x-1)*step,(step/2)+y*step,20,p);
            }
            Chessboard[y][x]=piece;
            Chessboard[y][x-1]=old;
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }

    public static void movesrook(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        int temp=1;
        for(int j=-1; j<=1; j+=2) {

            try{
                while( Chessboard[y][x+temp*j]==' '){
                    old = Chessboard[y][x+temp*j];
                    Chessboard[y][x]=' ';
                    Chessboard[y][x+temp*j]= piece;
                    if(kingsafe()) {moveslist[y][x+temp*j]=1;
                        genmove.drawCircle((step/2)+(x+temp*j)*step,(step/2)+(y)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y][x+temp*j]=old;
                    temp++;
                }
                if( redturn?Character.isUpperCase(Chessboard[y][x+temp*j]):Character.isLowerCase(Chessboard[y][x+temp*j])){
                    old = Chessboard[y][x+temp*j];
                    Chessboard[y][x]=' ';
                    Chessboard[y][x+temp*j]= piece;
                    if(kingsafe()) {moveslist[y][x+temp*j]=1;
                        genmove.drawCircle((step/2)+(x+temp*j)*step,(step/2)+(y)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y][x+temp*j]=old;
                }
            }
            catch(Exception e){}
            temp=1;
            try{
                while( Chessboard[y+temp*j][x]==' '){
                    old = Chessboard[y+temp*j][x];
                    Chessboard[y][x]=' ';
                    Chessboard[y+temp*j][x]= piece;
                    if(kingsafe()) {moveslist[y+temp*j][x]=1;
                        genmove.drawCircle((step/2)+(x)*step,(step/2)+(y+temp*j)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y+temp*j][x]=old;
                    temp++;
                }
                if( redturn?Character.isUpperCase(Chessboard[y+temp*j][x]):Character.isLowerCase(Chessboard[y+temp*j][x])){
                    old = Chessboard[y+temp*j][x];
                    Chessboard[y][x]=' ';
                    Chessboard[y+temp*j][x]= piece;
                    if(kingsafe()) {moveslist[y+temp*j][x]=1;
                        genmove.drawCircle((step/2)+(x)*step,(step/2)+(y+temp*j)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y+temp*j][x]=old;
                }
            }
            catch(Exception e){}
            temp=1;
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }

    public static void movesknight(int x,int y){
		
	// some error
    Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
    Canvas genmove = new Canvas(bmp);
    moveslist = new int[8][8];
    char old,piece=Chessboard[y][x];

    for(int j=-1; j<=1; j+=2){
        for(int k=-1; k<=1; k+=2){
            try{
                if( Chessboard[y+j][x+k*2]==' ' || redturn?Character.isUpperCase(Chessboard[y+j][x+k*2]):Character.isLowerCase(Chessboard[y+j][x+k*2])){
                    old = Chessboard[y+j][x+k*2];
                    Chessboard[y][x]=' ';
                    Chessboard[y+j][x+k*2]= piece;
                    if(kingsafe()) {moveslist[y+j][x+k*2]=1;
                        genmove.drawCircle((step/2)+(x+k*2)*step,(step/2)+(y+j)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y+j][x+k*2]=old;
                }
            }
            catch(Exception e){}
            try{
                if( Chessboard[y+j*2][x+k]==' ' || redturn?Character.isUpperCase(Chessboard[y+j*2][x+k]):Character.isLowerCase(Chessboard[y+j*2][x+k])){
                    old = Chessboard[y+j*2][x+k];
                    Chessboard[y][x]=' ';
                    Chessboard[y+j*2][x+k]= piece;
                    if(kingsafe()) {moveslist[y+j*2][x+k]=1;
                        genmove.drawCircle((step/2)+(x+k)*step,(step/2)+(y+j*2)*step,20,p);
                    }
                    Chessboard[y][x]=piece;
                    Chessboard[y+j*2][x+k]=old;
                }
            }
            catch(Exception e){}
        }
    }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }

    public static void movesboat(int x,int y){
		
		// Some error
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];
        for(int i=-1; i<=1; i+=2){
            for(int j=-1; j<=1; j+=2){
                try {
                    if (Chessboard[y + i][x + j] == ' ' || redturn ? Character.isUpperCase(Chessboard[y + i][x + j]) : Character.isLowerCase(Chessboard[y + i][x + j])) {
                        old = Chessboard[y + i][x + j];
                        Chessboard[y][x] = ' ';
                        Chessboard[y + i][x + j] = piece;
                        if (kingsafe()) {
                            moveslist[y + i][x + j] = 1;
                            genmove.drawCircle((step / 2) + (x + j) * step, (step / 2) + (y + i) * step, 20, p);
                        }
                        Chessboard[y][x] = piece;
                        Chessboard[y + i][x + j] = old;
                    }
                }
                catch(Exception e){}
            }
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }

    public static void movesking(int x,int y){
        Bitmap bmp = Bitmap.createBitmap(board.wide, board.wide, Bitmap.Config.ARGB_8888);
        Canvas genmove = new Canvas(bmp);
        moveslist = new int[8][8];
        char old,piece=Chessboard[y][x];

        int king = y*8 + x;
        for(int i=0; i<9; i++){
            if(i!=4){
                try {
                    // to be implemented
                }
                catch(Exception e){}
            }
        }
        board.moves = bmp;
        start.board.invalidate();
        px = x; py=y;
    }

    public static boolean validmove(int x,int y){
    if(moveslist[y][x]==1) {
        board.moves=null;
        char piece = Chessboard[py][px];
        Chessboard[y][x] = Chessboard[py][px];
        Chessboard[py][px]=' ';
        start.board.invalidate();
        redturn = !redturn;
        moveslist=new int[8][8];
        return true;
    }
    return false;
    }

    public static boolean kingsafe(){
		// to be implemented
    return true;
    }
}


