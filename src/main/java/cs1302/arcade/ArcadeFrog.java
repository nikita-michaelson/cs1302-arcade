package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/** Class ArcadeFrog represents all the actions and attribute needed to create a 
 * Frogger Game.
 */
public class ArcadeFrog extends Application{
   
    Scene leapfrog;
    StackPane frogStack;
    GridPane frogGrid;
    GridPane enemyGrid;
    int frogLevel = 1;
    double enemySpeed = 2.5;
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
    
    String pointsString = "0";
    int pointsInt = 0;
    VBox frogVbox;
    HBox info;
    Text score;
    Text points;
    Text frogInstructions;
    Timeline gctime = new Timeline();
    Timeline gc1time = new Timeline();
    Timeline yctime = new Timeline();
    boolean timelineStatus = true;
    int frogX = 2;
    int frogY = 5;
    int gcX = 1;
    int gcY = 3;
    int gc1X = 3;
    int gc1Y = 1;
    int ycX = 2;
    int ycY = 0;
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
        createFrogLeftHandler();
        createFrogRightHandler();
        createFrogUpHandler();
        createFrogDownHandler();
        prepareEnemyTimeline();
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
        //this.enemyGridInit();
        frogGrid.add(road,0,0);
        frogGrid.add(road2,0,1);
        frogGrid.add(log,0,2);
        frogGrid.add(road3,0,3);
        frogGrid.add(water,0,4);
        frogGrid.add(road16,0,5);
        frogGrid.add(road4,1,0);
        frogGrid.add(road5,1,1);
        frogGrid.add(log2,1,2);
        frogGrid.add(greenCarSprite.getImage(),1,3);
        greenCarSprite.setPosition(1,3);
        frogGrid.add(water2,1,4);
        frogGrid.add(road6,1,5);
        frogGrid.add(yellowCarSprite.getImage(),2,0);
        yellowCarSprite.setPosition(2,0);
        frogGrid.add(road7,2,1);
        frogGrid.add(water3,2,2);
        frogGrid.add(road8,2,3);
        frogGrid.add(log3,2,4);
        frogGrid.add(frogSprite.getImage(),2,5);
        frogSprite.setPosition(2,5);
        frogGrid.add(greenCar1Sprite.getImage(),3,1);
        greenCar1Sprite.setPosition(3,1);
        frogSprite.setPosition(2,5);
        frogGrid.add(road9,3,0);
        
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
   /* public void enemyGridInit()
    {
        
        enemyGrid = new GridPane();
        enemyGrid.add(road,0,0);
        enemyGrid.add(road2,0,1);
        enemyGrid.add(log,0,2);
        enemyGrid.add(road3,0,3);
        enemyGrid.add(water,0,4);
        enemyGrid.add(road16,0,5);
        enemyGrid.add(road4,1,0);
        enemyGrid.add(road5,1,1);
        enemyGrid.add(log2,1,2);
        enemyGrid.add(greenCarSprite.getImage(),1,3);
        greenCarSprite.setPosition(1,3);
        enemyGrid.add(water2,1,4);
        enemyGrid.add(road6,1,5);
        enemyGrid.add(yellowCarSprite.getImage(),2,0);
        yellowCarSprite.setPosition(2,0);
        enemyGrid.add(road7,2,1);
        enemyGrid.add(water3,2,2);
        enemyGrid.add(road8,2,3);
        enemyGrid.add(log3,2,4);
        enemyGrid.add(log,2,5);
        enemyGrid.add(road9,3,0);
        enemyGrid.add(greenCar1Sprite.getImage(),3,1);
        greenCar1Sprite.setPosition(3,1);
        enemyGrid.add(water4,3,2);
        enemyGrid.add(road10,3,3);
        enemyGrid.add(log4,3,4);
        enemyGrid.add(road11,3,5);
        enemyGrid.add(road12,4,0);
        enemyGrid.add(road13,4,1);
        enemyGrid.add(log5,4,2);
        enemyGrid.add(road14,4,3);
        enemyGrid.add(water5,4,4);
        enemyGrid.add(road15,4,5);
    }
    */
    /** Method to update score displayed in frogger scene.
     *@param
     */
    public void updateScore()
        {
            if(frogLevel == 1)
            {
            pointsInt+=10;
            //pointsString = this.scoreConvert(pointsInt);
            
            points.setText(Integer.toString(pointsInt));
            
            }else if(frogLevel == 2)
            {
            pointsInt+=15;
            pointsString = this.scoreConvert(pointsInt);
            }else if(frogLevel == 3)
            {
            pointsInt+=15;
            pointsString = this.scoreConvert(pointsInt);
            }
        }
    public String scoreConvert(int pointsInt){
        String pointsString = Integer.toString(pointsInt);
        return pointsString;
    }
    /** Method to update difficulty of game */
    public void updateLevel()
        {
            if(frogLevel == 1)
            {
                frogStack.getChildren().remove(frogGrid);
                this.initialiseFrogGrid();
                frogLevel = 2;
                enemySpeed = 2;
                //update car speed

            }else if(frogLevel == 2)
            {
                frogStack.getChildren().remove(frogGrid);
                this.initialiseFrogGrid();
                frogLevel = 3;
                enemySpeed = 1; 
            }else if (frogLevel == 3)
            {
                //winning dialogue box
            }
        }
    /** Method to handle threading of obstacles and start movement.*/
    public void startFrog(){
    }

