### 퀵 정렬 Quick Sort

퀵 정렬은 버블정렬과 유사한 분할 정복 알고리즘이다. 퀵정렬에서는 하나의 원소를 축(pivot)으로 설정하고 선택한 출을 기준으로 하여 주어진 배열을 파티셔닝한다.

#### 축(pivot)을 선택하는 기준
1. 항상 첫번째 원소를 축으로 선택
2. 항상 마지막 원소를 축으로 선택
3. 임의의 원소를 축으로 선택
4. 중간값(median)을 축으로 선택 

#### partition 함수

퀵 정렬에서 중요한 프로세스가 partition() 함수이다. 
대상 파티션은 임의의 원소를 기준으로 정렬된 배열에 자신보다 모두 작은 위치에 삽입하고, 자신보다 모두 큰 원소들을 뒤에 배치시킨다.




#### 의사코드

/* low  --> 시작 인덱스,  high  --> 마지막 인덱스 */

```
quickSort(arr[], low, high){

    if (low < high){

        pi[^id] = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi

    }
}
```

![alt text](QuickSort2.png )


[^id]:pi 는 파티셔닝 인덱스로서, arr[pi]는 현재 올바른 위치에 있음.