package dev.keith;

import dev.keith.internal.DataBaseLoader;

public class DataBaseCore {
    static {
        try {
            Class.forName("dev.keith.internal.DataBaseLoader");
            Class.forName("dev.keith.DataBaseHelper");
            Class.forName(DataBaseLoader.dataBaseClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
