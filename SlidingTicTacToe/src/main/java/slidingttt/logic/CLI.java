///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package slidingttt.logic;
//
//import java.util.Scanner;
//
///**
// *
// * @author Valhe Kouneli
// */
//public class CLI extends Game {
//
//    Scanner reader;
//    
//    public CLI(int i) {
//        super(i);
//        
//    }
//
//    @Override
//    public void init() {
//        reader = new Scanner(System.in);
//    }
//
//    @Override
//    public void refreshDisplay() {
//        super.toString();
//    }
//
//    @Override
//    public void announceWinner() {
//        System.out.println("Winner is " + super.getSituation()
//                .whoWasBefore(super.getSituation().getTurn()).toString());
//    }
//
//    @Override
//    public void setPlayers() {
//        HumanPlayer red = new HumanPlayer(PieceColor.RED);
//        HumanPlayer black = new HumanPlayer(PieceColor.BLACK);
//        red.setScanner(reader);
//        black.setScanner(reader);
//        super.players = new Player[]{red, black};
//    }
//    
//    
//}
