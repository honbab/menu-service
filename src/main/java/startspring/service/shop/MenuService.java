package startspring.service.shop;


import startspring.dto.ResponseRequestDto;
import startspring.dto.menu.RegisterMenuDto;
import startspring.dto.menu.UpdateMenuDto;
import startspring.response.menu.MenuDetail;
import startspring.response.menu.MenuDetailResponse;

public interface MenuService {

    ResponseRequestDto registerMenu(RegisterMenuDto registerMenuDto);

    ResponseRequestDto deleteMenu(Long shopId, Long menuId);

    MenuDetailResponse getMenus(Long shopId);

    MenuDetail getMenu(Long shopId, Long menuId);

    ResponseRequestDto updateMenu(Long shopId, UpdateMenuDto updateMenuDto);
}
