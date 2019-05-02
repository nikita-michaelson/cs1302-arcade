package cs1302.arcade;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.*;

public class Sprite {

    private Image image;
    private ImageView imageView;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    final Canvas canvas = new Canvas(250,250);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    public Sprite(ImageView imageView,Image image) {
        this.image = image;
        this.imageView = imageView;
        width = imageView.getFitWidth();
        height = imageView.getFitHeight();
        positionX = 0;
        positionY = 0;
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public double getX(){
        return positionX;
    }

    public double getY(){
        return positionY;
    }
    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersects(Sprite spr) {
        return spr.getBoundary().intersects(this.getBoundary());
    }
}