# Data Access Layer

This subsystem is responsible for receiving cardiovascular data from external simulator sources and transforming it into standardized internal objects that can be processed by the CHMS system.

The design uses the DataListener interface to support multiple communication methods without affecting the rest of the system. Specialized listener implementations such as TCPDataListener, WebSocketDataListener, and FileDataListener provide flexibility for receiving data from TCP streams, WebSocket connections, or log files. This design follows modular software engineering principles and supports future extensibility if new communication methods are introduced.

The DataParser class standardizes incoming raw data by converting formats such as JSON or CSV into structured PatientData objects. Separating parsing logic from data reception ensures that communication responsibilities remain independent from data transformation logic.

The DataSourceAdapter acts as an intermediary between external data listeners and the internal storage or processing subsystems. This abstraction improves maintainability because the rest of the CHMS system remains independent from the underlying communication technology.

Inheritance relationships are used between the listener implementations and the DataListener interface to demonstrate polymorphism and interchangeable data sources. Overall, the subsystem prioritizes modularity, flexibility, and scalability while supporting reliable real-time cardiovascular data streaming.