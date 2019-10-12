package utils.ExcelUtil;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.Sheet;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-04
 */
public class ExcelTest {
    public static void main(String[] args) {


        // 01 读取少于1000行的excle
        String filePath = "D:\\testExcel.xlsx";
        List<Object> objects = EasyExcelUtil.readLessThan1000Row(filePath);
        for (Object object : objects) {
            System.out.println(object);
        }

        //02 读取少于1000行的excle，可以指定sheet和从几行读起
//
//        String filePath = "D:\\testExcel.xlsx";
//       Sheet sheet = new Sheet(5,2);
//        List<Object> objects = EasyExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
//        for (Object object : objects){
//            System.out.println(object);
//        }

        //03 生成excel
//        String filePath = "D:\\testExcelExport.xlsx";
//        List<List<Object>> data = new ArrayList<List<Object>>();
//        data.add(Arrays.asList("111", "222", "333"));
//        data.add(Arrays.asList("111", "222", "333"));
//        data.add(Arrays.asList("111", "222", "333"));
//
//        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
//        EasyExcelUtil.writeBySimple(filePath,data,head);
//    }

        // 04 生成excel，代用模型
//    String filePath = "D:\\testExcelExport1.xls";
//
//    ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
//        for (int i = 0; i <4 ; i++) {
//            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
//            tableHeaderExcelProperty.setName("xiaoming"+i);
//            tableHeaderExcelProperty.setAge(22+i);
//            tableHeaderExcelProperty.setSchool("清华"+i);
//            data.add(tableHeaderExcelProperty);
//        }
//
//        EasyExcelUtil.writeWithTemplate(filePath,data);


        // 05 生成excel带用模型
//        String filePath = "D:\\testExcelExport2.xls";
//        ArrayList<EasyExcelUtil.MultipleSheelProperty> list1 = new ArrayList<>();
//        for (int j = 1; j < 4; j++) {
//            ArrayList<TableHeaderExcelProperty> list = new ArrayList<>();
//            for (int i = 0; i < 4; i++) {
//                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
//                tableHeaderExcelProperty.setName("cmj" + i);
//                tableHeaderExcelProperty.setAge(22 + i);
//                tableHeaderExcelProperty.setSchool("清华大学" + i);
//                list.add(tableHeaderExcelProperty);
//            }
//
//            Sheet sheet = new Sheet(j, 0);
//            sheet.setSheetName("sheet" + j);
//
//            EasyExcelUtil.MultipleSheelProperty multipleSheelPropety = new EasyExcelUtil.MultipleSheelProperty();
//            multipleSheelPropety.setData(list);
//            multipleSheelPropety.setSheet(sheet);
//
//            list1.add(multipleSheelPropety);
//        }
//        EasyExcelUtil.writeWithMultipleSheet(filePath, list1);
   }
}