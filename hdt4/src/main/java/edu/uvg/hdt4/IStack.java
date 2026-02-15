package edu.uvg.hdt4;

public interface IStack<T> {
    T pop();

    void push(T value);

    T peek();

    void clear();

    boolean isEmpty();

    int size();
}
