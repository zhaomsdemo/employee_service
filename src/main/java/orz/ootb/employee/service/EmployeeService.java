package orz.ootb.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import orz.ootb.employee.model.Employee;
import orz.ootb.employee.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.UUID;

@Service
public class EmployeeService {

    @Value("${service.department.getOne}")
    private String getDepartmentURI;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Employee createEmployee(Employee employee){
        discoveryClient.getInstances("department-service").forEach(
                serviceInstance -> {System.out.println(serviceInstance.toString());}
        );

        String departmentId = employee.getDepartmentId();
        HashMap department = restTemplate.getForObject(getDepartmentURI,HashMap.class,departmentId);
        employeeRepository.save(employee);

        return employee;
    }

    public Employee getEmployeeById(String employeeId){
        return employeeRepository.findById(employeeId).get();
    }
}
