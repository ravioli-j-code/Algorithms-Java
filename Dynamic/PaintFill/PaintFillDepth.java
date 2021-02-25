package Dynamic.PaintFill;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 25 오전 10:00
 */
public class PaintFillDepth {

    boolean PointFillColor(PaintColor.Color[][] screen, int r, int c, PaintColor.Color nColor) {
        if (screen[r][c] == nColor ) return false; // 이미 타겟 색상이면 리턴
        return PaintFill(screen, r, c, screen[r][c], nColor);
    }

    boolean PaintFill(PaintColor.Color[][] screen, int r, int c, PaintColor.Color oColor, PaintColor.Color nColor){
        // c와 r이 범위에서 벗어나기 전까지 계속 탐색
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length ){
            return false;
        }

        if ( screen[r][c] == oColor ) { //
            screen[r][c] = nColor;
            PaintFill(screen, r - 1, c, oColor, nColor ) ;
            PaintFill(screen, r + 1, c, oColor, nColor ) ;
            PaintFill(screen, r, c - 1, oColor, nColor ) ;
            PaintFill(screen, r, c + 1, oColor, nColor ) ;
        }
        return true;
    }

}