package Transactions.TransactionManager;

import Transactions.sql.Session;

import java.util.function.Consumer;
import java.util.function.Function;

public interface TransactionManager {
    <T> T required(Function<Session, T> sessionFunction);

    <T> T requiredNew(Function<Session, T> sessionFunction);

    <T> void required(Consumer<Session> sessionConsumer);

    <T> void requiredNew(Consumer<Session> sessionConsumer);
}
