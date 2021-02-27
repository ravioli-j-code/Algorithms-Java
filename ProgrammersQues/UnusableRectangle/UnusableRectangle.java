package ProgrammersQues.UnusableRectangle;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 27 오전 9:18
 */
public class UnusableRectangle {

    public long usableRectangle(int w, int h) {

        long diabledcnt;
        long mininumBlock = 1;

        for (int i = 1; i <= w ; i++ ) { // x 축을 움직임
            if ((h * i) % w == 0) {
                mininumBlock = i;
                break;
            }
        }

        int iLeft = h % w;
        int iDiv = h / w;

        if (iDiv >= 1) {
            diabledcnt = (iLeft > 0) ? (iDiv + 1) : iDiv;
        } else {
            diabledcnt = 1;
        }

        for (int i = 2; i <= mininumBlock ; i++ ) { // x 축을 움직임

            long left = (h * i) % w;
            long div = (h * i) / w;
            long prevdiv = (h * (i - 1)) / w;

            if ( (prevdiv == div) && left > 0) {
                diabledcnt += 1;
            } else if (prevdiv != div) {
                diabledcnt += ((left == 0) ? (div - prevdiv) : (div - prevdiv + 1)) ;
            }
        }

        return ((long)w * h) - (diabledcnt * ( w / mininumBlock ));
    }

}