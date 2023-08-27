package smallProject.MHL.View;

import smallProject.MHL.Domain.DiningTable;
import smallProject.MHL.Domain.Employee;
import smallProject.MHL.Domain.Menu;
import smallProject.MHL.Service.DiningTableService;
import smallProject.MHL.Service.EmployeeService;
import smallProject.MHL.Service.MenuService;
import smallProject.QQ01_Client.utils.Utility;

import java.util.List;

public class MHLView {
    private EmployeeService employeeService= new EmployeeService();
    private DiningTableService diningTableService= new DiningTableService();
    private MenuService menuService= new MenuService();
    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //显示所有菜品信息
    private void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("菜品编号"+"\t\t"+"名称"+"\t\t\t"+"种类"+"\t\t"+"价格");
        for (Menu menu:list){
            System.out.println(menu);
        }
    }

    //餐桌订餐
    private void oderDiningTable(){
        for (;;) {
            System.out.println("请确定订餐桌号(-1退出订餐): ");
            int id = Utility.readInt();
            if (id!=-1) {
                System.out.println("是否确定预定(y/n): ");
                char c = Utility.readChar();
                if (c=='y'){
                    DiningTable diningTable = diningTableService.getDiningTableById(id);
                    if (!(diningTable.getOderTel().equals("满"))){
                        System.out.print("请输入您的姓名: ");
                        String name = Utility.readString(50);
                        System.out.print("请输入您的电话: ");
                        String tel = Utility.readString(20);
                        diningTableService.oderDiningtable(id,name,tel);
                        System.out.println("预定成功...");
                        break;//退出订餐
                    }else{
                        System.out.println("该餐桌已满员，请重新输入...");
                    }

                } else if (c == 'n') {
                    break;
                }else {
                    System.out.println("输入信息不匹配请重新输入");
                }
            }else {
                System.out.println("退出预定...");
                break;
            }
        }
    }

    //显示餐桌信息
    private void listDiningTable(){
        List<DiningTable> diningTables = diningTableService.list();
        System.out.println("餐桌编号\t\t空闲状态");
        for (DiningTable diningTable: diningTables) {
            System.out.println(diningTable);
        }
    }
    public void mainMenu(){
        boolean loop = true;

        while(loop){
            System.out.println("===========满汉楼===========");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.print("请输入您的选择: ");
            int choice = Utility.readInt();

            if(choice==1){
                System.out.println("===========登录界面===========");
                System.out.print("请输入用户id: ");
                String id = Utility.readString(50);
                System.out.print("请输入用户密码: ");
                String pwd = Utility.readString(50);

                Employee employee = employeeService.getEmployeeByIdAndPwd(id, pwd);
                if (!(employee==null)){
                    System.out.println("===========员工["+employee.getName()+"]登录成功===========");
                    while (loop){
                        System.out.println("===========满汉楼(二级菜单)===========");
                        System.out.println("\t\t1 显示餐桌状态");
                        System.out.println("\t\t2 预订餐桌");
                        System.out.println("\t\t3 显示所有菜品");
                        System.out.println("\t\t4 点餐服务");
                        System.out.println("\t\t5 查看账单");
                        System.out.println("\t\t6 结账");
                        System.out.println("\t\t9 退出满汉楼");

                        System.out.print("请输入您的选择: ");
                        choice = Utility.readInt();
                        switch (choice){
                            case 1:
                                System.out.println("===========餐桌信息===========");
                                listDiningTable();
                                break;
                            case 2:
                                System.out.println("===========预订餐桌===========");
                                oderDiningTable();
                                break;
                            case 3:
                                System.out.println("===========菜单===========");
                                listMenu();
                                break;
                            case 4:
                                System.out.println("点餐服务");
                                break;
                            case 5:
                                System.out.println("查看账单");
                                break;
                            case 6:
                                System.out.println("结账");
                                break;
                            case 9:
                                System.out.println("退出登录");
                                loop=false;
                                break;
                        }
                    }
                }else {
                    System.out.println("信息不匹配登录失败");
                }
            }else if(choice==2){
                loop = false;
                System.out.println("退出登录");
            }else {
                System.out.println("输入信息不匹配，请重新输入");
            }
        }
    }
}
