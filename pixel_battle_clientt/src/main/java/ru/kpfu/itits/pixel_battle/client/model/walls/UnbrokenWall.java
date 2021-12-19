package ru.kpfu.itits.pixel_battle.client.model.walls;

import ru.kpfu.itits.pixel_battle.client.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class UnbrokenWall extends Wall {
    private static final String unbrokenWallPath = Main.class.getResource("/img/unbroken_wall.png").toString();

    public UnbrokenWall(int width, int height, int col, int row) {
        super(unbrokenWallPath, width, height, col, row);
    }

    public void makeImage(GridPane lawn){
        img = new ImageView();
        Image im = new Image(path, width, height,false,false);
        img.setImage(im);
        lawn.add(img, col, row,1,1);
    }
}
