package ru.kpfu.itits.pixel_battle.client.model.floors;


import ru.kpfu.itits.pixel_battle.client.Main;

public class StandartFloor extends Floor {
    private static final String floorPath = Main.class.getResource("/img/standartFloor.png").toString();

    public StandartFloor(int width, int height, int col, int row) {
        super(floorPath, width, height, col, row);
    }
}
