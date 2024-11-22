import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCsv {

    // Class & Method for wrtiting data from the linked list to the csv file
    public void writer1(linkedList lL){


    String csvFile = "src/CSVdemo.csv";

    BufferedWriter writer;


        try {
//           Initialise writer to write to csv
            writer = new BufferedWriter(new FileWriter(csvFile));

//          Node which is head of the list
            Node current = lL.getHead();

//            header of the list
            writer.write("id,Name,LastName,Email,Gender,IpAddress,Password \n");

            //Loop through linked list
            while(current != null){

                writer.write(current.uI.toString());
                writer.newLine();
                current=current.next;

            }

        }
        catch (IOException e) {

            System.out.println("Couldn't write to file");

            throw new RuntimeException(e);
        }
        try{
//          properly closing writer
                writer.flush();
                writer.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
