package arraylist;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY =  10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private Object elements[];

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyList() {
        this.elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    public MyList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[DEFAULT_CAPACITY];
        } else if (capacity == 0) {
            this.elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal parameter");
        }
    }
    private void rangeCheckException(int index) {
        if (index < 0  || index > size) {
            throw new IndexOutOfBoundsException("Index outof bound");
        }
    }
    private void grow(int minCapacity) {
        int oldCapacity = this.elements.length;
        if (oldCapacity > 0 || elements != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            elements = Arrays.copyOf(elements, newCapacity);
        } else {
            elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    public void add(int index, E element) {
        try {
            rangeCheckException(index);
            if (this.size == this.elements.length) {
                //grow array
                grow(size + 1);
            }
            //Shift element from index to right
            System.arraycopy(this.elements, index, this.elements, index + 1, size - index);
            this.elements[index] = element;
            this.size ++;
        }catch (Exception e) {
            System.out.println("Exception add");
        }
    }
    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Outbound" +
                    " exception");
        }
        final Object[] es = this.elements;
        E removedElement = (E) es[index];
        fastRemove(es, index);
        return removedElement;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
