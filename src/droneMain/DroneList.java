package droneMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class DroneList {

    // Debug für Terminal in printen
    public void getDronesListInTerminal() {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/drones/?format=json&limit=10";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    int id = resultObject.getInt("id");
                    String created = resultObject.getString("created");
                    String serialNumber = resultObject.getString("serialnumber");
                    int carriageWeight = resultObject.getInt("carriage_weight");
                    String carriageType = resultObject.getString("carriage_type");

                    // Do something with the extracted values
                    System.out.println("ID: " + id);
                    System.out.println("Created: " + created);
                    System.out.println("Serial Number: " + serialNumber);
                    System.out.println("Carriage Weight: " + carriageWeight);
                    System.out.println("Carriage Type: " + carriageType);
                    System.out.println();
                }
            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Drone Type nach ID gesucht
    public static String[] getDroneFromID(String inputID) {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/dronetypes/" + inputID + "/?format=json";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                int id = jsonResponse.getInt("id");
                String manufacturer = jsonResponse.getString("manufacturer");
                String typeName = jsonResponse.getString("typename");
                int weight = jsonResponse.getInt("weight");
                int maxSpeed = jsonResponse.getInt("max_speed");
                int batteryCapacity = jsonResponse.getInt("battery_capacity");
                int controlRange = jsonResponse.getInt("control_range");
                int maxCarriage = jsonResponse.getInt("max_carriage");

                String[] droneInfo = { Integer.toString(id), manufacturer, typeName, Integer.toString(weight),
                        Integer.toString(maxSpeed), Integer.toString(batteryCapacity), Integer.toString(controlRange),
                        Integer.toString(maxCarriage) };
                connection.disconnect();

                return droneInfo;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();

                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Alle Hersteller get
    public static String[][] getAllManufacturers() {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/dronetypes/?format=json&limit=999";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] manufacturers = new String[resultsArray.length()][2];

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    manufacturers[i][0] = resultObject.get("id").toString();
                    manufacturers[i][1] = resultObject.getString("manufacturer");
                }

                connection.disconnect();
                return manufacturers;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Nach speziellen Hersteller suchen
    public static String[][] getAllDronesFromManufactures(String manufacture) {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/drones/?format=json&limit=999";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] allManufactures = getAllManufacturers();
                String[][] dronetypesFromAllDronesList = new String[resultsArray.length()][6];

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    dronetypesFromAllDronesList[i][0] = resultObject.get("id").toString();
                    dronetypesFromAllDronesList[i][1] = resultObject.get("dronetype").toString();
                    dronetypesFromAllDronesList[i][2] = resultObject.get("created").toString();
                    dronetypesFromAllDronesList[i][3] = resultObject.get("serialnumber").toString();
                    dronetypesFromAllDronesList[i][4] = resultObject.get("carriage_weight").toString();
                    dronetypesFromAllDronesList[i][5] = resultObject.get("carriage_type").toString();
                }

                // Find the ID of the manufacture
                int countToManID = 0;
                for (; countToManID < allManufactures.length; countToManID++) {
                    if (allManufactures[countToManID][1].equals(manufacture)) {
                        break;
                    }
                }

                // Count how many drones are from the manufacture
                int countReturnList = 0;
                for (int i = 0; i < dronetypesFromAllDronesList.length; i++) {
                    if (dronetypesFromAllDronesList[i][1].substring(47, 49).equals(allManufactures[countToManID][0])) {
                        countReturnList++;
                    }
                }

                // Create the return list
                String[][] returnList = new String[countReturnList][6];
                int j = 0;
                for (int i = 0; i < dronetypesFromAllDronesList.length; i++) {
                    if (dronetypesFromAllDronesList[i][1].substring(47, 49).equals(allManufactures[countToManID][0])) {
                        returnList[j][0] = dronetypesFromAllDronesList[i][0];
                        returnList[j][1] = dronetypesFromAllDronesList[i][1];
                        returnList[j][2] = dronetypesFromAllDronesList[i][2];
                        returnList[j][3] = dronetypesFromAllDronesList[i][3];
                        returnList[j][4] = dronetypesFromAllDronesList[i][4];
                        returnList[j][5] = dronetypesFromAllDronesList[i][5];
                        j++;
                    }
                }

                connection.disconnect();
                return returnList;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Drone nach Seriennummer suchen
    public static String[] getDroneFromSerialnumber(String serialnumber) {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/drones/?format=json&limit=999";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] allDrones = new String[resultsArray.length()][6];

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    allDrones[i][0] = resultObject.get("id").toString();
                    allDrones[i][1] = resultObject.get("dronetype").toString();
                    allDrones[i][2] = resultObject.get("created").toString();
                    allDrones[i][3] = resultObject.get("serialnumber").toString();
                    allDrones[i][4] = resultObject.get("carriage_weight").toString();
                    allDrones[i][5] = resultObject.get("carriage_type").toString();
                }

                // Get Drone from Serialnumber
                String[] returnStringArray = new String[6];
                for (String[] indiviualDrone : allDrones) {
                    if (indiviualDrone[3].equals(serialnumber)) {
                        returnStringArray = indiviualDrone;
                        break;
                    }
                }

                // Print Drone
                for (String s : returnStringArray) {
                    System.out.println(s);
                }

                connection.disconnect();
                return returnStringArray;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String[][] getAllDrones() {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/drones/?format=json&limit=999";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";
            

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] resultsString = new String[resultsArray.length()][6];
                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    resultsString[i][0] = resultObject.get("id").toString();
                    resultsString[i][1] = resultObject.get("dronetype").toString();
                    resultsString[i][2] = resultObject.getString("created");
                    resultsString[i][3] = resultObject.getString("serialnumber");
                    resultsString[i][4] = resultObject.get("carriage_weight").toString();
                    resultsString[i][5] = resultObject.getString("carriage_type");
                }

                connection.disconnect();

                return resultsString;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;
            }

            // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String[] getDroneDynamic(String idSearchString) {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/dronedynamics/" + idSearchString + "/?format=json";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                String[] resultsString = new String[11];

                resultsString[0] = jsonResponse.get("drone").toString();
                resultsString[1] = jsonResponse.get("timestamp").toString();
                resultsString[2] = jsonResponse.get("speed").toString();
                resultsString[3] = jsonResponse.get("align_roll").toString();
                resultsString[4] = jsonResponse.get("align_pitch").toString();
                resultsString[5] = jsonResponse.get("align_yaw").toString();
                resultsString[6] = jsonResponse.get("longitude").toString();
                resultsString[7] = jsonResponse.get("latitude").toString();
                resultsString[8] = jsonResponse.get("battery_status").toString();
                resultsString[9] = jsonResponse.get("last_seen").toString();
                resultsString[10] = jsonResponse.get("status").toString();

                connection.disconnect();

                return resultsString;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;
            }

            // Close the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String[][] getAllDroneDynamic() {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/drones/?format=json&limit=999";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] flightDynamics = new String[resultsArray.length()][2];

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    flightDynamics[i][0] = resultObject.get("id").toString();;
                    flightDynamics[i][1] = resultObject.getString("serialnumber");
                    
                }
                

                connection.disconnect();
                return flightDynamics;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static String[][] getHistoricalAnalysis(String serialnumber) {
        try {
            // Replace the URL with your API endpoint
            String apiUrl = "http://dronesim.facets-labs.com/api/dronedynamics/?format=json&limit=3625";
            final String TOKEN = "Token 0572346481df5e740a17b02c4404a9abfe033264";

            // Make the HTTP request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", TOKEN);
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                // Speichern zu String line
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray resultsArray = jsonResponse.getJSONArray("results");

                String[][] allFlightIds = getAllDroneDynamic();
                String[][] allFlightsFromDroneDynamics = new String[resultsArray.length()][11];

                // Extract values from the results array
                for (int i = 0; i < resultsArray.length(); i++) {
                    JSONObject resultObject = resultsArray.getJSONObject(i);
                    allFlightsFromDroneDynamics[i][0] = resultObject.get("drone").toString();
                    allFlightsFromDroneDynamics[i][1] = resultObject.get("timestamp").toString();
                    allFlightsFromDroneDynamics[i][2] = resultObject.get("speed").toString();
                    allFlightsFromDroneDynamics[i][3] = resultObject.get("align_roll").toString();
                    allFlightsFromDroneDynamics[i][4] = resultObject.get("align_pitch").toString();
                    allFlightsFromDroneDynamics[i][5] = resultObject.get("align_yaw").toString();
                    allFlightsFromDroneDynamics[i][6] = resultObject.get("longitude").toString();
                    allFlightsFromDroneDynamics[i][7] = resultObject.get("latitude").toString();
                    allFlightsFromDroneDynamics[i][8] = resultObject.get("battery_status").toString();
                    allFlightsFromDroneDynamics[i][9] = resultObject.get("last_seen").toString();
                    allFlightsFromDroneDynamics[i][10] = resultObject.get("status").toString();
                }

                 // Find the ID of the manufacture
                 int countToManID = 0;
                 for (; countToManID < allFlightIds.length; countToManID++) {
                     if (allFlightIds[countToManID][1].equals(serialnumber)) {
                         break;
                     }
                 }
                

                 int countReturnList = 0;
                 for (int i = 0; i < allFlightsFromDroneDynamics.length; i++) {
                     if (allFlightsFromDroneDynamics[i][0].substring(43, 45).equals(allFlightIds[countToManID][0])) {
                         countReturnList++;
                     }
                 }

                // Create the return list
                String[][] returnList = new String[countReturnList][11];
                int j = 0;
                for (int i = 0; i < allFlightsFromDroneDynamics.length; i++) {
                    if (allFlightsFromDroneDynamics[i][0].substring(43, 45).equals(allFlightIds[countToManID][0])) {
                        returnList[j][0] = allFlightsFromDroneDynamics[i][0];
                        returnList[j][1] = allFlightsFromDroneDynamics[i][1];
                        returnList[j][2] = allFlightsFromDroneDynamics[i][2];
                        returnList[j][3] = allFlightsFromDroneDynamics[i][3];
                        returnList[j][4] = allFlightsFromDroneDynamics[i][4];
                        returnList[j][5] = allFlightsFromDroneDynamics[i][5];
                        returnList[j][6] = allFlightsFromDroneDynamics[i][6];
                        returnList[j][7] = allFlightsFromDroneDynamics[i][7];
                        returnList[j][8] = allFlightsFromDroneDynamics[i][8];
                        returnList[j][9] = allFlightsFromDroneDynamics[i][9];
                        returnList[j][10] = allFlightsFromDroneDynamics[i][10];
                        j++;
                    }
                }

                connection.disconnect();
                return returnList;

            } else {
                System.out.println("HTTP Request failed with response code: " + responseCode);
                connection.disconnect();
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
