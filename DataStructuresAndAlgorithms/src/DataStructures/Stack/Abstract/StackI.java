/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack.Abstract;

import DataStructures.Stack.Exceptions.EmptyStackEx;
import DataStructures.Stack.Exceptions.StackOverflowEx;

/**
 *
 * @author yasir
 */
public interface StackI<T> {
    T peek() throws EmptyStackEx;
    T pop() throws EmptyStackEx;
    void push(T obj);
}
