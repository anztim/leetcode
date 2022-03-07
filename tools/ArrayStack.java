package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anztim
 */
public class ArrayStack<E> extends ArrayList<E>{
    int height;
    public ArrayStack() {height = 0;}
    public void push(E e) {
        if (height == super.size()) super.add(e);
        else super.set(height, e);
        height++;
    }
    public E pop() { return super.get(--height);}
    public E peek() { return super.get(height - 1);}
    @Override
    public boolean isEmpty() { return height == 0;}
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(super.toArray(),height);
    }
}
