package com.alerts.decorator;

import com.alerts.Alert;

public class AlertDecorator {

    protected Alert alert;

    public AlertDecorator(Alert alert) {
        this.alert = alert;}

    public Alert getAlert() {
        return alert;
    }
}
