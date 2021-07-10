package apache.poi;

import Utils.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelIntro {

    @Test
    public void test1() throws IOException {

        File excelFile = new File("src/test/resources/Test.xlsx");
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row1 = sheet.getRow(0);
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);



    }

    @Test
    public void getDataFromRawTest() throws IOException {

        File file = new File("src/test/resources/Test.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);

        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++){
            System.out.print(row.getCell(i)+" | ");
        }
    }

    @Test
    public void utilsTest(){
        XSSFSheet sheet = FileUtils.openExcelSheet("TestData", "Sheet1");
        Map<Integer, List<Cell>> data = FileUtils.getAllDataFromSheet(sheet);
        System.out.println(data);

    }

    @Test
    public void utilTest2(){
        XSSFSheet sheet = FileUtils.openExcelSheet("TestData","Sheet1");
        List<Cell> rowData = FileUtils.getDataFromRow(sheet,2);
        System.out.println(rowData);
    }

}
