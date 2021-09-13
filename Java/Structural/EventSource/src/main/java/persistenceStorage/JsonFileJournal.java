package persistenceStorage;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import events.AccountCreateEvent;
import events.Event;
import events.MoneyDepositEvent;
import events.MoneyWithdrawEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonFileJournal {

    private final File file;
    private final List<String> events = new ArrayList<>();
    private int indexOfEvent = 0;

    /**
     * Instantiates a new Json file journal.
     */
    public JsonFileJournal() {
        file = new File("Journal.json");
        /**
         This so that when there are files in specified file they won't get overridden
         so they are stored in the memory.
         */
        populateMemoryWithFileData();
    }


    /**
     * Write.
     *
     * @param domainEvent the domain event
     */
    public void write(Event domainEvent) {
        var gson = new Gson();
        JsonElement jsonElement;
        if (domainEvent instanceof AccountCreateEvent) {
            jsonElement = gson.toJsonTree(domainEvent, AccountCreateEvent.class);
        } else if (domainEvent instanceof MoneyWithdrawEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyWithdrawEvent.class);
        } else if (domainEvent instanceof MoneyDepositEvent) {
            jsonElement = gson.toJsonTree(domainEvent, MoneyDepositEvent.class);
        } else {
            throw new RuntimeException("Journal Event not recegnized");
        }

        try (var output = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
            var eventString = jsonElement.toString();
            output.write(eventString + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reset.
     */
    public void reset() {
        file.delete();
    }


    /**
     * Read next domain event.
     *
     * @return the domain event
     */
    public Event readNext() {
        populateMemoryWithFileData();
        if (indexOfEvent >= events.size()) {
            return null;
        }
        var event = events.get(indexOfEvent);
        indexOfEvent++;

        var parser = new JsonParser();
        var jsonElement = parser.parse(event);
        var eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
        var gson = new Gson();
        Event domainEvent;
        if (eventClassName.equals("AccountCreateEvent")) {
            domainEvent = gson.fromJson(jsonElement, AccountCreateEvent.class);
        } else if (eventClassName.equals("MoneyDepositEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyWithdrawEvent.class);
        } else if (eventClassName.equals("MoneyTransferEvent")) {
            domainEvent = gson.fromJson(jsonElement, MoneyDepositEvent.class);
        } else {
            throw new RuntimeException("Journal Event not recegnized");
        }
        return domainEvent;
    }

    private void populateMemoryWithFileData() {
        if (file.exists()) {
            try (var input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                String line;
                while ((line = input.readLine()) != null) {
                    events.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            reset();
        }
    }
}
