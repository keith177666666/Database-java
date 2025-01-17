package dev.keith;

public interface IDataBaseProvider {
    Class<IDataBase<?, ?, ?>> provide();
}
