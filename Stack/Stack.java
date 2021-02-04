package Stack;

public interface Stack {
    boolean isEmpty();
    boolean isFull();
    boolean push(Object item);
    Object pop();
}