package com.user.user.service;
import com.user.user.repository.taskrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.user.model.tasks;


@Service
public class taskservice {
    
    @Autowired 
    private taskrepo tr;

    @Autowired 
    private userservice us;
    
    public void getTaskById(){

    }

    public void getAllTasks(){
            //User logs in and sees all tasks with buttons that have different actions 
            //Task table ha
    }

    public void createConfirmScheduleTask (){
        //Event propagation:
        //-> Panelist has been selected
        //Given the panelist has provided availability:
        //Candidate selects best time for meeting based on Panelist availability 
        //When candidate confirms their schedule:
        //This method is triggered and adds "please confirm this meeting" to the list of tasks
        //And a notification sent to Panelist and Candidate of the confirmed time 
        //
        
    }
}
