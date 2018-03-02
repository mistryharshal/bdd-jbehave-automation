package com.id.e2e.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class FileInfoServiceBean {
    private String fileName;

    public void setName(String fileName) {
        this.fileName = fileName;
    }

    public void printFileDetails() {
        System.out.println("**** FileDetails : " + fileName);
    }

    /**
     * List all the files under a directory
     *
     * @param directoryName to be listed
     */
    public void printAllFileDetailsInDirectory(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        int i = 1;
        for (File file : fList) {
            if (file.isFile()) {
                String fileType = "";
                String fileExtension = "";
                try {
                    fileType = Files.probeContentType(file.toPath());
                } catch (IOException ioException) {
                    System.out.println(
                            "ERROR: Unable to determine file type for " + file
                                    + " due to exception " + ioException);
                }
                String fileName = file.getName();
                if (fileName.lastIndexOf(".") != 0 && fileName.lastIndexOf(".") != -1) {
                    fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                }

                System.out.println(i++ + ") File Name : " + file.getName() + ", File Type : " + fileType + ", File Size : " + file.length() + ", File Extension : " + fileExtension);

            }
        }
    }

    public HashMap<String, String> retrieveCsvData(String csvFileWithPath) {

        System.out.println("To read Csv file: " + csvFileWithPath);
        String line = "";
        String cvsSplitBy = ",";
        HashMap<String, String> csvRowDataMap = new HashMap<>();
        int headerCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileWithPath))) {

            while ((line = br.readLine()) != null) {
                if ( headerCount != 0) {
                      // use comma as separator
                    String[] rowData = line.split(cvsSplitBy);

                    //System.out.println(country[0] +"  "  + country[1]);
                    csvRowDataMap.put(rowData[0], rowData[1]);
                }
                headerCount += 1;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return csvRowDataMap;
    }
}

