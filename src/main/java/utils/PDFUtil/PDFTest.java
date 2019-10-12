package utils.PDFUtil;

import java.io.File;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-04
 */
public class PDFTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\ text.pdf");
        file.createNewFile();
        new PDFReport(file).generatePDF();
    }
}
