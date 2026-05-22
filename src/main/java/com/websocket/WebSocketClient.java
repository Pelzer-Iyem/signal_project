package com.websocket;

import com.data_management.DataStorage;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketClient
        extends org.java_websocket.client.WebSocketClient
        implements com.data_management.DataReader {

    private DataStorage storage;

    public WebSocketClient(URI serverUri, DataStorage storage) {
        super(serverUri);
        this.storage = storage;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println(
                "Connected to WebSocket"
        );

    }

    @Override
    public void onMessage(String message) {
        try {System.out.println("Received: " + message);

            String[] parts = message.split(",");

            int patientId = Integer.parseInt(parts[0]);

            double value = Double.parseDouble(parts[1]);

            String type = parts[2];

            long timestamp = Long.parseLong(parts[3]);

            storage.addPatientData(
                    patientId,
                    value,
                    type,
                    timestamp
            );

        }

        catch (Exception e) {
            System.out.println("Invalid message received");
        }

    }

    @Override
    public void onClose(
            int code,
            String reason,
            boolean remote
    ) {

        System.out.println("Disconnected");

        try {Thread.sleep(2000);
            reconnect();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void readData(DataStorage dataStorage) {
        connect();
    }

    @Override
    public void connect() {
        try {this.connectBlocking();}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
