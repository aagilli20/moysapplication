/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moysapplication.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Andrés Gilli <agilli@santafe.gov.ar>
 */
public class readExcel {
    
    private final String server;
    // private String idSQL;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private URL myURL;
    
    public readExcel(){
        // this.server = "http://sigaeintranet.dpi.sfnet/IsiemeWeb/verExcel/";
        this.server = "https://app.santafe.gov.ar/isieme/verExcel/";
    }
    
    public ArrayList getArrayList(int idSQL, String Parametros) throws MalformedURLException, IOException{
        ArrayList<ArrayList> Resul = new ArrayList<>();
        myURL = new URL(this.server+"?idSQL="+idSQL+Parametros); 
        try (InputStream file = myURL.openStream()) {
            this.workbook = new HSSFWorkbook(file);
            this.sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                ArrayList<String> Fila = new ArrayList<>();
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next(); 
                    /*
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                    */
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    // System.out.print(cell.getStringCellValue() + "\t\t");
                    Fila.add(cell.getStringCellValue());
                }
                // System.out.println("");
                Resul.add(Fila);
            }       
        }
    return Resul; 
    }
    
}
