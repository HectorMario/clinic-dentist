package util;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatcher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.function.Supplier;

public class EntityManagerUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinic");
        return factory.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager entityManager = createEntityManagerProxy(EntityManager.class, EntityManagerUtil::getEntityManager);
        System.out.println("EntityManager class: " + entityManager.getClass().getCanonicalName());
    }

    @SuppressWarnings("unchecked")
    public static <T> T createEntityManagerProxy(Class<T> interfaceType, Supplier<T> realInstanceSupplier) {
        Class<? extends T> proxyType = new ByteBuddy()
                .subclass(interfaceType)
                .method(any())
                .intercept(InvocationHandlerAdapter.of(new EntityManagerInvocationHandler((Supplier<EntityManager>) realInstanceSupplier)))
                .make()
                .load(interfaceType.getClassLoader())
                .getLoaded();

        try {
            return proxyType.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error creating proxy instance", e);
        }
    }

    private static ElementMatcher<MethodDescription> any() {
        return new ElementMatcher<MethodDescription>() {
            @Override
            public boolean matches(MethodDescription target) {
                return true;
            }

            @Override
            public String toString() {
                return "any()";
            }
        };
    }

    private static class EntityManagerInvocationHandler implements InvocationHandler {
        private final Supplier<EntityManager> realInstanceSupplier;

        public EntityManagerInvocationHandler(Supplier<EntityManager> realInstanceSupplier) {
            this.realInstanceSupplier = realInstanceSupplier;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            EntityManager realInstance = realInstanceSupplier.get();
            return method.invoke(realInstance, args);
        }
    }
}


