import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class PrimePathCoverageCompanyTest {
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

    // Prime Path Coverage

    @Test
    public void goBankrupt_ZeroEmployeeCoverage()   // 1 2 5
    {
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.goBankrupt();
    }

    @Test
    public void goBankrupt_OneEmployeeCoverage()    // 2 3 4 2
    {

        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.goBankrupt();
    }

    @Test
    public void goBankrupt_MoreThanOneEmployeeCoverage(){   // 3 4 2 3
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        Assert.assertThat(c.goBankrupt(), Matchers.lessThan(0));
    }

    @Test
    public void sell_everything_ZeroResourceCoverage(){     // 1 2 3 6
        rp = new ResourcePool(new Vector<>(), 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        Assert.assertThat(c.goBankrupt(), Matchers.lessThan(0));
    }

    @Test
    public void sell_everything_OneResourceCoverage(){      // 3 4 5 3
        resources = new Vector<>();
        resources.add(r1);
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        Assert.assertThat(c.goBankrupt(), Matchers.lessThan(0));
    }

    @Test
    public void sell_everything_MoreThanOneResourceCoverage(){      // 4 5 3 4
        resources = new Vector<>();
        resources.add(r1);
        resources.add(r2);
        rp = new ResourcePool(resources, 10);
        Company c = new Company(rp);
        c.hireEmployee(e1);
        c.hireEmployee(e2);
        Assert.assertThat(c.goBankrupt(), Matchers.lessThan(0));
    }

    // end of Prime Path Coverage

}
