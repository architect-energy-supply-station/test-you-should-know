package utils.WordUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * framemarker 框架
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-04
 */
public class wordUtil {
    private static wordUtil service = null;

    public wordUtil() {
        super();
    }

    public static wordUtil getInstance() {
        if (service==null) {
            synchronized (wordUtil.class) {
                if (service==null) {
                    service = new wordUtil();
                }
            }
        }
        return service;
    }

   public File createDocFile(String templateFilePath, Map<String ,Object> dataMap, String exportFilePath, int loadType) throws IOException {

        Template t = null;
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("UTF-8");
        templateFilePath = pathReplace(templateFilePath);
        String ftlPath = templateFilePath.substring(0, templateFilePath.lastIndexOf("/"));

        // 以类加载的方式查找模板文件路径
        if (loadType==1) {
            try {
                configuration.setDirectoryForTemplateLoading(new File(ftlPath));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            configuration.setClassForTemplateLoading(this.getClass(), ftlPath);
        }

        String ftlFile = templateFilePath.substring(templateFilePath.lastIndexOf("/")+1);
        t = configuration.getTemplate(ftlFile);

        File outFile = new File(exportFilePath);
        Writer out = null;

        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        try {
            t.process(dataMap,out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String pathReplace(String path) {
        while(path != null && path.contains("\\")) {
            path = path.replace("\\", "/");
        }
        return path;
    }

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        getData(dataMap);
        String templateFile = "D:\\word\\exportTemplate.ftl";
        String exportFile = "D:\\word\\luedf.doc";

        try {
            wordUtil.getInstance().createDocFile(templateFile, dataMap, exportFile, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试用的
     * @param dataMap
     */
    public static void getData(Map<String, Object> dataMap) {
        dataMap.put("tb11", "10");
        dataMap.put("tb12", "2012");
        dataMap.put("tb13", "2");
        dataMap.put("tb111", "13");
        dataMap.put("tb112", "13");
        dataMap.put("tb113", "13");
        dataMap.put("tb114", "13");
        dataMap.put("tb115", "13");
        dataMap.put("tb116", "13");
        dataMap.put("tb117", "13");
        dataMap.put("tb118", "13");
        dataMap.put("tb119", "13");
        dataMap.put("tb1110", "13");
        dataMap.put("tb1111", "13");
    }
}
