package dev.keith;


/**
 * Please use Class.forName(YOUR_DEFAULT_DATABASE_CLASS) and initial this helper.
 */
public final class DataBaseHelper {
    private final IDataBase<?, ?> defaultDB;
    private static boolean isInitialed;
    private static DataBaseHelper instance;
    public DataBaseHelper(IDataBase<?, ?> defaultDB) {
        this.defaultDB = defaultDB;
        if (isInitialed) {
            throw new IllegalStateException("The helper has been initialed!");
        }
        isInitialed = true;
        instance = this;
    }
    public static DataBaseHelper getInstance() {
        if(isInitialed) {
            return instance;
        }
        return null;
    }
    public IDataBase<?, ?> getDefaultDataBase() {
        return defaultDB;
    }
}
