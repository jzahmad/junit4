package junit.framework;

import org.junit.internal.Throwables;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class TestSuite2{

    static public Test createTest(Class<?> theClass, String name) {
        Constructor<?> constructor;
        try {
            constructor = getTestConstructor(theClass);
        } catch (NoSuchMethodException e) {
            return warning("Class " + theClass.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
        Object test;
        try {
            if (constructor.getParameterTypes().length == 0) {
                test = constructor.newInstance(new Object[0]);
                if (test instanceof TestCase) {
                    ((TestCase) test).setName(name);
                }
            } else {
                test = constructor.newInstance(new Object[]{name});
            }
        } catch (InstantiationException e) {
            return (warning("Cannot instantiate test case: " + name + " (" + Throwables.getStacktrace(e) + ")"));
        } catch (InvocationTargetException e) {
            return (warning("Exception in constructor: " + name + " (" + Throwables.getStacktrace(e.getTargetException()) + ")"));
        } catch (IllegalAccessException e) {
            return (warning("Cannot access test case: " + name + " (" + Throwables.getStacktrace(e) + ")"));
        }
        return (Test) test;
    }

    public static Constructor<?> getTestConstructor(Class<?> theClass) throws NoSuchMethodException {
        try {
            return theClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            // fall through
        }
        return theClass.getConstructor();
    }

    public static Test warning(final String message) {
        return new TestCase("warning") {
            @Override
            protected void runTest() {
                fail(message);
            }
        };
    }
}
