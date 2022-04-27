package utils;

import java.io.*;
import java.util.Properties;

public class Config {
    private static final String fileName = "config.properties";
    private static final Properties props = new Properties();
    private static InputStream inputStream;

    static {
        try {
            String confPath = System.getProperty("config.path");
            inputStream = confPath != null && !confPath.isEmpty()
                    ? getConfigStreamFilesystem(confPath)
                    : getConfigStreamClasspath();
            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Can't read config file" +  e);
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Can't close config file" + e);
            }
        }
    }

    public static String getStr(String key) {
        return props.getProperty(key);
    }
    public static Integer getInt(String key) {
        return Integer.parseInt(props.getProperty(key));
    }

    private static InputStream getConfigStreamClasspath() {
        return Config.class.getClassLoader().getResourceAsStream(fileName);
    }

    private static InputStream getConfigStreamFilesystem(String path) throws FileNotFoundException {
        return new FileInputStream(new File(path));
    }

}
