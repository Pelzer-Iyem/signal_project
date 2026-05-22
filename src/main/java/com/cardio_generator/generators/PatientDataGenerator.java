package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Defines the contract for generating simulated patient health data.
 *
 * <p>Classes implementing this interface are responsible for generating
 * specific types of patient data and sending the generated output
 * using the provided output strategy.
 */
public interface PatientDataGenerator {

    /**
     * Generates simulated data for a patient and outputs it
     * using the specified output strategy.
     *
     * @param patientId the unique identifier of the patient
     * @param outputStrategy the strategy used to output generated data
     */
    void generate(int patientId, OutputStrategy outputStrategy);
}
