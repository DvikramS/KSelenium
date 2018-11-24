package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUitlity {
	
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow rw;
	public XSSFCell cl;
	
	public FileInputStream fs;
	public ExcelUitlity(String path){
		
		try {
			fs=new FileInputStream(path);
			wb=new XSSFWorkbook(fs);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getRowCount(String sheet){
		
		int n=wb.getSheetIndex(sheet);
		sh=wb.getSheetAt(n);
		return sh.getLastRowNum()+1;
		
	}
	public String getCellData(String sheet, String colname, int rownum ){
		int n=wb.getSheetIndex(sheet);
		sh=wb.getSheetAt(n);
		rw=sh.getRow(0);
		
		int colnum=-1;
		for(int i=0;i<rw.getLastCellNum();i++){
			if(rw.getCell(i).getStringCellValue().trim().equals(colname)){
				colnum=i;
				break;
			}
		}
		if(colnum==-1){
			return "col doesnot exist";
		}
		
		rw=sh.getRow(rownum-1);
		if(rw==null)
			return "";
		cl=rw.getCell(colnum);
		if(cl==null)
			return "";
if(cl.getCellType()==Cell.CELL_TYPE_STRING){
	return cl.getStringCellValue();
}
else if(cl.getCellType()==Cell.CELL_TYPE_BLANK)
    return "";
return colname +" "+ rownum +" "+"does not exist";

		
		
	}

	public String getCellData(String sheet, int colnum, int rownum ){
		int n=wb.getSheetIndex(sheet);
		sh=wb.getSheetAt(n);
		rw=sh.getRow(rownum-1);
		
		if(rw==null)
			return "";
		cl=rw.getCell(colnum-1);
		if(cl==null)
			return "";
		
		if(colnum==-1){
			return "col doesnot exist";
		}
		
		
if(cl.getCellType()==Cell.CELL_TYPE_STRING){
	return cl.getStringCellValue();
}
else if(cl.getCellType()==Cell.CELL_TYPE_BLANK)
    return "";
return colnum +" "+ rownum +" "+"does not exist";

		
		
	}

/*public static void main(String[] args) {
	ExcelUitlity x=new ExcelUitlity(".\\TestData.xlsx");
	System.out.println(x.getRowCount("TestCases"));
	System.out.println(x.getCellData("TestCases", "TestCase", 2));
	
}*/
}
