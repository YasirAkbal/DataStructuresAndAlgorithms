/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack.Classes;

import DataStructures.Base.Abstract.VectorI;
import DataStructures.Base.Exceptions.NotValidIndexOrPosition;
import DataStructures.LinkedLists.SinglyLinkedList;
import DataStructures.Stack.Abstract.StackI;
import DataStructures.Stack.Exceptions.EmptyStackEx;

/**
 *
 * @author yasir
 */
public class StackWithLL<T> implements StackI<T>, VectorI<T> {
    private SinglyLinkedList<T> list;
    
    public StackWithLL() {
        list = new SinglyLinkedList<>();
    }
    
    public StackWithLL(T[] toAdd) {
        list = new SinglyLinkedList(toAdd);
    }
    
    @Override
    public T peek() throws EmptyStackEx {
        if(list.isEmpty())
            throw new EmptyStackEx();
        
        return list.getFirst();
    }

    @Override
    public T pop() throws EmptyStackEx {
        if(list.isEmpty())
            throw new EmptyStackEx();
        
        return list.removeFirst();
    }

    @Override
    public void push(T elem) {
        list.addFirst(elem);
    }

    @Override
    public boolean contains(T value) {
        return list.contains(value);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void insert(int position, T value) throws NotValidIndexOrPosition {
        list.insert(position, value);
    }

    @Override
    public T get(int position) throws NotValidIndexOrPosition {
        return list.get(position);
    }

    @Override
    public T remove(int position) throws NotValidIndexOrPosition {
        return list.remove(position);
    }
}
