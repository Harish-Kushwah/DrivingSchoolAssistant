package model.entity;

/**
 *
 * @author haris
 */
public class COV {
    int id;
    String cov_name;
    public static int LMVTR = 3;
    public static int A3WGV = 6;
    public static int TRANS = 4;

    public COV(int id)
    {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCov_name() {
        return cov_name;
    }

    public void setCov_name(String cov_name) {
        this.cov_name = cov_name;
    }
}
