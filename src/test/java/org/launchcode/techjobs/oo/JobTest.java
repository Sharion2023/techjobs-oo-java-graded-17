package org.launchcode.techjobs.oo;
import org.junit.Test;

import static org.testng.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId (){
        Job testJob1 = new Job ();
        Job testJob2 = new Job();
        assertNotEquals(testJob1, testJob2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job fullTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(fullTestJob.getName() instanceof String);
        assertTrue(fullTestJob.getEmployer() instanceof Employer);
        assertTrue(fullTestJob.getLocation() instanceof Location);
        assertTrue(fullTestJob.getPositionType() instanceof PositionType);
        assertTrue(fullTestJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", fullTestJob.getName());
        assertEquals("Quality control", fullTestJob.getPositionType().toString());
        assertEquals("ACME", fullTestJob.getEmployer().toString());
        assertEquals("Desert", fullTestJob.getLocation().toString());
        assertEquals("Persistence", fullTestJob.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job equalityTestJob1= new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType ("creative"), new CoreCompetency ("arts creation"));
        Job equalityTestJob2= new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType ("creative"), new CoreCompetency ("arts creation"));
        assertFalse(equalityTestJob1.equals(equalityTestJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String newLine = System.lineSeparator();
        Job newLineTestJob= new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType ("creative"), new CoreCompetency ("arts creation"));
        assertEquals(true, newLineTestJob.toString().startsWith(newLine));
        assertEquals(true, newLineTestJob.toString().endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String newLine = System.lineSeparator();
        Job labelsAndDataTestJob = new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType ("creative"), new CoreCompetency ("arts creation"));
        assertEquals(newLine+ "ID: 1" + newLine + "Name: Artist" + newLine + "Employer: Hallmark" + newLine + "Location: Kansas City" +
                newLine+ "Position Type: creative" + newLine+ "Core Competency: arts creation" + newLine, labelsAndDataTestJob.toString());
    }

}
