import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is a subclass of Chess and it has its own methods,
 * overrides Chess class abstract method, non-abstract method as well.
 * @author Zhiping   student number 00822513      date 2020,08,10
 */
public class GreenChess extends Chess {
    /* set a chess's color to green */
    private static final Color c = Color.GREEN;

    /**
     * Constructor initializes the instance variables
     * @param x x-coordinate of the rectangle
     * @param y y-coordinate of the rectangle
     */
    public GreenChess(int x, int y){
        super(40,x,y); // hardcode the radius of a chess to 40 pixels and call super class
    }

    /**
     * Draw a green chess on the canvas
     * @param gc The GraphicsContext to draw on
     */
    public void drawChess(GraphicsContext gc){
        gc.setFill(c); // fill the chess with green
        super.drawChess(gc);
    }

    /**
     * Get the description of GreenChess
     * @return the representation of GreenChess
     */
    @Override
    public String toString() {
        return "GreenChess{" + " radius=40, "+
                "x=" + getX() +
                ", y=" + getY()+ ", clicked ="+ getClicked()+
                '}';
    }
    /**
     * Override equals method which is to Check if this chess and parameter object are the same
     * @param o other object passed in by parameter
     * @return boolean if two objects are at the same x and y coordinates, return true. Otherwise, return false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof GreenChess){
            GreenChess g = (GreenChess)o; // downcast object to GreenChess type
            return this.getX() == g.getX() && this.getY() == g.getY();
        }else{
            return false;
        }
    }
}
