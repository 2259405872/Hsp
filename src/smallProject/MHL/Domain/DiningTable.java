package smallProject.MHL.Domain;

public class DiningTable{
    int id;
    String state;
    String oderName;
    String oderTel;

    public DiningTable() {
    }

    public DiningTable(int id, String state, String oderName, String oderTel) {
        this.id = id;
        this.state = state;
        this.oderName = oderName;
        this.oderTel = oderTel;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOderName() {
        return oderName;
    }

    public void setOderName(String oderName) {
        this.oderName = oderName;
    }

    public String getOderTel() {
        return oderTel;
    }

    public void setOderTel(String oderTel) {
        this.oderTel = oderTel;
    }

    @Override
    public String toString() {
        return id+"\t\t\t"+state;
    }
}
