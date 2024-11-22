public class UserInfo {

//    initialising variables
    String id;

    String name;

    String lastName;

    String email;

    String gender;

    String ipAddress;

    String password;

//    constructor method
    public UserInfo(String id, String name,String lastName,String email, String gender, String ipAddress, String password){
        this.id= id;
        this.name= name;
        this.lastName = lastName;
        this.email = email;
        this.gender=gender;
        this.ipAddress = ipAddress;
        this.password = password;

    }


    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getGender(){
        return gender;
    }

//    to string formatting to print or write list in this order

    public String toString() {
        return id + "," + name + "," + lastName+"," + email+","+ gender+"," + ipAddress+"," + password;
    }


}
