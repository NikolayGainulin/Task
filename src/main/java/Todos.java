class Todos {
    private Task[] tasks = new Task[0];

    public void add(Task task) {
        Task[] tmp = new Task[tasks.length + 1];
        System.arraycopy(tasks, 0, tmp, 0, tasks.length);
        tmp[tmp.length - 1] = task;
        tasks = tmp;
    }

    public Task[] findAll() {
        return tasks;
    }

    public Task[] search(String query) {
        if (query == null || query.isEmpty()) {
            return new Task[0];
        }

        Task[] result = new Task[0];
        for (Task task : tasks) {
            if (task.matches(query)) {
                Task[] tmp = new Task[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = task;
                result = tmp;
            }
        }
        return result;
    }
}