package cs1302.arcade;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.*;
import javafx.scene.layout.Region;
public class Sprite extends Region{

    private Image image;
    private ImageView imageView;
    private int positionX ;
    private int positionY ;
    private double width;
    private double height;
    final Canvas canvas = new Canvas(500,500);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    public Sprite(ImageView imageView,Image image) {
        this.image = image;
        this.imageView = imageView;
        width = imageView.getFitWidth();
        height = imageView.getFitHeight();
        positionX = 0;
        positionY = 0;
    }
    public ImageView getImage()
    {
        return imageView;
    }
    public void setPosition(int x, int y) {
        positionX = x;
        positionY = y;
        //gc.drawImage(this.image,positionX,positionY);
    }

  
    public int getX(){
        return positionX;
    }

    public int getY(){
        return positionY;
    }
    
    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX*1.0, positionY*1.0);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX*1.0, positionY*1.0, width, height);
    }

    public boolean intersects(Sprite spr) {
        return spr.getBoundary().intersects(this.getBoundary());
    }
}