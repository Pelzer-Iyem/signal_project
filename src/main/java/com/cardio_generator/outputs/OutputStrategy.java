package com.cardio_generator.outputs;

/**
 * Defines the contract for outputting generated patient data.
 *
 * <p>Implementations of this interface determine how and where
 * simulated patient data is delivered, such as to the console,
 * files, TCP connections, or WebSocket clients.
 */
public interface OutputStrategy {

    /**
     * Outputs generated patient data.
     *
     * @param patientId the unique identifier of the patient
     * @param timestamp the timestamp when the data was generated
     * @param label the type or category of the generated data
     * @param data the generated patient data value
     */
    void output(int patientId, long timestamp, String label, String data);
}
