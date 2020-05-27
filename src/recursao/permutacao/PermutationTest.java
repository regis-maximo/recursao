/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.permutacao;

import java.util.Scanner;

/**
 *
 * @author regis
 */
public class PermutationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a string a ser permutada:");
        String input = scan.nextLine();
        
        Permutation permutation = new Permutation();
        permutation.permutationString("", input);
    }
    
}
