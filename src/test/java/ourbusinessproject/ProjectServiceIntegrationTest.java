package ourbusinessproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProjectServiceIntegrationTest {

    @Autowired
    private ProjectService projectService;

    private Project project;


    @Before
    public void setUp() throws Exception {
        // given a a valid project
        project = new Project();
        project.setTitle("A project");
        project.setDescription("Project description");
    }


    @Test
    public void testSaveValidProject() {

        // when saving the project
        projectService.save(project);

        // expect the project is saved with a generated id
        assertNotNull(project.getId());
    }

}