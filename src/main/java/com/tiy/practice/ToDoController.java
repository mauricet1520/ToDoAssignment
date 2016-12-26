package com.tiy.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crci1 on 12/24/2016.
 */

@Controller
public class ToDoController {
    List<ToDoItem> toDoItems = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));

        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        System.out.println(userName);
        session.setAttribute("userName", userName);
        return "redirect:/";
    }


    @RequestMapping(path = "/newview", method = RequestMethod.GET)
    public String listMethod(Model model, HttpSession session, String task, boolean completed) {

        model.addAttribute("list-of-items", toDoItems);
        return "newview";

    }


    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public String listMethod(HttpSession session, String item) {
        toDoItems.add(new ToDoItem(item, false));
        System.out.println(item);

        session.setAttribute("item", item);

        return "redirect:newview";
    }

    @RequestMapping(path = "/mark", method = RequestMethod.POST)
    public String markMethod(HttpSession session, String quantity) {

        if (quantity.equalsIgnoreCase("")) {
            return "redirect:newview";
        }

        int valueHolder = Integer.parseInt(quantity);

        if (valueHolder - 1 >= toDoItems.size()) {
            return "redirect:newview";

        } else {
            toDoItems.get(valueHolder - 1).setCompleted(true);
        }
        return "redirect:newview";
    }

}
