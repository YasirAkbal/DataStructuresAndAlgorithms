/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack.Exceptions;

/**
 *
 * @author yasir
 */
public class StackOverflowEx extends RuntimeException {
    public StackOverflowEx() {}
    
    public StackOverflowEx(String message) {
        super(message);
    }
}
