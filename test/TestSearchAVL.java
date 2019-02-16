import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestSearchAVL
{
	SearchAVL searchAVL = new SearchAVL();

	@Test
	public void testOpenPhoneDirectory()
	{
		searchAVL.openPhoneDirectory();
		searchAVL.openQueryList();
		searchAVL.setNumber();
		searchAVL.insert();
		searchAVL.find();
		searchAVL.delete();
	}
}