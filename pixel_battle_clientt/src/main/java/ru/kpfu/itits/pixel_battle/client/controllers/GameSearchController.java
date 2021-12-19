package ru.kpfu.itits.pixel_battle.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.connection.MessageAccepter;
import ru.kpfu.itits.pixel_battle.client.exceptions.ClientException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.kpfu.itits.pixel_battle.client.Main;
import ru.kpfu.itits.pixel_battle.client.model.User;

public class GameSearchController {
    private Timeline timeline;
    private User user;
    private MessageAccepter messageAccepter;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label gameSearchLabel;

    @FXML
    private Label gameSearchTimer;

    @FXML
    private Label gameSearchCount;

    @FXML
    private Button backButton;

    @FXML
    private void options(MouseEvent event) throws ClientException {
        HeaderController controller = new HeaderController();
        controller.setUser(user);
        controller.options(event);
    }

    @FXML
    public void goBack(MouseEvent event) throws ClientException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/intro.fxml"));
        try {
            Parent mainLayout = loader.load();

            user.setAction(UserAction.INTRO_MENU);
            IntroController controller = loader.getController();
            controller.setUser(user);

            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.getScene().setRoot(mainLayout);
        } catch (IOException e) {
            throw new ClientException(e);
        }
    }

    @FXML
    void initialize() {
        assert gameSearchLabel != null : "fx:id=\"gameSearchLabel\" was not injected: check your FXML file 'gameSearch.fxml'.";
        assert gameSearchTimer != null : "fx:id=\"gameSearchTimer\" was not injected: check your FXML file 'gameSearch.fxml'.";

        final int[] seconds = {0};
        final int[] minutes = {0};
        this.timeline = new Timeline (
                new KeyFrame(
                        Duration.millis(1000),

                        ae -> {
                            int usersCount =  messageAccepter.getUsers().size() + 1;
                            gameSearchCount.setText("Игроков в поиске: " + usersCount);
                            user.setAction(UserAction.BATTLE_SEARCH);
                            if(usersCount == 10){
                                FXMLLoader loader=new FXMLLoader();
                                loader.setLocation(Main.class.getResource("/markup/map.fxml"));
                                try {
                                    Parent mainLayout = loader.load();

                                    user.setAction(UserAction.IN_THE_BATTLE);
                                    MapController controller = loader.getController();
                                    controller.setUser(user);

                                    Stage appStage = (Stage) gameSearchLabel.getScene().getWindow();
                                    appStage.getScene().setRoot(mainLayout);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(seconds[0] < 10){
                                gameSearchTimer.setText(minutes[0] + ":0" + seconds[0]);
                            } else if(seconds[0] > 60){
                                minutes[0]++;
                                seconds[0] = 0;
                                gameSearchTimer.setText(minutes[0] + ":0" + seconds[0]);
                            } else {
                                gameSearchTimer.setText(minutes[0] + ":" + seconds[0]);
                            }
                            seconds[0]++;
                        }
                )
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setMessageAccepter(MessageAccepter messageAccepter) { this.messageAccepter = messageAccepter; }
}
