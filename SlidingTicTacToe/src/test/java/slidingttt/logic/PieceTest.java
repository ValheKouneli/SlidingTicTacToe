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
        piece = new Piece(Const.RED, Const.VERTICAL, 0);
    }
    
    @Test
    public void constructorWorks() {
        assertEquals(Const.RED, piece.getColor());
        assertEquals(Const.VERTICAL, piece.getOrientation());
    }
    
    @Test
    public void settingPositionWorks() {
        piece.setPosition(3);
        assertEquals(3, piece.getPosition());
    }

    @Test
    public void getCopyWorks() {
        piece.setPosition(0);
        Piece copy = piece.getCopy();
        copy.setPosition(1);
        assertEquals(0, piece.getPosition());
    }
}
