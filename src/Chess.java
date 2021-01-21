import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is an abstract class, which provides some non-abstract methods and an abstract method. However,
 * this class cannot be instantiated
 * @author Zhiping   student number 00822513      date 2020,08,10
 */
public abstract class Chess {
    /* radius of a chess */
    private final double radius;
    /* the x-coordinate of a rectangle */
    private int x;
    /* the y-coordinate of a rectangle */
    private int y;
    /* check if a chess has been selected */
    private boolean clicked;

    /**
     * Constructor  initializes the instance variables
     * @param radius  radius of a chess
     * @param x     x-coordinate of a rectangle
     * @param y     y-coordinate of a rectangle
     */
    public Chess(double radius, int x, int y){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    /**
     * Obtain the radius of the chess
     * @return radius of the chess
     */
    public double getRadius(){
        return radius;
    }

    /**
     * Draw a chess on the canvas based on specified line width
     * @param gc The GraphicsContext to draw on
     */
    public void drawChess(GraphicsContext gc){
        gc.setLineWidth(2);
        gc.fillOval(x,y,getRadius(),getRadius());
        gc.strokeOval(x,y,getRadius(),getRadius());
    }

    /**
     * Abstract method which will force its subtype to override it. Plus, it compares itself and other object
     * @param o other object
     * @return boolean check if parameter object is equal to this object
     */
    public abstract boolean equals(Object o);

    /**
     * Get the x-coordinate
     * @return the x-coordinate of the rectangle
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y-coordinate
     * @return the y-coordinate of the rectangle
     */
    public int getY() {
        return y;
    }

    /**
     * Checked if a chess has been clicked or not
     * @return boolean true if a chess has been clicked, otherwise false
     */
    public boolean getClicked(){
        return this.clicked;
    }

    /**
     * Set the value of clicked to true or false depending on the parameter
     * @param selected true or false value
     */
    public void setClicked(boolean selected){
        this.clicked = selected;
    }

}
