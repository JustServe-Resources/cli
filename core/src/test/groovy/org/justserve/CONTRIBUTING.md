# Testing Feature
## Test to Identify Useful Information for Organizations

### Test Example:


package model:

public class Organization {
    private string value:

    public Organization(String v) { this.value = v; }

    public String toString() { return this.value; }
}

package model;

public class OrganizationTest {

    @Test
    public void testToString() {
        String expected = "Test";
        Organization organization = new Organization(expected);
        Assert.assertEquals(expected, foo.toString());
    }
}

/**
    * This class contains the code to implement what information is useful for organizations.
    * Then also to separate the information that is null or not useful to the organization.
    * Tests input given from user
organization UserInput {
    // Information Input

/**
    * Tests input from user
    * Verifies the information given that is useful or needed
    */



