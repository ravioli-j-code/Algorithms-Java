package ProgrammersQues.UnusableRectangle;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 27 오후 3:04
 */
public class UnusableRectancleAns {


    long getAnswer(int w, int h) {
        long whole = (long) w * h;
        long broken = w + h - gcb(w, h);
        return whole - broken;
    }

    int gcb(int a, int b) {
        return a % b == 0 ? b : gcb(b, a % b);
    }

}