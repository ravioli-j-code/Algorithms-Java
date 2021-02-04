package SelectionSort;

public class SelectionSort {

    public void sort(int[] list) {
        int indexMin, temp;

        for (int i = 0; i < list.length - 1; i++) { 
            indexMin = i; // 최소값은 0에 있다고 가정하고 시작.
            for (int j = i + 1; j < list.length; j++) { 
                /* 
                * 증가된 최소 인덱스 이후의 모든 목록을 조회한다.
                * 만약 최소 인덱스보다 배열의 값이 작으면 해당 값을 최소 인덱스로 위치시킨다.
                */
                if (list[j] < list[indexMin]) {
                    indexMin = j;
                }
            }
            // 최소 인덱스를 원래 배열에 순차적으로 저장한다.
            temp = list[indexMin];
            list[indexMin] = list[i];
            list[i] = temp;
        }
    }
    
}
