/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
@Named("newBean")
@Stateful
public class NewBean implements Serializable, NewBeanLocal{
    @Inject
    private Conversation conversation;
    
    private List<String> answers;
    
    private static final Logger logger = Logger.getLogger(NewBean.class.getName());
    @PostConstruct
    public void startConversation()
    {
        System.out.println("create NewBean instance");
        if (conversation.isTransient())
            conversation.begin();
    }
    
     public void stopConversation()
    {
        if (!conversation.isTransient())
            conversation.end();
    }
    
    //Override
    public void addAnswer(String answer) {
        if(answers == null) {
            answers = new LinkedList<>();
        }
        answers.add(answer);
        System.out.println("added answer " + answer);
    }

    //@Override
    public List<String> getAllAnswers() {
        System.out.println("We are listing answers!!!" + answers.size());
        stopConversation();
        return answers;
        
    }
    
}
