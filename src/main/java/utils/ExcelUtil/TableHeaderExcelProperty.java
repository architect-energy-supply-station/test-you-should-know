package utils.ExcelUtil;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TableHeaderExcelProperty extends BaseRowModel {

    @ExcelProperty(value="姓名",index=0)
    private String name;

    @ExcelProperty(value="年龄",index=1)
    private int age;

    @ExcelProperty(value="学校",index=2)
    private String school;
}
