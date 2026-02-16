package edu.uvg.hdt4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StackArrayListTest {

    private IStack<Character> stack;

    @Before
    public void setUp() {
        stack = new StackArrayList<>();
    }   

    @Test
    public void testStackStartsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushIncreasesSize() {
        stack.push('A');
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeekReturnsLastElement() {
        stack.push('A');
        stack.push('B');
        assertEquals(Character.valueOf('B'), stack.peek());
    }

    @Test
    public void testPopReturnsLastElement() {
        stack.push('A');
        stack.push('B');
        Character popped = stack.pop();

        assertEquals(Character.valueOf('B'), popped);
        assertEquals(1, stack.size());
    }

    @Test
    public void testLIFOBehavior() {
        stack.push('A');
        stack.push('B');
        stack.push('C');

        assertEquals(Character.valueOf('C'), stack.pop());
        assertEquals(Character.valueOf('B'), stack.pop());
        assertEquals(Character.valueOf('A'), stack.pop());
    }

    @Test
    public void testPopOnEmptyStackReturnsNull() {
        assertNull(stack.pop());
    }

    @Test
    public void testPeekOnEmptyStackReturnsNull() {
        assertNull(stack.peek());
    }

    @Test
    public void testClearEmptiesStack() {
        stack.push('A');
        stack.push('B');

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
}
