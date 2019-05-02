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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.scene.paint.Color;
import javafx.scene.Node;
/** Class ArcadeFrog represents all the actions and attribute needed to create a 
 * Frogger Game.
 */
public class ArcadeFrog extends Application{
    Scene leapfrog;
    StackPane frogStack;
    GridPane frogGrid;
    int frogLevel;
    int enemySpeed;
    Image gridImage = new Image("frogger/introGrid.png");
    ImageView introGrid = new ImageView(gridImage);

    //~~~~~~~
    Image frogPic = new Image("frogger/frog.png");
    ImageView frog = new ImageView(frogPic);
    Sprite frogSprite = new Sprite(frog,frogPic);
    //~~~~~~~~~
    Image logPic = new Image("frogger/transparent.png");
    ImageView log = new ImageView(logPic);
    ImageView log2 = new ImageView(logPic);
    ImageView log3 = new ImageView(logPic);
    ImageView log4 = new ImageView(logPic);
    ImageView log5 = new ImageView(logPic);
    //~~~~~~~~~~~
    Image yellowCarPic = new Image("frogger/yellowcar.png");
    ImageView yellowCar = new ImageView(yellowCarPic);
    Sprite yellowCarSprite = new Sprite(yellowCar,yellowCarPic);
    //~~~~~~~~~~~~~~
    Image greenCarPic = new Image("frogger/greencar.png");
    ImageView greenCar = new ImageView(greenCarPic);
    Sprite greenCarSprite = new Sprite(greenCar,greenCarPic);
    //~~~~~~~~~~~~~~~
    ImageView greenCar1 = new ImageView(greenCarPic);
    Sprite greenCar1Sprite = new Sprite(greenCar1,greenCarPic);
    //~~~~~~~~~~~~~~~~
    Image waterPic = new Image("frogger/transparent.png");
    ImageView water = new ImageView(waterPic);
    ImageView water2 = new ImageView(waterPic);
    ImageView water3 = new ImageView(waterPic);
    ImageView water4 = new ImageView(waterPic);
    ImageView water5 = new ImageView(waterPic);
    Image roadPic = new Image("frogger/transparent.png");
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
    Text score;
    Text points;
    Text frogInstructions;
    double frogX = 2;
    double frogY = 5;
    
    public void start(Stage stage) {
        
    }
    public ArcadeFrog(){
        
    }
    public Scene froggerScene(){
        return this.initScene();
    }
    public Scene initScene(){
        pointsString = Integer.toString(pointsInt);
        frogVbox = new VBox();
        info = new HBox();
        score = new Text("Score :");
        frogInstructions = new Text("Use arrow keys to move.Good Luck Froggy!\n"+
                                    "10 points per move in level 1.\n"+
                                    "15 points per move in level 2.\n"+
                                    "25 points per move in level 3.");
        points = new Text(pointsString);
        info.getChildren().addAll(score,points,frogInstructions);
        this.initialiseFrogGrid();
        frogVbox.getChildren().addAll(info,frogStack);
        score.setFill(Color.WHITE);
        frogInstructions.setFill(Color.WHITE);
        frogVbox.setStyle("-fx-background-color : black;");
        leapfrog = new Scene(frogVbox);
        return leapfrog;
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
        this.frogImageFormat(greenCar1);
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
        frogStack = new StackPane();
        frogStack.getChildren().add(introGrid);
        introGrid.setFitWidth(500);
        introGrid.setFitHeight(575);
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
        
        frogGrid.add(frogSprite.getImage(),2,5);
        //frogSprite.setPosition(2.0,5.0);
        
        frogGrid.add(road9,3,0);
        frogGrid.add(greenCar1,3,1);
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
        
        frogStack.getChildren().add(frogGrid);
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
    }
    public EventHandler<? super KeyEvent> createKeyHandlerFrog() {
        return event -> {
            
            if (event.getCode() == KeyCode.LEFT)
            {
                if(frogSprite.getX()==0)
                {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("OUT OF BOUNDS");
                alert.setHEaderText("YOU WENT OUT OF BOUNDS");
                alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" ponits !");
                alert.showAndWait();
                frogStage.close();
                }

                frogX-=1;
                updateFrog();
                //frogLeft();
                //updateScore();
            }
        if (event.getCode() == KeyCode.RIGHT){
            if(frog.getX()==5)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("OUT OF BOUNDS");
                alert.setHEaderText("YOU WENT OUT OF BOUNDS");
                alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" ponits !");
                alert.showAndWait();
                frogStage.close();
            }
            frogX+=1;
            updateFrog();
            //frogRight();
            //updateScore();
        }
        if (event.getCode() == KeyCode.UP){
            if(frog.getY()==0)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("OUT OF BOUNDS");
                alert.setHEaderText("YOU WENT OUT OF BOUNDS");
                alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" ponits !");
                alert.showAndWait();
                frogStage.close();
            }
            frogY-=1;
            updateFrog();
            //frogUp();
            //updateScore();
        }
        if(event.getCode() == KeyCode.DOWN){
            if(frog.getY()==5)
            {
              Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("OUT OF BOUNDS");
                alert.setHEaderText("YOU WENT OUT OF BOUNDS");
                alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" ponits !");
                alert.showAndWait();
                frogStage.close();
            }
            frogY+=1;
            updateFrog();
              //frogDown();
              //updateScore();
            
        }
        };
    } // createKeyHandler
    public void updateFrog(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
        frog.setX(frogX);
        frog.setY(frogY);
    }
    
      public boolean moveCheckLeft(double x, double y){
      if(getNodeFromGridPane(frogGrid,(int)(x-1),(int)(y)) == water ||
      getNodeFromGridPane(frogGrid,(int)(x-1),(int)(y)) == water2||
      getNodeFromGridPane(frogGrid,(int)(x-1),(int)(y)) == water3||
      getNodeFromGridPane(frogGrid,(int)(x-1),(int)(y)) == water4||
      getNodeFromGridPane(frogGrid,(int)(x-1),(int)(y)) == water5)
      {
       return false;
      }else
      {
        return true;
      }
      }
  
 
      public boolean moveCheckRight(){
      if(getNodeFromGridPane(frogGrid,(int)(x+1),(int)(y)) == water ||
      getNodeFromGridPane(frogGrid,(int)(x+1),(int)(y)) == water2||
      getNodeFromGridPane(frogGrid,(int)(x+1),(int)(y)) == water3||
      getNodeFromGridPane(frogGrid,(int)(x+1),(int)(y)) == water4||
      getNodeFromGridPane(frogGrid,(int)(x+1),(int)(y)) == water5){
        return false;
      }else
      {
        return true;
      }
      }


      public boolean moveCheckUp(){
      if(getNodeFromGridPane(frogGrid,(int)(x),(int)(y-1)) == water ||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y-1)) == water2||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y-1)) == water3||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y-1)) == water4||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y-1)) == water5)
      {
       return false;
      }else
      {
        return true;
      }
      }
      public boolean moveCheckDown(){
      if(getNodeFromGridPane(frogGrid,(int)(x),(int)(y+1)) == water ||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y+1)) == water2||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y+1)) == water3||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y+1)) == water4||
      getNodeFromGridPane(frogGrid,(int)(x),(int)(y+1)) == water5)
      {
       return false;
      }else
      {
        return true;
      }
      }
      }
    
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
 
    public void enemyLeft(){
        //enemy check will be if coordinate it is going to contains frog then frog lost
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
