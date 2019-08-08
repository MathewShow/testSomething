package thread;

class DeadlockRisk {
    private static class Resource {
        public int value;
    }

    private Resource resourceA =new Resource();
    private Resource resourceB =new Resource();

    public int read() {
        synchronized (resourceA) {
            System.out.println("read():" + Thread.currentThread().getName() +"��ȡ��resourceA������");
            synchronized (resourceB) {
                System.out.println("read():" + Thread.currentThread().getName() +"��ȡ��resourceB������");
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a,int b) {
        synchronized (resourceB) {
            System.out.println("write():" + Thread.currentThread().getName() +"��ȡ��resourceA������");
            synchronized (resourceA) {
                System.out.println("write():" + Thread.currentThread().getName() +"��ȡ��resourceB������");
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }
}
