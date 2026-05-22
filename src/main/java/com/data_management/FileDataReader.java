package com.data_management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader implements DataReader {

    private String filePath;

    public FileDataReader(
            String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readData(DataStorage dataStorage) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");

            int patientId = Integer.parseInt(parts[0]);

            double value = Double.parseDouble(parts[1]);

            String type = parts[2];

            long timestamp = Long.parseLong(parts[3]);

            dataStorage.addPatientData(
                            patientId,
                            value,
                            type,
                            timestamp
                    );

        }

        reader.close();

    }

    @Override
    public void connect() {

        System.out.println(
                "File reader connected"
        );

    }

}
