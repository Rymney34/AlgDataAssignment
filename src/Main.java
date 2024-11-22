import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);
    static linkedList lL = new linkedList();

    static WriteToCsv wCsv= new WriteToCsv();

    static addToLinkedList addToList = new addToLinkedList();

    public static void main(String[] args) {


        ReadingCSV rs = new ReadingCSV();

        System.out.println("Welcome to the app");

        int num;
        while (true) {
            System.out.println("");
            System.out.println("What would you like to perform ");
            System.out.println("1) Search user by certain id?");
            System.out.println("2) Delete User by Name and Surname");
            System.out.println("3) Adding user");
            System.out.println("4) Sorting users by userId in descending order");
            System.out.println("Please enter your required number 1 - 4");


            num = scn.nextInt();
//          CSV file reader
            rs.readingFile();

            switch (num){
                case 1:
                    searchMethod();
                    rs.readingFile();
                break;
            case 2:
                rs.readingFile();
                deletion();
                break;

            case 3:
                insertingUserMethod();
                break;

            case 4:

                System.out.println(" ");

                sortingMethod();

                addToList.printList();
                lL.display();

                break;
                case 0:
                    System.out.println("Closing the program");
                    return;


            default:
                System.out.println("Invalid input");
            }

        }

    }

//    method to search id with user interaction logic
    public static void searchMethod(){
        String targetId = "";

        while(true) {
            System.out.println("Please enter user id from 0 to n");

            if (scn.hasNextInt()) {
                int idTarget = scn.nextInt();


                if(idTarget >0){
                    targetId = String.valueOf(idTarget);
                    break;
                }
                else{
                    System.out.println("Please enter positive number");
                }
            }
            else{
                System.out.println("Invalid input, Please try again");
                scn.next();
            }

        }


        UserInfo result = lL.search(targetId);

        System.out.println("\n Reserach result " + result + "\n");
    }

    //    method to delete user(Customer) with user interaction logic
        public static void deletion() {


        String name;
        String surname;
        scn.nextLine();
        while (true) {
            System.out.println("\nPlease enter required details to delete a user\n");


            System.out.println("Please enter name");
            name = scn.nextLine();

            System.out.println("Please enter last name");
            surname = scn.nextLine();

            if (surname.isBlank() || name.isBlank()) {
                System.out.println("Invalid input, can't leave empty");
            } else {

                break;

            }

        }

        UserInfo delRes = lL.deletion(name, surname);


        System.out.println("\nYour del res " + delRes + "\n");

        System.out.println("Would you like to delete this record(Node) and rewrite CSV file? y/n");

        String yes = scn.nextLine();

        if (yes.equals("y") || yes.equals("Y") || yes.equals("yes")) {
            lL.deleteNode(delRes);
            lL.display();
            wCsv.writer1(lL);
            System.out.println("\nCsv was successfully overwritten");
        } else {

        }

    }

//    sorting in descending order callback
    public static void sortingMethod(){

        lL.descendingSortId();
    }

//method to insert custom data to the end of the list
    public static void insertingUserMethod() {

        String name, lastName, email, gender, ipAddress, password;
        int users = 0;
        while (true) {
            System.out.println("\nHow many user you would like to add?");

            if (scn.hasNextInt()) {
                users = scn.nextInt();
                if (users > 0) {
                    break;
                } else {
                    System.out.println("Please enter positive number");
                }
            } else {
                System.out.println("Invalid input, Please try again");
                scn.next();
            }

        }
        for (int i = 0; i < users; i++) {

            scn.nextLine();

            System.out.println("Please enter details to create new customer \n");

            System.out.println("Please enter name ");
            name = scn.nextLine();

            System.out.println("Please enter last name ");
            lastName = scn.nextLine();

            System.out.println("Please enter email");
            email = scn.nextLine();

            System.out.println("please enter gender");
            gender = scn.nextLine();

            System.out.println("Please input ip address");
            ipAddress = scn.nextLine();

            System.out.println("Please password");
            password = scn.nextLine();

            String id = lL.increaseUserId();


            UserInfo uI = new UserInfo(id, name, lastName, email, gender, ipAddress, password);


            lL.insertAtEnd(uI);

        }

        wCsv.writer1(lL);

    }

}
