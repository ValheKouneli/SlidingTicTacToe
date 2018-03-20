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
    public void initializationWorks() {
        assertEquals("vertical", line.getOrientation());
        assertEquals(1, line.getNumber());
        assertEquals(5, line.getLength());
    }
    
    @Test
    public void settingBeginningPositionWorks() {
        line.setBeginningPosition();
        assertEquals("red", line.getPiece("red").getColor());
        assertEquals("black", line.getPiece("black").getColor());
        assertEquals(line.getOrientation(), line.getPiece("black").getOrientation());
        assertEquals(line.getOrientation(), line.getPiece("red").getOrientation());
        assertEquals(0, line.getPiece("red").getPosition());
        assertEquals(0, line.getPiece("black").getOtherPiece().getPosition());
        assertEquals(4, line.getPiece("black").getPosition());
        assertEquals(4, line.getPiece("red").getOtherPiece().getPosition());
    }
    
    @Test
    public void setPiecesWorks() {
        Piece red = new Piece("green", "vertical");
        Piece black = new Piece("purple", "vertical");
        line.setPieces(red, black);
        assertEquals("purple", line.getPiece("red").getOtherPiece().getColor());
        assertEquals("green", line.getPiece("black").getOtherPiece().getColor());
    }
    
    @Test
    public void getCopyWorks() {
        line.setBeginningPosition();
        Line copy = line.getCopy();
        copy.getPiece("red").setPosition(3);
        assertEquals(0, line.getPiece("red").getPosition());
    }
}
