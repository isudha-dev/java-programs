package interview.athenahealth;

public class SingletonEg {
    private static SingletonEg instance;

    private SingletonEg() {

    }

    public static SingletonEg getInstance() {

        if (instance == null){
            synchronized (SingletonEg.class) {
                if (instance == null) {
                    instance = new SingletonEg();
                }
            }
        }
        return instance;
    }


}
