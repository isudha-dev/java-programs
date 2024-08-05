package interview.athenahealth;

public class Test {

    private static Test instance;

    // private ctr
    private Test() {

    }

    public static Test getInstance() {

        if (instance == null) {
            synchronized (Test.class){
                if (instance == null) {
                    instance = new Test();
                }
            }
        }

        return instance;
    }

}
