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
        line = new Line(Const.VERTICAL, 0, 5);
    }
    
    @Test
    public void constructorSetsCorrectIndexAndLength() {
        assertEquals(Const.VERTICAL, line.getOrientation());
        assertEquals(0, line.getNumber());
        assertEquals(5, line.getLength());
    }
    
    @Test
    public void constructorSetsCorrectPieceColors() {
        assertEquals(Const.RED, line.getPiece(Const.RED).getColor());
        assertEquals(Const.BLACK, line.getPiece(Const.BLACK).getColor());

    }
    
    @Test
    public void constructorSetsCorrectPieceOrientation() {
        assertEquals(line.getOrientation(), line.getPiece(Const.BLACK).getOrientation());
        assertEquals(line.getOrientation(), line.getPiece(Const.RED).getOrientation());
    }
    
    @Test
    public void constructorSetsCorrectPiecePositions() {
        assertEquals(0, line.getPiece(Const.RED).getPosition());
        assertEquals(4, line.getPiece(Const.BLACK).getPosition());
    }
    
    @Test
    public void constructorLetsPiecesKnowEachOther() {
        assertEquals(0, line.getPiece(Const.BLACK).getOtherPiece().getPosition());
        assertEquals(4, line.getPiece(Const.RED).getOtherPiece().getPosition());
    }
    
    @Test
    public void getCopyWorks() {
        Line copy = line.getCopy();
        copy.getPiece(Const.RED).setPosition(3);
        assertEquals(0, line.getPiece(Const.RED).getPosition());
    }
}
