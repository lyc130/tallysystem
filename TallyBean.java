package tallysystem;

public class TallyBean {
    private int id;
    private String name;
    private String necessity;
    private int money;
    private int time;
    private String describe;
    public int getMoney() {
        return money;
    }

    public String getDescribe() {
        return describe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public String getNecessity() {
        return necessity;
    }

    public void setNecessity(String necessity) {
        this.necessity = necessity;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
