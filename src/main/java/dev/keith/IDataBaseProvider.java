package dev.keith;

public interface IDataBaseProvider<DB extends IDataBase<?, ?, ?>> {
    Class<? extends DB> provide();
}
