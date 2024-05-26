package model.entity;

/**
 *
 * @author haris
 */
public class Enrollment {
    private int id;
    private String enrollmentNumber;  
    private int applicationCOVid;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public int getApplicationCOVid() {
        return applicationCOVid;
    }

    public void setApplicationCOVid(int applicationCOVid) {
        this.applicationCOVid = applicationCOVid;
    }
}
