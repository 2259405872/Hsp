package smallProject.MHL.Service;

import smallProject.MHL.Dao.EmployeeDAO;
import smallProject.MHL.Domain.Employee;

public class EmployeeService {
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO=new EmployeeDAO();

    //通过员工id密码获取一个Employee
    public Employee getEmployeeByIdAndPwd(String empId,String pwd){
        return employeeDAO.querySingle("select * from employee where empId = ? and pwd=md5(?)",Employee.class,empId,pwd);
    }


}
