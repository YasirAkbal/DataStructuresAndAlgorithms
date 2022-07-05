/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Base.Exceptions;

/**
 *
 * @author yasir
 */
public class NotValidIndexOrPosition extends RuntimeException {
    public NotValidIndexOrPosition() {}
    
    public NotValidIndexOrPosition(String message) {
        super(message);
    }
}
