/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.permutacao;

/**
 *
 * @author regis
 */
public class Permutation {

    public void permutationString(String init, String end) {
        if (end.length() <= 1) {
            System.out.println(init + end);
        } else {
            for (int i = 0; i < end.length(); i++) {
                try {
                    String newString = end.substring(0, i)
                            + end.substring(i + 1);
                    permutationString(init + end.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
