/**
 * 
 */
package vn.elca.training.dom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coh
 *
 */
public class ProjectStore {

	private static final List<Project> projects = new ArrayList<Project>();

	/**
	 * @return the projects
	 */
	public static List<Project> getProjects() {
		return projects;
	}
}
