/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.DynamicArray;
import java.util.Iterator;
import java.lang.reflect.Array;

/**
 *
 * @author yasir
 */
public final class DynamicArray<T> implements IDynamicArray<T>, Iterable<T> {
    private int size;
    private int capacity;
    private T[] arr;
    private static final int DEFAULT_CAPACITY = 16;
    
    public DynamicArray() {
        this.arr = (T[])Array.newInstance(Object.class, DEFAULT_CAPACITY);
        this.capacity = DEFAULT_CAPACITY;
    }
    
    public DynamicArray(T[] arr) {
        int computedCap = arr.length > DEFAULT_CAPACITY ? arr.length*2 : DEFAULT_CAPACITY;
        this.arr = (T[])Array.newInstance(Object.class, computedCap);
        this.capacity = computedCap;
        for(T elem : arr)
            this.append(elem);
    }
    
    public DynamicArray(int capacity) {
        this.arr = (T[])Array.newInstance(Object.class, capacity);
        this.capacity = capacity;
    }
    
    private void resize() {
        int newCap = capacity*2;
        T[] newArr = (T[])Array.newInstance(Object.class, newCap);
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        capacity = newCap;
    }
    
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }
    
    private boolean isResizeRequired() {
        return size + 1 < capacity;
    }
    
    @Override
    public boolean contains(T value) {
        for(T elem: arr){
            if(elem.equals(value))
                return true;
        }
        
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void append(T value) {
        if(isResizeRequired())
            resize();
        
        this.arr[size++] = value;
    }

    @Override
    public T get(int index) {
        if(!isValidIndex(index))
            throw new ArrayIndexOutOfBoundsException();
        
        return arr[index];
    }

    @Override
    public T remove(int index) {
        if(!isValidIndex(index))
            throw new ArrayIndexOutOfBoundsException();
        
        for(int i=index;i<size-1;i++)
            arr[i] = arr[i+1];
        
        size--;
        T deleted = arr[size];
        arr[size] = null;
        return deleted;
    }

    @Override
    public void insert(int index, T value) {
        if(!isValidIndex(index))
            throw new ArrayIndexOutOfBoundsException();
        if(isResizeRequired())
            resize();
        
        for(int i=size;i>index;i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        size++;
    }
    
    @Override
    public Iterator<T> iterator() 
    {      
        // OverRiding Default List Iterator 
        Iterator<T> it = new Iterator<T>() 
        {
            private int index = 0;
            
            @Override
            public boolean hasNext() 
            {        
                return index < size;
            }
            @Override
            public T next() 
            {             
                return arr[index++];
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
