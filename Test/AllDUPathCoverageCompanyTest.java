import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class AllDUPathCoverageCompanyTest {
    public ResourcePool rp;
    public Resource r1 = new Resource(1, "gojeh");
    public Resource r2 = new Resource(10, "laptop");
    public Resource r3 = new Resource(100, "car");
    public Employee e1 = new Employee("gholi");
    public Employee e2 = new Employee("gholam");
    public Vector<Resource> resources = new Vector<>();

    @Before
    public void initialize(){
        r1 = new Resource(1, "gojeh");
        r2 = new Resource(10, "laptop");
        r3 = new Resource(100, "car");
        e1 = new Employee("gholi");
        e2 = new Employee("gholam");
        resources.add(r1);
        resources.add(r2);
        resources.add(r3);
    }

    // All DU Path Coverage

    @Test
    public void AllDUPathCoverage()   // 1 2 5
    {
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        c.goBankrupt();
    }

    // end of All DU Path Coverage

}
