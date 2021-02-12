import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.TickLabelOrientation;
import eu.hansolo.medusa.skins.ModernSkin;
import eu.hansolo.medusa.skins.SimpleDigitalSkin;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import static javafx.application.Application.launch;

public class Rocket extends Application {
    private final int HEIGHT = 500, WIDTH = 500;

    public static Pane root  = new Pane();

    ArrayList<ImageObject> rocket_list = new ArrayList<>();
    ArrayList<ImageObject> enemy_rocket_list = new ArrayList<>();


    boolean up = false,down = false,left = false,right = false, rotateLeft = false, rotateRight= false;

    ImageObject player = new ImageObject(300, 450, 100, 100, "C:\\Users\\MOSES\\Pictures\\Saved Pictures\\rocket1.png");

    ImageObject enemy = new ImageObject(100, 10, 50, 50, "C:\\Users\\MOSES\\Pictures\\Saved Pictures\\rocket1.png");

    @Override
    public void start(Stage stage) {
        try {

            Timeline tl = new Timeline(new KeyFrame(Duration.millis(5), e-> {

                playerUpdate();

                enemyUpdate();

                for(ImageObject rock : new ArrayList<ImageObject>(rocket_list)) {

                    rock.setLayoutY(rock.getLayoutY() - 2);

                    if(rock.getLayoutY() < 0) {

                        if(rock.getBound().intersects(enemy.getBound()))
                        {
                            enemy.delete();
                        }


                        System.out.println(rocket_list.size());
                        rock.delete();
                        rocket_list.remove(rock);

                    }
                }

            }));
            tl.setCycleCount(Animation.INDEFINITE);
            tl.play();

        
            Gauge gauge =new Gauge();

            gauge.setSkin(new ModernSkin(gauge));
            // gauge.setSkin(new GaugeSkin(gauge));
            gauge.setTitle("CHLOPHURIC");
            gauge.setUnit("km /h");
            gauge.setUnitColor(Color.WHITE);
            gauge.setDecimals(0);
            gauge.setValue(50.00);
            gauge.setMaxValue(200);
            gauge.setAnimated(true);

            gauge.setValueColor(Color.WHITE);
            gauge.setTitleColor(Color.WHITE);
            gauge.setSubTitleColor(Color.WHITE);
            gauge.setBarColor(Color.rgb(0,214,215));
            gauge.setNeedleColor(Color.RED);
            gauge.setThresholdColor(Color.RED);

            gauge.setThreshold(85);
            gauge.setThresholdVisible(true);
            gauge.setTickLabelColor(Color.rgb(151,151,151));
            gauge.setTickMarkColor(Color.WHITE);
            gauge.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);

            Gauge gauge1 = new Gauge();



            gauge1.setSkin(new SimpleDigitalSkin(gauge1));
            gauge1.setMinValue(0);
            gauge1.setMaxValue(200);
            gauge1.setTitle("ALTITUDE");
            gauge1.setUnit("Meters");
            gauge1.setUnitColor(Color.WHITE);
            gauge1.setDecimals(0);
            gauge1.setValue(0.00);
            gauge1.setAnimationDuration(100);
            gauge1.setAnimated(true);

            gauge1.setValueColor(Color.BLACK);
            gauge1.setTitleColor(Color.BLACK);
            gauge1.setSubTitleColor(Color.BLACK);
            gauge1.setBarColor(Color.rgb(0,214,215));
            gauge1.setNeedleColor(Color.RED);
            gauge1.setThresholdColor(Color.RED);

            gauge1.setThreshold(85);
            gauge1.setThresholdVisible(true);
            gauge1.setTickLabelColor(Color.rgb(151,151,151));
            gauge1.setTickMarkColor(Color.BLACK);
            gauge1.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);

            VBox box1 =new VBox();
            box1.getChildren().addAll(gauge,gauge1);

            
        
            SubScene scene2=new SubScene(box1,500,200);

            SubScene scene1 = new SubScene(root,500,500);

            HBox box=new HBox();
            box.setAlignment(Pos.CENTER);
           // box.setSpacing(10);
            box.getChildren().addAll(scene1,scene2);
            //box.getStylesheets().addAll(this.getClass().getResource("/cssFile/animation.css").toExternalForm());
            Scene s=new Scene(box,500,700);
            root.getStylesheets().add("/cssFile/pic.css");
            //box.setId("pane");
            //s.getStylesheets().add("/cssFile/pic.css");

