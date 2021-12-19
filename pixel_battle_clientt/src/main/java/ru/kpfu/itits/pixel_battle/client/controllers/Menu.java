package ru.kpfu.itits.pixel_battle.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu {
    User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private void exit(MouseEvent e){
        user.setAction(UserAction.EXIT);
        System.exit(0);
    }
    public void setUser(User user){
        this.user = user;
    }

}
