package Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            //Pfad zur Einstellungsdatei
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //Behandlung einer möglichen Ausnahme (keine Datei usw.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Methode zum Zurückgeben einer File mit einem Wert aus einer Einstellungsdatei
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}