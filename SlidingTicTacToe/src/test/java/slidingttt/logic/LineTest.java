/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Valhe Kouneli
 */
public class LineTest {
    
    Line line;
    
    @Before
    public void setUp() {
        line = new Line(Orientation.VERTICAL, 0, 5);
    }
    
    @Test
    public void constructorSetsCorrectIndexAndLength() {
        assertEquals(Const.VERTICAL, line.getOrientation());
        assertEquals(0, line.getNumber());
        assertEquals(5, line.getLength());
    }
    
    @Test
    public void constructorSetsCorrectPieceColors() {
        assertEquals(Const.RED, line.getPiece(Color.RED).getColor());
        assertEquals(Const.BLACK, line.getPiece(Color.BLACK).getColor());

    }
    
    @Test
    public void constructorSetsCorrectPieceOrientation() {
        assertEquals(line.getOrientation(), line.getPiece(Color.BLACK).getOrientation());
        assertEquals(line.getOrientation(), line.getPiece(Color.RED).getOrientation());
    }
    
    @Test
    public void constructorSetsCorrectPiecePositions() {
        assertEquals(0, line.getPiece(Color.RED).getPosition());
        assertEquals(4, line.getPiece(Color.BLACK).getPosition());
    }
    
    @Test
    public void constructorLetsPiecesKnowEachOther() {
        assertEquals(0, line.getPiece(Color.BLACK).getOtherPiece().getPosition());
        assertEquals(4, line.getPiece(Color.RED).getOtherPiece().getPosition());
    }
    
    @Test
    public void getCopyWorks() {
        Line copy = line.getCopy();
        copy.getPiece(Color.RED).setPosition(3);
        assertEquals(0, line.getPiece(Color.RED).getPosition());
    }
}
