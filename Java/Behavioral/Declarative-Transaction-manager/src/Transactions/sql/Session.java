package Transactions.sql;

public interface Session {
    void commit();
    void rollback();
    void close();
}
