package startspring.response.menu;


import startspring.entity.menu.Menu;

public class MenuDetail {

    private String menuName;
    private String menuPrice;
    private String menuImgUrl;

    public MenuDetail(Menu menu) {
        this.menuName = menu.getMenuName();
        this.menuPrice = menu.getMenuPrice().toString();
        this.menuImgUrl = menu.getMenuImgUrl();
    }
}
