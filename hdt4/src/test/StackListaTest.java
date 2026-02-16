package edu.uvg.hdt4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class StackListaTest {

    private StackLista stack;

    @Before
    public void setUp() {
        stack = new StackLista(3); // capacidad pequeña para probar límite
    }

    @Test
    public void testInitialState() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndSize() {
        stack.push('A');
        stack.push('B');
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push('X');
        stack.push('Y');
        assertEquals(Character.valueOf('Y'), stack.peek());
        assertEquals(2, stack.size()); // no elimina
    }

    @Test
    public void testPop() {
        stack.push('A');
        stack.push('B');

        assertEquals(Character.valueOf('B'), stack.pop());
        assertEquals(1, stack.size());
        assertEquals(Character.valueOf('A'), stack.peek());
    }

    @Test
    public void testPopOnEmptyReturnsNull() {
        assertNull(stack.pop());
    }

    @Test
    public void testLIFOOrder() {
        stack.push('1');
        stack.push('2');
        stack.push('3');

        assertEquals(Character.valueOf('3'), stack.pop());
        assertEquals(Character.valueOf('2'), stack.pop());
        assertEquals(Character.valueOf('1'), stack.pop());
    }

    @Test
    public void testClear() {
        stack.push('A');
        stack.push('B');
        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushWhenFullDoesNotIncreaseSize() {
        stack.push('A');
        stack.push('B');
        stack.push('C'); // lleno

        assertEquals(3, stack.size());

        stack.push('D'); // debería ignorarse

        assertEquals(3, stack.size());
        assertEquals(Character.valueOf('C'), stack.peek());
    }

}
