/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.DynamicArray;
import java.util.Iterator;
import java.lang.reflect.Array;
import DataStructures.Base.Abstract.VectorI;
import DataStructures.Base.Exceptions.NotValidIndexOrPosition;

/**
 *
 * @author yasir
 */
public final class DynamicArray<T> implements DynamicArrayI<T>, VectorI<T>, Iterable<T> {
    private int size;
    private int capacity;
    private T[] arr;
    private static final int DEFAULT_CAPACITY = 16;
    
    public DynamicArray(Class<T> clazz) {
        this.arr = (T[])Array.newInstance(clazz, DEFAULT_CAPACITY);
        this.capacity = DEFAULT_CAPACITY;
    }
    
    public DynamicArray(Class<T> clazz, T[] arr) {
        int computedCap = arr.length > DEFAULT_CAPACITY ? arr.length*2 : DEFAULT_CAPACITY;
        this.arr = (T[])Array.newInstance(clazz, computedCap);
        this.capacity = computedCap;
        for(T elem : arr)
            this.append(elem);
    }
    
    public DynamicArray(Class<T> clazz, int capacity) {
        this.arr = (T[])Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }
    
    private void resize() {
        int newCap = capacity*2; //Bir yerden sonra 2 katına çıkarmak fazla olacaktır. Farklı yöntemler uygulanabilir.
        T[] newArr = (T[])Array.newInstance(this.arr.getClass().componentType(), newCap);
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        capacity = newCap;
    }
    
    private boolean isValidIndexForAccess(int index) {
        return index >= 0 && index < size;
    }
    
    private boolean isValidIndexForInsert(int index) {
        return index >= 0 && index <= size;
    }
    
    private boolean isResizeRequired() {
        return size + 1 > capacity; //Değiştirilebilir.
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
    public T get(int index) throws NotValidIndexOrPosition {
        if(!isValidIndexForAccess(index))
            throw new NotValidIndexOrPosition();
        
        return arr[index];
    }

    @Override
    public T remove(int index) throws NotValidIndexOrPosition {
        if(!isValidIndexForAccess(index))
            throw new NotValidIndexOrPosition();
        
        T deleted = arr[index];
        for(int i=index;i<size-1;i++)
            arr[i] = arr[i+1];
         
        size--;
        arr[size] = null;
        return deleted;
    }

    @Override
    public void insert(int index, T value) throws NotValidIndexOrPosition{
        if(!isValidIndexForInsert(index))
            throw new NotValidIndexOrPosition();
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
