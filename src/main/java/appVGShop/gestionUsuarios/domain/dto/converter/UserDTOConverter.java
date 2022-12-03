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

    /**
     * Convierte un EmployeeDTOUpdate en un Employee
     *
     * @param employeeDTOUpdate
     * @return
     */
    public Employee convertToEmployee(EmployeeDTOUpdate employeeDTOUpdate) {

        return modelMapper.map(employeeDTOUpdate, Employee.class);

    }

    /**
     * Convierte un EmployeeDTODelete en un Employee
     *
     * @param employeeDTODelete
     * @return
     */
    public Employee convertToEmployee(EmployeeDTODelete employeeDTODelete) {

        return modelMapper.map(employeeDTODelete, Employee.class);

    }

    /**
     * Convierte un EmployeeDTOShow en un Employee
     *
     * @param employeeDTOShow
     * @return
     */
    public Employee convertToEmployee(EmployeeDTOShow employeeDTOShow) {

        return modelMapper.map(employeeDTOShow, Employee.class);

    }

}
