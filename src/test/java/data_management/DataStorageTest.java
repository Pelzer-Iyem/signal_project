package data_management;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.data_management.DataStorage;
import com.data_management.PatientRecord;

import java.util.List;

class DataStorageTest {

    @Test
    void testAddAndGetRecords() {

        DataStorage storage = DataStorage.getInstance();

        storage.addPatientData(1, 100.0, "WhiteBloodCells", 1714376789050L);
        storage.addPatientData(1, 200.0, "WhiteBloodCells", 1714376789051L);

        List<PatientRecord> records = storage.getRecords(1, 1714376789050L, 1714376789051L);

        assertEquals(2, records.size());
        assertEquals(100.0, records.get(0).getMeasurementValue());
    }

    @Test
    void testNoRecordsReturned() {
        DataStorage storage = DataStorage.getInstance();

        List<PatientRecord> records = storage.getRecords(
                        999,
                        0,
                        999999
                );

        assertTrue(records.isEmpty());

    }

    @Test
    void testSingleRecord() {
        DataStorage storage = DataStorage.getInstance();

        storage.addPatientData(
                1,
                50.0,
                "ECG",
                1000
        );

        List<PatientRecord> records =
                storage.getRecords(
                        1,
                        0,
                        2000
                );

        assertEquals(
                1,
                records.size()
        );
    }
}