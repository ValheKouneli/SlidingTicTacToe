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
public class SituationTest {
    
    private Situation situation;
    private static final int SIZE = 3;
    
    @Before
    public void setUp() {
        situation = new Situation(SIZE);
    }
    
    @Test
    public void initializationWorks() {
        assertEquals(SIZE, situation.getSize());
    }
    
    @Test
    public void initializationSetsPiecesOnFieldToZero() {
        assertEquals(0, situation.getBlacksOnField());
        assertEquals(0, situation.getRedsOnField());
    }
    
    @Test
    public void initializationSetsPositionsToNoPiecesOnField() {
        //random tests
        assertEquals(false, situation.getRedPositions(SIZE-1, SIZE-1));
        assertEquals(false, situation.getBlackPositions(SIZE-1, SIZE-1));
    }
    
    //@Test
    public void getCopyWorks() {
        Situation copy = situation.getCopy();
        //TODO
    }
    
}
