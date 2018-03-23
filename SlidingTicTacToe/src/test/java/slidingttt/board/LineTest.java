/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.board;

import slidingttt.board.Line;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import slidingttt.logic.PieceColor;
import slidingttt.logic.Orientation;

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
        assertEquals(Orientation.VERTICAL, line.getOrientation());
        assertEquals(0, line.getNumber());
        assertEquals(5, line.getLength());
    }
    
    @Test
    public void constructorSetsCorrectPieceColors() {
        assertEquals(PieceColor.RED, line.getPiece(PieceColor.RED).getColor());
        assertEquals(PieceColor.BLACK, line.getPiece(PieceColor.BLACK).getColor());

    }
    
    @Test
    public void constructorSetsCorrectPieceOrientation() {
        assertEquals(line.getOrientation(), line.getPiece(PieceColor.BLACK).getOrientation());
        assertEquals(line.getOrientation(), line.getPiece(PieceColor.RED).getOrientation());
    }
    
    @Test
    public void constructorSetsCorrectPiecePositions() {
        assertEquals(0, line.getPiece(PieceColor.RED).getPosition());
        assertEquals(4, line.getPiece(PieceColor.BLACK).getPosition());
    }
    
    @Test
    public void constructorLetsPiecesKnowEachOther() {
        assertEquals(0, line.getPiece(PieceColor.BLACK).getOtherPiece().getPosition());
        assertEquals(4, line.getPiece(PieceColor.RED).getOtherPiece().getPosition());
    }
    
    @Test
    public void getCopyWorks() {
        Line copy = line.getCopy();
        copy.getPiece(PieceColor.RED).setPosition(3);
        assertEquals(0, line.getPiece(PieceColor.RED).getPosition());
    }
}
