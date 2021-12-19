package ru.kpfu.itits.pixel_battle.client.connection;


import ru.kpfu.itis.pixel_battle.protocol.Message;
import ru.kpfu.itis.pixel_battle.protocol.UserAction;
import ru.kpfu.itits.pixel_battle.client.SocketClient;
import ru.kpfu.itits.pixel_battle.client.controllers.GameSearchController;
import ru.kpfu.itits.pixel_battle.client.controllers.MapController;
import ru.kpfu.itits.pixel_battle.client.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageAccepter implements Runnable{
    private SocketClient socket;
    private Thread thread;
    private volatile List<User> users;

    public MessageAccepter(SocketClient socket){
        this.socket = socket;
        this.users = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }

    public List<User> getUsers(){
        return users;
    }

    private void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Ответ сервера
                Message message = Message.readMessage(socket.getInputStream());

                System.out.println("accepter " + message.getUserAction());

                if(message.getUserAction().equals(UserAction.BATTLE_SEARCH)){
                    addUser(new User());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
