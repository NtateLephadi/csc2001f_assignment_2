import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

public class TestPrintIt
{
	PrintIt printIt = new PrintIt();

	@Test
	public void printIt()
	{
		printIt.openPhoneDirectory();
		printIt.writeToQueryList();
		printIt.setNumber();
	}
}