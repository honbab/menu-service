package startspring.repository.menu;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import startspring.dto.menu.UpdateMenuDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import startspring.entity.menu.Menu;
import startspring.entity.menu.QMenu;


import java.util.List;

@Repository
public class QMenuRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory factory;

    private QMenu qMenu = QMenu.menu;

    public QMenuRepository(JPAQueryFactory factory) {
        super(QMenuRepository.class);
        this.factory = factory;
    }

    // 메뉴들 조회
    public List<Menu> getMenus(Long shopId) {
        return factory.select(qMenu)
                .from(qMenu)
                .where(qMenu.shop.id.eq(shopId))
                .fetch();
    }

    // 메뉴 조회

    // 메뉴 등록

    public long updateMenu(Long shopId, UpdateMenuDto updateMenuDto) {
        JPAUpdateClause updateClause = factory.update(qMenu);

        if (updateMenuDto.menuName() != null) {
            updateClause.set(qMenu.menuName, updateMenuDto.menuName());
        }

        if (updateMenuDto.menuPrice() != null) {
            updateClause.set(qMenu.menuPrice, updateMenuDto.menuPrice());
        }

        if (updateMenuDto.menuImgUrl() != null) {
            updateClause.set(qMenu.menuImgUrl, updateMenuDto.menuImgUrl());
        }

        return updateClause
                .where(qMenu.shop.id.eq(shopId).and(qMenu.id.eq(updateMenuDto.id())))
                .execute();
    }


    public long deleteMenu(Long shopId, Long menuId) {
        return factory.update(qMenu)
                .set(qMenu.useMenu, qMenu.useMenu.not())
                .where(qMenu.shop.id.eq(shopId).and(qMenu.id.eq(menuId)))
                .execute();
    }
}
