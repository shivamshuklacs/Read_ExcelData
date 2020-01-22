package com.mustang.service;

import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustang.models.Customers;
import com.mustang.repository.CustomerDTO;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDTO cdto;
	
	public void saveCustomer() {
		System.out.println("Hii");
		Customers customers=new Customers();
		try
        {
            FileInputStream file = new FileInputStream(new File("src\\main\\resources\\data.xlsx"));
 
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    switch (cell.getCellType()) 
                    {
                        case NUMERIC:
                       
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                       case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
