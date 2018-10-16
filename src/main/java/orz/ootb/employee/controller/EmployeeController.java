package orz.ootb.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import orz.ootb.employee.model.Employee;
import orz.ootb.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
}
