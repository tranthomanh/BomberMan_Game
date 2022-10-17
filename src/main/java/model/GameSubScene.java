package model;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class GameSubScene extends SubScene {
    private final String FONT_PATH = "src/main/java/model/resources/kenvector_future.ttf";
    private final String BACKGROUND_IMAGE = "file:src/main/java/model/resources/grey_panel.png";

    private boolean isHidden;

    public GameSubScene(Parent parent, double v, double v1) {
        super(new AnchorPane(), v, v1);
        prefWidth(v);
        prefHeight(v1);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE,v,v1,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        isHidden = true;
        setLayoutX(1024);
        setLayoutY(180);
    }

    public void moveSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.5));
        transition.setNode(this);
        if(isHidden){
            transition.setToX(-700);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }

        transition.play();
    }

    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }
}
