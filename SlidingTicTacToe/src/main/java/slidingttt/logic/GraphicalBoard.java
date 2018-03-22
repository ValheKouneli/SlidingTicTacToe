/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import slidingttt.board.Situation;

/**
 *
 * @author Valhe Kouneli
 */
class GraphicalBoard extends JPanel {
    
    private  Shape[] pieces;

    //TODO: change into arrays
    private final Dimension dim = new Dimension(500, 500);
    private Situation situation;
    
    public GraphicalBoard() {
        super();
    }
    
    
    public void setSituationAndInit(Situation situation) {
        this.situation = situation;
        pieces = new Shape[situation.getSize()*Const.NUMBER_OF_ORIENTATIONS*2];
        
        addMouseListener(new MouseAdapter() { //MouseListener is interface so can not be instantiated
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Shape s : pieces) {

                    if (s.contains(me.getPoint())) {//check if mouse is clicked within shape

                        //do something

                    }
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Shape s : pieces) {
            g2d.draw(s);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }
    
}
