package com.alerts.decorator;

import com.alerts.Alert;

public class PriorityAlertDecorator
        extends AlertDecorator {

    public PriorityAlertDecorator(Alert alert) {
        super(alert);

    }

    public String getPriority() {
        return "HIGH PRIORITY";

    }

}