import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import edu.uvg.hdt4.StackVector;



public class StackVectorTest {

    private StackVector stack;

    @Before
    public void setUp() {
        stack = new StackVector();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushIncreasesSize() {
        stack.push('A');
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeekReturnsLastElement() {
        stack.push('A');
        stack.push('B');
        assertEquals(Character.valueOf('B'), stack.peek());
        assertEquals(2, stack.size()); // peek no elimina
    }

    @Test
    public void testPopRemovesLastElement() {
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
    public void testPeekOnEmptyReturnsNull() {
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

    @Test
    public void testLIFOBehavior() {
        stack.push('A');
        stack.push('B');
        stack.push('C');

        assertEquals(Character.valueOf('C'), stack.pop());
        assertEquals(Character.valueOf('B'), stack.pop());
        assertEquals(Character.valueOf('A'), stack.pop());
    }
}

