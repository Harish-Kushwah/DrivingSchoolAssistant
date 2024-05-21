package model.entity;

/**
 *
 * @author haris
 */
public class Payement {
    private int id;
    private float totalGiven;
    private float totalDecide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalGiven() {
        return totalGiven;
    }

    public void setTotalGiven(float totalGiven) {
        this.totalGiven = totalGiven;
    }

    public float getTotalDecide() {
        return totalDecide;
    }

    public void setTotalDecide(float totalDecide) {
        this.totalDecide = totalDecide;
    }
    
}
