package ru.kpfu.itis.pixel_battle.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Message {
    protected final UserAction userAction;

    public Message(UserAction userAction) {
        this.userAction = userAction;
    }

    public static byte[] getBytes(Message message){
        int rawMessageLength = 4; // 4 байта на UserAction, 4 байта на boolean(храним ли userId), 4 байта userId

        byte[] rawMessage = new byte[rawMessageLength];

        int j = 0;
        byte[] type = getTypeBytes(message.getUserAction());
        for(int i = 0;i < type.length;i++){
            rawMessage[j++] = type[i];
        }

        return rawMessage;
    }

    private static byte[] getTypeBytes(UserAction type){
        return ByteBuffer.allocate(4).put(type.getByte()).array();
    }

    public static Message createMessage(UserAction userAction){
        return new Message(userAction);
    }

    public static Message readMessage(InputStream inputStream) throws IOException {
        byte[] type = new byte[4];

        inputStream.read(type, 0, 4);
        byte typeByte = ByteBuffer.wrap(type, 0, 4).get();

        return new Message(UserAction.getMessageType(typeByte));
    }

    public UserAction getUserAction(){
        return userAction;
    }
}
