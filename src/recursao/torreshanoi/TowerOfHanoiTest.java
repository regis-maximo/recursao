/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.torreshanoi;

/**
 *
 * @author regis
 */
public class TowerOfHanoiTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int startPeg = 1; // valor 1 utilizado para indicar startPeg na saída
        int endPeg = 3; // valor 3 utilizado para indicar endPeg na saída
        int tempPeg = 2; // valor 2 utilizado para indicar tempPeg na saída
        int totalDisks = 3; // número de discos
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(totalDisks);

        // chamada não recursiva inicial: move todos os discos
        towerOfHanoi.solveTowers(totalDisks, startPeg, endPeg, tempPeg);
    }

}
