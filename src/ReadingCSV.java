import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Period;
import java.util.Iterator;
import java.util.LinkedList;
import  java.util.Scanner;

public class ReadingCSV {

//    Function that reads Csv file
    public static void readingFile() {
//
        try {
//Scanning csv file
            Scanner scn = new Scanner(new File("src/CSVdemo.csv"));

//          if something in csv it will print line
            if(scn.hasNext()) {

                scn.nextLine();
            }
//          initialising addToLinkedList
            addToLinkedList addList = new addToLinkedList();

//          loop that add info from scn(csv) to linked list
            while(scn.hasNext()){

                addList.addToList(scn);
            }

            scn.close();

//            addList.printList();

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}


