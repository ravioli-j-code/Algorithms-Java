### 머지 정렬 Merge Sort

머지 소트는 분할 정복 알고리즘.
배열을 두개로 나누고 정렬하고 정렬된 두개의 배열을 다시 병합한다.

#### 의사코드

MergeSort(arr[], l,  r)
If r > l
     1. 배열을 두 덩어리로 분할할 중간점을 찾는다:  
             middle m = l+ (r-l)/2
     2. 첫번째 배열 집합을 정렬하기 위한 mergeSort를 호출:   
             Call mergeSort(arr, l, m)
     3. 두번째 배열 집합을 정렬하기 위한 mergeSort를 호출:
             Call mergeSort(arr, m+1, r)
     4. 첫번째, 두번째 배열을 병합:
             Call merge(arr, l, m, r)




