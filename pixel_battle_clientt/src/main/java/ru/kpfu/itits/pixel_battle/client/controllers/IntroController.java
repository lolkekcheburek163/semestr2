package ru.kpfu.itits.pixel_battle.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ru.kpfu.itis.pixel_battle.protocol.Message;
import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.connection.MessageAccepter;
import ru.kpfu.itits.pixel_battle.client.exceptions.ClientException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ru.kpfu.itits.pixel_battle.client.Main;
import ru.kpfu.itits.pixel_battle.client.model.User;

public class IntroController {
    private User user;
    private MessageAccepter messageAccepter;

   @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button toBattleButton;

    @FXML
    private Button exitMenuButton;

    @FXML
    private Button optionsMenuButton;

    @FXML
    private FlowPane optionsPane;

    @FXML
    private void options(MouseEvent event) throws ClientException {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    @FXML
    private void toBattle(MouseEvent event) throws ClientException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/gameSearch.fxml"));
        try {
            Parent mainLayout = loader.load();

            user.setAction(UserAction.BATTLE_SEARCH);
            GameSearchController controller = loader.getController();
            controller.setUser(user);
            controller.setMessageAccepter(messageAccepter);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.getScene().setRoot(mainLayout);
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }

    @FXML
    void initialize() {
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setMessageAccepter(MessageAccepter messageAccepter) { this.messageAccepter = messageAccepter; }
}