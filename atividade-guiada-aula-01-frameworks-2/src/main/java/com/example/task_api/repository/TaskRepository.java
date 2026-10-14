package com.example.task_api.repository;

import com.example.task_api.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {
    private final ConcurrentMap<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task findById(long id) {
        return tasks.get(id);
    }

    public Task save(Task task) {
        if (task.getId() <= 0) {
            task.setId(idGenerator.incrementAndGet());
        } else {
            idGenerator.accumulateAndGet(task.getId(), Math::max);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public boolean delete(long id) {
        return tasks.remove(id) != null;
    }

    public boolean existsById(long id) {
        return tasks.containsKey(id);
    }
}
