package org.launchcode.techjobs.oo;
import org.junit.Test;
import org.testng.annotations.AfterTest;

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
        assertEquals(fullTestJob.getName(), "Product tester");
        assertEquals(fullTestJob.getPositionType().toString(),"Quality control");
        assertEquals( fullTestJob.getEmployer().toString(), "ACME");
        assertEquals(fullTestJob.getLocation().toString(), "Desert");
        assertEquals(fullTestJob.getCoreCompetency().toString(), "Persistence");
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
    public void testToStringStartsAndEndsWithNewLine() {
        String newLine = System.lineSeparator();
        Job newLineTestJob = new Job("Artist", new Employer("Hallmark"), new Location("Kansas City"),
                new PositionType("creative"), new CoreCompetency("arts creation"));
        assertEquals(newLineTestJob.toString().startsWith(newLine), true);
        assertEquals(newLineTestJob.toString().endsWith(newLine), true);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String newLine = System.lineSeparator();
        Job labelsAndDataTestJob = new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType ("creative"), new CoreCompetency ("arts creation"));
        assertEquals(labelsAndDataTestJob.toString(), newLine+ "ID: 1" + newLine + "Name: Artist" + newLine + "Employer: Hallmark" + newLine + "Location: Kansas City" +
                newLine+ "Position Type: creative" + newLine+ "Core Competency: arts creation" + newLine);
    }

   @Test
    public void testToStringHandlesEmptyField(){
        String newLine = System.lineSeparator();
        Job emptyFieldTestJob = new Job("Artist", new Employer ("Hallmark"), new Location ("Kansas City"),
                new PositionType (""), new CoreCompetency ("arts creation"));
        assertEquals(emptyFieldTestJob.toString(),newLine+ "ID: 1" + newLine + "Name: Artist" + newLine + "Employer: Hallmark" + newLine + "Location: Kansas City" +
                newLine+ "Position Type: Data not available" + newLine+ "Core Competency: arts creation" + newLine);
       Job emptyFieldTestJob1 = new Job("Artist", new Employer (""), new Location ("Kansas City"),
               new PositionType ("creative"), new CoreCompetency ("arts creation"));
       assertEquals(emptyFieldTestJob1.toString(),newLine+ "ID: 2" + newLine + "Name: Artist" + newLine + "Employer: Data not available" + newLine + "Location: Kansas City" +
               newLine+ "Position Type: creative" + newLine+ "Core Competency: arts creation" + newLine);
    }
}
