/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Observer.ChatObserver;
import Observerble.ChatObserverble;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class ChatControllerImpl extends UnicastRemoteObject implements ChatController {

    private ChatObserverble chatObserverble = new ChatObserverble();

    public ChatControllerImpl() throws RemoteException {

    }

    @Override
    public void addChatObserver(ChatObserver chatObserver) throws RemoteException {
        chatObserverble.addChatObserver(chatObserver);
    }

    @Override
    public void removeChatObserver(ChatObserver chatObserver) throws RemoteException {
        chatObserverble.removeChatObserver(chatObserver);
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        chatObserverble.notifyChatObservers(message);
    }

}
