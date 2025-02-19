package main.java.org.illiam.uokms;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

public class StorageServer {

    /**
     * Members that provide server functionality.
     * **/
    private final int port;
    private final int kmsPort;
    private final String kmsHost;

    private ServerSocket serverSocket;
    private Socket kmsSocket;

    public StorageServer(int port, String kmsHost, int kmsPort) {
        this.port = port;
        this.kmsHost = kmsHost;
        this.kmsPort = kmsPort;
    }


    public void Start() {
        // Communicate with the KMS to check if it's up and get the Domain Parameters.
        try {
            communicate(kmsHost, kmsPort, Storage.genGetDomainParametersRequest(), Storage.processDomainParameters);
        } catch (IOException | ParseException ex) {
            Storage.Log(Level.SEVERE, String.format("Error connecting to KMS: %s", ex.getMessage()));
            System.exit(1);
        }

        // Everything's correct by now, we can start the storage server.
        try {
            serverSocket = new ServerSocket(port);
            Storage.Log(Level.INFO, String.format("The server is listening on port %d", port));

            while (true) {
                Socket socket = serverSocket.accept();
                new StorageServerThread(socket).start();
            }

        } catch (IOException ex) {
            Storage.Log(Level.SEVERE, ex.getMessage());
        }

    }

    private void communicate(String kmsHost, int kmsPort, String request, IResponseProcessor processor)
            throws IOException, ParseException {
        kmsSocket = new Socket(kmsHost, kmsPort);

        Communicator.SendMessage(kmsSocket, request);
        String response = Communicator.ReceiveMessage(kmsSocket);
        processor.ProcessResponse(response);

        kmsSocket.close();
    }
}
