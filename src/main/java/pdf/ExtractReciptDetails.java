package pdf;

import model.entity.Recipt;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

public class ExtractReciptDetails {

    public static Recipt getApplicationsDetails(File file, int page_no) {
        Recipt application = new Recipt();
        try {
            PDDocument document = Loader.loadPDF(file);

            ObjectExtractor oe = new ObjectExtractor(document);

            SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm(); // Tabula algo.

            Page page = oe.extract(page_no); // extract only the first page
   
            for (int table_no = 0; table_no < sea.extract(page).size(); table_no++) {
             //   System.out.println("table: " + table_no);
                Table table = sea.extract(page).get(table_no);

                for (int col_no = 0; col_no < table.getColCount(); col_no++) {

                    for (int row_no = 0; row_no < table.getRowCount(); row_no++) {

                        String res = table.getCell(row_no, col_no).getText();
                        //    System.out.println("table :" + table_no + "col:" + col_no + "/lin:x " + row_no + "length : " +res.length() +" >> " + res);

                        //get text from the table 0
                        if (res.length() != 0) {
                            switch (table_no) {
                                case 0 -> {
                                    switch (col_no) {
                                        case 0 -> {

                                            switch (row_no) {

                                                case 5 -> {

                                                    application.setLicenceTypeAndNo(res);
                                                }
                                            }

                                        }
                                        case 1 -> {
                                            switch (row_no) {
                                                case 0 ->
                                                    application.setOfficeName(res);
                                                case 1 ->
                                                    application.setApllicantName(res);
                                                case 2 ->
                                                    application.setDOB(res);
                                                case 3 ->
                                                    application.setDate(res);
                                                case 4 ->
                                                    application.setApplicationNo(res);

                                            }
                                        }
                                        case 3 -> {
                                            switch (row_no) {
                                                case 0 ->
                                                    application.setReceiptDate(res);
                                                case 1 ->
                                                    application.setReceiptNo(res);
                                                case 2 ->
                                                    application.setBankGateway(res);
                                                case 3 ->
                                                    application.setBankReferenceNo(res);
                                                case 4 ->
                                                    application.setTransactionID(res);
                                            }
                                        }
                                    }
                                }
                                case 1 -> {
                                    //get text from the table
                                    if (col_no == 0 && row_no == 1) {
                                        application.setReciptTransactionType(res);
                                    }
                                    if (col_no == 1 && row_no == 1) {
                                        application.setCOV(res);
                                    }
                                }
                            }

                        }
                    }
                }
            }
        } catch (NoSuchFileException exp) {
            System.out.println("File Not Found");
        } catch (IndexOutOfBoundsException exp) {
            System.out.println(exp.getMessage());
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return application;
    }

//    public static void main(String[] args) throws IOException {
//
//        File file = new File("./recipts/dl.pdf");
//        System.out.println(getApplicationsDetails(file, 1));
//    }
}
