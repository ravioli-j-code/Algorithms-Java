package HeapSort;


public class HeapSort {
    
    private int[] element;
    //private static final int ROOTLOC = 1;
    private static final int DEFAULT = 10;

    public HeapSort(int size) {
        if (size > DEFAULT) {
            element = new int[size+1];
            element[0] = 0;
        } else {
            element = new int[DEFAULT + 1];
            element[0] = 0;
        }
    }

    public void add(int newnum) {
        if(element.length <= element[0] + 1) {
            int[] elementTemp = new int[element[0]*2];
            for(int x = 0; x < element[0]; x++ ) {
                elementTemp[x] = element[x];
            }
            element = elementTemp;
        }

        element[++element[0]] = newnum;
        upheap();
    }

    public int extractRoot() {
        int extracted = element[1];
        element[1] = element[element[0]--];
        downheap();
        return extracted;
    }

    public void upheap() {
        int locmark= element[0];
        while(locmark >= 1 && element[locmark/2] > element[locmark]) {
            swap(locmark/2, locmark);
            locmark /=2;
        }
    }

    public void downheap() {
        int locmark = 1;
        while(locmark * 2 <= element[0]){
            if (locmark*2 + 1 <= element[0]) {
                int small = smaller(locmark*2, locmark*2+1);
                swap(locmark, small);
                locmark = small;
            }
        }
    }

    public void swap(int a, int b){
        int temp = element[a];
        element[a] = element[b];
        element[b] = temp;
    }

    public int smaller(int a, int b){
        return element[a] < element[b] ? a : b;
    }

}
