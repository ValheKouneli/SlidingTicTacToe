/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.graphics;

import java.awt.FlowLayout;
import slidingttt.logic.Game;
import javax.swing.*;

/**
 *
 * @author Valhe Kouneli
 */
public class GUI extends Game {
    
    public GUI(int size) {
        super(size);
    }
    
    public void init() {
        JFrame frame = new JFrame("Sliding Tic Tac Toe");
        
        JPanel  panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
