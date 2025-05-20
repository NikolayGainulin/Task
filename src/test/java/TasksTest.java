import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        assertTrue(task.matches("Позвонить"));
        assertTrue(task.matches("родителям"));
        assertFalse(task.matches("написать"));
        assertFalse(task.matches(""));
        assertFalse(task.matches(null));
    }

    @Test
    public void testSimpleTaskGetters() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        assertEquals(1, task.getId());
        assertEquals("Позвонить родителям", task.getTitle());
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        assertTrue(epic.matches("Молоко"));
        assertTrue(epic.matches("Яйца"));
        assertTrue(epic.matches("Хлеб"));
        assertFalse(epic.matches("Вода"));
        assertFalse(epic.matches(""));
        assertFalse(epic.matches(null));
    }

    @Test
    public void testEpicGetters() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        assertEquals(55, epic.getId());
        assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанка"));
        assertFalse(meeting.matches("Сбербанк"));
        assertFalse(meeting.matches("обеда")); // так как ищем только в topic и project
        assertFalse(meeting.matches(""));
        assertFalse(meeting.matches(null));
    }

    @Test
    public void testMeetingGetters() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertEquals(555, meeting.getId());
        assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
        assertEquals("Приложение НетоБанка", meeting.getProject());
        assertEquals("Во вторник после обеда", meeting.getStart());
    }

    @Test
    public void testTaskInheritance() {
        SimpleTask simpleTask = new SimpleTask(1, "Задача");
        assertTrue(simpleTask instanceof Task);

        Epic epic = new Epic(2, new String[]{});
        assertTrue(epic instanceof Task);

        Meeting meeting = new Meeting(3, "", "", "");
        assertTrue(meeting instanceof Task);
    }
}