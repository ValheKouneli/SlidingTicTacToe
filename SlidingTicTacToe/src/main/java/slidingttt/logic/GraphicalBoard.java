/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import slidingttt.board.Piece;
import slidingttt.board.Situation;

/**
 *
 * @author Valhe Kouneli
 */
class GraphicalBoard extends Application {
    
    private HashMap<PieceColor, HashMap<Orientation, HashMap<Integer, Shape>>> pieces;
    private final Scene scene;
    private Pane pane;
    private Situation situation;
    
    public GraphicalBoard() {
        super();
        this.pane = new Pane();
        this.scene = new Scene(pane);
    }
    
    
    public void setSituationAndInit(Situation situation) {
        this.situation = situation;
        pieces = new HashMap<>();
        Shape shape;
        
        pane.setPrefSize(situation.getSize()*100, situation.getSize()*100+100);
        
        for (PieceColor color : PieceColor.values()) {
            pieces.put(color, new HashMap<>());
            for (Orientation orientation : Orientation.values()) {
                pieces.get(color).put(orientation, new HashMap<>());
                for (int i=0; i<situation.getSize(); i++) {
                    shape = orientation.getNewShape();
                    pieces.get(color).get(orientation).put(i, orientation.getNewShape());
                }
            }
        }
        
        
        //add shapes
        
        
//        addMouseListener(new MouseAdapter() { //MouseListener is interface so can not be instantiated
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                super.mouseClicked(me);
//                for (Shape s : pieces) {
//
//                    if (s.contains(me.getPoint())) {//check if mouse is clicked within shape
//
//                        //do something
//
//                    }
//                }
//            }
//        });
    }
    
    public void refresh() {
        Shape shape;
        int piecePosition;
        
        for (PieceColor color : PieceColor.values()) {
            for (Orientation orientation : Orientation.values()) {
                for (int i=0; i<situation.getSize(); i++) {
                    shape = pieces.get(color).get(orientation).get(i);
                    piecePosition = situation.getPiecePosition(color, orientation, i);
                }
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
