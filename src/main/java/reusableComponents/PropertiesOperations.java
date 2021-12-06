package reusableComponents;

import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

    static Properties props= new Properties();

    public static String getPropertyValueByKey(String key) throws Exception {

        String propFilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";

        FileInputStream fis = new FileInputStream(propFilePath);

        props.load(fis);

        String value = props.get(key).toString();

        if(StringUtils.isEmpty(value)){
            throw new Exception("Value is not specified for key: "+ key + "in properties file." );
        }

        return value;
    }
}
