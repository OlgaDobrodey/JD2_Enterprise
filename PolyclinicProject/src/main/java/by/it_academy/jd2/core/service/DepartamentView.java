package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.menu.Department;
import by.it_academy.jd2.core.service.api.IDepartementView;
import by.it_academy.jd2.storage.api.IDepartamentRepository;

import java.util.List;

public class DepartamentView implements IDepartementView {
    private IDepartamentRepository repository;

    public DepartamentView(IDepartamentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department save(Department department) {
        return this.repository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Department findDepartamentById(String idDepartments) {
        final int anInt = Integer.parseInt(idDepartments);
        return this.repository.findDepartmentByIdDepartments(anInt);
    }
}
