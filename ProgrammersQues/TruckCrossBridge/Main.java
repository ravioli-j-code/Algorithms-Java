package ProgrammersQues.TruckCrossBridge;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 03. 03 오후 4:02
 */
public class Main {

    public static void main (String[] args) {

        TruckCrossBridge cross = new TruckCrossBridge();

        int[] truckWeight1 = {7, 4, 5, 6};
        int bridgeWeight = 10;
        int bridgeLength = 2;

        int result = cross.runTrucks(bridgeLength, bridgeWeight, truckWeight1);
        System.out.println(result);

        int[] truckWeight2 = { 10 };
        bridgeWeight = 100;
        bridgeLength = 100;

        result = cross.runTrucks(bridgeLength, bridgeWeight, truckWeight2);
        System.out.println(result);

        int[] truckWeight3 = {10,10,10,10,10,10,10,10,10,10};
        bridgeWeight = 100;
        bridgeLength = 100;

        result = cross.runTrucks(bridgeLength, bridgeWeight, truckWeight3);
        System.out.println(result);

        int[] truckWeight4 = {10,10,10,10};
        bridgeWeight = 30;
        bridgeLength = 30;

        result = cross.runTrucks(bridgeLength, bridgeWeight, truckWeight4);
        System.out.println(result);


    }

}