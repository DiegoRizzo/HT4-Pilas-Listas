package edu.uvg.hdt4;

public class StackLista implements IStack<Character> {
    private Character[] stack;
    private int tope;

    public StackLista(int capacidad) {
        this.stack = new Character[capacidad];
        this.tope = -1;
    }

    @Override
    public Character pop() {
        if (isEmpty()) {
            System.out.println("El stack está vacío. No se puede hacer pop.");
            return null;
        }

        Character valor = stack[tope];
        stack[tope] = null;
        tope--;
        return valor;
    }

    @Override
    public void push(Character value) {
        if (tope == stack.length - 1) {
            System.out.println("El stack está lleno. No se puede hacer push.");
            return;
        }

        tope++;
        stack[tope] = value;
    }

    @Override
    public Character peek() {
        if (isEmpty()) return null;
        return stack[tope];
    }

    @Override
    public void clear() {
        for (int i = 0; i <= tope; i++) {
            stack[i] = null;
        }
        tope = -1;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public int size() {
        return tope + 1;
    }

    
}
