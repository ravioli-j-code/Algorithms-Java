package Stack;

public class StackImpl implements Stack{
    private int top; // stack pointer
    private int size; // stack size
    private Object[] stackArray; // stack content

    public StackImpl(int size) {
        this.size = size;
        this.stackArray = new Object[size];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() { 
        return (top == size - 1); // stack의 포인터가 maxsize에 도달
    }

    @Override
    public boolean push(Object item) {
        if (isFull()) {
            System.out.println("Stack is Full.");
            return false;
        }
        stackArray[++top] = item;
        return true;
    }

    @Override
    public Object pop() {
        if( isEmpty() ) {
            System.out.println("Stack is Empty.");
            return false;
        } else {
            Object item = stackArray[top];
            stackArray[top] = null;
            top--;
            return item;
        }
    }

    // print stack
    public void printStack(Stack stack) {
        if(top != -1) {
            for( int i=top; i< top; i-- ) {
                if ( i == -1 ) { // 인덱스가 벗어난 경우
                    break;
                }

                System.out.println("stackArray is  : " + stackArray[i]);
                System.out.println("-------------------------------");
            }
        } else {
            System.out.println("Stack is Empty.");
        }
    }
    
}
