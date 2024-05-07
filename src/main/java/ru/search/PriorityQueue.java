package ru.search;

import java.util.LinkedList;

public class PriorityQueue {
    public LinkedList<Task> getTasks() {
        return tasks;
    }

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритета.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        int mainPriority = task.getPriority();
        for (Task element : tasks) {
            if (mainPriority < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

}
