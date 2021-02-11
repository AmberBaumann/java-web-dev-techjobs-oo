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
        //testing that job1 Id does not equal job2 Id
        assertTrue(test_job1.getId() != test_job2.getId());
        //testing that job1 Id is less than job2 Id - how to check difference is by 1??
        assertTrue(test_job1.getId() < test_job2.getId());
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
}
