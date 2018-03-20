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
public class BoardTest {
    
    Board board;
    
    
    @Before
    public void setUp(){
        board = new Board(3);
    }
    
    @Test
    public void toStringWorking(){
        assertEquals(
                    "  0 1 2 3 4 \n" +
                    "0   r b r   \n" +
                    "1 R + + + B \n" +
                    "2 B + + + R \n" +
                    "3 R + + + B \n" +
                    "4   b r b   \n", board.toString());
    }
    
    
    
}
