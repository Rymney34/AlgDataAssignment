import java.util.Scanner;

public class addToLinkedList {


    linkedList  lL = new linkedList(); //create new linked list
    String[] fields;// array to store user info
    public void addToList(Scanner scn){

    //read input line and split by comma
        String line = scn.nextLine();

        fields = line.split(",");

//      adding info to individual field
        String id = fields[0].trim();
        String name = fields[1];
        String lastName = fields[2];
        String email = fields[3];
        String gender = fields[4];
        String ipAddress = fields[5];
        String password = fields[6];

//      create UserInfo object and adding to linked list
        UserInfo uI = new UserInfo(id, name, lastName,email, gender, ipAddress, password);
        lL.add(uI);
    }


//    Function were loop through linked list and then prints into console
    public void printList(){
        System.out.println("id,Name,LastName,Email,Gender,IpAddress,Password,");
        for(int i = 0; i < lL.size(); i++){
            UserInfo ui = lL.get(i);
            String info = ui.toString();
            System.out.println(info);

        }

    }

}
