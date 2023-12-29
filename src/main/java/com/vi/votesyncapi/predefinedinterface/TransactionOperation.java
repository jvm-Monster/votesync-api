package com.vi.votesyncapi.predefinedinterface;
@FunctionalInterface
public interface TransactionOperation<T> {

    T execute();
}
