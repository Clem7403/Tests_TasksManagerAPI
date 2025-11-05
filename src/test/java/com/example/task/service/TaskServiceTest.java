package com.example.task.service;

import com.example.task.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    //On initialise un nouveau TAskService avant chaque test pour qu'ils restent indépendants.
    @BeforeEach
    public void setup(){
        taskService = new TaskService();
    }

    @Test
    void testAddTask(){
        Task task = taskService.addTask("TestAjoutTache");

        assertEquals(1, taskService.getAllTasks().size()); //La liste contient 1 tâche
        assertEquals("TestAjoutTache", task.getDescription());
        assertEquals(Task.Status.EN_COURS, task.getStatus()); //status utilisé par défaut
    }

    @Test
    void testRemoveTask(){
        Task task = taskService.addTask("TestRemove");

        boolean removed = taskService.removeTask(task.getId());

        assertTrue(removed);
        assertEquals(0, taskService.getAllTasks().size()); //liste vide

        //tester la suppression d'un ID inexistant
        assertFalse(taskService.removeTask(999));
    }

    @Test
    void testMarkAsDone(){
        Task task = taskService.addTask("TestTerminerTache");

        boolean done = taskService.markTaskAsDone(task.getId());

        assertTrue(done);
        assertEquals(Task.Status.TERMINE, task.getStatus());

        //Vérifie que ID invalides soient gérés.
        assertFalse(taskService.markTaskAsDone(999));
    }

    @Test
    void testGetAllTasks(){
        taskService.addTask("TestAjoutTache1");
        taskService.addTask("TestAjoutTache2");

        assertEquals(2, taskService.getAllTasks().size());
    }
}
