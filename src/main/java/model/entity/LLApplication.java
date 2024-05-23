package model.entity;

import java.sql.Date;

/**
 *
 * @author haris
 */
public class LLApplication {
    int id;
    String app_no,ll_number;
    Date app_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_no() {
        return app_no;
    }

    public void setApp_no(String app_no) {
        this.app_no = app_no;
    }

    public String getLl_number() {
        return ll_number;
    }

    public void setLl_number(String ll_number) {
        this.ll_number = ll_number;
    }

    public Date getApp_date() {
        return app_date;
    }

    public void setApp_date(Date app_date) {
        this.app_date = app_date;
    }
    
    
}
