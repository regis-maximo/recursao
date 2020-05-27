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
public class TowerOfHanoi {
    
    private final int disks;

    public TowerOfHanoi(int disks) {
        this.disks = disks;
    }
    
    public void solveTowers(int disks, int sourcePeg, int destinationPeg, int tempPeg) {
        // caso básico -- somente um disco para ser movido
        if(disks == 1) {
            System.out.printf("%d ---> %d*\n", sourcePeg, destinationPeg);
            return;
        }
        // passo de recursao -- move o disco p/ tempPeg, e depois para destinationPeg
        // move (disks - 1) discos de sourcePeg para tempPeg recursivamente
        solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);
        
        // move o último disco de sourcePeg para destinationPeg
        System.out.printf("%d ---> %d\n", sourcePeg, destinationPeg);
        
        // move (disks - 1) discos de tempPeg para destinationPeg
         solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
    }
}
