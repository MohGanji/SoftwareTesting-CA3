import java.util.Vector;

public class ResourcePool {
    private Vector<Resource> objectPool;
    private int maxResourceCount;
    private int currentPoolCount;

    public ResourcePool(Vector<Resource> object_pool, int max_resource_count) {
        this.objectPool = object_pool;
        this.maxResourceCount = max_resource_count;
        this.currentPoolCount = object_pool.size();
    }

    public int getCurrentPoolCount() {
        return currentPoolCount;
    }

    public Resource acquireResource() {
        if (!objectPool.isEmpty()) {
            Resource resource = objectPool.lastElement();
            objectPool.removeElement(resource);
            return resource;
        } else {
            try {
                return createNewResource();
            } catch (IllegalAccessException e) {
                return null;
            }
        }
    }

    private Resource createNewResource() throws IllegalAccessException {
        if (currentPoolCount >= maxResourceCount) {
            throw new IllegalAccessException();
        } else {
            return new Resource(1500, "Monitor");
        }
    }

    public void releaseResource(Resource resource) {
        objectPool.add(resource);
    }

}
