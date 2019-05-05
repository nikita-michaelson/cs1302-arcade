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

//level update, exiting singular stage, pushing score to gui, (thread/timeline issues) doesnt work
public class ArcadeFrog extends Application{
   
    Scene leapfrog;
    StackPane frogStack;
    GridPane frogGrid;
    GridPane enemyGrid;
    int frogLevel = 1;
    double enemySpeed = 1.5;
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
    Image finish = new Image("frogger/finish.png");
    ImageView road = new ImageView(finish);
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
    Text points = new Text();
    Text frogInstructions;
    Timeline gctime = new Timeline();
    Timeline gc1time = new Timeline();
    Timeline yctime = new Timeline();

    boolean yright = true;
    boolean gcright = true;
    boolean gc1right = true;
    int frogX = 2;
    int frogY = 5;
    int gcX = 1;
    int gcY = 3;
    int gc1X = 3;
    int gc1Y = 1;
    int ycX = 2;
    int ycY = 0;
    boolean dead;
    /** Empty start method to satisfy extends Application*/
    public void start(Stage stage) {
        
    }
    /** An Empty constructor to allow reference to this classes
    * variables elsewhere.
    */
    public ArcadeFrog(){
        dead = false;
    }
    /** Method that returns initialised frogger Scene
    *@return this.initScene()
    */
    public Scene froggerScene(){
        return this.initScene();
    }
    /** Method that returns initialised frogger Scene
    *@return leapfrog
    */
    public Scene initScene(){
        pointsString = Integer.toString(pointsInt);
        frogVbox = new VBox();
        info = new HBox();
        score = new Text("Score :");
        frogInstructions = new Text("Use arrow keys to move.Get to the lily pad!\n"+
                                    "Good Luck Froggy!\n"+
                                    "10 points per move in level 1.\n"+
                                    "15 points per move in level 2.\n"+
                                    "25 points per move in level 3.");
        info.getChildren().addAll(frogInstructions,score,points);
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
    /** Method that formats ImageViews
     *@param imgv is the imageView to be formatted
     */
    public void frogImageFormat(ImageView imgv){
        imgv.setFitWidth(100);
        imgv.setFitHeight(100);
    }
    /**Method that formats all used imageViews.*/
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
    /** Method that initialises the frogger gridpane.*/
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
       
       
    }

    /** Method to update score displayed in frogger scene.*/
    public void updateScore()
        {
            if(frogLevel == 1)
            {
            pointsInt+=10;
            //pointsString = this.scoreConvert(pointsInt);
             points.setText(Integer.toString(pointsInt));
             info.getChildren().remove(points);
             info.getChildren().add(points);
            
            }else if(frogLevel == 2)
            {
            pointsInt+=15;
            points.setText(Integer.toString(pointsInt));
            }else if(frogLevel == 3)
            {
            pointsInt+=15;
            points.setText(Integer.toString(pointsInt));
            }
        }
    
    /** Method to update difficulty of game */
    public void updateLevel()
        {
            if(frogLevel == 1)
            {
                //frogStack.getChildren().remove(frogGrid);
                this.initialiseFrogGrid();
                this.initScene();
                frogLevel = 2;
                enemySpeed = 3;
                //update car speed

            }else if(frogLevel == 2)
            {
                //frogStack.getChildren().remove(frogGrid);
                this.initialiseFrogGrid();
                this.initScene();

                frogLevel = 3;
                enemySpeed = 2; 
            }else if (frogLevel == 3)
            {
                //winning dialogue box
            }
        }
    /** Method that creates handle for left movement.*/
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
                    dead = true;
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
    /** Method that creates handle for right movement.*/
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
                    dead = true;
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
    /** Method that creates handle for up movement.*/
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
                    dead = true;
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
    /** Method that creates handle for down movement.*/
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
                    dead = true;

                    
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

