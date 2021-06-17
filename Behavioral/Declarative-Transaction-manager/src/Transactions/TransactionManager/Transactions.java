package Transactions.TransactionManager;

public class Transactions {
    private static final ThreadLocal<TransactionContext<?>> context = new ThreadLocal<>();

    private Transactions(){}

    public static void setContext(TransactionContext<?> transactionContext) {
        context.set(transactionContext);
    }

    @SuppressWarnings("unchecked")
    public static <T> TransactionContext<T> getContext() {
        return (TransactionContext<T>)context.get();
    }

    public static TransactionContext<?> removeContext() {
        TransactionContext<?> transactionContext = context.get();
        context.remove();
        return transactionContext;
    }


}
