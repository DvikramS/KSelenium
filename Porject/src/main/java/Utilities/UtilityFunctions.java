package Utilities;

import java.util.Hashtable;

public class UtilityFunctions {
	//public ExcelUitlity xl;
	
	public static boolean isExecutable(String TestName,ExcelUitlity xl){
		for(int i=2;i<=xl.getRowCount("TestCases");i++){
			if(TestName.equals(xl.getCellData("TestCases", "TestCase", i))){
				if(xl.getCellData("TestCases", "RunMode", i).equals("Y")){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static Object[][] getData(String TestName, ExcelUitlity xl){
		int row=0;
		for(int i=1;i<=xl.getRowCount("TestData1");i++){
			if(xl.getCellData("TestData1", 1, i).equals(TestName)){
				row=i;
				break;
			}
		}
		int headerrow=row+1;
		
		int col=2;
		while(!(xl.getCellData("TestData1", col, headerrow).equals(""))){
			col++;
		}
		int headercount=col-2;
		
		int rowcount1=headerrow+1;
		int rowcount=0;
		while(!(xl.getCellData("TestData1", 2, rowcount1+rowcount).equals(""))){
			rowcount++;
		}
		int testdataset=rowcount;
		Object[][]obj=new Object[testdataset][1];
		int index=0;
		String datavalue="";
		String keyvalue="";
		for(int i=headerrow;i<(headerrow+testdataset);i++){
			Hashtable hs=new Hashtable();
			for(int j=2;j<(2+headercount);j++){
				keyvalue=xl.getCellData("TestData1", j, headerrow);
				datavalue=xl.getCellData("TestData1", j, i+1);
				hs.put(keyvalue, datavalue);
			}
			obj[index][0]=hs;
			index++;
		}
		return obj;
		
		
	}
	
	
	/*public static void main(String[] args) {
		UtilityFunctions u=new UtilityFunctions();
		ExcelUitlity xl=new ExcelUitlity(".\\TestData.xlsx");
	//	System.out.println(u.isExecutable("Test", xl));
		Object[][]a=u.getDataforDataProvider("VerifyLogin", xl);
		System.out.println("ss");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}*/

}
