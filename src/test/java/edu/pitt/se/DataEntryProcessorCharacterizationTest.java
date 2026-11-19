package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataEntryProcessorCharacterizationTest {

    private final DataEntryProcessor processor = new DataEntryProcessor();

    // Patient test cases

    @Test
    void patient_validRecord_anonymizesName() {
        String out = processor.process("patient", "Name: Katie Bryce, Condition: unknown");
        assertEquals("[PATIENT] Name: *****, Condition: unknown", out);
    }

    @Test
    void patient_missingCondition_returnsInvalid() {
        assertEquals("Invalid patient record.",
                processor.process("patient", "Name: Katie Bryce"));
    }

    @Test
    void patient_typeIsCaseInsensitive() {
        String out = processor.process("PATIENT", "Name: Meredith Grey, Condition: fatigue");
        assertEquals("[PATIENT] Name: *****, Condition: fatigue", out);
    }

    // Notes test cases
    @Test
    void notes_expandsAbbreviationsAndStripsFillers() {
        String out = processor.process("notes", "pt reports uhm pain in left ankle");
        assertEquals("[NOTES] patient reports pain in left ankle", out);
    }

    @Test
    void notes_expandsBp() {
        assertEquals("[NOTES] bp is elevated".replace("bp", "blood pressure"),
                processor.process("notes", "bp is elevated"));
    }

    // Schedule test cases
    @Test
    void schedule_normalizesTimes() {
        assertEquals("[SCHEDULE] Appointment at 09:00 with Dr. Grey",
                processor.process("schedule", "Appointment at 9am with Dr. Grey"));
    }

    // Edge test cases
    // After refactoring: delete unknownType_returnsFallback (no type string anymore),
    // keep noStrategyConfigured_runThrows unchanged (it already uses run()).

    @Test
    void unknownType_returnsFallback() {
        assertEquals("Unknown data type!", processor.process("lab", "whatever"));
    }

    @Test
    void noStrategyConfigured_runThrows() {
        assertThrows(IllegalStateException.class, () -> processor.run("anything"));
    }
}
