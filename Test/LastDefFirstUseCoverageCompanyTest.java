import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class LastDefFirstUseCoverageCompanyTest {
    public ResourcePool rp;
    public Resource r1 = new Resource(1, "gojeh");
    public Resource r2 = new Resource(10, "laptop");
    public Resource r3 = new Resource(100, "car");
    public Employee e1 = new Employee("gholi");
    public Employee e2 = new Employee("gholam");
    public Vector<Resource> resources = new Vector<>();

    private void initEmployees(){
        e1 = new Employee("gholi");
        e2 = new Employee("gholam");
    }

    private void initResources() {
        r1 = new Resource(1, "gojeh");
        r2 = new Resource(10, "laptop");
        r3 = new Resource(100, "car");
    }

    private void fillResourcePool() {
        resources.add(r1);
        resources.add(r2);
        resources.add(r3);
    }

    @Before
    public void initialize(){
        initResources();
        initEmployees();
        fillResourcePool();
    }

    // All DU Path Coverage

    @Test
    public void LastDefFirstUseCoverage()   // 1 2 5
    {
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        Assert.assertThat(c.goBankrupt(), Matchers.lessThan(0));
        Assert.assertEquals(0, rp.getCurrentPoolCount());
    }

    // end of All DU Path Coverage

}
