/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import spread.*;

/**
 *
 * @author shina
 */
public class ConnectionController {
    
    SpreadConnection connection;
    private String address;
    private String userName;
    boolean priority;
    private int port;

    public ConnectionController(String address, String userName, boolean priority, int port) {        
        connection = new SpreadConnection();
        this.address = address;
        this.userName = userName;
        this.priority = priority;
        this.port = port;
    }
    
    public void connect() throws UnknownHostException, SpreadException
    {
        connection.connect(InetAddress.getByName(address), port, userName, priority, true);
    }
    
    public void joinGroup(String grupo) throws SpreadException
    {
        SpreadGroup group = new SpreadGroup();
        group.join(connection, grupo);
    }
    
    public void disconnect() throws SpreadException
    {
        connection.disconnect();
    }
    
    public void addMessageListener(MessageListener listener)
    {
        connection.add(listener);
    }
    
    public void multicast(SpreadMessage message) throws SpreadException
    {
        connection.multicast(message);
    }
    
}
