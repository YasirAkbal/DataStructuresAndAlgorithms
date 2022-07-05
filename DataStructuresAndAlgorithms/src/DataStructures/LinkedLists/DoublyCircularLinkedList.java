/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.LinkedLists;

import DataStructures.Base.Abstract.VectorI;
import DataStructures.Base.Exceptions.NotValidIndexOrPosition;
import DataStructures.LinkedLists.Abstract.ILinkedList;
import DataStructures.LinkedLists.Abstract.LinkedListBase;
import DataStructures.LinkedLists.Nodes.NodeDoubCircLL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yasir
 */
public final class DoublyCircularLinkedList<T> extends LinkedListBase<T,NodeDoubCircLL<T>> implements ILinkedList<T>, Iterable<T>, VectorI<T> {
    public DoublyCircularLinkedList() {}
    public DoublyCircularLinkedList(ArrayList<T> toAdd) {
        for(T data: toAdd) {
            this.addLast(data);
        }
    }
    
    @Override
    protected NodeDoubCircLL<T> getNodeFromValue(T value) {
        if(head == null) return null;
        
        NodeDoubCircLL<T> itr = head;
        
        do {
            if(itr.data.equals(value))
                return itr;
            itr = itr.next;
        } while(itr != head);
        
        return null;
    }

    @Override
    protected NodeDoubCircLL<T> getNodeFromPosition(int position) {
        if(position < 1 || position > size) throw new NotValidIndexOrPosition();
        
        NodeDoubCircLL<T> itr = head;
        for(int i=0;i<position-1;i++) {
            itr = itr.next;
        }
        
        return itr;
    }

    
    @Override
    public int search(T value) {
        if(head == null) return -1;
        
        NodeDoubCircLL<T> itr = head;
        int pos = 1;
        
        do {
            if(itr.data.equals(value))
                return pos;
            pos++;
            itr = itr.next;
        } while(itr != head);
        
        return -1;
    }

    @Override
    public boolean contains(T value) {
        return getNodeFromValue(value) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(T value) {
        NodeDoubCircLL<T> newNode = new NodeDoubCircLL<>(value);
        
        if(head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        NodeDoubCircLL<T> newNode = new NodeDoubCircLL<>(value);
        
        if(head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    @Override
    public void insert(int position, T value) throws NotValidIndexOrPosition {
        if(position < 0 || position > size+1) throw new NotValidIndexOrPosition();
        
        if(position == 1) { addFirst(value); return; }
        if(position == size+1) { addLast(value); return; }
        
        NodeDoubCircLL<T> newNode = new NodeDoubCircLL<>(value);
        NodeDoubCircLL<T> prev = getNodeFromPosition(position-1);
        
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next.prev = newNode;
        prev.next = newNode;
        size++;
    }

    @Override
    public T getFirst() {
        if(head == null) return null;
        
        return head.data;
    }

    @Override
    public T getLast() {
        if(head == null) return null;
        
        return head.prev.data;
    }

    @Override
    public T get(int position) throws NotValidIndexOrPosition {
        NodeDoubCircLL<T> node = getNodeFromPosition(position);
        
        if(node == null)
            throw null;
        else
            return node.data;
    }

    @Override
    public T removeLast() {
        if(head == null) return null;
        
        T toDelete;
        if(head.next == head) {
            toDelete = head.data;
            head = null;
        } else {
            toDelete = head.prev.data;
            NodeDoubCircLL<T> prev = head.prev.prev;

            prev.next = head;
            head.prev = prev;
        }
        
        size--;
        return toDelete;
    }

    @Override
    public T removeFirst() {
        if(head == null) return null;
        
        T toDelete;
        if(head.next == head) {
            toDelete = head.data;
            head = null;
            
        } else {
            toDelete = head.data;
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        }
        
        size--;
        return toDelete;
    }

    @Override
    public T remove(int position) throws NotValidIndexOrPosition {
        if(position < 1 || position > size) throw new NotValidIndexOrPosition();
        
        if(position == 1) { return removeFirst(); }
        if(position == size) { return removeLast(); }
        
        NodeDoubCircLL<T> prev = getNodeFromPosition(position-1);
        T toDelete = prev.next.data;
        
        prev.next.next.prev = prev;
        prev.next = prev.next.next;
        
        size--;
        return toDelete;
    }

    @Override
    public void printAll() {
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }
    
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private NodeDoubCircLL<T> curr = head;
            private boolean isFirst = true;
            
            @Override
            public boolean hasNext() 
            {   
                if(head == null)
                    return false;
                
                return curr != head || isFirst;
            }
            @Override
            public T next() 
            {   
                isFirst = false;
                T data = curr.data;
                curr = curr.next;
                return data;
            }
            @Override
            public void remove() 
            {                     
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
