package com.alerts.strategy;

import com.data_management.Patient;

public class HeartRateStrategy
        implements AlertStrategy {

    @Override
    public boolean checkAlert(Patient patient) {
        return patient != null;
    }
}
