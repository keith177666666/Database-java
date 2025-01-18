package dev.keith;

public interface IDataBaseProvider<DB extends IDataBase<?, ?, ?>> {
    Class<DB> provide();
}
