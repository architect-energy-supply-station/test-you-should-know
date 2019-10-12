import com.alibaba.excel.metadata.BaseRowModel;
import demo.EasyExcelUtil;
import model.Model;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/4 16:58
 */
public class EasyExcelUtilTest {
    @Test
    public void test_parse_excel() {
        Resource resource = new ClassPathResource("mm.xlsx");
        try {
            List<Model> list = (List<Model>) EasyExcelUtil.readExcelByModelSheetName(resource.getFile(), "Sheet1", Model.class);
            System.out.println(list);
//            Assert.assertEquals(list.size(),10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
