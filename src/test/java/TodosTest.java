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

        Task[] expected_2 = {};
        Task[] actual_2 = todos.search("Вода");
        Assertions.assertArrayEquals(expected_2, actual_2);
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

    @Test
    public void shouldMatchesTask() {
        Task task = new Task(1);

        boolean expected = false;
        boolean actual = task.matches("a");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldEqualsTask() {
        Task task = new Task(2);
        Task task2 = task;
        Task task3 = new Task(2);
        SimpleTask task_4 = new SimpleTask(33, "Посмотреть фильм");


        boolean expected = true;
        boolean actual = task.equals(task2);

        Assertions.assertEquals(expected, actual);

        boolean expected_2 = false;
        boolean actual_2 = task.equals(null);

        Assertions.assertEquals(expected_2, actual_2);

        boolean expected_3 = true;
        boolean actual_3 = task.equals(task3);

        Assertions.assertEquals(expected_3, actual_3);

        boolean expected_4 = false;
        boolean actual_4 = task.equals(task_4);

        Assertions.assertEquals(expected_4, actual_4);
    }

    @Test
    public void shouldHashTask() {
        Task task = new Task(2);
        Task task2 = new Task(2);

        int expected = task2.hashCode();
        int actual = task.hashCode();

        Assertions.assertEquals(expected, actual);
    }
}
