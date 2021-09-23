package com.dwp.api.utils;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class DataWriter {

    public static void writeOutput(JSONObject output) throws IOException {

        String outputText = output.toString() + System.getProperty("line.separator");
        Files.write(Paths.get("LondonUser_Range50Miles.txt"), outputText.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
