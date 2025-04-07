package org.justserve

import kotlin.Pair
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileInputStream
import java.io.FileOutputStream


//fun main() {
//    return
//}
//
//


class ExcelWorkbook(val filePath: String){
    private fun openWorkbook(): Pair<FileInputStream, Workbook>? {

        val fileExtension=filePath.split(".")[(filePath.split(".").size-1)]
        val fileInputStream=FileInputStream(filePath)
        if(fileExtension == "xlsx"){
            return Pair(fileInputStream, XSSFWorkbook(fileInputStream))
        }else if(fileExtension == "xls"){
            return Pair(fileInputStream, HSSFWorkbook(fileInputStream))
        }else{
            return null
        }
    }
    private fun getSheetNumber(sheetName:String, workbook: Workbook): Int{
        for(sheetsIndex in (0..< workbook.getNumberOfSheets())){
            val sheet=workbook.getSheetAt(sheetsIndex)
            if(sheet.sheetName==sheetName){
                return sheetsIndex
            }
        }
        return 0
    }


    fun editCell(sheetName:String, X:Int, Y:Int, value: String){
        val openWorkbookResults= openWorkbook() ?: return
        val fileInputStream=openWorkbookResults.first
        val workbook=openWorkbookResults.second

        val sheetNumber:Int=getSheetNumber(sheetName, workbook)
        val sheet=workbook.getSheetAt(sheetNumber)
        val row=sheet.getRow(Y)
        var cell=row.getCell(X)
        if(cell==null){
            cell=row.createCell(X)
        }
        cell.setCellValue(value)

        //save modified value to spreadsheet
        val fileOutputStream = FileOutputStream(filePath)
        workbook.write(fileOutputStream)
        fileOutputStream.close()
        //close connection to excel
        workbook.close()
        fileInputStream.close()
    }

    fun readCell(sheetName:String, X:Int, Y:Int):String?{
        val openWorkbookResults= openWorkbook() ?: return null
        val fileInputStream=openWorkbookResults.first
        val workbook=openWorkbookResults.second

        val sheetNumber:Int=getSheetNumber(sheetName, workbook)
        val sheet=workbook.getSheetAt(sheetNumber)
        val row=sheet.getRow(Y)
        var cell=row.getCell(X)
        if(cell==null){
            cell=row.createCell(X)
        }
        val cellValue = when (cell.cellType) {
            CellType.STRING -> cell.stringCellValue
            CellType.NUMERIC -> cell.numericCellValue.toString()
            CellType.BOOLEAN -> cell.booleanCellValue.toString()
            CellType.BLANK -> ""
            else -> ""
        }
        workbook.close()
        fileInputStream.close()
        return cellValue
    }



    fun printAllSheets(){
        val openWorkbookResults= openWorkbook() ?: return
        val fileInputStream=openWorkbookResults.first
        val workbook=openWorkbookResults.second

        //prints the table
        for(sheetsIndex in 0..(workbook.getNumberOfSheets()-1)){
            val sheet=workbook.getSheetAt(sheetsIndex)

            for(row in sheet){
                for (cell in row) {
                    val cellValue = when (cell.cellType) {
                        CellType.STRING -> cell.stringCellValue
                        CellType.NUMERIC -> cell.numericCellValue.toString()
                        CellType.BOOLEAN -> cell.booleanCellValue.toString()
                        CellType.BLANK -> ""
                        else -> ""
                    }
                    print(cellValue)
                }
                println()
            }
            workbook.close()
            fileInputStream.close()
        }
    }
}