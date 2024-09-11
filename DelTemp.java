public class DelTemp {
    private static DelTemp instance;

    private DelTemp() {

    }

    public static DelTemp getInstance() {
        if(instance == null) {
            synchronized (DelTemp.class) {
                if(instance == null) {
                    instance = new DelTemp();
                }
            }
        }

        return instance;

    }
}
