package ru.kpfu.itits.pixel_battle.client;

import ru.kpfu.itits.pixel_battle.client.exceptions.ClientException;
import ru.kpfu.itis.pixel_battle.protocol.Message;

public interface Client {
    void connect() throws ClientException;
    void sendMessage(Message message) throws ClientException;
//    Message getMessage() throws ClientException;
}
