/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Locations;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author TAMU
 */
public class LocationsDAO implements InterfaceDAO{

    public SessionFactory factory;
    public Session session;
    public Transaction transaksi;
    public FunctionsDAO fdao;
    
    public LocationsDAO(){
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
        this.factory = HibernateUtil.getSessionFactory();
    }
    @Override
    public boolean insert(Object object) {
        boolean flag = false;
        try {
            session = factory.openSession();
            transaksi = session.beginTransaction();
            Locations loc = (Locations) object;
            session.save(loc);
            transaksi.commit();
            flag = true; //kenapa itdak di buat return? jika flag true maka catch tidak dijalankan
        } catch (Exception e) {
            e.printStackTrace();
            if (transaksi!=null) {
                transaksi.rollback();
            }
        } finally {
            session.close();
        }
        return flag;
    }

     /**
    * Fungsi update untuk tabel Locations
    * @param object Object berupa class Locations
    * @return flag berhasil/gagal diupdate
    */
    @Override
    public boolean update(Object object) {
        boolean flag = false;
        try {
            session = factory.openSession();
            transaksi = session.beginTransaction();
            Locations locations = (Locations) object;
            Locations loc = (Locations) session.get(Locations.class, locations.getLocationId());
//            loc.setStreetAddress(locations.getStreetAddress());
//            loc.setPostalCode(locations.getPostalCode());
            loc.setCity(locations.getCity());
//            loc.setStateProvince(locations.getStateProvince());
//            loc.setCountryId(locations.getCountryId());
            session.update(loc);
            transaksi.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaksi!=null) {
                transaksi.rollback();
            }
        } finally {
            session.close();
        }
        return flag;
    }

    @Override
    public boolean delete(Object object) {
       boolean flag = false;
        try {
            session = factory.openSession();
            transaksi = session.beginTransaction();
            Locations loc = (Locations) session.get(Locations.class, flag);
            session.delete(loc);
            transaksi.commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if(transaksi!=null)transaksi.rollback();
        }finally{
            session.close();
        }
        return flag;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Locations");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Locations WHERE "
                + category +" LIKE '%"+search+"'%");
    }

    @Override
    public Object getById(String id) {
    Object loc = new Object();
        try {
            session = factory.openSession();
            transaksi = session.beginTransaction();
            loc = session
                    .createQuery("FROM Locations"
                            + " WHERE locationid=:id")
//                    .setInteger("id",Integer.parseInt(id))
                    .setParameter("id",id)
                    .uniqueResult();
            transaksi.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaksi!=null)transaksi.rollback();
        } finally {
            session.close();
        }
        return loc;}
    
}
