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
import tools.HibernateUtil;

/**
 *
 * @author Ignatius
 */
public class EmployeesDAO implements InterfaceDAO {

    public SessionFactory factory;
    private Session session;
    private Transaction transaction;
    public FunctionsDAO fdao;

    public EmployeesDAO() {
        this.fdao = new FunctionsDAO(HibernateUtil
                .getSessionFactory());
    }

    /**
     *
     * @param object Object berupa class Employees
     * @return
     */
    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        Employees employees = (Employees) object;
        Employees emp = (Employees) this.getById(employees.getEmployeeId()+"");
        emp.setFirstName(employees.getFirstName());
        emp.setPhoneNumber(employees.getPhoneNumber());
        emp.setSalary(employees.getSalary());
        emp.setManagerId(employees.getManagerId());
        emp.setDepartmentId(employees.getDepartmentId());
        return fdao.update(emp);
    }

    @Override
    public boolean delete(Object object) {
        Employees emp = (Employees) this.getById(object.toString());
        System.out.println(emp.getFirstName());
        return fdao.delete(emp);
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Employees");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Employees"
                + " WHERE " + category
                + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Employees where employeeId=" + id);
    }

}
