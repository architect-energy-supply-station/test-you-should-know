package demo;
import	java.util.HashMap;
import	java.io.FileOutputStream;
import	java.io.OutputStreamWriter;
import	java.io.BufferedWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/4 10:25
 */
public class WordExportUtil {
    private static WordExportUtil service = null;

    private WordExportUtil() {
        super();
    }

    public static WordExportUtil getInstance() {
        if (service==null) {
            synchronized (WordExportUtil.class) {
                if (service==null) {
                    service = new WordExportUtil();
                }
            }
        }
        return service;
    }
    public File createDocFile(String templateFilePath, Map<String,Object> dataMap,String exportFilePath,int loadType) throws IOException, TemplateException {
        Template t = null;
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("UTF-8");
        templateFilePath = pathReplace(templateFilePath);
       String ftlPath =templateFilePath.substring(0, templateFilePath.lastIndexOf("/"));
        if (loadType==1) {
            configuration.setDirectoryForTemplateLoading(new File(ftlPath));
        }else {
            configuration.setClassForTemplateLoading(this.getClass(),ftlPath);
        }
        String ftlFile = templateFilePath.substring(templateFilePath.lastIndexOf("/") + 1);
        t = configuration.getTemplate(ftlFile);
        File outFile = new File(exportFilePath);
        Writer out = null;
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        t.process(dataMap, out);
        return null;
    }

    //    把路径的\替换成/
    private String pathReplace(String path) {
        while (path != null && path.contains("\\")) {
            path = path.replace("\\", "/");

        }
        return path;
    }

    public static void getData(Map<String, Object> dataMap) {
        dataMap.put("username", "mm");
        dataMap.put("sex", "女");
    }

    public static void main(String[] args) throws IOException, TemplateException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        getData(dataMap);
        String templateFile = "D:\\桌\\wordM.ftl";
        String exportFile = "D:\\桌\\mmWord.doc";
        WordExportUtil.getInstance().createDocFile(templateFile, dataMap, exportFile, 1);

    }
}