    /** Method that creates left movement.*/
    public void left(){
    
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
        if(frogSprite.getX()==0 && frogSprite.getY()==0)
            {
            updateLevel();
            }

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
                    dead = true;
        }


    }
    /** Method that creates rightleft movement.*/
    public void right(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY * 1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
         if(frogSprite.getX()==0 && frogSprite.getY()==0)
        {
            updateLevel();
        }
        
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
                    dead = true;

        }
    }
    /** Method that creates up movement.*/
    public void up(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
         if(frogSprite.getX()==0 && frogSprite.getY()==0)
        {
            updateLevel();
        }
        
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
                    dead = true;

        }
    }
    /** Method that creates down movement.*/
    public void down(){
        //check if valid move if  valid set and update Score , if not set and throw up death dialogue box
       double x = frogX * 1.0;
       double y = frogY *1.0;
       if(moveCheck(x,y))
       {
        this.removeNodeFromGridPane(frogSprite.getImage());
        frogGrid.add(frogSprite.getImage(),frogX,frogY);
         if(frogSprite.getX()==0 && frogSprite.getY()==0)
        {
            updateLevel();
        }
        
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
                    dead = true;

        }
    }
    /** Method that checks if fallen in water.*/
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
      /**Method that accurately compares if doubles are equal.*/
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
    
    
    /**Method that removes nodes from GridPane.*/
    private void removeNodeFromGridPane(Node n) {
        frogGrid.getChildren().remove(n);    
    }
    /*
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    */
    /**Method that creates and starts the Enemy Timeline. */
    public void prepareEnemyTimeline(){
        EventHandler<ActionEvent> greenMove = event -> gcMove();
        KeyFrame gckey = new KeyFrame(Duration.seconds(enemySpeed),greenMove);
        EventHandler<ActionEvent> green1Move = event -> gc1Move();
        KeyFrame gc1key = new KeyFrame(Duration.seconds(enemySpeed),green1Move);
        EventHandler<ActionEvent> yellowMove = event -> ycMove();
        KeyFrame yckey = new KeyFrame(Duration.seconds(enemySpeed),yellowMove);
        gctime.setCycleCount(Timeline.INDEFINITE);
        gc1time.setCycleCount(Timeline.INDEFINITE);
        yctime.setCycleCount(Timeline.INDEFINITE);
        gctime.getKeyFrames().add(gckey);
        gc1time.getKeyFrames().add(gc1key);
        yctime.getKeyFrames().add(yckey);
        gctime.play();
        gc1time.play();
        yctime.play();

    }
    
    /** Method to move the green car Sprite.*/
    public void gcMove(){
    if(greenCarSprite.getX()<4&&(gcright == true || greenCarSprite.getX()==0))
            {

            gcRight();
            }else {
               
            if(greenCarSprite.getX()==4||greenCarSprite.getX()>0)
            gcLeft();
        
            }
            

        }
    /** Method to move the green car Sprite left.*/
    public void gcLeft(){
        //change 
        //set p
        gcX-=1;
        if(gcX==0)
        {
            gcright = true;
        }
        greenCarSprite.setPosition(gcX,gcY);
        this.removeNodeFromGridPane(greenCarSprite.getImage());
        frogGrid.add(greenCarSprite.getImage(),gcX,gcY);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    //alert.setOnHidden(evt -> frogStage.close());
                    alert.show();
                    dead = true;
        }

    }
    /** Method to move the green car Sprite right.*/
    public void gcRight(){
       gcX+=1;
        if(gcX==4)
        {
            gcright = false;
        }
        if(gcX==1)
        {
            gcright = true;
        }
        //set p
        greenCarSprite.setPosition(gcX,gcY);
        this.removeNodeFromGridPane(greenCarSprite.getImage());
        frogGrid.add(greenCarSprite.getImage(),gcX,gcY);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    //alert.setOnHidden(evt -> frogStage.close());
                    alert.show();
                    dead = true;
        }

    }
    /** Method to move the green car1 Sprite.*/
    public void gc1Move(){
        if(greenCar1Sprite.getX()<4&&(gc1right == true || greenCar1Sprite.getX()==0))
            {

            gc1Right();
            //System.out.println(gc1X);
            //System.out.println(greenCar1Sprite.getX());
            }else {
            if(greenCar1Sprite.getX()==4||greenCar1Sprite.getX()>0)
    
            gc1Left();
            //System.out.println(gc1X);
            //System.out.println(greenCar1Sprite.getX());

            }
    }
    /** Method to move the green car1 Sprite left.*/
    public void gc1Left(){
        //change 
        gc1X-=1;
        if(gc1X==1)
        {
            gc1right = true;
        }
        //set p
        greenCarSprite.setPosition(gc1X,gc1Y);
        this.removeNodeFromGridPane(greenCar1Sprite.getImage());
        frogGrid.add(greenCar1Sprite.getImage(),gc1X,gc1Y);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    //alert.setOnHidden(evt -> frogStage.close());
                    alert.show();
                    dead = true;
        }

    }
    /** Method to move the green car1 Sprite right.*/
    public void gc1Right(){
       gc1X+=1;
        if(gc1X==4)
        {
            gc1right = false;
        }
        if(gc1X==1)
        {
            gc1right = true;
        }
        //set p
        greenCarSprite.setPosition(gc1X,gc1Y);
        this.removeNodeFromGridPane(greenCar1Sprite.getImage());
        frogGrid.add(greenCar1Sprite.getImage(),gc1X,gc1Y);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                   // alert.setOnHidden(evt -> frogStage.close());
                    alert.show();
                    dead = true;
        }
    }
    /** Method to move the yellow car Sprite.*/
     public void ycMove(){

            if(yellowCarSprite.getX()<4&&(yright == true || yellowCarSprite.getX()==0))
            {

            ycRight();
            }else {
            if(yellowCarSprite.getX()==4||yellowCarSprite.getX()>0)
    
            ycLeft();
            }
        
    }
    /** Method to move the yellow car Sprite left.*/
    public void ycLeft(){
         ycX-=1;
         
        //set p
        yellowCarSprite.setPosition(ycX,ycY);
        this.removeNodeFromGridPane(yellowCarSprite.getImage());
        frogGrid.add(yellowCarSprite.getImage(),ycX,ycY);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.setOnHidden(evt -> Platform.exit());
                    alert.show();
                    dead = true;
        }
        
    }
    /** Method to move the yellow car Sprite right.*/
    public void ycRight(){
        ycX+=1;
        if(ycX==4)
        {
            yright = false;
        }
        if(ycX==1)
        {
            yright = true;
        }
        //set p
        yellowCarSprite.setPosition(ycX,ycY);
        this.removeNodeFromGridPane(yellowCarSprite.getImage());
        frogGrid.add(yellowCarSprite.getImage(),ycX,ycY);
        if(collisionCheck())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ROADKILL");
                    alert.setHeaderText("YOU GOT HIT FROGGY");
                    alert.setContentText("Better Luck Next Time! You scored :"+pointsInt+" points !");
                    alert.setOnHidden(evt -> Platform.exit());
                    alert.show();
                    dead = true;
        }
    }
    /** Method to check if car hits frog.*/
    public boolean collisionCheck(){
        boolean crash = false;
        if(frogSprite.getX()==greenCarSprite.getX() && frogSprite.getY()==greenCarSprite.getY())
        {
            crash = true;
        }
        if(frogSprite.getX()==greenCar1Sprite.getX() && frogSprite.getY()==greenCar1Sprite.getY())
        {
            crash = true;
        }
        if(frogSprite.getX()==yellowCarSprite.getX() && frogSprite.getY()==yellowCarSprite.getY())
        {
            crash = true;
        }
        return crash;
    }
    
    
} // ArcadeApp
