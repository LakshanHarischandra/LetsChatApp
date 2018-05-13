/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Connector.ServerConnector;
import Controller.ChatController;
import Observer.ChatObserver;
import Observer.ChatObserverImpl;
import View.ChatWindow;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class StartClient {

    public static void main(String[] args) {
        try {
            String name = JOptionPane.showInputDialog(null, "Enter User Name");
            ChatWindow chatWindow = new ChatWindow(name);
            ChatObserverImpl chatObserverImpl = new ChatObserverImpl(chatWindow);
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.addChatObserver((ChatObserver)chatObserverImpl);

        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(StartClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
