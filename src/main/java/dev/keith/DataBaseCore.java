package dev.keith;

import dev.keith.internal.DataBaseLoader;

public class DataBaseCore {
    static {
        try {
            Class.forName("dev.keith.internal.DataBaseLoader");
            Class.forName("dev.keith.DataBaseHelper");
            try {
                Class.forName(DataBaseLoader.dataBaseClass);
            } catch (ClassNotFoundException ignored) {}
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
