package view;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private static final int screenWidth = 800;
    private static final int screenHeight = 600;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTON_START_X = 75;
    private final static int MENU_BUTTON_START_Y = 190;
    List<GameButton> menuButtons;

    GameSubScene creditsSubScene;
    GameSubScene helpSubScene;
    GameSubScene scoresSubScene;
    GameSubScene mapChooserSubScene;

    GameSubScene sceneToHide;


    /**
     * Khoi tao man hinh chinh cua app.
     */
    public ViewManager() {
        menuButtons = new ArrayList<GameButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, screenWidth, screenHeight);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
        createBackground();
        createSubScene();
        createLogo();



    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createButtons() {
        createStartMenuButton();
        createScoresButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createBackground(){
        Image backgroundImage = new Image("file:src/main/java/view/resources/wood.jpg",screenWidth,screenHeight,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,null);
        mainPane.setBackground(new Background(background));
    }

    private void addMenuButton(GameButton button){
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y+menuButtons.size()*80);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createStartMenuButton(){
        GameButton startButton = new GameButton("PLAY");
        addMenuButton(startButton);
        startButton.setOnAction(e->{
            GameViewManager gameViewManager = new GameViewManager();
            gameViewManager.createNewGame(this.mainStage);
        });

    }

    private void createScoresButton(){
        GameButton scoresButton = new GameButton("SCORES");
        addMenuButton(scoresButton);
        scoresButton.setOnAction(e->{
           showSubScene(scoresSubScene);
        });
    }

    private void createHelpButton(){
        GameButton helpButton = new GameButton("HELP");
        addMenuButton(helpButton);
        helpButton.setOnAction(e->{
            showSubScene(helpSubScene);
        });
    }

    private void createCreditsButton(){
        GameButton creditsButton = new GameButton("CREDITS");
        addMenuButton(creditsButton);
        creditsButton.setOnAction(e->{
            showSubScene(creditsSubScene);
        });
    }

    private void createExitButton(){
        GameButton exitButton = new GameButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction(e->{
            mainStage.close();
        });
    }

    private void createLogo(){
        ImageView logo = new ImageView("file:src/main/java/view/resources/logoBomberMan.png");
        ImageView logo1 = new ImageView("file:src/main/java/view/resources/BomBer_Men.png");
        ImageView logo2 = new ImageView("file:src/main/java/view/resources/bomber_women.png");
        logo.setFitHeight(300);
        logo.setFitWidth(480);
        logo.setLayoutX(300);
        logo.setLayoutY(-20);

        logo1.setFitWidth(170);
        logo1.setFitHeight(187);
        logo1.setLayoutX(0);
        logo1.setLayoutY(0);

        logo2.setFitWidth(150);
        logo2.setFitHeight(225);
        logo2.setLayoutX(650);
        logo2.setLayoutY(375);


        logo.setOnMouseEntered(e->{
            logo.setEffect(new DropShadow());
        });

        logo.setOnMouseExited(e->{
            logo.setEffect(null);
        });
        mainPane.getChildren().addAll(logo,logo1,logo2);
    }

    public void createSubScene(){
        creditsSubScene = new GameSubScene(null,400,380);
        mainPane.getChildren().add(creditsSubScene);

        helpSubScene = new GameSubScene(null,400,380);
        mainPane.getChildren().add(helpSubScene);

        scoresSubScene = new GameSubScene(null,400,380);
        mainPane.getChildren().add(scoresSubScene);

        showSubScene(scoresSubScene);
        textInScore();
        textInHelp();
        textInCredits();




    }
    private void textInScore(){
        InfoLabel highScores = new InfoLabel("HIGH SCORES");
        highScores.setLayoutX(-35);
        highScores.setLayoutY(-135);
        scoresSubScene.getPane().getChildren().add(highScores);
    }
    private void textInHelp(){
        InfoLabel help = new InfoLabel("HELP");
        help.setLayoutX(-35);
        help.setLayoutY(-135);
        helpSubScene.getPane().getChildren().add(help);
    }
    private void textInCredits(){
        InfoLabel credits = new InfoLabel("CREDITS");
        credits.setLayoutX(-35);
        credits.setLayoutY(-135);
        creditsSubScene.getPane().getChildren().add(credits);
    }

    private void showSubScene(GameSubScene thatScene){
        if(sceneToHide!=null){
            sceneToHide.moveSubScene();
        }

        thatScene.moveSubScene();
        sceneToHide = thatScene;

    }
}
