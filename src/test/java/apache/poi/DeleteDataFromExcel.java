package apache.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class DeleteDataFromExcel {


    @Test
    public void deleteTest() throws IOException {
        File file = new File("src/test/resources/Test.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(3);
        XSSFCell cell = row.getCell(0);
        row.removeCell(cell);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/test/resources/Test.xlsx"));
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }

}
