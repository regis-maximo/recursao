/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.fibonacci;

/**
 *
 * @author regis
 */
public class Fibonacci {
    
    public static long fibonacci(long n) {
        if((n == 0) || (n == 1))
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void display() {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d%s", fibonacci(i), (i < 10 ? ", " : "..."));
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        display();
    }
}
