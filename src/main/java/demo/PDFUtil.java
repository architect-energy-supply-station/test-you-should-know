package demo;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/3 20:04
 */
public class PDFUtil {

    public PDFUtil(File file) {
//        设置页面大小
        document.setPageSize(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
        } catch (DocumentException e) {
        } catch (FileNotFoundException e) {
        }
    }

    int maxWidth = 520;


    Document document = new Document();

    //    设置字体大小
    private static Font headfont;
    //    设置字体大小
    private static Font keyfont;
    private static Font textfont;

    static {
        BaseFont bfChiense;
        try {
//            设置字体大小
            bfChiense = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            headfont = new Font(bfChiense, 10, Font.BOLD);
            keyfont = new Font(bfChiense, 8, Font.BOLD);
            textfont = new Font(bfChiense, 8, Font.NORMAL);
        } catch (DocumentException e) {
        } catch (IOException e) {
        }
    }

    public PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, Font font, int align, int colspan,boolean boderFlay) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlay) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        }
        return cell;
    }
    //    创建表的列号
    public PdfPTable createTable(int colNumber) {
        PdfPTable table = new PdfPTable(colNumber);
        table.setTotalWidth(maxWidth);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(1);
        return table;
    }



    public void generatePDF() throws DocumentException {
        PdfPTable table = createTable(4);
        table.addCell(createCell("学生信息列表:", keyfont, Element.ALIGN_LEFT, 4, false));
        table.addCell(createCell("姓名:", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("年龄:", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("性别:", keyfont, Element.ALIGN_CENTER));
        table.addCell(createCell("住址:", keyfont, Element.ALIGN_CENTER));
        for (int i = 0; i < 5; i++) {
            table.addCell(createCell("姓名" + i, textfont));
            table.addCell(createCell(i + 15 + "", textfont));
            table.addCell(createCell((i % 2 == 0) ? "男" : "女", textfont));
            table.addCell(createCell("地址" + i, textfont));
        }
        document.add(table);
        document.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File("D:\\text.pdf");
        file.createNewFile();
        new PDFUtil(file).generatePDF();
    }


}



