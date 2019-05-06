package cs1302.arcade;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.*;
import javafx.scene.layout.Region;

/** a wrapper class that gave imageview better attributes.*/
public class Sprite extends Region{
    
    private Image image;
    private ImageView imageView;
    private int positionX ;
    private int positionY ;
    private double width;
    private double height;
    final Canvas canvas = new Canvas(500,500);
    GraphicsContext gc = canvas.getGraphicsContext2D();


/** Constructor that initializes a sprite with its own image and imageview
 *@param imageView the imageView to be assigned to the sprite
 *@param image the image to be assigned to the sprite
 */
    public Sprite(ImageView imageView,Image image) {
        //initialize variables
        this.image = image;
        this.imageView = imageView;
        width = imageView.getFitWidth();
        height = imageView.getFitHeight();
        positionX = 0;
        positionY = 0;
    }//Sprite
    
    /** Getter method for a sprites image 
     *@return imageView 
     */
    public ImageView getImage()
        {
            return imageView;
        }//getImage
    
    /** Setter method for the sprite's position 
     *@param x is the x coordinate
     *@param y is the y coordinate
     */
    public void setPosition(int x, int y) {
        //change position
        positionX = x;
        positionY = y;
    }//setPostition
    
    /** method that returns x coord
     *@return positionX
     */
    public int getX(){
        return positionX;
    }//getX

    /** method that returns y coord
     *@return positionY
     */
    public int getY(){
        return positionY;
    }//getY
   
}
