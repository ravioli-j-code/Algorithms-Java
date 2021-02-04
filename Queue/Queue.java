package Queue;

interface Queue {
    boolean isEmpty(); // queue 가 비어있는지 확인
    boolean isFull(); // queue가 가득 찼는지 확인
    void insertqueue(char item); // queue에 문자 넣기
    char removequeue(); // queue 에 문자 빼기
    char peek(); // queue에 있는 문자 확인
    void clear(); // queue 비우기
}

