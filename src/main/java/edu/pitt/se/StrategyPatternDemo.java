package edu.pitt.se;

public class StrategyPatternDemo {
    public static void main(String[] args) {

        DataEntryProcessor processor = new DataEntryProcessor();

        // TODO: Uncomment, no need to make additional changes

        // processor.setStrategy(new PatientDataStrategy());
        // System.out.println(processor.run("Name: Katie Bryce, Condition: unknown"));

        // processor.setStrategy(new PhysicianNotesStrategy());
        // System.out.println(processor.run("pt reports uhm pain in left ankle"));

        // processor.setStrategy(new AppointmentScheduleStrategy());
        // System.out.println(processor.run("Appointment at 9am with Dr. Grey"));
    }
}
