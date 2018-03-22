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
public class PieceTest {
    
    Piece piece;
    
    @Before
    public void setUp() {
        piece = new Piece(Color.RED, Orientation.VERTICAL, 0);
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(Color.RED, piece.getColor());
        assertEquals(Orientation.VERTICAL, piece.getOrientation());
    }
    
    @Test
    public void settingPositionWorks() {
        piece.setPosition(3);
        assertEquals(3, piece.getPosition());
    }
    
    @Test
    public void settingOtherPieceWorks() {
        //TODO: make this test better
        Piece other = new Piece(Color.BLACK, Orientation.HORIZONTAL, 0);
        piece.setOtherPiece(other);
        assertEquals(Orientation.HORIZONTAL, piece.getOtherPiece().getOrientation());
    }
    
    @Test
    public void getCopyWorks() {
        piece.setPosition(0);
        Piece copy = piece.getCopy();
        copy.setPosition(1);
        assertEquals(0, piece.getPosition());
    }
}
