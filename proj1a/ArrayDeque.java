/**
 * Created by wushbin on 6/16/17.
 */
public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addFirst(Item item) {
        if (size == items.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= 0; i --) {
            items[i + 1] = items[i];
        }
        items[0] = item;
        size += 1;
    }
    public void addLast(Item item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < size; i ++) {
            System.out.println(items[i].toString() + " ");
        }
    }
    public Item removeFirst() {
        Item first = items[0];
        for (int i = 0; i < size - 1; i ++) {
            items[i] = items[i + 1];
        }
        if (((double) size / (double)items.length) < 0.25) {
            resize(items.length / 2);
        }
        size -= 1;
        return first;
    }
    public Item removeLast() {
        Item last = items[size - 1];
        items[size - 1] = null;
        if (((double) size / (double)items.length) < 0.25) {
            resize(items.length / 2);
        }
        size -= 1;
        return last;
    }
    public Item get(int index) {
        if (index >= 0 && index < size) {
            return items[index];
        }
        return null;
    }
}
