import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestSearchIt
{
	SearchIt searchIt = new SearchIt();

	@Test
	public void testOpenPhoneDirectory()
	{
		searchIt.openPhoneDirectory();
		searchIt.openQueryList();
		searchIt.setNumber();
		searchIt.insert();
		searchIt.find();
		searchIt.delete();
	}
}