package com.mycompany.service_request_tracking_app;

import javax.swing.JOptionPane; 
import java.util.Random;

public class ServiceRequestApp {

    private ServiceRequest lastRequest;
    private int requestCounter = 1;

    public void start() {

        int option;

        do {

            String input = JOptionPane.showInputDialog(
                    "1. Log Service Request"
                    + "\n2. View Last Request"
                    + "\n3. Update Last Request Description"
                    + "\n4. Display Request Code"
                    + "\n5. Exit");

            option = Integer.parseInt(input);

            switch (option) {

                case 1:
                    logRequest();
                    break;

                case 2:
                    viewRequest();
                    break;

                case 3:
                    updateRequest();
                    break;

                case 4:
                    displayRequestCode();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "All service requests logged successfully!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid option selected.");
            }

        } while (option != 5);

    }

    private void logRequest() {

        String category =
                JOptionPane.showInputDialog("Enter service category:");

        while (category.trim().isEmpty()) {

            category = JOptionPane.showInputDialog(
                    "Category cannot be empty.");
        }

        String description =
                JOptionPane.showInputDialog("Enter request description:");

        while (description.trim().isEmpty()
                || description.length() > 200) {

            description = JOptionPane.showInputDialog(
                    "Description must be between 1 and 200 characters.");
        }

        Random random = new Random();

        int requestID =
                10000000 + random.nextInt(90000000);

        lastRequest = new ServiceRequest(
                requestID,
                category,
                description,
                requestCounter);

        requestCounter++;

        JOptionPane.showMessageDialog(null,
                lastRequest.displayRequest());
    }

    private void viewRequest() {

        if (lastRequest != null) {

            JOptionPane.showMessageDialog(null,
                    lastRequest.displayRequest());

        } else {

            JOptionPane.showMessageDialog(null,
                    "No request has been logged yet.");
        }
    }

    private void updateRequest() {

        if (lastRequest != null) {

            String newDescription =
                    JOptionPane.showInputDialog(
                            "Enter new description:");

            while (newDescription.trim().isEmpty()
                    || newDescription.length() > 200) {

                newDescription =
                        JOptionPane.showInputDialog(
                                "Description invalid.");
            }

            lastRequest.setDescription(newDescription);

            JOptionPane.showMessageDialog(null,
                    lastRequest.displayRequest());

        } else {

            JOptionPane.showMessageDialog(null,
                    "No request exists.");
        }
    }

    private void displayRequestCode() {

        if (lastRequest != null) {

            JOptionPane.showMessageDialog(null,
                    lastRequest.getRequestCode());

        } else {

            JOptionPane.showMessageDialog(null,
                    "No request exists.");
        }
    }
}