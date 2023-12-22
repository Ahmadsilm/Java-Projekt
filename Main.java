import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private JFrame frame;
    private JLabel responseLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Main().createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void createAndShowGUI() throws IOException {
        frame = new JFrame("API Caller Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        responseLabel = new JLabel("API Response will be displayed here.");

        JButton apiButton = new JButton("Call API");
        apiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String apiResponse = callApi("https://api.nationalize.io/?name=nathaniel");
                    responseLabel.setText("API Response:\n" + apiResponse);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    responseLabel.setText("Error occurred while calling the API.");
                }
            }
        });

        panel.add(apiButton, BorderLayout.NORTH);
        panel.add(responseLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private String callApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the API response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        // Close the connection and reader
        reader.close();
        connection.disconnect();

        return response.toString();
    }
}
