package CountingSort;

public class CountingSort {
    
    public void Sort() {
        int[] countArr = new int[6];
        int targetArr[] = {
            1,3,2,4,3,
            2,5,3,1,2,
            3,4,4,3,5,
            1,2,3,5,2,
            3,1,4,3,5,
            1,2,1,1,1
        };

        // 초기화
        for(int i=1 ; i<=5 ; i++){
            countArr[i] = 0;
        }

        // targetArr 에 있는 자연수를 인덱스로 이용하여 카운트를 센다.
        for(int i=0 ; i < 30 ; i++){
            countArr[targetArr[i]]++;
        }

        // 카운트가 종료된 countArr 내에 들어있는 정수의 수만큼 출력한다.
        for(int i=1 ; i<=5 ; i++){
            if(countArr[i] != 0 ) {
                for(int j=0; j < countArr[i]; j++) {
                    System.out.println(i + "  ");
                }
            }
        }
    }

}
