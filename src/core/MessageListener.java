package core;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import spread.AdvancedMessageListener;
import spread.MembershipInfo;
import spread.SpreadGroup;
import spread.SpreadMessage;
import spreadchat.view.MainWindow;
import ui.MainPanel;
import ui.swing.webLaf.MessagePanel;
import ui.swing.webLaf.UserPanel;

public class MessageListener implements AdvancedMessageListener
{
    
    // ------------- Class attributes
    
    private boolean userListCreated;
    private final MainPanel mainPanel;

    
    // ------------- Public methods
    
    public MessageListener(MainPanel mainPanel) 
    {
        userListCreated = false;
        this.mainPanel = mainPanel;
    }

    
    // ------------- Public overriden methods
    
    @Override
    public void regularMessageReceived(SpreadMessage sm) 
    {
        //System.out.println("Regular message received");
        mainPanel.getMessagePanel1().addMessage(getUser(sm.getSender()), new String(sm.getData()));
    }

    @Override
    public void membershipMessageReceived(SpreadMessage sm) 
    {
        //System.out.println("Membership message received");
        MembershipInfo membershipInfo = sm.getMembershipInfo();
        SpreadGroup user = null;
        
        if (!userListCreated)
        {
            mainPanel.setUsers(membershipInfo.getMembers());
            userListCreated = true;
        }
        else if (membershipInfo.isCausedByJoin())
        {
            user = membershipInfo.getJoined();
            mainPanel.getMessagePanel1().addInformationMessage(getUser(user), "entered in the group.");
            mainPanel.addUser(user);
        }
        else if (membershipInfo.isCausedByLeave() && 
                null != (user = membershipInfo.getLeft()))
        {
            mainPanel.getMessagePanel1().addInformationMessage(getUser(user), "left the group.");
            mainPanel.removeUser(user);
        }
        else if (membershipInfo.isCausedByDisconnect() && 
                null != (user = membershipInfo.getDisconnected()))
        {
            mainPanel.getMessagePanel1().addInformationMessage(getUser(user), "was disconnected.");
            mainPanel.removeUser(user);
        }
    }
    
    private String getUser(SpreadGroup user)
    {
        String[] userInfo = user.toString().split("#");
        return userInfo[1];
    }
    
}
