package ru.kpfu.itits.pixel_battle.client.model;


import ru.kpfu.itits.pixel_battle.client.model.tanks.shots.Shot;

public interface Destroymable {
    public boolean destroy(Shot shot);
}
