package ourbusinessproject;

import org.junit.Before;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.*;

public class EnterpriseTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testEnterpriseValidation() {

        // given: an enterprise with all properties correctly set
        Enterprise enterprise = new Enterprise();
        enterprise.setName("Company & Co");
        enterprise.setDescription("Comp description");
        enterprise.setContactName("Paul Durand");
        enterprise.setContactEmail("paul@compco.com");

        // then: enterprise is valid
        assertTrue("Expected no constraint violation", validator.validate(enterprise).isEmpty());


    }

}