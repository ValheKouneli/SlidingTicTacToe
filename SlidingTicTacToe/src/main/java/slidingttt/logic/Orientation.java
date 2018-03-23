/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidingttt.logic;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Valhe Kouneli
 */
public enum Orientation {
    HORIZONTAL,
    VERTICAL;

    public Shape getNewShape() {
        switch (this) {
            case HORIZONTAL : return new Rectangle(90, 50);
            case VERTICAL   : return new Rectangle(50, 90);
            default         : return null;
        }
    }
}
