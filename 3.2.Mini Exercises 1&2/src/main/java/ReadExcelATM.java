import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelATM {
    public static final int col_index_ngay = 1;
    public static final int col_index_mayATM = 2;
    public static final int col_index_soThe = 3;
    public static final int col_index_soGD = 4;
    public static final int col_index_soTK = 5;
    public static final int col_index_soTien = 6;
    public static final int col_index_soDu = 7;
    public static final int col_index_lePhi = 8;
    public static final int col_index_vat = 9;

    public static List<Trans> readExcel(String excelFilePath) throws IOException {
        List<Trans> listTrans = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            Trans trans = new Trans();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case col_index_ngay:
                        trans.setNgay(LocalDateTime.parse((String) getCellValue(cell)));
                        break;
                    case col_index_mayATM:
                        trans.setMayATM((String) getCellValue(cell));
                        break;
                    case col_index_soThe:
                        trans.setSoThe((String) getCellValue(cell));
                        break;
                    case col_index_soGD:
                        trans.setSoGD((String) getCellValue(cell));
                        break;
                    case col_index_soTien:
                        trans.setSoTien((double) getCellValue(cell));
                        break;
                    case col_index_soDu:
                        trans.setSoDu((double) getCellValue(cell));
                        break;
                    case col_index_lePhi:
                        trans.setLePhi((double) getCellValue(cell));
                        break;
                    case col_index_vat:
                        trans.setVat((double) getCellValue(cell));
                        break;
                    default:
                        break;
                }

            }
            listTrans.add(trans);
        }

        workbook.close();
        inputStream.close();

        return listTrans;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }

    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

}
