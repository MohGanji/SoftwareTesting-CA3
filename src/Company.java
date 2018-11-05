import java.util.Vector;

public class Company {
    private Vector<Employee> employees;
    private ResourcePool resourcePool;

    static final int EKHTELAS_SIZE = 5000;

    public Company(ResourcePool resourcePool) {
        this.employees = new Vector<>();
        this.resourcePool = resourcePool;
    }

    public void hireEmployee(Employee employee) {
        Resource resource = resourcePool.acquireResource();
        employee.assignResource(resource);
        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        Resource resource = employee.getResource();
        resourcePool.releaseResource(resource);
        employees.removeElement(employee);
    }

    public int goBankrupt() {
        for (Employee employee : employees) {
            resourcePool.releaseResource(employee.getResource());
        }
        int company_value = sell_everything();
        company_value = company_value - EKHTELAS_SIZE;
        return company_value;
    }

    private int sell_everything() {
        int value = 0;
        int poolCount = resourcePool.getCurrentPoolCount();
        Resource resource;
        for (int i = 0; i < poolCount; i++) {
            resource = resourcePool.acquireResource();
            value += resource.getPrice();
        }
        return value;
    }
}
