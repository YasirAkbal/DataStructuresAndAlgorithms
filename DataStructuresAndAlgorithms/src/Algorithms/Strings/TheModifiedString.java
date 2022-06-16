/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class TheModifiedString {
    public static long modified(String a) {
        int result = 0;
        int n = a.length();
        
        int count = 1;
        for(int i=1;i<n;i++) {
            if(a.charAt(i) == a.charAt(i-1)) {
                count++;
            } else if(count > 2){
                int add = count%2 == 0 ? count/2-1 : count/2;
                result += add;
                count = 1;
            } else {
                count = 1;
            }
        }
        
        if(count > 2) {
            int add = count%2 == 0 ? count/2-1 : count/2;
            result += add;
        }
        
        return result;
    }
}
