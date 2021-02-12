package Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.swing.event.TableColumnModelEvent;

import static org.junit.Assert.*;


public class JobTest {
    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObject(){
        test_job1 = new Job();
        test_job2 = new Job();
    }
    //TESTING THAT ID VALUES FOR TWO OBJECTS NOT THE SAME AND DIFFER BY 1.
    //UNSURE HOW TO CHECK IF THEY DIFFER BY ONE
    @Test
    public void testSettingJobId(){
        assertEquals(1, test_job2.getId() - test_job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertTrue(job instanceof Job);
        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("Desert", job.getLocation().getValue());
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Quality Control", job.getPositionType().getValue());
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testToString(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Boolean expected = job.toString().startsWith("\n");
        Boolean expected2 = job.toString().endsWith("\n");
        Boolean compareThis = expected2 == expected;
        assertEquals(true, compareThis);
    }

    @Test
    public void testStringContainsLabelsAndFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + job.getId() + "\nName: " + job.getName() + "\nEmployer: " + job.getEmployer() + "\nLocation: " + job.getLocation()
                                   + "\nPosition Type: " + job.getPositionType() + "\nCore Competency: " + job.getCoreCompetency() +"\n";
        assertEquals(expected, job.toString());
    }

    @Test
    public void testIfFieldIsEmpty(){
        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + job.getId() + "\nName: " + "Data not available" + "\nEmployer: " + job.getEmployer() + "\nLocation: " + job.getLocation()
                + "\nPosition Type: " + job.getPositionType() + "\nCore Competency: " + job.getCoreCompetency() +"\n";
        assertEquals(expected, job.toString());
    }

    @Test
    public void testIfJobOnlyContainsIdField(){
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected;
    }
}


