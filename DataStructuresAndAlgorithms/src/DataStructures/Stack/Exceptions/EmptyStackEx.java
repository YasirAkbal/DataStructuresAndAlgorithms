/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack.Exceptions;

/**
 *
 * @author yasir
 */
public class EmptyStackEx extends RuntimeException {
    public EmptyStackEx() {}
    
    public EmptyStackEx(String message) {
        super(message);
    }
}
