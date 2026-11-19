package edu.pitt.se;

public class DataEntryProcessor {

    private DataProcessingStrategy strategy;

    public void setStrategy(DataProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public String run(String input) {
        if (strategy == null) {
            throw new IllegalStateException("No processing strategy configured!");
        }

        return strategy.process(input);
    }

    // TODO: REMOVE this entire method and SPLIT the logic below
    // into three classes that implement DataProcessingStrategy:
    // 1. PatientDataStrategy
    // 2. PhysicianNotesStrategy
    // 3. AppointmentScheduleStrategy
    // No need to make changes to the logic!
    public String process(String type, String input) {

        if (type.equalsIgnoreCase("patient")) {
            // Patient processing
            String result = input;

            // Check record structure
            if (!result.contains("Name") || !result.contains("Condition")) {
                return "Invalid patient record.";
            }

            // Anonymize name (naive)
            result = result.replaceAll("Name: [A-Za-z ]+", "Name: *****");

            return "[PATIENT] " + result;

        } else if (type.equalsIgnoreCase("notes")) {
            String result = input;

            // Replace filler words
            result = result.replace(" uhm", "");
            result = result.replace(" basically", "");

            // Expand on abbreviations
            result = result.replace("pt", "patient");
            result = result.replace("bp", "blood pressure");

            return "[NOTES] " + result;

        } else if (type.equalsIgnoreCase("schedule")) {
            String result = input;

            // Normalize time (simulated, naive way)
            result = result.replace("9am", "09:00");
            result = result.replace("10am", "10:00");
            result = result.replace("2pm", "14:00");
            result = result.replace("3pm", "15:00");

            return "[SCHEDULE] " + result;
        }

        return "Unknown data type!";
    }
}
