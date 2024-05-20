
package pdf;

/**
 *
 * @author MATOSHRI
 */
public class FullName
{
    String firstName,middleName,lastName;

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
}