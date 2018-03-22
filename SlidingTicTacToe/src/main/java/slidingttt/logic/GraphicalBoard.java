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
    
    private final ArrayList<Shape> shapes;
    private final Dimension dim = new Dimension(500, 500);
    private Situation situation;
    
    public GraphicalBoard() {
        shapes = new ArrayList<>();
        //add shapes
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Shape s : shapes) {

                    if (s.contains(me.getPoint())) {//check if mouse is clicked within shape

                        //do something

                    }
                }
            }
        });
    }
    
    public void setSituation(Situation situation) {
        this.situation = situation;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Shape s : shapes) {
            g2d.draw(s);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }
    
}
