package stack.commons.testing.mocking.soq59519047;

public class EnterpriseConfiguration {

    private static EnterpriseConfiguration instance;

    private EnterpriseConfiguration() {
    }

    public static EnterpriseConfiguration getInstance() {
        if(instance == null) {
            instance = new EnterpriseConfiguration();
        }

        return instance;
    }

    public Object loadImplementation(Class<?> clazz) {
        return new ServiceImpl();
    }


}
