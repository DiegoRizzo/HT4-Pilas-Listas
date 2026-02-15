package edu.uvg.hdt4;

public interface IList<T> {
    void addFirst(T value);

    void addLast(T value);

    T removeFirst();

    T removeLast();

    void clear();

    boolean isEmpty();

    int size();
}
