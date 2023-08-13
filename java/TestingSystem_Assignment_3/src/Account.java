import java.time.LocalDate;
import java.util.Arrays;

public class Account {
    int id;
    String email;
    String username;
    String fullname;
    Department department;
    Position position;
    LocalDate createDate;
    Group[] groups;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
