package stack.commons.testing.mocking.soq59519047;

public interface Service {

    String generate(String var1) throws Exception;

    public static final class Factory {
        private static Service instance = null;

        public Factory() {
        }

        public static final Service getInstance() {
            if (instance == null) {
                instance = (Service)EnterpriseConfiguration.getInstance().loadImplementation(Service.class);
            }

            return instance;
        }
    }
}
