package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    public static void loadConfig() {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                // Fallback: direct path (Eclipse or manual run)
                String altPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                                 File.separator + "resources" + File.separator + "config.properties";
                System.out.println("config.properties not found in classpath, trying: " + altPath);

                File file = new File(altPath);
                if (file.exists()) {
                    input = new FileInputStream(file);
                } else {
                    throw new RuntimeException("config.properties not found at " + altPath);
                }
            }

            props.load(input);
            System.out.println("Config file loaded successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
