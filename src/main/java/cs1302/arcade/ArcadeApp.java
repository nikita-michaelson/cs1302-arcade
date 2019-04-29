package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
public class ArcadeApp extends Application {

    /**
     * Return a key event handler that moves to the rectangle to the left
     * or the right depending on what key event is generated by the associated
     * node.
     * @return the key event handler
     */
    private EventHandler<? super KeyEvent> createKeyHandler() {
	return event -> {
	    System.out.println(event);
	    if (event.getCode() == KeyCode.LEFT)  r.setX(r.getX() - 10.0);
	    if (event.getCode() == KeyCode.RIGHT) r.setX(r.getX() + 10.0);
	    // TODO bounds checking
	};
    } // createKeyHandler

    Scene twenty;
    GridPane grid;

    //frogger instance variables
    Scene leapfrog;
    GridPane frogGrid;
    int frogLevel;
    int enemySpeed;
    Image frog = new Image("frogger/frog.png");
    Image log = new Image("frogger/log.png");
    Image yellowCar = new Image("frogger/yellowcar.png");
    Image greenCar = new Image("frogger/greencar.png");
    Image water = new Image("frogger/water.png");
    String pointsString;
    VBox frogVbox;
    HBox info;
    Label score;
    Text points;
    Label frogInstructions;
    /** {@inheritdoc} */
    @Override
    public void start(Stage stage) {

        /* You are allowed to rewrite this start method, add other methods,
         * files, classes, etc., as needed. This currently contains some
         * simple sample code for mouse and keyboard interactions with a node
         * (rectangle) in a group.
         */

        VBox vbox = new VBox();
        Text t = new Text ("Pick a Game");
        Button frogButton = new Button("Frogger");
        Button tf8 = new Button("2048");
        EventHandler<ActionEvent> tf = () -> stage.setScene(twenty);
        tf8.setOnAction(tf);
        EventHandler<ActionEvent> frogButtonAction = () -> stage.setScene(leapFrog);
        frogButton.setOnAction(frogButtonAction);
        vbox.getChildren().addAll(t,frogger,tf8);
        Scene scene = new Scene(vbox);
        stage.setTitle("cs1302-arcade!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    } // start

    public void setTF8(){
        HBox hbox = new HBox();
        grid = new GridPane();
        grid.setPrefSize(400,400);
        grid.setGridLinesVisible(true);
        //start image method
        //Adds all blanks except to one random
        hbox.add(grid);
        twenty = new Scene(hbox,500,500);
        twenty.add(hbox);
    }
    public void startTF(){
        //random on these
        int row;
        int col;
        for(int i = 0; i < 4; i++){
            for(int j= 0; j < 4; j++){
                if(row == i && col == j){
                    //add 2 to gridpane
                }
                else{
                    //add blank
                }
            }
        }
    }
    public void addRandom(){
        int row;
        int col;
        //while r/c not empty
        while(){}
        //random 2 or 4 (weigtheted towards 2)
        //add image to col
    }
    public void checkMatch(){
        //Check if gridpane = gridpane +1
        //Check others if gridbane + 1 = blank 
    }
    public void combine(){
        //checkMatch
        //place as next image in array list in place
        //addSum
    }
    public void addSum(){
        //switch over string for image
        switch(){}
    }
    public void moveLeft(){
        //check column 3 to 0 for all rows
        //checkMatch
        //move left
    }
    public void moveRight(){
        //check column 0 to 3 for all rows
        //checkMatch
        //move right
    }
    public void moveUp(){
        //check row 0 to 3 for all cols
        //checkMatch
        //move up
    }
    public void moveDown(){
        //check cow 3 to 0 for all cols
        //checkMatch
        //move down
    }
    //FROGGER-----------------------------------------------------------------------------------------
 
    
    //moving elems use replace method so frog becomes road then moves and replace

    public void initScene(){
        pointsString = "0";
        frogVbox = new VBox();
        info = new HBox();
        score = new Label("Score :");
        frogInstructions = new Text("Use arrow keys to move.Good Luck Froggy!\n"+
                                    "10 points per move in level 1.\n"+
                                    "15 points per move in level 2.\n"+
                                    "25 points per move in level 3.");
        points = new Text(pointsString);
        info.getChildren().addAll(Score,points,frogInstructions);
        frogGrid = new GridPane();
        
        VBox.getChildren().addAll(info,frogGrid);


    }
    public void initialiseFrogGrid(GridPane frogGrid){
        frogGrid.



    }
    public void startFrog(){

        //set background
        //javafx css set background
        //set background of the scene^^
        //place images
        //set level as 1
        //obstacles move in a repetitive motion
        //grid pane
        //if level one use level one speed 
    }
     public void frogLeft(){
        //check column 3 to 0 for all rows
        //checkMatch
        //move left
    }
    public void frogRight(){
        //check column 0 to 3 for all rows
        //checkMatch
        //move right
    }
    public void frogUp(){
        //check row 0 to 3 for all cols
        //checkMatch
        //move up
    }
    public void frogDown(){
        //check cow 3 to 0 for all cols
        //checkMatch
        //move down
    }
     public void enemyLeft(){
         //check column 3 to 0 for all rows
        //checkMatch
        //move left
     }
    public void enemyRight(){
        //check column 0 to 3 for all rows
        //checkMatch
        //move right
    }
    public void levelUp(){
        //increase speed variable
        //change level graphic
        
        }
    public void replace(){


    }
   
} // ArcadeApp
