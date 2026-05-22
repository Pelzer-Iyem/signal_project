package com.cardio_generator.generators;

import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Generates simulated alert events for patients.
 *
 * <p>This class simulates patient alert states such as emergency alerts
 * being triggered and resolved over time using probabilistic behavior.
 */
public class AlertGenerator implements PatientDataGenerator {

    public static final Random randomGenerator = new Random();

    private boolean[] alertStates;

    /**
     * Creates an alert generator for a specified number of patients.
     *
     * @param patientCount the number of patients to simulate
     */

    public AlertGenerator(int patientCount) {

        alertStates = new boolean[patientCount + 1];
    }

    /**
     * Generates and outputs simulated alert data for a patient.
     *
     * <p>If an alert is currently active, there is a high probability
     * that it will be resolved. If no alert is active, there is a small
     * probability that a new alert will be triggered.
     *
     * @param patientId the unique identifier of the patient
     * @param outputStrategy the strategy used to output generated data
     */

    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            if (alertStates[patientId]) {
                if (randomGenerator.nextDouble() < 0.9) {
                    alertStates[patientId] = false;

                    outputStrategy.output(
                            patientId,
                            System.currentTimeMillis(),
                            "Alert",
                            "resolved");
                }

            } else {
                double Lambda = 0.1;
                double p = -Math.expm1(-Lambda);
                boolean alertTriggered = randomGenerator.nextDouble() < p;

                if (alertTriggered) {
                    alertStates[patientId] = true;

                    outputStrategy.output(patientId,
                            System.currentTimeMillis(),
                            "Alert",
                            "triggered");
                }
            }

        } catch (Exception e) {

            System.err.println(
                    "An error occurred while generating alert data for patient "
                            + patientId);

            e.printStackTrace();
        }
    }
}
