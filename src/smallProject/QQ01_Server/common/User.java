package smallProject.QQ01_Server.common;


import java.io.Serializable;

//用户
public class User implements Serializable {
    private static final long serialVersionUID =1L;

    private String userid;//用户id
    private String password;//密码

    public User() {
    }

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
