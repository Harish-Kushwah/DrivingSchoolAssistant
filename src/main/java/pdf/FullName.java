
package pdf;

import javaswingdev.system.SystemStrings;
import model.entity.User;

/**
 *
 * @author MATOSHRI
 */
public class FullName
{
    String firstName,middleName,lastName;
    String fullName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public FullName(String fullName)
    {
        String names[] = fullName.split("\\s+");
        if(names.length==2)
        {
            this.firstName=names[0];
            this.lastName=names[1];
        }
        else if(names.length==3)
        {
            this.firstName=names[0];
            this.middleName=names[1];
            this.lastName=names[2];
        }
    }
    
    public FullName(User user)
    {
        if(!user.getFirstName().equals(SystemStrings.FIRST_NAME)){
            this.fullName += user.getFirstName();
        }
        if(!user.getMiddleName().equals(SystemStrings.MIDDLE_NAME)){
            this.fullName += user.getMiddleName();
        }
        if(!user.getFirstName().equals(SystemStrings.LAST_NAME)){
            this.fullName += user.getLastName();
        }
    }
    public String getFullName()
    {
        return this.fullName;
    }
}