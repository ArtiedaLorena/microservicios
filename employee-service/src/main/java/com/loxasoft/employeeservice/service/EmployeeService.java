package com.loxasoft.employeeservice.service;

import com.loxasoft.employeeservice.dto.DepartmentDTO;
import com.loxasoft.employeeservice.dto.ResponseDTO;
import com.loxasoft.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.loxasoft.employeeservice.entity.Employee;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public ResponseDTO getEmployeeById(Integer id){
        ResponseDTO responseDTO= new ResponseDTO();
        Employee employee= new Employee();
        //Retorna un optional por eso se coloca .get()
        employee= employeeRepository.findById(id).get();

        //Comunicacion de microservicios
        ResponseEntity<DepartmentDTO> responseEntity = restTemplate. getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentId(), DepartmentDTO.class);
        DepartmentDTO departmentDTO= responseEntity.getBody();
        responseDTO.setEmployee(employee);
        responseDTO.setDepartmentDTO(departmentDTO);
        return responseDTO;
        }
}
