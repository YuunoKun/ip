package duke.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeCommandException;
import duke.exception.DukeStorageException;

public class EventTest {

    private String path = java.nio.file.Paths.get("src", "test").toString();

    @Test
    public void test1() {
        TaskList taskList = new TaskList();
        Storage storage = new Storage(path);
        Ui ui = new Ui();

        Command command = new EventCommand("event");

        String message = null;
        try {
            command.execute(taskList, storage, ui);
        } catch (DukeStorageException | DukeCommandException e) {
            message = e.getMessage();
        }

        assertEquals("\u2639 OOPS!!! Wrong 'event' command format!", message);
    }

    @Test
    public void test2() {
        TaskList taskList = new TaskList();
        Storage storage = new Storage(path);
        Ui ui = new Ui();

        Command command = new EventCommand("event party");

        String message = null;
        try {
            command.execute(taskList, storage, ui);
        } catch (DukeStorageException | DukeCommandException e) {
            message = e.getMessage();
        }

        assertEquals("\u2639 OOPS!!! Wrong 'event' command format!", message);
    }

    @Test
    public void test3() {
        TaskList taskList = new TaskList();
        Storage storage = new Storage(path);
        Ui ui = new Ui();

        Command command = new EventCommand("event party /by 12/12/2020 1234");

        String message = null;
        try {
            command.execute(taskList, storage, ui);
        } catch (DukeStorageException | DukeCommandException e) {
            message = e.getMessage();
        }

        assertEquals("\u2639 OOPS!!! Wrong 'event' command format!", message);
    }
}
