import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
	SearchAVL is an application that takes in a single name and returns the full contact details of the person if they are in the phone
	directory or returns Not found it also deletes and inserts the phone directory details into the tree

	@author Tumelo Lephadi
	@version 10 April 2017
*/
public class SearchAVL
{
	Scanner scanner0 = null, scanner1 = null, scanner2 = null;
	int amountOfData = 0;
	String fullName = "", fullEntry = "", temporary = "", queryList = "names", phoneDirectory = "yellowpages", query = "";
	AVLTree<String> avlTree = new AVLTree<String>();

	public void openPhoneDirectory()
	{
		try
		{
			scanner1 = new Scanner(new FileInputStream(phoneDirectory));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	public void openQueryList()
	{
		try
		{
			scanner2 = new Scanner(new FileInputStream(queryList));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

 	public void setNumber()
  	{
    	scanner0 = new Scanner(System.in);
    	System.out.println("Enter the amount of data you want to add to the tree: ");
    	amountOfData = scanner0.nextInt();
  	}

	public void insert()
	{
		openPhoneDirectory();
		for (int i = 0; i < amountOfData; i++)
		{
			temporary = scanner1.nextLine();
			fullName = temporary.substring(temporary.lastIndexOf("|") + 1);
			fullEntry = temporary;
			avlTree.insert(fullName, fullEntry);
		}
	}

	public void find()
	{
		openQueryList();
		while(scanner2.hasNext())
		{
			query = scanner2.nextLine();
			if (avlTree.find(query) == null)
				System.out.println("Not found");
			else
				System.out.println(avlTree.find(query).data2);
		}
	}

	public void delete()
	{
		openQueryList();
		while(scanner2.hasNext())
		{
			query = scanner2.nextLine();
			avlTree.delete(query);
		}
	}

	public static void main(String[] args)
	{
		SearchAVL searchAVL = new SearchAVL();
		PrintIt printIt = new PrintIt();
		printIt.setNumber();
		printIt.openPhoneDirectory();
		printIt.writeToQueryList();
		searchAVL.setNumber();
		searchAVL.openPhoneDirectory();
		searchAVL.openQueryList();
		searchAVL.insert();
		searchAVL.find();
	}

}