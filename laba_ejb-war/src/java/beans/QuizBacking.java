/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import logic.NewBeanLocal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author пк
 */
@Named("quizBacking")
@RequestScoped
public class QuizBacking {
    
    @Inject 
    private NewBeanLocal conversation;
    
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public void saveAnswer() {
        conversation.addAnswer(answer);
    }
    
    public String endQuiz() {
        return "/page3.xhtml";
    }
}
