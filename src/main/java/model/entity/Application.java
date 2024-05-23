package model.entity;

/**
 *
 * @author haris
 */
public class Application {
    int id,user_id,app_type_id;
    String licence_type;

    public String getLicence_type() {
        return licence_type;
    }

    public void setLicence_type(String licence_type) {
        this.licence_type = licence_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getApp_type_id() {
        return app_type_id;
    }

    public void setApp_type_id(int app_type_id) {
        this.app_type_id = app_type_id;
    }
}
