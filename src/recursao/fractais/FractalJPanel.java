/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.fractais;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author regis
 */
public class FractalJPanel extends JPanel {
    
    private Color color; // armazena cor utilizada para desenhar o fractal
    private int level; // armazena o nível atual do fractal
    
    private final int WIDTH = 400; // define a largura do JPanel
    private final int HEIGHT = 400; // define a altura do JPanel
    
    // configura o nível do fractal inicial com o valor especificado
    // e configura as configurações do JPanel

    public FractalJPanel(int currentLevel) {
        
        color = Color.BLUE; // inicializa a cor do desenho como azul
        level = currentLevel; // configura o nível do fractal inicial 
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    } // fim do contrutor
    
    // desenha o fractal recursivamente
    public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g) {
       
        // caso básico: desenha uma linha conectando dois pontos dados
        if(level == 0) {
            g.drawLine(xA, yA, xB, yB);
        } else { // ponto de recursão: determina novos pontos, desenha próximo nível
            
            // calcula ponto intermediário entre (xA, yA) e (yB, yB)
            int xC = (xA + yB) / 2;
            int yC = (yA + yB) / 2;
            
            // calcula o quarto ponto (xD, yD) que forma uma 
            // triângulo isósceles reto entre (xA, yA) e (xC, yC)
            // onde o ângulo direito está a (xD, yD)
            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 - (xC - xA) / 2;
            
            // desenha recursivamente o Fractal
            drawFractal(level - 1, xD, yD, xA, yA, g);
            drawFractal(level - 1, xD, yD, xC, yC, g);
            drawFractal(level - 1, xD, yD, xB, yB, g);
        } // fim do else
    } // fim do método drawFractal
    
    // inicia o desenho de Fractal
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // desenha o padrão de fractal
        g.setColor(color);
        drawFractal(level, 100, 90, 290, 200, g);
    } // fim do método paintComponent
    
    // configura a cor de desenho como c
    public void setColor(Color c) {
        color = c;
    }
    
    // configura o novo nível de recursão
    public void setLevel(int currentLevel) {
        level = currentLevel;
    }
    
    // retorna o nível de recursão
    public int getLevel() {
        return level;
    } 
} // fim da classe FractalJPanel
