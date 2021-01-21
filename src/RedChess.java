import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * This is a subclass of Chess and it has its own methods,
 * overrides Chess class abstract method, non-abstract method as well.
 * @author Zhiping   student number 00822513      date 2020,08,10
 */
public class RedChess extends Chess {
    /* set a chess's color to dark red */
    private static final Color c = Color.DARKRED;

    /**
     * Constructor initializes instance variables
     * @param x x-coordinate of a rectangle
     * @param y y-coordinate of a rectangle
     */
    public RedChess(int x, int y){
        super(40,x, y); // hardcode radius of the red chess and call super class to initialize it
    }

    /**
     * Draw a dark red chess
     * @param gc The GraphicsContext to draw on
     */
    public void drawChess(GraphicsContext gc){
        gc.setFill(c); // fill the chess to dark red color
        super.drawChess(gc);
    }
    /**
     * Get the description of RedChess
     * @return the representation of RedChess
     */
    @Override
    public String toString() {
        return "RedChess{" + " radius=40, "+
                "x=" + getX() +
                ", y=" + getY()+ ", clicked ="+ getClicked()+
                '}';
    }
    /**
     * Override equals method which is to Check if this chess and parameter object are the same
     * @param o other object passed in by parameter
     * @return boolean  if two objects are at same x and y coordinates, return true. Otherwise, return false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof RedChess){
            RedChess r = (RedChess)o; // down cast object to RedChess
            return this.getX() == r.getX() && this.getY() == r.getY();
        }else{
            return false;
        }
    }

}
