package com.tiy.practice;

import jodd.json.JsonSerializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crci1 on 12/24/2016.
 */

@RestController
public class ToDoRestController {
    @RequestMapping(path = "/list.json", method = RequestMethod.GET)
    public ArrayList<ToDoItem> jsonHome(String task, boolean completed, HttpSession session) {
        ArrayList<ToDoItem> toDoItems = new ArrayList<>();
        toDoItems.add(new ToDoItem((String) session.getAttribute(task), completed));


        return toDoItems;
    }

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



//    @RequestMapping(path = "alltasks.json", method = RequestMethod.POST)
//    public ToDoItem jsonToDos()

//    @RequestMapping(path = "/mytasks.json", method = RequestMethod.GET)
//    public String saveJson(ToDoItem toDoItem) {
//        JsonSerializer jsonSerializer = new JsonSerializer().deep(true);
//        String jsonString = jsonSerializer.serialize(toDoItem);
//        return jsonString;
//
//
//    }
//    @RequestMapping(path = "/alltasks")
//    public ToDoItem jsonRestore(String jsonTD) {
//        JsonParser toDoItemParser = new JsonParser();
//        ToDoItem item = toDoItemParser.parse(jsonTD, ToDoItem.class);
//
//        return item;
//    }
}
