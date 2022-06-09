import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WriteExcelATM {

    public static final int col_index_ngay = 1;
    public static final int col_index_mayATM = 2;
    public static final int col_index_soThe = 3;
    public static final int col_index_soGD = 4;
    public static final int col_index_soTK = 5;
    public static final int col_index_soTien = 6;
    public static final int col_index_soDu = 7;
    public static final int col_index_lePhi = 8;
    public static final int col_index_vat = 9;
    private static CellStyle cellStyleFormatNumber = null;

    public static void main(String[] args) throws IOException {
        final List<Trans> transList = getTransactions();
        final String excelFilePath = "books.xlsx";
        writeExcel(transList, excelFilePath);
    }

    private static List<Trans> getTransactions() {
        List<Trans> listTrans = new ArrayList<>();
        Trans transaction;
        for (int i = 1; i <= 5; i++) {
            transaction = new Trans("ATM001", "123456", ""+i, "123456789", 50000,50000,
            2000);
            listTrans.add(transaction);
        }
        return listTrans;
    }

    public static void writeExcel(List<Trans> listTransaction, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        Sheet sheet = workbook.createSheet("Trans");
        int rowIndex = 0;
        writeHeader(sheet,rowIndex);
        rowIndex++;
        for (Trans transaction : listTransaction) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeTransaction(transaction, row);
            rowIndex++;
        }

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
        //System.out.println("Done!!!");

    }

    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }


    private static void writeHeader(Sheet sheet, int rowIndex) {
        CellStyle cellStyle = createStyleForHeader(sheet);
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(col_index_ngay);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày giờ");

        cell = row.createCell(col_index_mayATM);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Máy ATM");

        cell = row.createCell(col_index_soThe);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số thẻ");

        cell = row.createCell(col_index_soGD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số GD");

        cell = row.createCell(col_index_soTK);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số TK");

        cell = row.createCell(col_index_soTien);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số Tiền");

        cell = row.createCell(col_index_soDu);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số dư");

        cell = row.createCell(col_index_lePhi);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Lệ Phí");

        cell = row.createCell(col_index_vat);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("VAT");

    }

    // Write data
    private static void writeTransaction(Trans transaction, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(col_index_ngay);
        cell.setCellValue(transaction.getNgay().toString());

        cell = row.createCell(col_index_mayATM);
        cell.setCellValue(transaction.getMayATM());

        cell = row.createCell(col_index_soThe);
        cell.setCellValue(transaction.getSoThe());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(col_index_soGD);
        cell.setCellValue(transaction.getSoGD());

        cell = row.createCell(col_index_soTK);
        cell.setCellValue(transaction.getSoTK());

        cell = row.createCell(col_index_soTien);
        cell.setCellValue(transaction.getSoTien());

        cell = row.createCell(col_index_soDu);
        cell.setCellValue(transaction.getSoDu());

        cell = row.createCell(col_index_lePhi);
        cell.setCellValue(transaction.getLePhi());

        cell = row.createCell(col_index_vat);
        cell.setCellValue(transaction.getVat());

        // Create cell formula
        // col_index_vat = col_index_soTien * 10%
        cell = row.createCell(col_index_vat, CellType.FORMULA);
        cell.setCellStyle(cellStyleFormatNumber);
        int currentRow = row.getRowNum() + 1;
        String columnSotien = CellReference.convertNumToColString(col_index_soTien);
        cell.setCellFormula(columnSotien + currentRow + "*0.1");
    }


    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private static Workbook getWorkbook(String excelFilePath) {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }
}
