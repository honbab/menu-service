package startspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import startspring.common.GlobalURI;
import startspring.dto.ResponseRequestDto;
import startspring.dto.menu.RegisterMenuDto;
import startspring.dto.menu.UpdateMenuDto;
import startspring.response.menu.MenuDetail;
import startspring.response.menu.MenuDetailResponse;
import startspring.service.shop.MenuService;


@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    // 메뉴 추가
    @PostMapping(GlobalURI.MENU_URI)
    public ResponseEntity<ResponseRequestDto> registerMenu(@RequestBody RegisterMenuDto registerMenuDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.registerMenu(registerMenuDto));
    }

    // 메뉴 수정
    @PutMapping(GlobalURI.MENU_PATH_URI)
    public ResponseEntity<ResponseRequestDto> updateMenu(@PathVariable Long shopId, @PathVariable Long menuId, @RequestBody UpdateMenuDto updateMenuDto) {
        return ResponseEntity.ok().body(menuService.updateMenu(shopId, updateMenuDto));
    }

    // 메뉴 삭제
    @DeleteMapping(GlobalURI.MENU_PATH_URI)
    public ResponseEntity<ResponseRequestDto> deleteMenu(@PathVariable Long shopId, @PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.deleteMenu(shopId, menuId));
    }

    // 메뉴들 전체 조회
    @GetMapping(GlobalURI.MENU_URI)
    public ResponseEntity<MenuDetailResponse> getMenus(@PathVariable Long shopId) {
        return ResponseEntity.ok().body(menuService.getMenus(shopId));
    }

    // 메뉴 조회
    @GetMapping(GlobalURI.MENU_PATH_URI)
    public ResponseEntity<MenuDetail> getMenu(@PathVariable Long shopId, @PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenu(shopId, menuId));
    }
}
