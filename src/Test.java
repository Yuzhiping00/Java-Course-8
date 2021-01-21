import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * This is a test class, which is used to create GUI and requests users to add,remove and select specific chess. In addition,
 * if users input invalid information, there will be warning message sent out to inform users.
 * @author Zhiping   student number 00822513      date 2020,08,10
 */
public class Test extends Application {
    /* declare which components should appear on the GUI */
    private GraphicsContext gc;       // GraphicsContext draw on the canvas
    private ArrayList<Chess> chesses; // an ArrayList which contains chess objects
    private Button addButton;         // add a piece button
    private Button removeButton1;     // remove a piece button
    private Label rowLabel;           // text row
    private Label columnLabel;        // text column
    private Label colorLabel;         // ask users to pick up a color
    private Label title;              // text indicates the size of the board
    private Label selectLabel;        // text selected area
    private TextField addField;       // a field on the right of add button
    private TextField columnField;    // a field after text column
    private TextField rowField;       // a field after text row
    private TextField colorField;     // a field for user to pick color
    private TextField selectField;    // a field below the text selected area
    private TextField removeField;    // a field on the right of the remove button

    /**
     * Start method(use this method instead of main). Create new components and put them on the panel, then
     * relocate their position and change the size of the components.
     *
     * @param stage The FX stage to draw on
     * @throws Exception an exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 480, 800); // set the size here
        stage.setTitle("Play Chess!"); // set the window title here
        stage.setScene(scene);
        Canvas canvas = new Canvas(440, 440);
        chesses = new ArrayList<>();
        gc = canvas.getGraphicsContext2D();
        title = new Label("This is a 10 * 10 chess board");
        rowLabel = new Label("Row: ");
        columnLabel = new Label("Column: ");
        rowField = new TextField("");
        columnField = new TextField("");
        addButton = new Button("Add");
        removeButton1 = new Button("Remove");
        colorLabel = new Label("Pick A Color To add a chess (r/g)");
        colorField = new TextField("");
        addField = new TextField("");
        removeField = new TextField("");
        selectField = new TextField("");
        selectLabel = new Label("Selected Area: ");
        root.getChildren().addAll(canvas,title, addButton, removeButton1, columnField, rowField, rowLabel,
                columnLabel,colorField, colorLabel, addField, selectField, selectLabel, removeField);
        setBoard();
        title.relocate(160, 5);
        title.setStyle("-fx-background-color:lightblue; -fx-text-fill: blue;");
        title.setFont(Font.font("Geneva", 18));
        rowLabel.relocate(40, 480);
        rowLabel.setFont(Font.font("Verdana", 16));
        rowField.relocate(85, 480);
        rowField.setPrefWidth(50);
        rowField.setStyle("-fx-background-color:lightblue; -fx-text-fill: blue;");
        columnLabel.relocate(40, 520);
        columnLabel.setFont(Font.font("Verdana", 16));
        columnField.relocate(110, 520);
        columnField.setPrefWidth(50);
        columnField.setStyle("-fx-background-color:lightblue; -fx-text-fill: blue;");

        colorLabel.relocate(180, 480);
        colorLabel.setFont(Font.font("Verdana", 16));
        colorLabel.setStyle("-fx-background-color: pink;");
        colorField.relocate(250, 520);
        colorField.setFont(Font.font("Verdana", 14));
        colorField.setPrefWidth(50);
        colorField.setStyle("-fx-background-color: lightblue;-fx-text-fill:blue");

        addButton.relocate(40, 580);
        addButton.setPrefWidth(80);
        addButton.setFont(Font.font("Geneva", 16));
        addField.relocate(130, 580);
        addField.setPrefWidth(345);
        addField.setFont(Font.font("System", 16));
        addField.setStyle("-fx-background-color: lightblue;-fx-text-fill:blue");
        removeButton1.relocate(40, 630);
        removeButton1.setPrefWidth(90);
        removeButton1.setFont(Font.font("Geneva", 16));
        removeField.relocate(140, 630);
        removeField.setPrefWidth(335);
        removeField.setFont(Font.font("System", 16));
        removeField.setStyle("-fx-background-color: lightblue;-fx-text-fill:blue");

        selectLabel.relocate(40, 700);
        selectLabel.setFont(Font.font("Verdana", 16));
        selectField.relocate(40, 740);
        selectField.setPrefWidth(435);
        selectField.setFont(Font.font("Verdana", 14));
        selectField.setStyle("-fx-background-color:lightblue;-fx-text-fill:blue;");
        addButton.setOnAction(this::addHandler);
        removeButton1.setOnAction(this::removeHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::clickHandler);
        stage.show();
    }

    /**
     * Draw a 10 * 10 chess board and some different color chess have been placed on it.
     */
    private void setBoard() {

        for (int c = 1; c <= 10; c += 1) {
            for (int r = 1; r <= 10; r += 1) {
                drawGrid(c,r);
            }
        }
        // place some chess on the board
        GreenChess g1 = new GreenChess(80, 160);

        g1.drawChess(gc);
        chesses.add(g1);

        RedChess r1 = new RedChess(80, 80);

        r1.drawChess(gc);
        chesses.add(r1);

        GreenChess g2 = new GreenChess(160, 320);

        g2.drawChess(gc);
        chesses.add(g2);

        RedChess r2 = new RedChess(280, 120);

        r2.drawChess(gc);
        chesses.add(r2);

        GreenChess g3 = new GreenChess(120, 360);

        g3.drawChess(gc);
        chesses.add(g3);

        RedChess r3 = new RedChess(240, 360);

        r3.drawChess(gc);
        chesses.add(r3);

        GreenChess g4 = new GreenChess(320, 320);

        g4.drawChess(gc);
        chesses.add(g4);

        RedChess r4 = new RedChess(360, 240);

        r4.drawChess(gc);
        chesses.add(r4);

        GreenChess g5 = new GreenChess(160, 160);

        g5.drawChess(gc);
        chesses.add(g5);

    }

