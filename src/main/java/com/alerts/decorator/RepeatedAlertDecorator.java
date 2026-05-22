package com.alerts.decorator;

import com.alerts.Alert;

public class RepeatedAlertDecorator
        extends AlertDecorator {

    public RepeatedAlertDecorator(Alert alert) {
        super(alert);
    }

    public String repeat() {
        return "Repeated: " + alert.getCondition();

    }

}
