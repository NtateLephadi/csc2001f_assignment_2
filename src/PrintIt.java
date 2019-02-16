import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.Writer;

/**
  PrintIt.java is an application which prints out a number of items in a list
  and writes these names into a File

  @author Tumelo Lephadi
  @version 15 April 2017
*/

public class PrintIt
{
  Scanner scanner, scanner1;
  int numberOfNames = 0;
  String name, queryList = "names";
  String phoneDirectory = "yellowpages";

  public void openPhoneDirectory()
  {
    try
    {
      scanner = new Scanner(new FileInputStream(phoneDirectory));
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }
  }

  public void writeToQueryList()
  {
    try
    {
      FileOutputStream fileOutputStream = new FileOutputStream(queryList);
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
      Writer writer = new BufferedWriter(outputStreamWriter);
      openPhoneDirectory();
        for (int i = 0; i < numberOfNames; i++)
        {
          name = scanner.nextLine();
          name = name.substring(name.lastIndexOf("|") + 1);
          writer.write(name + "\n");
        }
        writer.close();
    }
    catch(IOException ioe)
    {
      System.out.println(ioe);
    }
  }

  public void setNumber()
  {
    scanner1 = new Scanner(System.in);
    System.out.println("Enter the number of names you want to add to a query list: ");
    numberOfNames = scanner1.nextInt();
  }
}