package com.cardio_generator.generators;

import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Generates simulated blood oxygen saturation data for patients.
 *
 * <p>This class creates realistic blood saturation values with small
 * fluctuations over time to simulate real patient monitoring data.
 */
public class BloodSaturationDataGenerator implements PatientDataGenerator {

    private static final Random random = new Random();
    private int[] lastSaturationValues;

    /**
     * Creates a blood saturation generator for a specified number of patients.
     *
     * <p>Each patient is initialized with a baseline saturation value
     * between 95% and 100%.
     *
     * @param patientCount the number of patients to simulate
     */

    public BloodSaturationDataGenerator(int patientCount) {
        lastSaturationValues = new int[patientCount + 1];

        // Initialize with baseline saturation values for each patient
        for (int i = 1; i <= patientCount; i++) {
            lastSaturationValues[i] = 95 + random.nextInt(6);
        }
    }

    /**
     * Generates and outputs a simulated blood saturation value.
     *
     * <p>The method applies small random fluctuations to the patient's
     * previous saturation value while ensuring the result remains
     * within a realistic range between 90% and 100%.
     *
     * @param patientId the unique identifier of the patient
     * @param outputStrategy the strategy used to output generated data
     */

    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            // Simulate blood saturation values
            int variation = random.nextInt(3) - 1;
            int newSaturationValue = lastSaturationValues[patientId] + variation;

            // Ensure the saturation stays within a realistic and healthy range
            newSaturationValue = Math.min(Math.max(newSaturationValue, 90), 100);
            lastSaturationValues[patientId] = newSaturationValue;

            outputStrategy.output(
                    patientId,
                    System.currentTimeMillis(),
                    "Saturation",
                    Double.toString(newSaturationValue) + "%");

        } catch (Exception e) {
            System.err.println(
                    "An error occurred while generating blood saturation data for patient "
                            + patientId);

            e.printStackTrace();
        }
    }
}
