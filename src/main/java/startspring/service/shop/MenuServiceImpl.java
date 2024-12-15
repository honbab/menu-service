package startspring.service.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import startspring.dto.ResponseRequestDto;
import startspring.dto.menu.RegisterMenuDto;
import startspring.dto.menu.UpdateMenuDto;
import startspring.entity.menu.Menu;
import startspring.repository.menu.MenuRepository;
import startspring.response.menu.MenuDetail;
import startspring.response.menu.MenuDetailResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public ResponseRequestDto registerMenu(RegisterMenuDto registerMenuDto) {
        Menu menu = new Menu(registerMenuDto);
        menuRepository.save(menu);
        return new ResponseRequestDto(true);
    }


    @Override
    @Transactional
    public ResponseRequestDto deleteMenu(Long shopId, Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException(""));

//        if(menu.getShop().getId().equals(shopId)) {
//            menu.delete();
//        }
        //Shop existShop = shopValidation.validationCheck(shopId);
        //long deleteSuccess = qMenuRepository.deleteMenu(existShop.getId(), menuId);
        return new ResponseRequestDto(true);
    }

    @Override
    @Transactional(readOnly = true)
    public MenuDetailResponse getMenus(Long shopId) {
        List<Menu> menus = menuRepository.findAllById(shopId);
        List<MenuDetail> result = menus.stream().map(MenuDetail::new).collect(Collectors.toList());
        return new MenuDetailResponse(result);
    }

    @Override
    public MenuDetail getMenu(Long shopId, Long menuId) {
//        Shop existShop = shopValidation.validationCheck(shopId);
//        menuRepository.findById(existShop.getId());
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException());

        return new MenuDetail(menu);
    }

    @Override
    public ResponseRequestDto updateMenu(Long shopId, UpdateMenuDto updateMenuDto) {
        Menu menu = menuRepository.findById(updateMenuDto.id()).orElseThrow(() -> new RuntimeException(""));

        //if(!menu.getShop().getId().equals(shopId)) throw BadRequestException
        //qMenuRepository.updateMenu(existShop.getId(), updateMenuDto);
        menu.updateMenu(updateMenuDto);
        menuRepository.save(menu);
        return new ResponseRequestDto(true);
    }

}
