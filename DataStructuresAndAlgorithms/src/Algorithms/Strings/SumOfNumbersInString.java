/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class SumOfNumbersInString {
    public static long findSum(String str) {
        int n = str.length();
        int sum = 0;
        StringBuffer num = new StringBuffer();
        
        
        for(int i=0;i<n;i++) {
            if(Character.isDigit(str.charAt(i))) {
                num.append(str.charAt(i));
            } else if(num.length() > 0) {
                sum += Integer.parseInt(num.toString());
                num = new StringBuffer();
            }
        }
        
        if(num.length() > 0) {
            sum += Integer.parseInt(num.toString());
        }
        
        return sum;
    }
}
