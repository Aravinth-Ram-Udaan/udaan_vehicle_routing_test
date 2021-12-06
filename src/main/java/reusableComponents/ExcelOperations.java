package reusableComponents;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelOperations {
    String filepath;

    Sheet sh;

    public ExcelOperations(String sheetName) {
        try {
            filepath = System.getProperty("user.dir")+PropertiesOperations.getPropertyValueByKey("testDataLocation");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File testDataFile = new File(filepath);

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(testDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sh = wb.getSheet("Sheet1");
    }

    public HashMap<String, String> getTestDataInMap(int rowNum) throws IOException {

        HashMap<String, String> hm = new HashMap<String, String>();

        for(int i=0; i < sh.getRow(0).getLastCellNum(); i++) {
            sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
        }

        return hm;
    }

    public int getRowCount() {
        return sh.getLastRowNum();
    }

    public int getColCount() {
        return sh.getRow(0).getLastCellNum();
    }

}
