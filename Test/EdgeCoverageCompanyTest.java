import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class EdgeCoverageCompanyTest {
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
        rp = new ResourcePool(resources, 10);
    }

    // Edge Coverage

    @Test
    public void ConstructorCoverage()
    {
        Company c = new Company(rp);
    }

    @Test
    public void hireEmployeeCoverage()
    {
        Company c = new Company(rp);
        c.hireEmployee(e1);
    }

    @Test
    public void fireEmployeeCoverage(){
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.fireEmployee(e1);
    }

    @Test
    public void goBankrupt_sell_everythingCoverage(){
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        c.goBankrupt();
    }

    // end of Edge Coverage

}
