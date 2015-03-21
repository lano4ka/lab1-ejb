/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import javax.inject.Named;

/**
 *
 * @author пк
 */
@Local
//@Named
public interface NewBeanLocal {
    void addAnswer(String answer);
    List<String> getAllAnswers();
}
