package com.tiy.practice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by crci1 on 12/24/2016.
 */

@RestController
public class ToDoRestController {

    /**
     *  Get method the gets a list of to do items
     * @param task
     * @param completed
     * @param session
     * @return
     */
    @RequestMapping(path = "/list.json", method = RequestMethod.GET)
    public ArrayList<ToDoItem> jsonHome(String task, boolean completed, HttpSession session) {
        ArrayList<ToDoItem> toDoItems = new ArrayList<>();
        toDoItems.add(new ToDoItem((String) session.getAttribute(task), completed));
        return toDoItems;
    }

    /**
     *
     * @param model
     * @param task
     * @param completed
     * @return
     */
    @RequestMapping(path = "/newview.json", method = RequestMethod.GET)
    public ArrayList<ToDoItem> jsonHome(Model model, String task, boolean completed) {
        ArrayList<ToDoItem> toDoItems = new ArrayList<>();
        toDoItems.add(new ToDoItem("Clean house", false));
        toDoItems.add(new ToDoItem("Make money", false));
        toDoItems.add(new ToDoItem("change tires", false));
        toDoItems.add(new ToDoItem("buy gifts", false));
        model.addAttribute(toDoItems);
        return toDoItems;
    }

}
