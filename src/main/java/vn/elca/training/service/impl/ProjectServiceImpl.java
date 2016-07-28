/**
 * 
 */
package vn.elca.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import vn.elca.training.dom.Project;
import vn.elca.training.dom.ProjectStore;
import vn.elca.training.service.ProjectService;

/**
 * @author coh
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<Project> findByQuery(String query) {
		List<Project> projects = new ArrayList<Project>();
		
		String criteria = StringUtils.trimToEmpty(query);
		
		if (StringUtils.isBlank(criteria)) {
			return projects;
		}
		
		for (Project project : ProjectStore.getProjects()) {
			if (StringUtils.containsIgnoreCase(project.getName(), criteria)
					|| StringUtils.containsIgnoreCase("" + project.getNumber(), criteria)
					|| StringUtils.containsIgnoreCase(project.getCustomer(), criteria)
					|| StringUtils.containsIgnoreCase(project.getLeader(), criteria)) { 
				projects.add(project);
			}
		}
		
		return projects;
	}
}
