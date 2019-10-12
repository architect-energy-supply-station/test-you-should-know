package utils.ExcelUtil;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-04
 */
public class EasyExcelUtil {
    private EasyExcelUtil(){

    }

    private static Sheet initSheet;

    static{
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    /***
     * 读小于1000行数据
     * @param filePath
     * @return
     */
    public static List<Object> readLessThan1000Row(String filePath) {
        return readLessThan1000RowBySheet(filePath, null);
    }

    public static List<Object> readLessThan1000RowBySheet(String filePath, Sheet sheet) {

        sheet = sheet != null ? sheet : initSheet;
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            return EasyExcelFactory.read(fileStream, sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件路径");
        }finally {
            if (fileStream!=null) {
                try {
                    fileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件读取失败");
                }
            }
        }
        return null;
    }

    public static List<Object> readMoreThan1000RowsBySheet(String filePath, Sheet sheet) {
        sheet = sheet != null ? sheet : initSheet;
        FileInputStream fileStream = null;

        try {
            fileStream=new FileInputStream(filePath);
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(fileStream,sheet,excelListener);
            return excelListener.datas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件位置没有找到");
        }finally {
            try {
                fileStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void writeBySimple(String filePath,List<List<Object>> data,List<String> head) {
        writeSimpleSheet(filePath,data,head,null);
    }


    public static void writeSimpleSheet(String filePath,List<List<Object>> data, List<String> head, Sheet sheet) {
        sheet = sheet != null ? sheet : initSheet;
        if (head!=null) {
            final List<List<String>> list = new ArrayList<List<String>>();
            head.forEach(h -> list.add(Collections.singletonList(h)));
            sheet.setHead(list);
        }


        FileOutputStream outputStream = null;
        ExcelWriter writer = null;

        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data,sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (writer!=null) {
            writer.finish();
        }

        if (outputStream!=null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeWithTemplate(String filePath, List<? extends BaseRowModel> data){
        writeWithTemplateAndSheet(filePath,data,null);
    }

    /**
     * 导出excel
     */
    public static void writeWithTemplateAndSheet(String filePath, List<? extends BaseRowModel> data , Sheet sheet) {

        if (CollectionUtils.isEmpty(data)) {
            return;
        }

        sheet = sheet == null ? initSheet : sheet;
        sheet.setClazz(data.get(0).getClass());

        FileOutputStream outputStream = null;
        //获取流
        try {
           outputStream = new FileOutputStream(filePath);
            // 写入器 写入到excel
            ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
            writer.write(data, sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 关闭流
        if (outputStream==null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("excel文件导出失败,原因："+e);
            }
        }
   }


    public static void writeWithMultipleSheet(String filePath, List<MultipleSheelProperty> multipleSheetPropertys) {
        if (CollectionUtils.isEmpty(multipleSheetPropertys)) {
            return;
        }

        OutputStream outputStream = null;
        ExcelWriter writer=null;

        try {
            outputStream= new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);

            for (MultipleSheelProperty multipleSheetProperty : multipleSheetPropertys) {
                Sheet sheet = multipleSheetProperty.getSheet() != null ? multipleSheetProperty.getSheet() : initSheet;
                if (!CollectionUtils.isEmpty(multipleSheetProperty.data)) {
                    sheet.setClazz(multipleSheetProperty.data.get(0).getClass());
                }
                writer.write(multipleSheetProperty.data, sheet);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (writer!=null) {
                        writer.finish();
                    }
                    if (outputStream!=null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    @Data
    public static class MultipleSheelProperty{
        private List<? extends BaseRowModel> data;

        private Sheet sheet;

        public Sheet getSheet() {
            return sheet;
        }

        public void setSheet(Sheet sheet) {
            this.sheet = sheet;
        }
    }

    public static class ExcelListener extends AnalysisEventListener {

        private List datas = new ArrayList();
        @Override
        public void invoke(Object object, AnalysisContext analysisContext) {
            if (object!=null) {
                datas.add(object);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        }
    }


}
