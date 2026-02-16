package edu.uvg.hdt4;
import java.util.Vector;

public class StackVector implements IStack<Character> {
    private Vector<Character> stack;

    public StackVector() {
        this.stack = new Vector<>();
    }

    @Override
    public Character pop() {
        if (isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    @Override
    public void push(Character value) {
        stack.add(value);
    }

    @Override
    public Character peek() {
        if (isEmpty()) return null;
        return stack.lastElement();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    
}
