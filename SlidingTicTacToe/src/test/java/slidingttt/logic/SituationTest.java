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
    public void setBeginningSituationSetsPiecesOnFieldToZero() {
        situation.setBeginningSituation();
        assertEquals(0, situation.getBlacksOnField());
        assertEquals(0, situation.getRedsOnField());
    }
    
    @Test
    public void setBeginningSituationSetsPositionsToNoPiecesOnField() {
        situation.setBeginningSituation();
        //random tests
        assertEquals(false, situation.getRedPositions(SIZE-1, SIZE-1));
        assertEquals(false, situation.getBlackPositions(SIZE-1, SIZE-1));
    }
    
    @Test
    public void setSituationSetsCorrectNumberOfPiecesOnField() {
        situation.setSituation(new Line[SIZE][SIZE], 2, 4, new boolean[SIZE][SIZE], new boolean[SIZE][SIZE]);
        assertEquals(2, situation.getRedsOnField());
        assertEquals(4, situation.getBlacksOnField());
    }
    
    @Test
    public void setSituationSetsCorrectPiecesPositions() {
        boolean[][] red_positions = new boolean[SIZE][SIZE];
        boolean[][] black_positions = new boolean[SIZE][SIZE];
        red_positions[0][SIZE-1] = true;
        black_positions[SIZE-1][0] = true;
        situation.setSituation(new Line[SIZE][SIZE], 1, 1, red_positions, black_positions);
        assertEquals(true, situation.getRedPositions(0, SIZE-1));
        assertEquals(false, situation.getRedPositions(SIZE-1, 0));
        assertEquals(true, situation.getBlackPositions(SIZE-1, 0));
        assertEquals(false, situation.getBlackPositions(0, SIZE-1));
    }
    
    //@Test
    public void getCopyWorks() {
        situation.setBeginningSituation();
        Situation copy = situation.getCopy();
        //TODO
    }
    
}
