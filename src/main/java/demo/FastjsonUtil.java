//package demo;
//import	java.util.ArrayList;
//import	java.util.List;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.PropertyFilter;
//import com.alibaba.fastjson.serializer.SerializeFilter;
//import model.User;
//
//import java.util.Date;
//
///**
// * @author 任蒙蒙
// * @version 1.0.0
// * @since 2019/10/5 8:28
// */
//public class FastjsonUtil {
//    @Test
//    public void testOne() {
//        User user = new User();
//        user.setBirthday(new Date());
//        user.setId(1);
//        user.setName("tom");
//
////        属性在json中是否生成
//        SerializeFilter filter = new PropertyFilter() {
//            @Override
//            public boolean apply(Object o, String s, Object o1) {
//                if (s.equals("id")) {
//                    return false;
//                }
//                return true;
//            }
//        };
//        String json = JSONObject.toJSONString(user, filter);
//        System.out.println(json);
//
//    }
//
//    @Test
//    public void testTwo() {
//        User user = new User();
//        user.setBirthday(new Date());
//        user.setId(1);
//        user.setName("tom");
//
//        User user1 = new User();
//        user1.setBirthday(new Date());
//        user1.setId(1);
//        user1.setName("fox");
//        List<User> users = new ArrayList<User>();
//        users.add(user1);
//        users.add(user);
//
//        String json = JSONObject.toJSONString(users);
//        System.out.println(json);
//    }
//
//}
