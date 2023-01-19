package appVGShop.gestionUsuarios.infra.controller;

import appVGShop.gestionUsuarios.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import appVGShop.gestionUsuarios.domain.dto.*;

@RestController
public class EmployeeController implements EmployeeAPI {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<?> getAll() {
        return employeeService.getAll();
    }

    @Override
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return employeeService.getUser(id);
    }

    @Override
    public ResponseEntity<?> newUser(@RequestBody EmployeeDTOCreator newUserCreator) {
        return employeeService.newUser(newUserCreator);
    }

    @Override
    public ResponseEntity<?> editUser(EmployeeDTOCreator editData, Integer id) {
        return employeeService.editUser(editData, id);
    }

    @Override
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return employeeService.deleteUser(id);
    }

}
