package ru.kpfu.itits.pixel_battle.client.model.walls;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import ru.kpfu.itits.pixel_battle.client.model.Destroymable;
import ru.kpfu.itits.pixel_battle.client.model.tanks.shots.Shot;
import ru.kpfu.itits.pixel_battle.client.Main;

public class StandartWall extends Wall implements Destroymable {
    private static final String wallPath = Main.class.getResource("/img/wall1.png").toString();

    public StandartWall(int width, int height, int col, int row) {
        super(wallPath, width, height, col, row);
    }

    public void makeImage(GridPane lawn){
        img = new ImageView();
        Image im = new Image(path, width, height,false,false);
        img.setImage(im);
        lawn.add(img, col, row,1,1);
    }

    @Override
    public boolean destroy(Shot shot) {
        return false;
    }
}
