module client {
    requires protocol;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports ru.kpfu.itits.pixel_battle.client to javafx.graphics;
    exports ru.kpfu.itits.pixel_battle.client.controllers to javafx.fxml;
    opens ru.kpfu.itits.pixel_battle.client.controllers;
}