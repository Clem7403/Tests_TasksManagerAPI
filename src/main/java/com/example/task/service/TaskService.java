package com.example.task.service;

import com.example.task.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
/* Les responsabilités :
    - Gestion d'une liste de tâches (List<Task)
    - Ajout d'une tâche (addTAsk(description)
    - Suppression d'une tâche (removeTask(id))
    - RÉcupérer la liste (getAllTasks())
    - Marquer une tâche comme terminée (markTaskAsDone(id))


    Prévoir les tests unitaires sur
 */
public class TaskService {

        private final List<Task> tasks = new ArrayList<>();


        //Ajout d'une tâche
        public Task addTask(String description){
            Task newTask = new Task(description);
            tasks.add(newTask);
            return newTask;
        }

        //Supprimer une tâche par ID
        public boolean removeTask(int id){
            return tasks.removeIf(task -> task.getId()== id);
        }

        //Récupérer la liste de toutes les tâches
        public List<Task> getAllTasks(){
            return new ArrayList<>(tasks);
        }

        //MArquer une tâche comme terminée
        public boolean markTaskAsDone(int id){
            Optional<Task> optionalTask = tasks.stream().filter(task -> task.getId() == id).findFirst();
            if(optionalTask.isPresent()){
                optionalTask.get().markAsDone();
                return true;
            }
            return false;
        }
    /// TO BE IMPLEMENTED
    /// Handle and manage a list of Task objects
}
