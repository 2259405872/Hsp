package smallProject.MHL.Service;

import smallProject.MHL.Dao.MenuDAO;
import smallProject.MHL.Domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO=new MenuDAO();

    //获得所有菜品信息对象
    public List<Menu> list(){
        return menuDAO.queryMultiple("select * from Menu", Menu.class);
    }
}
