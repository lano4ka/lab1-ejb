/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import javax.ejb.Remote;
import models.*;
/**
 *
 * @author пк
 */
@Remote
public interface DAORemoteInterface {
    
    public List<Procedura> selectAll();
    
}
