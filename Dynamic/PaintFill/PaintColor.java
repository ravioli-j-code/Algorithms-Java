package Dynamic.PaintFill;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 25 오전 10:11
 */
public class PaintColor {

    static enum Color {Black, White, Red, Yellow, Green}

    static Color[][] screen =
            {
                    {Color.Black, Color.Black, Color.Black, Color.Black, Color.Black, Color.White, Color.White, Color.White, Color.White},
                    {Color.White, Color.Black, Color.White, Color.White, Color.Black, Color.White, Color.White, Color.White, Color.White},
                    {Color.White, Color.White, Color.Black, Color.White, Color.White, Color.White, Color.White, Color.Black, Color.White},
                    {Color.White, Color.White, Color.Black, Color.Black, Color.White, Color.White, Color.Black, Color.White, Color.White},
                    {Color.White, Color.White, Color.White, Color.White, Color.Black, Color.White, Color.White, Color.Black, Color.White},
                    {Color.White, Color.White, Color.White, Color.White, Color.White, Color.Black, Color.Black, Color.White, Color.White},
                    {Color.White, Color.Red, Color.Red, Color.Red, Color.White, Color.White, Color.White, Color.White, Color.White},
                    {Color.White, Color.Red, Color.White, Color.Red, Color.White, Color.White, Color.White, Color.White, Color.White},
                    {Color.White, Color.Red, Color.White, Color.Red, Color.White, Color.White, Color.White, Color.White, Color.White},
                    {Color.White, Color.Red, Color.Red, Color.Red, Color.White, Color.White, Color.White, Color.White, Color.White}
            };

}