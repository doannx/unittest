package vn.elca.training.service.impl;

import java.util.List;

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

	// TODO [Task – 1] Add necessary configuration to make ProjectServiceImplTest.java runnable under JUnit.
	
	public void testFindProjectByName() {
		// 1. Prepare data
		insertProject("Project P1", 1001, "Customer C1", "COH");
		insertProject("Project P2", 1002, "Customer C2", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("P1");
		
		// 3. Verify
		// TODO [Task – 2] Fill MISSING points to verify the test result by using assertion library.
	}
	
	public void testFindProjectByNumber() {
		// 1. Prepare data
		insertProject("Project P3", 1001, "Customer C3", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("1001");
		
		// 3. Verify
		// TODO [Task – 2] Fill MISSING points to verify the test result by using assertion library.
	}
	
	// TODO [Task – 3] Install jacoco, run test and find missing tests cases for the function projectService.findByQuery based on jacoco report result

	private void insertProject(String name, int number, String customer, String leader) {
		Project project = new Project();
		project.setName(name);
		project.setNumber(number);
		project.setCustomer(customer);
		project.setLeader(leader);
		ProjectStore.getProjects().add(project);
	}
}
