/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import java.util.Arrays;

/**
 *
 * @author Valhe Kouneli
 */
public class Situation {
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private int reds_on_field;
    private int blacks_on_field;
    private boolean[][] red_positions;
    private boolean[][] black_positions;
    private final int size;
    
    public Situation(int size) {
        this.size = size;
    }
    
    public void setBeginningSituation() {
        reds_on_field = 0;
        blacks_on_field = 0;
        red_positions = new boolean[size][size];
        black_positions = new boolean[size][size];
    }
    
    public boolean alterSituation(String orientation, int line_number, int destination) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean checkForThreeInARow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void setSituation(int reds_on_field, int blacks_on_field,
            boolean[][] red_positions, boolean[][] black_positions) {
        this.reds_on_field = reds_on_field;
        this.blacks_on_field = blacks_on_field;
        this.red_positions = red_positions;
        this.black_positions = black_positions;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getBlacksOnField() {
        return blacks_on_field;
    }
    
    public int getRedsOnField() {
        return reds_on_field;
    }
    
    public boolean getRedPositions(int x, int y) {
        return red_positions[x][y];
    }
    
    public boolean getBlackPositions(int x, int y) {
        return black_positions[x][y];
    }
    
    public Situation getCopy(){
        Situation copy = new Situation(size);
        copy.setSituation(reds_on_field, blacks_on_field, Arrays.copyOf(red_positions, size), Arrays.copyOf(black_positions, size));
        return copy;
    }
    
    
}
