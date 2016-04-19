package properties.methods;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValue {

    String result = "";
    InputStream inputStream;

    public String getPropValue(String propertyFileName, String propertyName) throws IOException {
        try{
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);

            if(inputStream != null){
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '"+propertyFileName+"' not found");
            }
            result = prop.getProperty(propertyName);
        } catch (Exception e){
            System.out.println("Exception: "+e);
        } finally {
            inputStream.close();
        }
        return result;
    }

}
