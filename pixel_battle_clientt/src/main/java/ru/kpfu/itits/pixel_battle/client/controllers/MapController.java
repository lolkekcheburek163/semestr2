package ru.kpfu.itits.pixel_battle.client.controllers;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.SocketClient;
import ru.kpfu.itits.pixel_battle.client.connection.MessageAccepter;
import ru.kpfu.itits.pixel_battle.client.model.floors.Floor;
import ru.kpfu.itits.pixel_battle.client.exceptions.ClientException;
import ru.kpfu.itits.pixel_battle.client.model.User;
import ru.kpfu.itits.pixel_battle.client.model.floors.StandartFloor;
import ru.kpfu.itits.pixel_battle.client.model.tanks.Tank;
import ru.kpfu.itits.pixel_battle.client.model.tanks.shots.Shot;
import ru.kpfu.itits.pixel_battle.client.model.walls.StandartWall;
import ru.kpfu.itits.pixel_battle.client.model.walls.UnbrokenWall;
import ru.kpfu.itits.pixel_battle.client.model.walls.Wall;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MapController {
    private User user;

    @FXML
    public Button optionsMenuButton;

    @FXML
    private GridPane lawnGrid;

    @FXML
    private GridPane mapPage;

    @FXML
    private void options(MouseEvent event) throws ClientException {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    private Tank getTank(){
        return user.getTank();
    }

    public void initialize() throws Exception {

        Wall wall = new UnbrokenWall(40, 40, 0, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 1, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 2, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 3, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 4, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 5, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 6, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 7, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 8, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 9, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 10, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 11, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 12, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 14, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 15, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 16, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 17, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 0);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 1);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 2);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 3);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 4);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 5);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 6);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 7);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 8);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 9);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 1);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 2);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 3);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 4);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 5);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 6);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 7);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 8);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 9);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 0, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 1, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 2, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 3, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 4, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 5, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 6, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 7, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 8, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 9, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 10, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 11, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 12, 10);
        wall.makeImage(lawnGrid);
        wall = new UnbrokenWall(40, 40, 13, 10);
        wall.makeImage(lawnGrid);

        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 2, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 3, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 4, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 6, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 7, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 8, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 10, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 11, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 12, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 10, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 11, 3);
        wall.makeImage(lawnGrid);
        wall = new StandartWall(40, 40, 12, 3);
        wall.makeImage(lawnGrid);

        Floor floor = new StandartFloor(40, 40, 12, 4);
        floor.makeImage(lawnGrid);
        floor = new StandartFloor(40, 40, 11, 4);
        floor.makeImage(lawnGrid);

        lawnGrid.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            Tank tank = user.getTank();
            tank.makeImage(lawnGrid);

            if (oldScene == null && newScene != null) {
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.W){
                        user.setAction(UserAction.TANK_MOVE_FORWARD);
                        tank.tankMoveForward();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.S){
                        user.setAction(UserAction.TANK_MOVE_BACK);
                        tank.tankMoveBack();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.A){
                        user.setAction(UserAction.TANK_ROTATE_LEFT);
                        tank.tankRotateLeft();
                    }
                });
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if(event.getCode() == KeyCode.D){
                        user.setAction(UserAction.TANK_ROTATE_RIGHT);
                        tank.tankRotateRight();
                    }
                });
                newScene.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    Shot shot = tank.tankFire();
                    shot.makeImage(lawnGrid);
                });
            }
        });

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(1000),
                        ae -> {

                        }
                )
        );

        timeline.setCycleCount(1);
        timeline.play();
    }

    public void setUser(User user){
        this.user = user;
    }
}
