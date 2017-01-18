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

    /**
     * path that ask for user login.
     * @param model
     * @param session
     * @return "home.html"
     */

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));

        return "home";
    }

    /**
     * sign user in if exist
     * @param session creates a session to save a userName
     * @param userName sets the username to the session
     * @return "home.html"
     */

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    /**
     * get the list of items
     * @param model model the objects
     * @return returns newview.html
     */
    @RequestMapping(path = "/newview", method = RequestMethod.GET)
    public String listMethod(Model model) {

        model.addAttribute("list-of-items", toDoItems);
        return "newview";

    }

    /**
     * Adds a totoItem to the list
     * @param session sets a item to the seession
     * @param item adds a item to the list
     * @return returns newview.html
     */
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public String listMethod(HttpSession session, String item) {
        toDoItems.add(new ToDoItem(item, false));
        session.setAttribute("item", item);
        return "redirect:newview";
    }

    /**
     * post method that marks the toItem to true of false
     * @param quantity how many to do items do you have.
     * @return returns newview.html
     */

    @RequestMapping(path = "/mark", method = RequestMethod.POST)
    public String markMethod(String quantity) {

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