    /**
     * Draw squares on the board
     * @param c column number
     * @param r row number
     */
    private void drawGrid(int c, int r){
        gc.setFill(Color.IVORY);
        gc.fillRect(c*40, r*40, 40, 40);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeRect(c*40, r*40, 40, 40);
    }

    /**
     * After users press the add button, it is supposed to add a new chess to the board. However, if there has already
     * one chess been on the specific grid, the system will throw an exception and inform users the issue in an
     * alert. If users input non-integer on the row and column fields, there is another exception called InputMismatch
     * exception which will cause another alert. In addition, if users input integer less than or equal to 0, or
     * greater than 10, the system will ask users to reenter an integer. Furthermore, if users do not pick up color from
     * r/g, system will asks users to reenter a String.
     */
    private void addHandler(ActionEvent e) {
        /* when users repress the add button, the previous information in the fields should disappear */
        selectField.setText("");
        removeField.setText("");
        try { // check if there is an InputMismatchException
            int row = Integer.parseInt(rowField.getText());
            int column = Integer.parseInt(columnField.getText());
            if ((row <= 0 || row > 10) || (column <= 0 || column > 10)) { // check if numbers inputted is in the range
                addField.setText("Enter integer for row/column from 1 to 10 !");
            } else {
                try { // check if there has already one piece on that grid
                    checkOverlap(row, column);
                    String color = colorField.getText();
                    if (color.toLowerCase().equals("g")) {// add one piece to the board with random color
                        addField.setText("Added a new GreenChess at row: " + row + " column: " + column);
                        GreenChess gAdd = new GreenChess(40 * column, 40 * row);
                        gAdd.drawChess(gc);
                        chesses.add(gAdd);
                    } else if (color.toLowerCase().equals("r")) {
                        addField.setText("Added a new RedChess at row: " + row + " column: " + column);
                        RedChess rAdd = new RedChess(40 * column, 40 * row);
                        rAdd.drawChess(gc);
                        chesses.add(rAdd);
                    } else {
                        addField.setText("Please enter r/g for color!");
                    }
                } catch (IllegalArgumentException e1) {
                    createAlert(e1.getMessage());

                }
                rowField.requestFocus();
            }
        } catch (NumberFormatException e2) {
            String errorMsg = "Please input integers for column and row!";
            createAlert(errorMsg);
        }
    }

