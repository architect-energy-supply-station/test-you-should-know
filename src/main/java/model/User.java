package model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/5 8:28
 */
@Data
public class User {
    private int id;
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

}