    public void createFrogLeftHandler() {
        
            leapfrog.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
             if (key.getCode() == KeyCode.LEFT)
                {
                    if(frogSprite.getX()==0)
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("OUT OF BOUNDS");
                    alert.setHeaderText("YOU WENT OUT OF BOUNDS");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    ArcadeApp app = new ArcadeApp();
                    
                    app.frogStage.close();
                    app.stage.show();
                }
                frogX-=1;
                frogSprite.setPosition(frogX,frogY);
                left();
                //frogLeft();
                updateScore();
                }
            }
        );
    }

        public void createFrogRightHandler() {
        
        leapfrog.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.RIGHT)
                {
                   if(frogSprite.getX()==4)
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("OUT OF BOUNDS");
                    alert.setHeaderText("YOU WENT OUT OF BOUNDS");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    
                } 
                frogX+=1;
                frogSprite.setPosition(frogX,frogY);
                right();
                //frogRight();
                updateScore();
                }
            }
        );
    }

        public void createFrogUpHandler() {
        
        leapfrog.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.UP){
                if(frogSprite.getY()==0)
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("OUT OF BOUNDS");
                    alert.setHeaderText("YOU WENT OUT OF BOUNDS");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    
                }
                frogY-=1;
                frogSprite.setPosition(frogX,frogY);
                up();
                //frogUp();
                updateScore();
            }
        }
        );
    }

        public void createFrogDownHandler() {
       
        leapfrog.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode() == KeyCode.DOWN){
                if(frogSprite.getY()==5)
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("OUT OF BOUNDS");
                    alert.setHeaderText("YOU WENT OUT OF BOUNDS");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    ArcadeApp app = new ArcadeApp();

                    
                }
                frogY+=1;
                frogSprite.setPosition(frogX,frogY);
                down();
               
                //frogDown();
                updateScore();
            
            }
        }
        );
    }// createKeyHandler
    public void left(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);

        }
        else
        {
            this.removeNodeFromGridPane(frogSprite.getImage());
            frogGrid.add(frogSprite.getImage(),frogX,frogY);
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Oh No");
                    alert.setHeaderText("YOU WENT FOR A DIP");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    Platform.exit();

        }
    }
    public void right(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY * 1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
        }
        else
        {
            this.removeNodeFromGridPane(frogSprite.getImage());
            frogGrid.add(frogSprite.getImage(),frogX,frogY);
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Oh NO");
                    alert.setHeaderText("YOU WENT FOR A DIP");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    Platform.exit();

        }
    }
    public void up(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
        }
        else
        {
            this.removeNodeFromGridPane(frogSprite.getImage());
            frogGrid.add(frogSprite.getImage(),frogX,frogY);
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Oh NO");
                    alert.setHeaderText("YOU WENT FOR A DIP");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    Platform.exit();

        }
    }
    public void down(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
        }
        else
        {
            this.removeNodeFromGridPane(frogSprite.getImage());
            frogGrid.add(frogSprite.getImage(),frogX,frogY);
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Oh No");
                    alert.setHeaderText("YOU WENT FOR A DIP");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.showAndWait();
                    Platform.exit();

        }
    }
    
      public boolean moveCheck(double x, double y){
        double xx = x;
        double yy = y;

          if(this.compare(xx,1.0) == 0 && this.compare(yy,4.0)==0)
          {
            return false;
          }else if(this.compare(xx,0.0)==0 && this.compare(yy,4.0) == 0)
          {
            return false;
        }else if(this.compare(xx,4.0) ==0 && this.compare(yy,4.0)==0)
        {
            return false;
        
        }else if(this.compare(xx,3.0)==0 && this.compare(yy,2.0)==0)
        {
            return false;
        
        }else if(this.compare(xx,2.0)== 0 && this.compare(yy,2.0)==0)
        {
            return false;
        }else
        {   
        return true;
         }   
      }
        public int compare(double x,double y)
        {
            int t = 1;
            double threshold = .0000001;
            if(Math.abs(x-y)<threshold)
            {
                t = 0;
            }
            return t;
        }
    
    
    
    private void removeNodeFromGridPane(Node n) {
        frogGrid.getChildren().remove(n);    
    }
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    public void prepareEnemyTimeline(){
        EventHandler<ActionEvent> greenMove = event -> gcMove();
        KeyFrame gckey = new KeyFrame(Duration.seconds(enemySpeed),greenMove);
        EventHandler<ActionEvent> green1Move = event -> gc1Move();
        KeyFrame gc1key = new KeyFrame(Duration.seconds(enemySpeed),green1Move);
        EventHandler<ActionEvent> yellowMove = event -> gcMove();
        KeyFrame yckey = new KeyFrame(Duration.seconds(enemySpeed),yellowMove);
        gctime.getKeyFrames().add(gckey);
        gc1time.getKeyFrames().add(gc1key);
        yctime.getKeyFrames().add(yckey);
        gctime.play();
        gc1time.play();
        yctime.play();

    }
    
    
    public void gcMove(){

            if(greenCarSprite.getX()!=0)
            {
            gcLeft();
            }else{
            gcRight();
            }

        }
    
    public void gcLeft(){
        //change 
        gcX-=1;
        //set p
        greenCarSprite.setPosition(gcX,gcY);
        this.removeNodeFromGridPane(greenCarSprite.getImage());
        frogGrid.add(greenCarSprite.getImage(),gcX,gcY);

    }
    public void gcRight(){
       //change 
        gcX+=1;
        //set p
        greenCarSprite.setPosition(gcX,gcY);
        this.removeNodeFromGridPane(greenCarSprite.getImage());
        frogGrid.add(greenCarSprite.getImage(),gcX,gcY);

    }
    public void gc1Move(){
        if(greenCar1Sprite.getX()!=0)
            {
            gc1Left();
            }else{
            gc1Right();
            }
    }
    
    public void gc1Left(){
        //change 
        gc1X-=1;
        //set p
        greenCarSprite.setPosition(gc1X,gc1Y);
        this.removeNodeFromGridPane(greenCar1Sprite.getImage());
        frogGrid.add(greenCar1Sprite.getImage(),frogX,frogY);

    }
    public void gc1Right(){
      gc1X+=1;
        //set p
        greenCarSprite.setPosition(gc1X,gc1Y);
        this.removeNodeFromGridPane(greenCar1Sprite.getImage());
        frogGrid.add(greenCar1Sprite.getImage(),frogX,frogY);
    }
     public void ycMove(){

            if(yellowCarSprite.getX()!=0)
            {
            ycLeft();
            }else{
            ycRight();
            }
    }
    
    public void ycLeft(){
         ycX-=1;
        //set p
        yellowCarSprite.setPosition(ycX,ycY);
        this.removeNodeFromGridPane(yellowCarSprite.getImage());
        frogGrid.add(yellowCarSprite.getImage(),ycX,ycY);
    }
    public void ycRight(){
        ycX+=1;
        //set p
        yellowCarSprite.setPosition(ycX,ycY);
        this.removeNodeFromGridPane(yellowCarSprite.getImage());
        frogGrid.add(yellowCarSprite.getImage(),ycX,ycY);
    }
    public void collisionCheck(){
        
    }
    
    
} // ArcadeApp
