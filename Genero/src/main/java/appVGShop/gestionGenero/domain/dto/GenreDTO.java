package appVGShop.gestionGenero.domain.dto;

import appVGShop.gestionVideojuegos.domain.dto.VideogameDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreDTO {
    private Integer generoID;
    private String nombre;
    private String descripcion;
    private List<VideogameDTO> listaJuegos;
}
