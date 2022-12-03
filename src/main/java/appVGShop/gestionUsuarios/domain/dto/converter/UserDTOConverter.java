package appVGShop.gestionUsuarios.domain.dto.converter;

import appVGShop.gestionUsuarios.domain.Employee;
import appVGShop.gestionUsuarios.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDTOConverter {

    private final ModelMapper modelMapper;

    public EmployeeDTO fromPropertyToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEmployee (EmployeeDTOCreator employeeDTOCreator) {

        return modelMapper.map(employeeDTOCreator, Employee.class);

    }

    public Employee convertToEmployee (EmployeeDTOUpdate employeeDTOUpdate) {

        return modelMapper.map(employeeDTOUpdate, Employee.class);

    }

    public Employee convertToEmployee (EmployeeDTODelete employeeDTODelete) {

        return modelMapper.map(employeeDTODelete, Employee.class);

    }

    public Employee convertToEmployee (EmployeeDTOShow employeeDTOShow) {

        return modelMapper.map(employeeDTOShow, Employee.class);

    }

}
