package apache.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Homework {

    @Test
    public void getRegionColumn() throws IOException {

        File file = new File("src/test/resources/TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");


        int totalRaws = sheet.getPhysicalNumberOfRows();
        for(int i = 0; i < totalRaws ; i++){
            Row currentRow = sheet.getRow(i);
            for(int j = currentRow.getFirstCellNum(); j<currentRow.getLastCellNum();j++){
                if(j == 4){
                    System.out.println(currentRow.getCell(j));
                }
            }
        }


    }

    @Test
    public void getInfoAboutNY() throws IOException {
        File file = new File("src/test/resources/TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Map<String, List<Object>> newYork = new LinkedHashMap<>();


        int totalRaws = sheet.getPhysicalNumberOfRows();
        for(int i = 0; i < totalRaws ; i++){//getting into every raw
            Row currentRow = sheet.getRow(i);
            for(int j = currentRow.getFirstCellNum(); j<currentRow.getLastCellNum();j++){//getting into every cell
                Cell newYorkCell = currentRow.getCell(3);//get cell with State

                if(newYorkCell.getStringCellValue().equals("NY")){//get value withing cell with State
                    List<Object> listFromMap = new ArrayList<>();//creating a list inside this inner for loop, because we need it to be refreshed on the next loop
                    listFromMap.add(currentRow.getCell(1));
                    listFromMap.add(currentRow.getCell(2));
                    listFromMap.add(currentRow.getCell(3));
                    listFromMap.add(currentRow.getCell(4));
                    listFromMap.add(currentRow.getCell(5));
                    listFromMap.add(currentRow.getCell(6));
                    listFromMap.add(currentRow.getCell(7));
                    listFromMap.add(currentRow.getCell(8));
                    listFromMap.add(currentRow.getCell(9));
                    //one list with all info about row with NY state is ready we can start adding it into a map
                    newYork.put(currentRow.getCell(0).getStringCellValue(),listFromMap);

                }

            }



        }
        System.out.print(newYork);



    }

}
