import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskOfSimpleType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskOfEpicType() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskOfMeetingType() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Task[] actual2 = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertArrayEquals(expected, actual2);
    }

    @Test
    public void shouldGetIdTask() {
        Task task = new Task(33);

        int expected = 33;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitleSimple() {
        SimpleTask task = new SimpleTask(33, "Посмотреть фильм");

        String expected = "Посмотреть фильм";
        String actual = task.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtaskEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(44, subtasks);

        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(subtasks, actual);
    }

    @Test
    public void shouldGetTopicMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProjectMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStartMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();

        Assertions.assertEquals(expected, actual);
    }
}
