package edu.uvg.hdt4;
import java.util.ArrayList;

public class StackArrayList implements IStack<Character> {
    private ArrayList<Character> stack;

    public StackArrayList() {
        this.stack = new ArrayList<>();
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
        return stack.get(stack.size() - 1);
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
