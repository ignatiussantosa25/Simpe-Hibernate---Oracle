/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentsDAO;
import dao.EmployeesDAO;
import dao.LocationsDAO;
import entities.Departments;
import entities.Employees;
import entities.Locations;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ignatius
 */
public class DepartmentsController {

    private final DepartmentsDAO dDAO;
    private final EmployeesDAO eDAO;
    private final LocationsDAO lDAO;

    public DepartmentsController() {
        this.dDAO = new DepartmentsDAO();
        this.eDAO = new EmployeesDAO();
        this.lDAO = new LocationsDAO();
    }

    public boolean save(String departmentId, String departmentName, String managerId, String LocationId, boolean isSave) {
        Departments departments = new Departments(Short.valueOf(departmentId), departmentName);
        String[] mId = managerId.split(" ");
        String[] lId = LocationId.split(" ");
        departments.setManagerId((Employees) eDAO.getById(mId[0]));
        departments.setLocationId((Locations) lDAO.getById(lId[0]));
        if (isSave) {
            return dDAO.insert(departments);
        }
        return dDAO.update(departments);
    }

    public List<String> bindingAll(JTable table,
            String[] header) {
        return bindingTable(table, header,
                dDAO.getAll());
    }

    //belum sempurna, data masih ter-replace
    public List<String> bindingSearch(JTable table,
            String[] header, String category,
            String cari) {
        String search = cari;
        if (category.equalsIgnoreCase("managerId")) {
            Employees employees = (Employees) eDAO.search("firstName", cari).get(0);
            if (employees == null) {
                employees = (Employees) eDAO.search("lastName", cari).get(0);
            }
            search = employees.getEmployeeId().toString();
        } else if (category.equalsIgnoreCase("locationId")) {
            List<Object> locations = lDAO.search("city", cari);
            Locations location = (Locations) locations.get(0);

            search = location.getLocationId().toString();
        }
        return bindingTable(table, header, dDAO.search(category, search));
    }

    private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataManager = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            Departments departments = (Departments) data;
            String manager = "";
            if (departments.getManagerId() != null) {
                manager = departments.getManagerId().getFirstName() + " "
                        + departments.getManagerId().getLastName();
                dataManager.add(departments.getManagerId().getEmployeeId()
                        + " - " + manager + ";" + departments.getLocationId().getLocationId()
                        + " - " + departments.getLocationId().getCity());
            } else {
                dataManager.add(" - ;" + departments.getLocationId().getLocationId()
                        + " - " + departments.getLocationId().getCity());
            }
            Object[] data1 = {
                i++,
                departments.getDepartmentId(),
                departments.getDepartmentName(),
                manager,
                departments.getLocationId().getCity()
            };
            model.addRow(data1);
        }
        table.setModel(model);
        return dataManager;
    }

    public void loadManager(JComboBox jComboBox) {
        jComboBox.addItem(" - ");
        eDAO.getAll().stream().map((object) -> (Employees) object).forEachOrdered((employees) -> {
            jComboBox.addItem(employees.getEmployeeId() + " - "
                    + employees.getFirstName() + " "
                    + employees.getLastName());
        });
    }

    public void loadCity(JComboBox jComboBox) {
        jComboBox.addItem(" - ");
        lDAO.getAll().stream().map((object) -> (Locations) object).forEachOrdered((locations) -> {
            jComboBox.addItem(locations.getLocationId() + " - "
                    + locations.getCity());
        });
    }

    public boolean delete(String id) {
        return dDAO.delete(id);
    }
}
