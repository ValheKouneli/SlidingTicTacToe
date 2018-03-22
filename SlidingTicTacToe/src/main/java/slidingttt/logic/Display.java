/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;


import java.awt.event.ActionListener;
import javax.swing.JFrame;
import slidingttt.board.Situation;

/**
 *
 * @author Valhe Kouneli
 */
public class Display {
    
    ActionListener listener;
    Situation situation;
    
    public Display(ActionListener listener, Situation situation) {
        this.listener = listener;
        this.situation = situation;
    }
    
    public void init() {
        JFrame frame = new JFrame();
        frame.setTitle("Shape Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }
    
    private void initComponents(JFrame frame) {
        GraphicalBoard graphicalBoard = new GraphicalBoard();
        graphicalBoard.setSituationAndInit(situation);
        frame.add(graphicalBoard);
    }
    
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
