package view;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private Stage menuStage;

    ImageView bomber;
    Image currentBomber;
    int number = 0;

    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isUpPressed;
    private boolean isDownPressed;
    private AnimationTimer gameTimer;

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    private static final int SCALE = 2;
    private static final int SPEED = 3;

    public GameViewManager() {
        initializeStage();
        createKeyListeners();
    }

    private void createKeyListeners() {
        gameScene.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.LEFT||e.getCode() == KeyCode.A){
                isLeftPressed = true;
            }
            if(e.getCode() == KeyCode.RIGHT||e.getCode() == KeyCode.D){
                isRightPressed = true;
            }
            if(e.getCode() == KeyCode.UP||e.getCode() == KeyCode.W){
                isUpPressed = true;
            }
            if(e.getCode() == KeyCode.DOWN||e.getCode() == KeyCode.S){
                isDownPressed = true;
            }
        });
        gameScene.setOnKeyReleased(e->{
            if(e.getCode() == KeyCode.LEFT||e.getCode() == KeyCode.A){
                isLeftPressed = false;
            }
            if(e.getCode() == KeyCode.RIGHT||e.getCode() == KeyCode.D){
                isRightPressed = false;
            }
            if(e.getCode() == KeyCode.UP||e.getCode() == KeyCode.W){
                isUpPressed = false;
            }
            if(e.getCode() == KeyCode.DOWN||e.getCode() == KeyCode.S){
                isDownPressed = false;
            }
        });
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuStage){
        this.menuStage = menuStage;
        this.menuStage.hide();
        createBomber();
        createGameLoop();
        gameStage.show();
    }



    public void createBomber(){
        bomber = new ImageView(new Image("file:src/main/java/view/resources/sprites/player_left.png"));
        bomber.setLayoutX(GAME_WIDTH/2);
        bomber.setLayoutY(GAME_HEIGHT/2);
        bomber.setFitHeight(48);
        bomber.setFitWidth(48);
        gamePane.getChildren().add(bomber);
    }

    private void createGameLoop(){
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    moveBomber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        };
        gameTimer.start();


    }

    private void moveBomber() throws InterruptedException {
        if(isUpPressed) {
            bomber.setLayoutY(bomber.getLayoutY() - SPEED);
            if (number == 0) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_up_1.png"));
                Thread.sleep(1000/60);
                number = 1;
            } else if (number == 1) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_up_2.png"));
                Thread.sleep(1000/60);
                number = 2;
            } else if (number == 2) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_up.png"));
                Thread.sleep(1000/60);
                number = 0;
            }
        }
        if(isDownPressed){
            bomber.setLayoutY(bomber.getLayoutY()+SPEED);
            if (number == 0) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_down_1.png"));
                Thread.sleep(1000/60);
                number = 1;
            } else if (number == 1) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_down_2.png"));
                Thread.sleep(1000/60);
                number = 2;
            } else if (number == 2) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_down.png"));
                Thread.sleep(1000/60);
                number = 0;
            }
        }
        if(isLeftPressed){
            bomber.setLayoutX(bomber.getLayoutX()-SPEED);
            if (number == 0) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_left_1.png"));
                Thread.sleep(1000/60);
                number = 1;
            } else if (number == 1) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_left_2.png"));
                Thread.sleep(1000/60);
                number = 2;
            } else if (number == 2) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_left.png"));
                Thread.sleep(1000/60);
                number = 0;
            }
        }
        if(isRightPressed){
            bomber.setLayoutX(bomber.getLayoutX()+SPEED);
            if (number == 0) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_right_1.png"));
                Thread.sleep(1000/60);
                number = 1;
            } else if (number == 1) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_right_2.png"));
                Thread.sleep(1000/60);
                number = 2;
            } else if (number == 2) {
                bomber.setImage(new Image("file:src/main/java/view/resources/sprites/player_right.png"));
                Thread.sleep(1000/60);
                number = 0;
            }
        }

    }
}
