public class Employee {
    private String name;
    private Resource resource;

    public Employee(String name) {
        this.name = name;
    }

    public void assignResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}
