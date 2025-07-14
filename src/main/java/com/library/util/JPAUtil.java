package com.library.util;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("libraryPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
