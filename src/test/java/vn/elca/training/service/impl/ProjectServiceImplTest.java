package vn.elca.training.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import vn.elca.training.dom.Project;
import vn.elca.training.dom.ProjectStore;
import vn.elca.training.service.ProjectService;

/**
 * 
 * @author coh
 *
 */
@ContextConfiguration(locations = { "classpath:test-config.xml" })
public class ProjectServiceImplTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ProjectService projectService;

	// FIXED [Task � 1] Add necessary configuration to make ProjectServiceImplTest.java runnable under JUnit.
	@Test
	public void testFindProjectByName() {
		// 1. Prepare data
		insertProject("Project P1", 1001, "Customer C1", "COH");
		insertProject("Project P2", 1002, "Customer C2", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("P1");
		
		// 3. Verify
		// FIXED [Task � 2] Fill MISSING points to verify the test result by using assertion library.
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(Project.class, result.get(0).getClass());
		assertEquals("Project P1", result.get(0).getName());
		assertEquals("Customer C1", result.get(0).getCustomer());
		assertEquals("COH", result.get(0).getLeader());
		assertEquals(1001, result.get(0).getNumber());
	}
	@Test
	public void testFindProjectByNumber() {
		// 1. Prepare data
        // Remove the old data
        this.clearProject();
        // Insert new data for this test
		insertProject("Project P3", 1001, "Customer C3", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("1001");
		
		// 3. Verify
		// FIXED: [Task � 2] Fill MISSING points to verify the test result by using assertion library.
		assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(Project.class, result.get(0).getClass());
        assertEquals("Project P3", result.get(0).getName());
        assertEquals("Customer C3", result.get(0).getCustomer());
        assertEquals("COH", result.get(0).getLeader());
        assertEquals(1001, result.get(0).getNumber());
	}
	
	// FIXED [Task � 3] Install jacoco, run test and find missing tests cases for the function projectService.findByQuery based on jacoco report result
    @Test
    public void testFindProjectByBlank() {
        // 1. Prepare data
        insertProject("Project P4", 1001, "Customer C4", "XDG");
        
        // 2. Execute
        List<Project> result = projectService.findByQuery("");
        
        // 3. Verify
        assertNotNull(result);
        assertEquals(0, result.size());
        Object exception = null;
        try {
            result.get(0).getName();
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
    }
    
    @Test
    public void testFindProjectByCustomer() {
        // 1. Prepare data
        // Remove the old data
        this.clearProject();
        // Insert new data for this test
        insertProject("Project P5", 1005, "Customer C5", "XDG");
        insertProject("Project P6", 1006, "ELCA C6", "XDG");

        // 2. Execute
        List<Project> result = projectService.findByQuery("Customer");
        
        // 3. Verify
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(Project.class, result.get(0).getClass());
        assertEquals("Project P5", result.get(0).getName());
        assertEquals("Customer C5", result.get(0).getCustomer());
        assertEquals("XDG", result.get(0).getLeader());
        assertEquals(1005, result.get(0).getNumber());
    }
    
    @Test
    public void testFindProjectByLeader() {
        // 1. Prepare data:
        // Remove the old data
        this.clearProject();
        // Insert new data for this test
        insertProject("Project P7", 1007, "Customer C7", "XDG");
        insertProject("Project P8", 1008, "Customer C8", "XDG");
        
        // 2. Execute
        List<Project> result = projectService.findByQuery("XDG");
        
        // 3. Verify
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(Project.class, result.get(0).getClass());
        assertEquals("Project P7", result.get(0).getName());
        assertEquals("Customer C7", result.get(0).getCustomer());
        assertEquals("XDG", result.get(0).getLeader());
        assertEquals(1007, result.get(0).getNumber());
        assertEquals(Project.class, result.get(1).getClass());
        assertEquals("Project P8", result.get(1).getName());
        assertEquals("Customer C8", result.get(1).getCustomer());
        assertEquals("XDG", result.get(1).getLeader());
        assertEquals(1008, result.get(1).getNumber());
    }
    
	private void insertProject(String name, int number, String customer, String leader) {
		Project project = new Project();
		project.setName(name);
		project.setNumber(number);
		project.setCustomer(customer);
		project.setLeader(leader);
		ProjectStore.getProjects().add(project);
	}
	
	private void clearProject(){
	    ProjectStore.getProjects().clear();
	}
}
