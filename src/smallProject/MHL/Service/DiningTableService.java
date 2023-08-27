package smallProject.MHL.Service;

import smallProject.MHL.Dao.DiningTableDAO;
import smallProject.MHL.Domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDAO diningTableDAO= new DiningTableDAO();

    //返回所有餐桌对象
    public List<DiningTable> list(){
        return diningTableDAO.queryMultiple("select * from DiningTable",DiningTable.class);
    }

    //通过id查询获取diningtable
    public DiningTable getDiningTableById(int id){
        return diningTableDAO.querySingle("select * from DiningTable where id=?",DiningTable.class,id);
    }

    //更新餐桌表信息完成预定
    public int oderDiningtable(int id,String oderName,String oderTel){
        return diningTableDAO.update("update diningTable set state='满',oderName=?,oderTel=? where id=?",oderName,oderTel,id);
    }
}
