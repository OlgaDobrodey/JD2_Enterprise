package by.it_academy.jd2.core.service.api.medical;

import by.it_academy.jd2.core.model.menu.Department;

import java.util.List;

public interface IDepartementView {

    Department save(Department department);
    List<Department> findAll();
    Department findDepartamentById(String idDepartments);
}
