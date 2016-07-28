/**
 * 
 */
package vn.elca.training.service;

import java.util.List;

import vn.elca.training.dom.Project;

/**
 * @author coh
 *
 */
public interface ProjectService {

	List<Project> findByQuery(String query);
}
