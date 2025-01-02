package dev.keith;


/**
 * Please use Class.forName(YOUR_DEFAULT_DATABASE_CLASS) and initial this helper.
 */
@SuppressWarnings("unused")
public final class DataBaseHelper {
    private final IDataBase<?, ?, ?> defaultDB;
    private final IDataBaseObserver<?, ?, ?> defaultObserver;
    private static boolean isInitialed;
    private static DataBaseHelper instance;
    public DataBaseHelper(IDataBase<?, ?, ?> defaultDB, IDataBaseObserver<?, ?, ?> defaultObserver) {
        this.defaultDB = defaultDB;
        this.defaultObserver = defaultObserver;
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
    public IDataBase<?, ?, ?> getDefaultDataBase() {
        return defaultDB;
    }
    public IDataBaseObserver<?, ?, ?> getDefaultObserver() {
        return defaultObserver;
    }
}
