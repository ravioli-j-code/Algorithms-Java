package AlgorithmStrategy.CatalanNumber;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 03. 12 오후 12:59
 */
public class CatalanNumber {

    static int Catalan ( int n ) {
        int res = 0;

        if (n <= 1) {
            return 1;
        }

        for (int i = 0 ; i < n ; i++ ) {
            res += Catalan(i) * Catalan( n - i - 1 );
        }
        return res;
    }

}