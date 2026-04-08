package sn.isi.l3gl.api.task_api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task_core.entities.Task;
import sn.isi.l3gl.core.task_core.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestParam String title,
                           @RequestParam String description) {
        return taskService.createTask(title, description);
    }

    @GetMapping
    public List<Task> listTasks() {
        return taskService.listTasks();
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id,
                             @RequestParam Task.TaskStatus status) {
        return taskService.updateStatus(id, status);
    }

    @GetMapping("/done/count")
    public long countCompletedTasks() {
        return taskService.countCompletedTasks();
    }
}
