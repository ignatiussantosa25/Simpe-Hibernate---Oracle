/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Employees;
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
    public SessionFactory factory;

    public FunctionsDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean operations(int operation, Object object) {
        boolean flag = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            switch (operation) {
                case 0:
                    session.save(object);
                    break;
                case 1:
                    session.update(object);
                    break;
                default:
                    session.delete(object);
                    break;
            }
            transaction.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean insert(Object object) {
        return operations(0, object);
    }

    public boolean update(Object object) {
        return operations(1, object);
    }

    public boolean delete(Object object) {
        return operations(2, object);
    }

    public List<Object> getAll(String query) {
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
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return data;
    }

    public Object getById(String query) {
        Object obj = new Object();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            obj = session.createQuery(query).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }
}
