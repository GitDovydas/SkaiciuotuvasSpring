package com.spring.skaiciuotuvas.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Java Persistence API
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    // Transakcijų gamykla. Transakcijų gali būti daug, bet gamykla - viena.
    // Transakcija - bet koks CRUD veiksmas su duomenų baze.
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) { // Singleton šablonas - jeigu neturime gamyklos - sukuriame.
            // Gamyklą susiejame su persistence.xml failu, kuriame aprašome prisijungimus prie duomenų bazės.
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        // Grąžiname entityManagerFactory Objektą
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
