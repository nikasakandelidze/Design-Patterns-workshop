package Transactions.TransactionManager;

import Transactions.sql.Session;
import Transactions.sql.SqlSession;

import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionManagerImpl implements TransactionManager {
    @Override
    public <T> T required(Function<Session, T> sessionFunction) {
        TransactionContext<Session> context = Transactions.<Session>getContext();
        try {
            if (context == null) {
                context = new TransactionContext<>();
                Transactions.setContext(context);
                context.in(new SqlSession());
            } else {
                context.incEnclosure();
            }

            final T apply = sessionFunction.apply(context.getSession());
            context.decEnclosure();
            if (context.getEnclosure() == 0) {
                Transactions.removeContext();
                Session session = context.out();
                session.commit();
                session.close();
            }
            return apply;
        } catch (Exception e) {
            Transactions.removeContext();
            Session session = context.out();
            session.rollback();
            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public <T> T requiredNew(Function<Session, T> sessionFunction) {
        TransactionContext<SqlSession> context = Transactions.getContext();
        try {
            if (context == null) {
                context = new TransactionContext<>();
                Transactions.setContext(context);
            }
            context.in(new SqlSession());

            final T apply = sessionFunction.apply(context.getSession());
            context.decEnclosure();
            if (context.getEnclosure() == 0) {
                Transactions.removeContext();
                SqlSession session = context.out();
                session.commit();
                session.close();
            }
            return apply;
        } catch (Exception e) {
            Transactions.removeContext();
            SqlSession session = context.out();
            session.rollback();
            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public <T> void required(Consumer<Session> sessionConsumer) {
        required(session -> {
            sessionConsumer.accept(session);
            return (Void)null;
        });
    }

    @Override
    public <T> void requiredNew(Consumer<Session> sessionConsumer) {
        required(session -> {
            sessionConsumer.accept(session);
            return (Void)null;
        });
    }
}
