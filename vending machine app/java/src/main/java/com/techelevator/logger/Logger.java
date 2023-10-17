package com.techelevator.logger;

import java.io.*;

public class Logger implements Closeable {
    private File auditFile;
    private FileWriter fileWriter;


    public Logger(String pathName) {
        auditFile = new File("audit.txt");
        if (auditFile.exists()) {
            try {
                fileWriter = new FileWriter(auditFile, true);

            } catch (IOException e) {
                System.out.println("Unable to append to audit file");
            }
        } else {
                try {
                    fileWriter = new FileWriter(auditFile);
                } catch (IOException e) {
                    System.out.println("Unable to create audit file");
                }
            }
        }

    public void write(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void close() throws IOException {
        fileWriter.close();
    }
}
