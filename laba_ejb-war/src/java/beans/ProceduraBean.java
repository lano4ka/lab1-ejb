/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import dao.*;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.*;

/**
 *
 * @author пк
 */
public class ProceduraBean {
    
@EJB 
private DAORemoteInterface dao;
    
public List<Procedura> getAllProcedures()
{
    return dao.selectAll();
}
    
}
