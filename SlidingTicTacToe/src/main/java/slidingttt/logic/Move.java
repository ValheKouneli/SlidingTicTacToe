/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

/**
 *
 * @author Valhe Kouneli
 */
public class Move {
    
    private final Piece piece;
    private final int from;
    private final int to;
    
    public Move(Piece piece, int from, int to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public int getFrom() {
        return from;
    }
    
    public int getTo() {
        return to;
    }
    
}
