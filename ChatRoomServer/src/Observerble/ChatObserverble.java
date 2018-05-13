/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observerble;

import Observer.ChatObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class ChatObserverble {

    private ArrayList<ChatObserver> chatClientList = new ArrayList<>();

    public void addChatObserver(ChatObserver chatObserver) {

        chatClientList.add(chatObserver);
    }

    public void removeChatObserver(ChatObserver chatObserver) {
        chatClientList.remove(chatObserver);
    }

    public void notifyChatObservers(String message) throws RemoteException {

        for (ChatObserver client : chatClientList) {
            new Thread() {
                public void run() {
                    try {
                        client.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ChatObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
