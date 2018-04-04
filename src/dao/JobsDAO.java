/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Jobs;
import java.util.List;
import tools.HibernateUtil;

/**
 *
 * @author Ignatius
 */
public class JobsDAO {
    
    public FunctionsDAO fdao;

    public JobsDAO() {
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Jobs");

    }

    /**
     * Fungsi untuk mengambil berdasarkan ID yang ada di tabel Jobs
     *
     * @return data /getById() berdasarkan Jobs Id
     *
     */
    public Object getById(String id) {
        return fdao.getById("from Jobs where jobId='" + id + "'");
    }

    /**
     * Fungsi untuk mengupdate data pada tabel JOBS
     *
     * @return flag /update berdasarkan Jobs Id
     *
     */
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    /**
     * Fungsi untuk menambahkan data pada tabel JOBS
     *
     * @return flag /Insert berdasarkan Jobs Id
     *
     */
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    /**
     * Fungsi untuk menghapus dari tabel Jobs
     *
     * @param object
     * @return flag
     */
    public boolean delete(Object object) {
        return fdao.delete(Jobs.class,object.toString());
    }

    /**
     * fungsi Search untuk mencari data pada tabel Jobs
     *
     * @param object Object Berupa Kelas Jobs
     * @return List data yang dicari dari kelas Jobs
     */
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Jobs WHERE " + category + " LIKE '%" + search + "%'");
    }

}
