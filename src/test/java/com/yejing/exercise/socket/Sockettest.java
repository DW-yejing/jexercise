package com.yejing.exercise.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockettest {
    public void test1(){
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = new Socket("127.0.0.1", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
