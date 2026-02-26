package edu.uvg.hdt4;

public abstract class AbstractStack<T> implements IStack<T> {

    public boolean empty() {
        return size() == 0;
    }
    
}
