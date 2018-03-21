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
        line = new Line("vertical", 1, 5);
    }
    
    @Test
    public void initializationSetsCorrectNumberAndLength() {
        assertEquals("vertical", line.getOrientation());
        assertEquals(1, line.getNumber());
        assertEquals(5, line.getLength());
    }
    
    @Test
    public void initializationSetsCorrectPieceColors() {
        assertEquals("red", line.getPiece("red").getColor());
        assertEquals("black", line.getPiece("black").getColor());

    }
    
    @Test
    public void initializationSetsCorrectPieceOrientation() {
        assertEquals(line.getOrientation(), line.getPiece("black").getOrientation());
        assertEquals(line.getOrientation(), line.getPiece("red").getOrientation());
    }
    
    @Test
    public void initializationSetsCorrectPiecePositions() {
        assertEquals(0, line.getPiece("red").getPosition());
        assertEquals(4, line.getPiece("black").getPosition());
    }
    
    @Test
    public void initializationLetsPiecesKnowEachOther() {
        assertEquals(0, line.getPiece("black").getOtherPiece().getPosition());
        assertEquals(4, line.getPiece("red").getOtherPiece().getPosition());
    }
    
    @Test
    public void getCopyWorks() {
        Line copy = line.getCopy();
        copy.getPiece("red").setPosition(3);
        assertEquals(0, line.getPiece("red").getPosition());
    }
}
