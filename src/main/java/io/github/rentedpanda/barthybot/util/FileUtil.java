package io.github.rentedpanda.barthybot.util;

import java.io.InputStream;

public class FileUtil {

    // imported from https://mkyong.com/java/java-read-a-file-from-resources-folder/

    public InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

}
