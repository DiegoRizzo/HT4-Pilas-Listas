package edu.uvg.hdt4;

public class StackLista<T> extends AbstractStack<T> {
    private T[] stack;
    private int tope;

    public StackLista(int capacidad) {
        this.stack = (T[]) new Object[capacidad];
        this.tope = -1;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("El stack está vacío. No se puede hacer pop.");
            return null;
        }

        T valor = stack[tope];
        stack[tope] = null;
        tope--;
        return valor;
    }

    public void push(T value) {
        if (tope == stack.length - 1) {
            System.out.println("El stack está lleno. No se puede hacer push.");
            return;
        }

        tope++;
        stack[tope] = value;
    }

    public T peek() {
        if (isEmpty()) return null;
        return stack[tope];
    }

    public void clear() {
        for (int i = 0; i <= tope; i++) {
            stack[i] = null;
        }
        tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public int size() {
        return tope + 1;
    }

    
}
