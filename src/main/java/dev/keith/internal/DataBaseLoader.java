package dev.keith.internal;

import dev.keith.IDataBaseProvider;
import org.jetbrains.annotations.ApiStatus;

import java.util.ServiceLoader;

@ApiStatus.Internal
public class DataBaseLoader {
    static {
        ServiceLoader<IDataBaseProvider> loader = ServiceLoader.load(IDataBaseProvider.class);
        dataBaseClass = loader.stream()
                .toList()
                .getFirst()
                .get()
                .provide()
                .getName();
    }
    public static String dataBaseClass;
}
