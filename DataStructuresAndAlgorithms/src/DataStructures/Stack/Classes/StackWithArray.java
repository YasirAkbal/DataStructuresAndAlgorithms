/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack.Classes;

import DataStructures.Base.Abstract.VectorI;
import DataStructures.Base.Exceptions.NotValidIndexOrPosition;
import DataStructures.DynamicArray.DynamicArray;
import DataStructures.Stack.Abstract.StackI;
import DataStructures.Stack.Exceptions.EmptyStackEx;

/**
 *
 * @author yasir
 */
public class StackWithArray<T> implements VectorI<T>, StackI<T> {
    private DynamicArray<T> arr;
    private int top; //Aslında top yerine direkt olarak arr.size()-1 ' de kullanılabilir.
    private final Class<T> clazz;
    
    public StackWithArray(Class<T> clazz) {
        arr = new DynamicArray(clazz);
        top = -1;
        this.clazz = clazz;
    }
    
    public StackWithArray(Class<T> clazz, T[] toAdd) {
        arr = new DynamicArray(clazz, toAdd);
        top = arr.size()-1;
        this.clazz = clazz;
    }
    
    @Override
    public T peek() throws EmptyStackEx {
        if(isEmpty()) throw new EmptyStackEx();
        
        return arr.get(top);
    }

    @Override
    public T pop() throws EmptyStackEx {
        if(isEmpty()) throw new EmptyStackEx();
        
        T deleted = arr.remove(top);
        top--;
        return deleted;
    }

    @Override
    public void push(T elem) {
        arr.append(elem);
        top++;
    }
 
    @Override
    public boolean contains(T elem) {
        return arr.contains(elem);
    }
    
    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void insert(int position, T value) throws NotValidIndexOrPosition { // 1-based
        arr.insert(size()-position+1, value);
        top++;
    }

    @Override
    public T get(int position) throws NotValidIndexOrPosition {
        return arr.get(size()-position);
    }

    @Override
    public T remove(int position) throws NotValidIndexOrPosition {
        try {
            return arr.remove(size()-position);
        } catch(NotValidIndexOrPosition ex) {
            throw new NotValidIndexOrPosition();
        } finally {
            top--;
        }   
    }
}
