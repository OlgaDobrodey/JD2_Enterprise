package by.it_academy.jd2.storage.api.medicalCard;

import by.it_academy.jd2.core.model.menu.Department;
import by.it_academy.jd2.core.model.people.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentRepository extends JpaRepository<Department,Integer> {
    Department findDepartmentByIdDepartments(Integer idDepartament);
}
