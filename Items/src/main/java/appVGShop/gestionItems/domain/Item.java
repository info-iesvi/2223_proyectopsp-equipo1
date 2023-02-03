package appVGShop.gestionItems.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer itemId;

    private String nombreItem;
    private String descripcionItem;
    private Boolean esElectronico;
}