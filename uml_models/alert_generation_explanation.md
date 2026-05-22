# Alert Generation System

This subsystem is responsible for monitoring incoming patient vital signs and generating alerts when abnormal conditions are detected. The design separates alert evaluation, threshold management, and notification responsibilities to improve maintainability and scalability.

The AlertGenerator class evaluates incoming PatientData objects against personalized ThresholdRule objects assigned to each patient. This modular structure allows different patients to have unique cardiovascular thresholds without modifying the alert logic itself.

When a threshold violation occurs, the system creates an Alert object containing information such as patient ID, condition, severity, and timestamp. The AlertManager class is responsible for dispatching alerts to the appropriate MedicalStaff members. Separating alert generation from alert routing improves flexibility and allows future expansion such as SMS notifications or integration with hospital paging systems.

The Patient class owns multiple ThresholdRule objects through composition because threshold rules should not exist independently from a patient profile. Aggregation is used between AlertManager and Alert because alerts can exist temporarily even if managers are replaced.

Access to sensitive patient information is limited to classes that require it for monitoring and notification purposes. This design supports extensibility, modularity, and maintainability while reflecting the real-time safety-critical requirements of a cardiovascular monitoring environment.