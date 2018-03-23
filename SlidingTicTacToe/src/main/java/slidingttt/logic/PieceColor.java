package slidingttt.logic;
import javafx.scene.paint.Color;
/**
 *
 * @author Valhe Kouneli
 */
public enum PieceColor {
    
    
    RED(Color.RED),
    BLACK(Color.BLACK);
    
    private Color color;
    
    PieceColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
    /**
     * @return name of the color
     */
    @Override
    public String toString() {
        return "Color: " + name();
    }
}
