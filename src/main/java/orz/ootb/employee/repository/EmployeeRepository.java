package orz.ootb.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import orz.ootb.employee.model.Employee;

@RepositoryRestResource(path = "employee",collectionResourceRel = "employee")
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