            s.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e)
                {

                    switch (e.getCode()) {
                        case UP:
                            up = true;
                            gauge.setAnimated(true);
                            //gauge.setValue(val);
                            if(gauge.getCurrentValue() <= 195) {
                                gauge.setValue((gauge.getCurrentValue()) + 5);
                            }
                            //
                            gauge1.setAnimated(true);
                            //gauge.setValue(val);
                            if(gauge1.getCurrentValue() <= 190) {
                                gauge1.setValue((gauge1.getCurrentValue()) + 10);
                            }
                            break;
                        case DOWN:

                            down = true;
                            gauge.setAnimated(true);
                            //gauge.setValue(0.00);
                            if(gauge.getCurrentValue() >= 0 && gauge.getCurrentValue() <= 195) {
                                gauge.setValue((gauge.getCurrentValue()) + 10);
                            }
                            gauge1.setAnimated(true);
                            //gauge.setValue(0.00);
                            if(gauge1.getCurrentValue() >= 10) {
                                gauge1.setValue((gauge1.getCurrentValue()) - 10);
                            }
                            break;

                        case W:
                            up = true;

                            break;
                        case S:

                            down = true;
                            break;
                        case A:

                            left = true;
                            break;
                        case D:

                            right = true;
                            break;

                        case LEFT:
                            gauge.setAnimated(true);
                            //gauge.setValue(val);
                            if(gauge.getCurrentValue() <= 195) {
                                gauge.setValue((gauge.getCurrentValue()) + 5);
                            }
                            left = true;
                            break;

                        case RIGHT:
                            gauge.setAnimated(true);
                            //gauge.setValue(0.00);
                            if(gauge.getCurrentValue() >= 0 && gauge.getCurrentValue() <= 195) {
                                gauge.setValue((gauge.getCurrentValue()) + 10);
                            }
                            right = true;
                            break;

                        case SPACE:

                            ImageObject io = new ImageObject(player.getX() + 38, player.getY(), 25, 25, "C:\\Users\\Clo\\Pictures\\JET.png");//bullet
                            rocket_list.add(io);

                            break;


                    }
                }
            });


            s.setOnKeyReleased(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e)
                {

                    switch (e.getCode()) {
                        case UP:
                            up = false;
                            gauge.setAnimated(true);
                            //gauge.setValue(val);
                           // if(gauge.getCurrentValue() <= 195) {
                                gauge.setValue(0);
                           // }
                            gauge1.setAnimated(true);
                            //gauge.setValue(val);
                            if(gauge1.getCurrentValue() <= 195) {
                                gauge1.setValue((gauge1.getCurrentValue()) + 5);
                            }

                            break;
                        case DOWN:

                            down = false;
                            gauge.setAnimated(true);
                            gauge.setValue(0.00);
                            if(gauge.getCurrentValue() >= 5) {
                                gauge.setValue((gauge.getCurrentValue()) - 5);
                            }
                            gauge1.setAnimated(true);
                            //gauge1.setValue(0.00);
                            if(gauge1.getCurrentValue() >= 10) {
                                gauge1.setValue((gauge1.getCurrentValue()) - 10);
                            }
                            break;

                        case W:
                            up = false;

                            break;
                        case S:

                            down = false;
                            break;
                        case A:

                            left = false;
                            break;
                        case D:

                            right = false;
                            break;

                        case LEFT:
                            //System.out.println("Rotate Left");
                            //rotateLeft = false;
                            gauge.setValue(0);
                            left = false;
                            break;

                        case RIGHT:
                           // System.out.println("Rotate Right");
                            //rotateRight = false;
                            gauge.setValue(0);
                            right = false;
                            break;

                    }
                }
            });

            stage.setScene(s);

            stage.show();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void enemyUpdate() {

        for(ImageObject rock : new ArrayList<ImageObject>(enemy_rocket_list)) {
            rock.setLayoutY(rock.getLayoutY() + 2);
            if(rock.getLayoutY() > HEIGHT) {

                System.out.println(rocket_list.size());
                rock.delete();
                rocket_list.remove(rock);

            }
        }

    }


    private void playerUpdate() {


        Point2D ene = new Point2D(enemy.getLayoutX(), enemy.getLayoutY());
        Point2D play = new Point2D(player.getLayoutX(), player.getLayoutY());
        Point2D p3 = play.subtract(ene);
        Point2D p4 = new Point2D(1, 0);

        System.out.println("Point2D: " + p4.angle(p3));

        player.setRotate(p4.angle(p3) - 90);

        System.out.println(Math.sin(p4.angle(p3)));


        //So Player Can't move outside of the border
        if (player.getX() < 0) {
            player.setLayoutX(0);

        } else if (player.getX() > WIDTH - player.getWidth()) {
            player.setLayoutX(WIDTH - player.getWidth());
        } else if (player.getY() < 0) {
            player.setLayoutY(0);
        } else if (player.getY() > HEIGHT - player.getHeight()) {
            player.setLayoutY(HEIGHT - player.getHeight());
        } else {

            //Player movement UP, DOWN, LEFT, RIGHT
            if (up) {
                player.setLayoutY(player.getLayoutY() - 1);

            }
            if (down) {
                player.setLayoutY(player.getLayoutY() + 1);
            }
            if (left) {
                player.setLayoutX(player.getLayoutX() - 1);
            }
            if (right) {
                player.setLayoutX(player.getLayoutX() + 1);

            }

            if (rotateLeft) {

                player.setRotate(120 - 90);


            }
            if (rotateLeft) {
                player.setRotate(60 - 90);

            }

        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
