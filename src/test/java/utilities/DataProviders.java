package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="LoginData")
    public String[][] getData(){
        String path = ".\\testData\\TestData.xlss";
        ExcelUtilities e = new ExcelUtilities();

        return new String[0][];
    }
}
