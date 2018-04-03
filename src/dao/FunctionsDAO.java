/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ignatius
 */
public class FunctionsDAO {
    private Session session;
    private Transaction transaction;
    private SessionFactory factory;

    public FunctionsDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    public boolean insert(Object object){
        boolean flag = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return flag;
    }
    
    public List<Object> getAll(String query){
        List<Object> data = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            data = session
                    .createQuery(query)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return data;
    }
    
    public Object getById(String query){
        Object emp = new Object();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            emp = session
                    .createQuery("FROM Employees"
                            + " WHERE employeeId=:id")
//                    .setInteger("id",Integer.parseInt(id))
                    .setParameter("id",Integer.parseInt(query))
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return emp;
    }
}
