/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.LinkedLists;

import DataStructures.LinkedLists.Abstract.ILinkedList;
import DataStructures.LinkedLists.Abstract.LinkedListBase;
import DataStructures.LinkedLists.Nodes.NodeSingleLL;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author yasir
 */
public final class SingleLinkedList<T> extends LinkedListBase<T,NodeSingleLL<T>> implements ILinkedList<T>, Iterable<T> {  
    protected NodeSingleLL<T> tail;
    
    public SingleLinkedList() { }
    
    public SingleLinkedList(ArrayList<T> toAdd) { // diğer koleksiyon tipleri için de yazılabilir.
        for(T data: toAdd) {
            this.addLast(data);
        }
    }
    
    @Override
    public int search(T value) {
        NodeSingleLL<T> itr = head;
        int pos = 1;
        
        while(itr != null) {
            if(itr.data.equals(value))
                return pos;
            pos++;
            itr = itr.next;
        }
        
        return -1;
    }

    @Override
    public boolean contains(T value) {
        return this.getNodeFromValue(value) != null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(T value) {
        NodeSingleLL<T> newNode = new NodeSingleLL<>(value);
        
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }

    @Override
    public void addLast(T value) {
        NodeSingleLL<T> newNode = new NodeSingleLL<>(value);
        
        if(tail == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }

    @Override
    public boolean insert(int position, T value) {
        if(position < 1 || position > this.size+1) return false;
        
        if(position == 1) { this.addFirst(value); return true; }
        if(position == this.size+1) { this.addLast(value); return true; }
        
        NodeSingleLL<T> prev = getNodeFromPosition(position-1);
        NodeSingleLL<T> newNode = new NodeSingleLL<>(value);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
        return true;
    }

    @Override
    public T getFirst() {
        if(head == null) return null;
        
        return head.data;
    }

    @Override
    public T getLast() {
        if(tail == null) return null;
        
        return tail.data;
    }

    @Override
    public T removeLast() { //tail pointer tuttugum halde bu islem O(n) karmaşıklığa sahip. tail'den bir önceki elemanı tutmak çözüm olabilirdi ama zaten double/circular linked list bunun için var.
        if(tail == null) return null; //aslında burada hata fırlatmak lazım. Node'daki data da null olabilir. Bu iki durum arasından ayrım yapmak mümkün değil.
        
        T toDelete;
        
        if(head.next == null) {
            toDelete = head.data;
            head = null;
        } else {
            NodeSingleLL<T> prev = this.getNodeFromPosition(size-1);
            toDelete = prev.next.data;
            prev.next = null;
            tail = prev;
        }  
        size--;
        return toDelete;
    }

    @Override
    public T removeFirst() {
        if(head == null) return null;
        
        NodeSingleLL<T> toDelete = head;
        head = head.next;
        size--;
        return toDelete.data;
    }

    @Override
    public T remove(int position) {
        if(position < 1 || position > size) return null;
        
        if(position == 1) { return this.removeFirst(); }
        if(position == size) { return this.removeLast(); }
        
        NodeSingleLL<T> prev = getNodeFromPosition(position-1);
        NodeSingleLL<T> toDelete = prev.next;
        prev.next = prev.next.next;
        size--;
        return toDelete.data;
    }
    
    @Override
    public T get(int position) {
        NodeSingleLL<T> node = getNodeFromPosition(position);
        
        if(node == null)
            return null;
        else
            return node.data;
    }
    
    @Override
    protected NodeSingleLL<T> getNodeFromValue(T value) {
        NodeSingleLL<T> itr = head;
        
        while(itr != null) {
            if(itr.data.equals(value))
                return itr;
            itr = itr.next;
        }
        
        return null;
    }

    @Override
    protected NodeSingleLL<T> getNodeFromPosition(int position) {
        if(position < 1 || position > size) return null;
        
        NodeSingleLL<T> itr = head;
        
        for(int i=0;i<position-1;i++)
            itr = itr.next;
        
        return itr;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private NodeSingleLL<T> curr = head;
            
            @Override
            public boolean hasNext() 
            {        
                return curr != null;
            }
            @Override
            public T next() 
            {   
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

    @Override
    public void printAll() {
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }
}
