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
public class CLI extends Game {

    public CLI(int i) {
        super(i);
        
    }

    @Override
    public void init() {
    }

    @Override
    public void refreshDisplay() {
        super.toString();
    }

    @Override
    public void announceWinner() {
        System.out.println("Winner is " + super.getSituation()
                .whoWasBefore(super.getSituation().getTurn()).toString());
    }

    @Override
    public void setPlayers() {
        super.players = new Player[]{new HumanPlayer(Color.RED), 
            new HumanPlayer(Color.BLACK)};
    }
    }
    
}
