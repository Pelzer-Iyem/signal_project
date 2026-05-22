# Patient Identification System

This subsystem ensures that incoming cardiovascular data is correctly linked to the appropriate hospital patient record. Accurate patient identification is essential in a healthcare environment because incorrect matching could lead to serious medical errors.

The PatientIdentifier class is responsible for extracting patient identifiers from incoming signals and validating them against records stored in the PatientDatabase. If a valid match is found, the system retrieves a HospitalPatient object containing relevant patient details and medical history.

The IdentityManager oversees the integrity of the identification process and handles exceptional situations such as missing identifiers, duplicate IDs, or unmatched records. Separating mismatch handling from the matching logic improves maintainability and allows future extension of anomaly detection strategies.

The IncomingSignal class represents real-time data arriving from the simulator, while the AuditTrail class records identification events to improve traceability and accountability. Logging identification activity is especially important in healthcare systems where patient data integrity and privacy must be preserved.

Aggregation is used between IdentityManager and PatientIdentifier because multiple identification processes may be supervised simultaneously. Associations are used for database lookup and patient retrieval operations. Overall, the design emphasizes reliability, modularity, and secure handling of sensitive patient identification data within the CHMS environment.