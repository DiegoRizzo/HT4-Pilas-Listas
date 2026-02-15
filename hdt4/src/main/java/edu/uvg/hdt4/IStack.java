package edu.uvg.hdt4;

public interface IStack<T> {
    T pop();

    void push(T value);

    T peek();

    boolean empty();

    boolean isEmpty();

    int size();
}
