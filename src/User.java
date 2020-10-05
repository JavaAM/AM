import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {


    String firstName;
    String lastName;
    int age;
    String email;
    LocalDateTime timestamp;

    enum Status {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        NEW,
    }

    public Status status;


    public User(String firstName, String lastName, int age, String email, Status status, LocalDateTime timestamp) {

        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.timestamp = timestamp;


    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Users:FirstName =" + firstName + ";LastName = " + lastName + ";Age = " + 22 + ";Email = " + email + ";Status = "
                + status + ";TimeStamp = " + timestamp;
    }

    public static class Application {
        public static void main(String args[]) {

            ArrayList<User> ListUser = new ArrayList<>();
            ListUser.add(new User("Corlăteanu", "Alexandru", 22, "sandusandu@yahoo.com", Status.ACTIVE, LocalDateTime.now()));
            ListUser.add(new User("Tofan", "Marcel", 30, "matcelT@yahoo.com", Status.NEW, LocalDateTime.now().minusDays(1)));
            ListUser.add(new User("Furtună", "Zina", 30, "Furtună@yahoo.com", Status.INACTIVE, LocalDateTime.now()));
            ListUser.add(new User("Vulpe", "Alina", 20, "Alina@yahoo.com", Status.INACTIVE, LocalDateTime.now().minusMonths(2)));
            ListUser.add(new User("Tofan", "Ion", 30, "IonTof@yahoo.com", Status.NEW, LocalDateTime.now().minusDays(3)));


            for (User user : ListUser) {
                if (register(user)) {
                    user.setStatus(Status.ACTIVE);
                }
                if (minusMonth(user)){
                     user.setStatus(Status.BLOCKED);
                }
                System.out.println(user);
            }



        }

        public static boolean register (User user){
          return   user.getStatus().equals(Status.NEW) && user.getTimestamp().isBefore(LocalDateTime.now().minusDays(1));


        }

        public  static  boolean minusMonth(User user){
           return user.getStatus().equals(Status.INACTIVE) && user.getTimestamp().isBefore(LocalDateTime.now().minusMonths(1));

        }



    }
}