package classy.com.chaturanga;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class start extends Activity {
    static ImageView board;
    static TextView tv;
    static int step;
    boolean ai = false;
    int width,height,size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        width = getWindowManager().getDefaultDisplay().getWidth();
        height = getWindowManager().getDefaultDisplay().getHeight();
        tv = (TextView) findViewById(R.id.text);
        board = (ImageView) findViewById(R.id.drawarea);

        size = width<height?width:height;
        ViewGroup.LayoutParams params=board.getLayoutParams();
        params.width=size;
        params.height=size;
        board.setLayoutParams(params);

        board.setImageDrawable(new board(this, size));

        step = size / 8;

        if(ai) {
            board.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                    int x = (int) event.getX()/step;     int y = (int) event.getY()/step;
                    return false;
                }
            });
        }
        else{
            board.setOnTouchListener(new fourplayer());
        }

    }
    static class fourplayer implements View.OnTouchListener{
        static int turn = 1;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int x = (int) event.getX()/step;     int y = (int) event.getY()/step;
       //     if(event.getAction()==MotionEvent.ACTION_DOWN) {
                char p = alphabeta.Chessboard[y][x];
                switch (turn) {
                    case 1:
                        switch (p) {
                            case 'p':
                                alphabeta.movespawn1(x, y);
                                break;
                            case 'n':
                                alphabeta.movesknight(x, y);
                                break;
                            case 'r':
                                alphabeta.movesrook(x, y);
                                break;
                            case 'b':
                                alphabeta.movesboat(x, y);
                                break;
                            case 'k':
                                alphabeta.movesking(x, y);
                                break;
                            default:
                                if (alphabeta.validmove(x, y)) {
                              //      if(alphabeta.Chessboard[py][px]=='p' && y==0)
                                //        choosenewpiece();
                                    turn = 2;
                                }
                        }

                        break;
                    case 2:
                        switch (p) {
                            case 'P':
                                alphabeta.movespawn2(x, y);
                                break;
                            case 'N':
                                alphabeta.movesknight(x, y);
                                break;
                            case 'R':
                                alphabeta.movesrook(x, y);
                                break;
                            case 'B':
                                alphabeta.movesboat(x, y);
                                break;
                            case 'K':
                                alphabeta.movesking(x, y);
                                break;
                            default:
                                if (alphabeta.validmove(x, y)) {
                                    turn = 3;
                                }
                        }
                        break;
                    case 3:
                        switch (p) {
                            case 's':
                                alphabeta.movespawn3(x, y);
                                break;
                            case 'g':
                                alphabeta.movesknight(x, y);
                                break;
                            case 'h':
                                alphabeta.movesrook(x, y);
                                break;
                            case 'j':
                                alphabeta.movesboat(x, y);
                                break;
                            case 'm':
                                alphabeta.movesking(x, y);
                                break;
                            default:
                                if (alphabeta.validmove(x, y)) {
                                    turn = 4;
                                }
                        }
                        break;
                    case 4:
                        switch (p) {
                            case 'S':
                                alphabeta.movespawn4(x, y);
                                break;
                            case 'G':
                                alphabeta.movesknight(x, y);
                                break;
                            case 'H':
                                alphabeta.movesrook(x, y);
                                break;
                            case 'J':
                                alphabeta.movesboat(x, y);
                                break;
                            case 'M':
                                alphabeta.movesking(x, y);
                                break;
                            default:
                                if (alphabeta.validmove(x, y)) {
                                    turn = 1;
                                }
                        }
                        break;
                }
            tv.setText("player "+turn+" turn");

            return false;
        }
    }


}