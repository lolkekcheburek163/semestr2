package ru.kpfu.itits.pixel_battle.client.connection;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import ru.kpfu.itis.pixel_battle.protocol.Message;
import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.SocketClient;
import ru.kpfu.itits.pixel_battle.client.exceptions.ClientException;
import ru.kpfu.itits.pixel_battle.client.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class MessageSender implements Runnable{
    private SocketClient socket;
    private Thread thread;

    public MessageSender(SocketClient socket){
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            try (PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true)) {
                while (true) {
                    // Отправка данных на сервер
                    User user = socket.getUser();
                    while(!user.getFlag()){
                    }
                    UserAction action = user.getAction();
                    System.out.println("sender " + action);
                    Message request = Message.createMessage(action);
                    socket.sendMessage(request);
                }
            } catch (ClientException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            try {
                if (e instanceof SocketTimeoutException) {
                    throw new SocketTimeoutException();
                } else {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException ste) {
                System.out.println("Turn off the client by timeout");
            }
        }
    }
}
