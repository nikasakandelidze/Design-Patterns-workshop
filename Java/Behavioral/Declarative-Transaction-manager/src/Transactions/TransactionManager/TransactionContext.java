package Transactions.TransactionManager;

import java.util.Deque;
import java.util.LinkedList;

public class TransactionContext<T> {

    private static class Enclosure<E> {
        int level;
        E session;

        private Enclosure(int level, E session){
            super();
            this.level = level;
            this.session = session;
        }
    }

    private Deque<Enclosure<T>> enclosures = new LinkedList<>();

    void in(T session) {
        enclosures.push(new Enclosure<>(1, session));
    }

    T out() {
        return enclosures.pop().session;
    }

    void incEnclosure() {
        enclosures.peek().level++;
    }

    void decEnclosure() {
        enclosures.peek().level--;
    }

    int getEnclosure() {
        return enclosures.peek().level;
    }

    T getSession() {
        return enclosures.peek().session;
    }
}

