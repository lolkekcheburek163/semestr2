package ru.kpfu.itits.pixel_battle.client.exceptions;

public class ClientException extends Exception{
    public ClientException(Exception e){
        this.setStackTrace(e.getStackTrace());
    }
}
