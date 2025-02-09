package dev.keith.internal;

import dev.keith.IDataBaseProvider;
import org.jetbrains.annotations.ApiStatus;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

@ApiStatus.Internal
public class DataBaseLoader {
    static {
        ServiceLoader<IDataBaseProvider> loader = ServiceLoader.load(IDataBaseProvider.class);
        try {
            dataBaseClass = loader.stream()
                    .toList()
                    .getFirst()
                    .get()
                    .provide()
                    .getName();
        } catch (NoSuchElementException e) {
            System.out.println("No DataBase is currently exists.");
            dataBaseClass = "";
        }
    }
    public static String dataBaseClass;
}
