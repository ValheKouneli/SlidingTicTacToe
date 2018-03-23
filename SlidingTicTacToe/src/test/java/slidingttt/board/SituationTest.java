///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package slidingttt.board;
//
//import slidingttt.board.Situation;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import slidingttt.logic.PieceColor;
//
///**
// *
// * @author Valhe Kouneli
// */
//public class SituationTest {
//    
//    private Situation situation;
//    private static final int SIZE = 3;
//    
//    @Before
//    public void setUp() {
//        situation = new Situation(SIZE);
//    }
//    
//    @Test
//    public void constructorSetsSizeCorrectly() {
//        //TODO: check that even numbers are not allowed
//        assertEquals(SIZE, situation.getSize());
//    }
//    
//    @Test
//    public void constructorSetsPiecesOnFieldToZero() {
//        assertEquals(0, situation.getPiecesOnField(PieceColor.BLACK));
//        assertEquals(0, situation.getPiecesOnField(PieceColor.RED));
//    }
//    
//    @Test
//    public void constructorSetsPositionsToNoPiecesOnField() {
//        //random tests
//        assertEquals(false, situation.getPiecePositions(PieceColor.RED, SIZE-1, SIZE-1));
//        assertEquals(false, situation.getPiecePositions(PieceColor.BLACK, SIZE-1, SIZE-1));
//    }
//    
//    @Test
//    public void pieceIsTryingToPassAnotherWorksProperly() {
//        assertEquals(false, situation.pieceIsTryingToPassAnother(1, 2, 3));
//        assertEquals(true, situation.pieceIsTryingToPassAnother(1, 3, 2));
//        assertEquals(false, situation.pieceIsTryingToPassAnother(3, 2, 1));
//        assertEquals(true, situation.pieceIsTryingToPassAnother(3, 1, 2));
//    }
//    
//    //@Test
//    public void getCopyWorks() {
//        Situation copy = situation.getCopy();
//        //TODO
//    }
//    
//}
