/**
 * Created by wushbin on 6/16/17.
 */
public class LinkedListDeque<Item> {
    public class ListNode {
        public Item item;
        public ListNode next;
        public ListNode prev;

        public ListNode(){
            item = null;
            next = null;
            prev = null;
        }
        public ListNode(Item i, ListNode n, ListNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(Item i) {
        sentinel = new ListNode();
        ListNode newNode = new ListNode(i, sentinel, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        size = 1;
    }

    public void addFirst(Item i) {
        sentinel.next = new ListNode(i, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    public void addLast(Item i) {
        sentinel.prev = new ListNode(i, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        ListNode prt = sentinel.next;
        if (prt == null) {
            return;
        }
        while (prt.next != sentinel.next) {
            System.out.println(prt.item.toString() + " ");
            prt = prt.next;
        }
    }
    public Item removeFirst() {
        ListNode first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    public Item removeLast() {
        ListNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size -= 1;
        return last.item;
    }
    public Item get(int index) {
        ListNode prt = sentinel.next;
        for (int i = 0; i < size && i < index; i ++, prt = prt.next) {
            if (i == index) {
                return prt.item;
            }
        }
        return null;
    }





}
