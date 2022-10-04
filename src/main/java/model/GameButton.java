package model;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameButton extends Button {
    private final String FONT_PATH = "src/main/java/model/resources/kenvector_future.ttf";

    /*
    //CSS
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: radial-gradient(center 50px 50px, radius 100px, blue, red);-fx-text-fill: orange";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: radial-gradient(center 50px 50px, radius 100px, red, blue);-fx-text-fill: khaki";
    */
    private Image backgroundImageFree = new Image("file:src/main/java/model/resources/green_button00.jpg",190,49,false,true);
    private BackgroundImage backgroundFree = new BackgroundImage(backgroundImageFree, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT,null);

    private Image backgroundImagePressed = new Image("file:src/main/java/model/resources/green_button00_press.jpg",190,49,false,true);
    private BackgroundImage backgroundPressed = new BackgroundImage(backgroundImagePressed, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,
            BackgroundPosition.DEFAULT,null);

    public GameButton(String text) {
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        setBackground(new Background(backgroundFree));
        initButtonListener();
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));

        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }

    }

    private void setButtonPressedStyle() {
        setBackground(new Background(backgroundPressed));
        setPrefHeight(49);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setBackground(new Background(backgroundFree));
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void initButtonListener() {
        setOnMousePressed(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressedStyle();
            }
        });

        setOnMouseReleased(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleasedStyle();
            }
        });

        setOnMouseEntered(e -> {
            setEffect(new DropShadow());
        });

        setOnMouseExited(e -> {
            setEffect(null);
        });
    }
}
