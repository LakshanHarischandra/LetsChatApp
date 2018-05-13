/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lakshan Ranasinghe
 */
public interface ChatObserver extends Remote {

    public void update(String message) throws RemoteException;
}
