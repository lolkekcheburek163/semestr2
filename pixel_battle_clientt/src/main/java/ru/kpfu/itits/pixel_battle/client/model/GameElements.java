package ru.kpfu.itits.pixel_battle.client.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.Serializable;

public abstract class GameElements implements Serializable {
    protected String path;
    transient protected ImageView img;
    protected int width;
    protected int height;

    public GameElements(String path, int width, int height){
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public void makeImage(Pane pane){
        img = new ImageView();
        Image im=new Image(path,(double) width,(double) height,false,false);
        img.setImage(im);
        pane.getChildren().add(img);
    }
}
