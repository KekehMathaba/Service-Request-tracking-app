package com.mycompany.service_request_tracking_app;

public class ServiceRequest {

    private int requestID;
    private String category;
    private String description; 
    private String requestCode;
    private int requestNumber;

    public ServiceRequest(int requestID,
                          String category,
                          String description,
                          int requestNumber) {

        this.requestID = requestID;
        this.category = category;
        this.description = description;
        this.requestNumber = requestNumber;

        generateRequestCode();
    }

    public void generateRequestCode() {

        String[] words = description.trim().split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String idLastTwo =
                String.valueOf(requestID).substring(6);

        requestCode = idLastTwo + "-"
                + requestNumber + "-"
                + firstWord + "-"
                + lastWord;
    }

    public int getRequestID() {
        return requestID;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setDescription(String description) {

        this.description = description;
        generateRequestCode();
    }

    public String displayRequest() {

        return "Request ID: " + requestID
                + "\nCategory: " + category
                + "\nDescription: " + description
                + "\nRequest Code: " + requestCode;
    }
}
