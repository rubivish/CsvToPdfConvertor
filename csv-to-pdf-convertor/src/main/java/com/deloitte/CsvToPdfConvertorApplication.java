package com.deloitte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class CsvToPdfConvertorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CsvToPdfConvertorApplication.class, args);

		ArrayList<String> array = new ArrayList<String>();
		String path = ("C:\\META_24_06_2022.csv");
		String line = "";
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(path));

			while ((line = buffer.readLine()) != null) {
				String[] values = line.split(",");
				array.add(values[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 1; i < array.size(); i++) {

			try {

//				Document document = new Document();
//
//				PdfWriter.getInstance(document, new FileOutputStream("C:\\GeneratedPDF\\" + array.get(i)));
//
//				document.open();
				
				File file = new File("C:/AWCFPCIM20220622012345601F0123124.pdf");
				FileOutputStream out = new FileOutputStream("C://generatedPdf.zip");
			    ZipOutputStream zout = new ZipOutputStream(out);
				OutputStream outputStream;
				try {
					FileInputStream inputStream = new FileInputStream(file);
					 outputStream = new FileOutputStream("C:\\GeneratedPDF\\" + array.get(i));
					byte[] buffer = new byte[8192];
					int j = 0;
					while ((j = inputStream.read(buffer, 0, buffer.length)) > 0) {
						outputStream.write(buffer, 0, j);
						outputStream.flush();
					}
					

				    for(int k = 1; k < array.size() ; k++) {
				        byte[] documentBytes =  "12345".getBytes();
				        ZipEntry zip = new ZipEntry(k+".pdf");
				        zout.putNextEntry(zip);
				        zout.write(documentBytes);
				        zout.closeEntry();
				    }

				    zout.close();   
					
					outputStream.close();
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
		
		}
	}
}

	

