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
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class ArcadeApp extends Application {

    /**
     * Return a key event handler that moves to the rectangle to the left
     * or the right depending on what key event is generated by the associated
     * node.
     * @return the key event handler
     */
    /*
    private EventHandler<? super KeyEvent> createKeyHandler() {
	return event -> {
	    System.out.println(event);
	    if (event.getCode() == KeyCode.LEFT)  r.setX(r.getX() - 10.0);
	    if (event.getCode() == KeyCode.RIGHT) r.setX(r.getX() + 10.0);
	    // TODO bounds checking
	};
    } // createKeyHandler
    */
    Scene twenty;
    GridPane grid;

    //frogger instance variables
    Scene leapfrog;
    GridPane frogGrid;
    int frogLevel;
    int enemySpeed;
    Image frogPic = new Image("frogger/frog.png");
    ImageView frog = new ImageView(frogPic);
    Image logPic = new Image("frogger/log.png");
    ImageView log = new ImageView(logPic);
    ImageView log2 = new ImageView(logPic);
    ImageView log3 = new ImageView(logPic);
    ImageView log4 = new ImageView(logPic);
    ImageView log5 = new ImageView(logPic);
    Image yellowCarPic = new Image("frogger/yellowcar.png");
    ImageView yellowCar = new ImageView(yellowCarPic);
    Image greenCarPic = new Image("frogger/greencar.png");
    ImageView greenCar = new ImageView(greenCarPic);
    ImageView greenCar2 = new ImageView(greenCarPic);
    Image waterPic = new Image("frogger/water.png");
    ImageView water = new ImageView(waterPic);
    ImageView water2 = new ImageView(waterPic);
    ImageView water3 = new ImageView(waterPic);
    ImageView water4 = new ImageView(waterPic);
    ImageView water5 = new ImageView(waterPic);
    Image roadPic = new Image("frogger/road.png");
    ImageView road = new ImageView(roadPic);
    ImageView road2 = new ImageView(roadPic);
    ImageView road3 = new ImageView(roadPic);
    ImageView road4 = new ImageView(roadPic);
    ImageView road5 = new ImageView(roadPic);
    ImageView road6 = new ImageView(roadPic);
    ImageView road7 = new ImageView(roadPic);
    ImageView road8 = new ImageView(roadPic);
    ImageView road9 = new ImageView(roadPic);
    ImageView road10 = new ImageView(roadPic);
    ImageView road11 = new ImageView(roadPic);
    ImageView road12 = new ImageView(roadPic);
    ImageView road13 = new ImageView(roadPic);
    ImageView road14 = new ImageView(roadPic);
    ImageView road15 = new ImageView(roadPic);
    ImageView road16 = new ImageView(roadPic);
    
    String pointsString;
    int pointsInt;
    VBox frogVbox;
    HBox info;
    Label score;
    Text points;
    Text frogInstructions;
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
        EventHandler<ActionEvent> tf = event -> {
            Stage twentyStage = new Stage();
            twentyStage.setScene(twenty);
            twentyStage.initModality(Modality.WINDOW_MODAL);
            twentyStage.initOwner(stage);
            twentyStage.sizeToScene();
            twentyStage.show();
        };
        tf8.setOnAction(tf);
        
        EventHandler<ActionEvent> frogButtonAction = event -> {
            Stage frogStage = new Stage();
            this.initScene();
            frogStage.setScene(leapfrog);
            frogStage.initModality(Modality.WINDOW_MODAL);
            frogStage.initOwner(stage);
            frogStage.sizeToScene();
            frogStage.show();
        };
        frogButton.setOnAction(frogButtonAction);
        HBox intro = new HBox();
        vbox.getChildren().addAll(t,frogButton,tf8);
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
        hbox.getChildren().add(grid);
        twenty = new Scene(hbox,500,500);
        //twenty.add(hbox);
    }
    public void startTF(){
        //random on these
        int row= 0;
        int col = 0;
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
        // while(){}
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
        // switch(){}
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
    //FROGGER--------------------
    //moving elems use replace method so frog becomes road then moves and replace
    /** Method that initialises frogger Scene
     *@param leapfrog is the scene being initialised
     */
    public void initScene(){
        pointsString = Integer.toString(pointsInt);
        frogVbox = new VBox();
        info = new HBox();
        score = new Label("Score :");
        frogInstructions = new Text("Use arrow keys to move.Good Luck Froggy!\n"+
                                    "10 points per move in level 1.\n"+
                                    "15 points per move in level 2.\n"+
                                    "25 points per move in level 3.");
        points = new Text(pointsString);
        info.getChildren().addAll(score,points,frogInstructions);
        this.initialiseFrogGrid();
        frogVbox.getChildren().addAll(info,frogGrid);
        frogVbox.setStyle("-fx-background-color : black;"); 
        leapfrog = new Scene(frogVbox);
        
    }
    public void frogImageFormat(ImageView imgv){
        imgv.setFitWidth(100);
        imgv.setFitHeight(100);
    }
    public void imageFormatting(){
        this.frogImageFormat(frog);
        this.frogImageFormat(log);
        this.frogImageFormat(log2);
        this.frogImageFormat(log3);
        this.frogImageFormat(log4);
        this.frogImageFormat(log5);
        this.frogImageFormat(yellowCar);
        this.frogImageFormat(greenCar);
        this.frogImageFormat(greenCar2);
        this.frogImageFormat(water);
        this.frogImageFormat(water2);
        this.frogImageFormat(water3);
        this.frogImageFormat(water4);
        this.frogImageFormat(water5);
        this.frogImageFormat(road);
        this.frogImageFormat(road2);
        this.frogImageFormat(road3);
        this.frogImageFormat(road4);
        this.frogImageFormat(road5);
        this.frogImageFormat(road6);
        this.frogImageFormat(road7);
        this.frogImageFormat(road8);
        this.frogImageFormat(road9);
        this.frogImageFormat(road10);
        this.frogImageFormat(road11);
        this.frogImageFormat(road12);
        this.frogImageFormat(road13);
        this.frogImageFormat(road14);
        this.frogImageFormat(road15);
        this.frogImageFormat(road16);   

    }
    /** Method that initialises the frogger gridpane
     *@param frogGrid is the gridpane to be initialised
     */
    public void initialiseFrogGrid(){
//        Runnable r = () -> {
        //          Platform.runLater(() -> {
        frogGrid = new GridPane();
        this.imageFormatting();
        frogGrid.add(road,0,0);
        frogGrid.add(road2,0,1);
        frogGrid.add(log,0,2);
        frogGrid.add(road3,0,3);
        frogGrid.add(water,0,4);
        frogGrid.add(road16,0,5);
        frogGrid.add(road4,1,0);
        frogGrid.add(road5,1,1);
        frogGrid.add(log2,1,2);
        frogGrid.add(greenCar,1,3);
        frogGrid.add(water2,1,4);
        frogGrid.add(road6,1,5);
        frogGrid.add(yellowCar,2,0);
        frogGrid.add(road7,2,1);
        frogGrid.add(water3,2,2);
        frogGrid.add(road8,2,3);
        frogGrid.add(log3,2,4);
        frogGrid.add(frog,2,5);
        frogGrid.add(road9,3,0);
        frogGrid.add(greenCar2,3,1);
        frogGrid.add(water4,3,2);
        frogGrid.add(road10,3,3);
        frogGrid.add(log4,3,4);
        frogGrid.add(road11,3,5);
        frogGrid.add(road12,4,0);
        frogGrid.add(road13,4,1);
        frogGrid.add(log5,4,2);
        frogGrid.add(road14,4,3);
        frogGrid.add(water5,4,4);
        frogGrid.add(road15,4,5);
        System.out.println("Frog Grid init works");
        /*      });
        };
        Thread fg = new Thread(r);
        fg.setDaemon(true);
        fg.start();
        */
    }
    /** Method to update score displayed in frogger scene. 
     *@param 
     */
    public void updateScore(int add)
        {
            pointsInt+=add;
            pointsString = this.scoreConvert(pointsInt);
        }
    public String scoreConvert(int pointsInt){
        String pointsString = Integer.toString(pointsInt);
        return pointsString;
    }
    /** Method to update difficulty of game */
    public void updateLevel()
        {

        }
    /** Method to handle threading of obstacles and start movement.*/
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
    public void keyboardStuff(){
        //placeholder method for setting actions on arrow keys
    }
    /** Method that moves frog to the left.*/
     public void frogLeft(){
        //check column 3 to 0 for all rows
        //checkMatch
        //move left
    }
    /** Method that moves frog to the right.*/
    public void frogRight(){
        //check column 0 to 3 for all rows
        //checkMatch
        //move right
    }
    /** Method that moves frog upwards.*/
    public void frogUp(){
        //check row 0 to 3 for all cols
        //checkMatch
        //move up
    }
    /** Method that moves frog downward. */
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
        //method for moving

    }
   
} // ArcadeApp
