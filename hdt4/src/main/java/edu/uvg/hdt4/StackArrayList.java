package edu.uvg.hdt4;
import java.util.ArrayList;

public class StackArrayList<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    public StackArrayList() {
        this.stack = new ArrayList<T>();
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
        return stack.get(stack.size() - 1);
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