    /**
     * This method is used to remove an existing chess from the board based on the columns and rows user
     * indicated. When there is a chess on the specific grid, we can remove it and remove this element from
     * Arraylist as well. When there is no chess on the grid user specified, we should inform user by
     * displaying an alert information.
     *
     * @param e ActionEvent action event
     */
    private void removeHandler(ActionEvent e) {
        /* when users repress the remove button, the previous information in the fields should disappear */
        selectField.setText("");
        addField.setText("");
        try { // check if input is legal
            int row = Integer.parseInt(rowField.getText());
            int column = Integer.parseInt(columnField.getText());
            try { // check if there is a chess on the board
                checkEmpty(row, column); // if there is no chess on the board, throw an exception
                Chess red = new RedChess(column * 40, row * 40);
                Chess green = new GreenChess(column * 40, row * 40);
                if (chesses.contains(red)) { // check what color of the chess at the specified area
                    chesses.remove(red);
                    removeField.setText("RedChess at row: " + row + ",column: " + column + " removed");
                } else if (chesses.contains(green)) {
                    chesses.remove(green);
                    removeField.setText("GreenChess at row: " + row + ",column: " + column + " removed");
                }
                // After removing a chess, the original grid will show up
                drawGrid(column,row);
            } catch (IllegalArgumentException e1) {
                createAlert(e1.getMessage());
            }
        } catch (NumberFormatException e2) {
            String errorMsg = "Please input integers for row and column!";
            createAlert(errorMsg);
        }
    }

    /**
     * When the mouse clicks on a grid which has a chess, then we outlines the chess. If these is no chess
     * on the specific grid, the grid keeps its original state. After we click another chess the outline of
     * the previous chess should be gone and new selected one has the outline.
     *
     * @param me MouseEvent mouse event
     */
    private void clickHandler(MouseEvent me) {
        //To remove the information in the fields from last stage
        rowField.setText("");
        columnField.setText("");
        colorField.setText("");
        addField.setText("");
        removeField.setText("");
        for (Chess chess:chesses
             ) {
            if(chess.getClicked()){
                drawGrid(chess.getX()/40, chess.getY()/40);
                chess.drawChess(gc);
                chess.setClicked(false);
                System.out.println(chess);// print out the chess which lost outline
            }
        }
        int column = (int) (me.getX()) / 40; // calculate which column the user selected
        int row = (int) (me.getY()) / 40;   // calculate which row the user selected
        Chess red = new RedChess(column * 40, row * 40);
        Chess green = new GreenChess(column * 40, row * 40);
        if (chesses.contains(red)) { // check if selected area has a chess or not and what color of it
            drawOutline(column,row);
            selectField.setText("RedChess at row: " + row + ",column: " + column + " is selected.");
            chesses.get(chesses.indexOf(red)).setClicked(true);
            System.out.println(chesses.get(chesses.indexOf(red))); // print the chess with outline
        } else if (chesses.contains(green)) {
            drawOutline(column,row);
            selectField.setText("GreenChess at row: " + row + ",column: " + column + " is selected.");
            chesses.get(chesses.indexOf(green)).setClicked(true);
            System.out.println(chesses.get(chesses.indexOf(green))); // print the chess with outline
        } else {
            selectField.setText("No Chess can be selected at row: " + row + ", column: " + column + " Try again!");
        }
    }

    /**
     * If there is a chess in a specific grid, throw an IllegalArgument exception object.
     * @param r specific row user input
     * @param c specific column user input

     */
    private void checkOverlap(int r, int c){
        if (chesses.contains(new RedChess(40 * c, 40 * r)) ||
                chesses.contains(new GreenChess(40 * c, 40 * r))) {
            throw new IllegalArgumentException("Do not place a new piece on the existing one!");
        }
    }

    /**
     *  If there is no chess at a specific grid, throw an IllegalArgument exception object.
     * @param r specific row user input
     * @param c specific column user input
     */
    private void checkEmpty(int r, int c){
        if (!(chesses.contains(new RedChess(40 * c, 40 * r)) ||
                chesses.contains(new GreenChess(40 * c, 40 * r)))) {
            throw new IllegalArgumentException("No chess in this grid, you cannot remove a chess here!");
        }
    }

    /**
     * Create an alert window and show users what the system is warning
     * @param msg the warning message will show to the users in the alert window
     */

    private void createAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING MESSAGE");
        alert.setHeaderText("WARNING!");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * Draw dark blue outline for the selected chess
     *
     * @param column the column of the chess exists
     * @param row    the row of the chess exists
     */

    private void drawOutline(int column, int row) {
        gc.setStroke(Color.DARKBLUE);
        gc.setLineWidth(4);
        gc.strokeOval(column * 40, row * 40, 40, 40);

    }


    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
