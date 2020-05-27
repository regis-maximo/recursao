/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.fatorial;

/**
 *
 * @author regis
 */
public class Fatorial {
    
    public static long fatorar(long n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        return n * fatorar(n - 1);
    }
    
    public static void displayFat() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + fatorar(i));
        }
    }
    
    public static void main(String[] args) {
       displayFat();
    }
}
