package Queue;

public class QueueImpl implements Queue{

    private int front;
    private int rear;
    private int size;
    private char queueArr[];

    // 생성자
    public QueueImpl(int size) {
        // 초기화
        front = -1; 
        rear = -1;
        this.size = size;
        queueArr = new char[this.size];
    }

    @Override
    public boolean isEmpty() {
        // EXP front 와 rear가 같으면 데이터가 없는 상태
        if(front == rear) {
            front = -1;
            rear = -1;
            return true; //데이터가 없음
        }
        return false; // 데이터가 있음
    }

    @Override
    public boolean isFull() {
        // EXP rear 포인터가 큐의 마지막 원소와 동일한 경우 참. 아니면 거짓.
        return (rear == this.size -1);
    }

    @Override
    public void insertqueue(char item) {
        if(isFull()) {
            System.out.println("Queue is Full.");
        } else {
            queueArr[++rear] = item; // 다음 rear 포인터 위치에 데이터를 추가함
            System.out.println("Inserted Data : " + item);
        }
    }

    @Override
    public char removequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return 0; // Q. 왜 0으로 리턴하지?
        } else {
            int next = front + 1;
            System.out.println("deleted Item : " + queueArr[next]);
            front = next % this.size;
            return queueArr[front];
        }
    }

    @Override
    public char peek() {
        if(isEmpty()){
            System.out.println("Queue is Empty.");
            return 0; 
        } else {
            int next = front + 1;
            System.out.println("peek item : " + queueArr[next]);
            return queueArr[next]; 
        }
    }

    @Override
    public void clear() {
        if(isEmpty()){
            System.out.println("Queue is Empty.");
        } else {
            front = -1;
            rear = -1;
            queueArr = new char[this.size];
            System.out.println("Queue initialized.");
        }

    }
    
    
}
