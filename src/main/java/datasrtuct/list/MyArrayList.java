package datasrtuct.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author youyinnn
 */
@SuppressWarnings("unchecked")
public class MyArrayList<E> implements Iterable<E>{

    private final int DEFAULT_CAPACTTY = 10;
    private int size = 0;
    private E[] array;

    MyArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACTTY];
    }

    MyArrayList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        E element;
        if (index >= 0 && index <= endIndex()) {
            element = array[index];
            if (index < endIndex()) {
                System.arraycopy(array, index + 1, array, index, endIndex() - index);
            }
            size--;
            return element;
        } else {
            throw new ArrayIndexOutOfBoundsException("index:" + index);
        }
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("index:" + index);
        } else {
            // 如果插入位置为当前数组尾部或者更后面 则统一插到尾部位置
            adjustArray();
            if (index < size) {
                System.arraycopy(array, index, array, index + 1, endIndex() - index);
            }
            array[index] = element;
            size++;
        }
    }

    public void adjustArray() {
        if (size == array.length) {
            E[] newArr = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
        }
    }

    public E get(int index) {
        E element = null;
        if (index <= endIndex()) {
            element = array[index];
        }
        return element;
    }

    public boolean contains(E target) {
        if (target != null) {
            for (E e : this) {
                if (e.equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(E element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int endIndex() {
        return size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0 ; i < size - 1; ++i) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }

    private class MyArrayListIterator implements Iterator<E>{

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return array[currentIndex++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--currentIndex);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            MyArrayList.this.forEach(action);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        if (action != null) {
            for (E e : this) {
                action.accept(e);
            }
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
