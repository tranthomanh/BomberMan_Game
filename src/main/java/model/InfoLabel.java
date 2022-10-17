package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InfoLabel extends Label {
    public final static String FONT_PATH = "src/main/java/model/resources/kenvector_future.ttf";

    public InfoLabel(String text) {
        setPrefWidth(470);
        setPrefHeight(380);
        setText(text);
        setWrapText(true);
        setLabelFont();
        setAlignment(Pos.CENTER);


    }
    public void setLabelFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)),23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana",23));
        }
    }
}
