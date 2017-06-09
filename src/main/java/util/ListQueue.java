package util;

import java.util.Collection;

/**
 * Created by KJB-001064 on 2017/5/2.
 */
public class ListQueue<E> {


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        int index;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public Node(E element, Node<E> next, Node<E> prev, int index) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            this.index = index;
        }
    }

    int size;
    Node first;
    Node last;


    protected transient int modCount = 0;

    public boolean add(Collection<? super E> c){
        return add(0,c);
    }
    public boolean add(int index, Collection<? super E> c) {

        Node<E> p, n;
        Object[] ca = c.toArray();

        int newNum = ca.length;

        if (size == index) {
            n = null;
            p = last;

        } else {
            n = node(index);
            p = n.prev;
        }
        for (Object o : ca) {
            E e = (E) o;
            Node<E> newnode = new Node<E>(e, null, p);
            if (p == null)
                first = newnode;
            else
                p.next = newnode;
            p = newnode;
        }
        if (n == null)
            last = p;
        else {
            p.next = n;
            n.prev = p;
        }
        size += newNum;
        modCount++;
        return true;
    }


     Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
}
