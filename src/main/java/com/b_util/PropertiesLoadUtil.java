package com.b_util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoadUtil {
    public static Properties loadProperties(String fileName) {
        Properties prop = new Properties();
        InputStream in = PropertiesLoadUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
