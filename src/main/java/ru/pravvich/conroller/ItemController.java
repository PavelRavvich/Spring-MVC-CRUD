package ru.pravvich.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pravvich.model.Item;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author : Pavel Ravvich.
 * Created : 12.08.17.
 */
@Controller
public class ItemController {

    private final List<Item> items = new CopyOnWriteArrayList<>();

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String home() {
        return "menu";
    }

    @RequestMapping(value = "/home/single_item", method = RequestMethod.POST)
    public String getById(@ModelAttribute int id, ModelMap model) {

        boolean exist = false;

        for (final Item item : items) {
            if (id == item.getId()) {
                model.addAttribute("item", item);
                exist = true;
                break;
            }
        }

        if (!exist) model.addAttribute("massage", "fail");

        return exist ? "single_item" : "all_items";
    }

    @RequestMapping(value = "/home/get_all_items", method = RequestMethod.GET)
    public String allItems(ModelMap model) {
        model.addAttribute("items", items);
        return "all_items";
    }



    @RequestMapping(value = "/home/add_item_interface",
            method = RequestMethod.GET)
    public String addInterface() {
        return "add_item_inter";
    }


    @RequestMapping(value = "/home/add_item", method = RequestMethod.POST)
    public String add(@ModelAttribute final Item item, final ModelMap model) {

        if (items.add(item)) {

            model.addAttribute("massage", "success");

        } else {

            model.addAttribute("massage", "fail");
        }

        return "result_add_item";
    }



    @RequestMapping(value = "/home/delete_item_interface",
            method = RequestMethod.GET)
    public String deleteInterface() {
        return "delete_item_inter";
    }

    @RequestMapping(value = "/home/delete_item", method = RequestMethod.POST)
    public String delete(@ModelAttribute final Item item, ModelMap model) {

        if (items.remove(item)) {

            model.addAttribute("massage", "success");

        } else {

            model.addAttribute("massage", "fail");
        }

        return "result_delete_item";
    }



    @RequestMapping(value = "/home/update_item_interface",
            method = RequestMethod.GET)
    public String updateInterface() {
        return "update_item_interface";
    }

    @RequestMapping(value = "/home/update_item", method = RequestMethod.POST)
    public String update(@ModelAttribute final Item item, ModelMap model) {

        String massage = "fail";

        for (Item i : items) {
            if (i.getId() == item.getId()) {
                items.remove(i);
                items.add(item);
                massage = "success";
                break;
            }
        }

        model.addAttribute("massage", massage);

        return "result_update_item";
    }
}
