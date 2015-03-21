/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author пк
 */
@ConversationScoped
@Named()
@Stateful
public class NewBean implements Serializable, NewBeanLocal{
    @Inject
    private Conversation conversation;
    private List<String> answers;

    public void startConversation()
    {
        if (conversation.isTransient())
            conversation.begin();
    }
    
     public void stopConversation()
    {
        if (!conversation.isTransient())
            conversation.end();
    }
    
    @Override
    public void addAnswer(String answer) {
        if(answers == null) {
            answers = new LinkedList<>();
        }
        answers.add(answer);
    }

    @Override
    public List<String> getAllAnswers() {
        stopConversation();
        return answers;
    }
    
}
