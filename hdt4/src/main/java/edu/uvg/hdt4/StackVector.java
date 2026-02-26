package edu.uvg.hdt4;
import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {

    private Vector<T> stack;

    public StackVector() {
        this.stack = new Vector<T>();
    }

    public T pop() {
        if (isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public void push(T value) {
        stack.add(value);
    }

    public T peek() {
        if (isEmpty()) return null;
        return stack.lastElement();
    }

    public void clear() {
        stack.clear();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    
}
