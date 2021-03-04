package ProgrammersQues.TruckCrossBridge;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 03 오후 4:02
 */
public class Main {

    public static void main (String[] args) {

        TruckCrossBridge cross = new TruckCrossBridge();

        int[] truckWeight = {10,10,10,10,10,10,10,10,10,10};
        int bridgeWeight = 100;
        int bridgeLength = 100;

        int result = cross.getCrossTime(bridgeLength, bridgeWeight, truckWeight);
        System.out.println(result);
    }

}