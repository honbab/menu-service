package startspring.entity.menu;

import jakarta.persistence.*;
import lombok.*;
import startspring.common.converter.booleanYesNoConverter;
import startspring.dto.menu.RegisterMenuDto;
import startspring.dto.menu.UpdateMenuDto;
import startspring.entity.common.BaseEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String menuName;

    @Column
    private BigDecimal menuPrice;

    @Column
    private String menuImgUrl;

    @Convert(converter = booleanYesNoConverter.class)
    private boolean useMenu;

//    @ManyToOne
//    private Shop shop;

    public Menu(RegisterMenuDto registerMenuDto) {
        this.id = getId();
        this.menuName = registerMenuDto.menuName();
        this.menuPrice = registerMenuDto.menuPrice();
        this.menuImgUrl = registerMenuDto.menuImgUrl();
        this.useMenu = registerMenuDto.useMenu();
    }


    public void delete() {
        this.useMenu = false;
    }

    public void updateMenu(UpdateMenuDto updateMenuDto) {
        this.menuName = updateMenuDto.menuName() != null ? updateMenuDto.menuName() : this.menuName;
        this.menuPrice = updateMenuDto.menuPrice() != null ? updateMenuDto.menuPrice() : this.menuPrice;
        this.menuImgUrl = updateMenuDto.menuImgUrl() != null ? updateMenuDto.menuImgUrl() : this.menuImgUrl;
    }
}
