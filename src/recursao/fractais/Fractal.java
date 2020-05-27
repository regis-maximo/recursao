/*
 * Demostra uma interface com o usuário para desenhar um fractal
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao.fractais;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author regis
 */
public class Fractal extends JFrame {

    private final int WIDTH = 400; // define a largura de GUI
    private final int HEIGHT = 480;// define a altura de GUI
    private final int MIN_LEVEL = 0, MAX_LEVEL = 15;
    private Color color = Color.BLUE;

    private JButton changeColorJButton, increaseLevelJButton,
            decreaseLevelJButton;
    private JLabel levelLabel;
    private FractalJPanel drawSpace;
    private JPanel mainJPanel, controlJPanel;

    // configura a GUI
    public Fractal() {
        super("Fractal");

        // configura o painel de controle
        controlJPanel = new JPanel();
        controlJPanel.setLayout(new FlowLayout());

        // configura o botão de cor e registra o ouvinte
        changeColorJButton = new JButton("Color");
        controlJPanel.add(changeColorJButton);
        changeColorJButton.addActionListener(
                new ActionListener() { // classe interna anônima

            // processa o evento changeColorJButton
            @Override
            public void actionPerformed(ActionEvent event) {

                color = JColorChooser.showDialog(Fractal.this, "Choose a Color", color);

                // configura a cor padrão se nenhuma cor for retornada 
                if (color == null) {
                    color = Color.BLUE;

                    drawSpace.setColor(color);
                }
            } // fim do método actionPerformed
        }); // fim da classe interna anônima

        // configura o botão decrease level para adicionar no ControlJPanel
        // e registra o ouvinte
        decreaseLevelJButton = new JButton("Decrease Level");
        controlJPanel.add(decreaseLevelJButton);
        decreaseLevelJButton.addActionListener(
                new ActionListener() { // classe interna anônima

            // processa o evento decreaseLevelJButton        
            @Override
            public void actionPerformed(ActionEvent e) {

                int level = drawSpace.getLevel();
                level--; // diminui o level por um

                // modifica o nível se possível 
                if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
                    levelLabel.setText("Level: " + level);
                    drawSpace.setLevel(level);
                    repaint();
                } // fim do if
            } // fim da classe interna anônima
        }); // fim do método actionPerformed

        // configura o botão increase level para adicionar no controlJPanel
        // registrar o ouvinte 
        increaseLevelJButton = new JButton("Increase Level");
        controlJPanel.add(increaseLevelJButton);
        increaseLevelJButton.addActionListener(
        new ActionListener() { // classe interna anônima
            
            // processa evento increaseLevelJButton
            @Override
            public void actionPerformed(ActionEvent event) {
               
                int level = drawSpace.getLevel();
                level++; // aumenta nível por um
                
                // modifica o nível se possível 
                if((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
                    levelLabel.setText("Level: " + level);
                    drawSpace.setLevel(level);
                    repaint();
                } // fim do if
            } // fim do método actionPerformed
        }); // fim de addActionListener e da classe interna anônima 
        
        // configura levelJLabel para adicionar ao controlJPanel
        levelLabel = new JLabel("Level: 0");
        controlJPanel.add(levelLabel);
        
        drawSpace = new FractalJPanel(0);
        
        // cria mainJPanel para conter controlJPanel e drawSpace
        mainJPanel = new JPanel();
        mainJPanel.add(controlJPanel);
        mainJPanel.add(drawSpace);
        add(mainJPanel); // adiciona JPanel ao JFrame
        
        setSize(WIDTH, HEIGHT); // configura o tamanho do JFrame
        setVisible(true); // exibe JFrame
    } // fim do contrutor Fractal
} // fim da classe Fractal
