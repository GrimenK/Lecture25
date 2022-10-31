import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reader.MyCSVReader;

import java.util.Iterator;

public class BaseTest {


    @Test(dataProvider = "csvProvider", priority = 1)
    public void firstTest(String a, String b){
        Assert.assertTrue(a.contains(b));
    }

    @Test(priority = 2)
    @Parameters({"a","b"})
    public void secondTest(String a, String b){
        Assert.assertEquals(Integer.parseInt(b), Integer.parseInt(a));

    }


    @DataProvider(name = "csvProvider")
    public Iterator<Object[]> dataset(){
        return new MyCSVReader().readCsv(JSONReader.get("data"));
    }
}
