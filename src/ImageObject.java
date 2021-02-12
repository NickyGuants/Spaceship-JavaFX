import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageObject  {
    private String folder_location ="File:Images/";
    private ImageView image_view;
    private boolean alive = true;
    public ImageObject(double x,double y,double w,double h,String image)
    {


        image_view = new ImageView("File:"+image);
        image_view.setCache(true); //help in performance

        image_view.setFitHeight(h );
        image_view.setFitWidth(w);

        image_view.setLayoutX(x);
        image_view.setLayoutY(y);

        image_view.setSmooth(true);



        Rocket.root.getChildren().add(image_view);

    }

    public double getX(){

        return image_view.getLayoutX();
    }

    public double getY() {
        return image_view.getLayoutY();
    }

    public void setRotate(double rot) {
        image_view.setRotate(rot);
    }

    public double getHeight()
    {
        return image_view.getFitHeight();
    }


    public double getWidth()
    {
        return image_view.getFitWidth();
    }

    public void setHeight(double h)
    {
        image_view.setFitHeight(h);

    }
    public void setWidth(double w)
    {
        image_view.setFitWidth(w);
    }

    public void setSize(double h,double w)
    {
        image_view.setFitHeight(h);
        image_view.setFitWidth(w);
    }

    //Axis
    public double getLayoutX()
    {
        return image_view.getLayoutX();
    }
    public double getLayoutY()
    {
        return image_view.getLayoutY();
    }

    public void setLayoutX(double x)
    {

        image_view.setLayoutX(x);
    }

    public void setLayoutY(double y)
    {
        image_view.setLayoutY(y);
    }

    public void setPos(double x,double y)
    {   image_view.setLayoutX(x);
        image_view.setLayoutY(y);
    }


    public Bounds getBound()
    {
        return image_view.getBoundsInParent();

    }

    public ImageView getView()
    {
        return image_view;
    }

    public void delete()
    {
        Rocket.root.getChildren().remove(image_view);
    }


    public boolean isAlive() {
        return alive;
    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
