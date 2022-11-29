package appVGShop.gestionUsuarios.domain.dto.converter;

import appVGShop.gestionUsuarios.domain.User;
import appVGShop.gestionUsuarios.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDTOConverter {

    private final ModelMapper modelMapper;

    public UserDTO fromPropertyToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User fromDTOToProperty(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
