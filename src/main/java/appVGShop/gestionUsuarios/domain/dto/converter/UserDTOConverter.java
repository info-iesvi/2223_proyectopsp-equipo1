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

    /**
     * Toma un Employee y lo convierte en un EmployeeDTO
     *
     * @param employee
     * @return
     */
    public EmployeeDTO fromPropertyToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    /**
     * Convierte un EmployeeDTOCreator en un Employee
     *
     * @param employeeDTOCreator
     * @return
     */
    public Employee convertToEmployee(EmployeeDTOCreator employeeDTOCreator) {

        return modelMapper.map(employeeDTOCreator, Employee.class);

    }

}
