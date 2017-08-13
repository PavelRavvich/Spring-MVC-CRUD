package ru.pravvich.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pravvich.model.Item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author : Pavel Ravvich.
 * Created : 12.08.17.
 */
@Controller
public class ItemController {
    /**
     * Fake database for example.
     */
    private final Map<Integer, Item> items = new ConcurrentHashMap<>();
    /**
     * Generator of id.
     */
    private final AtomicInteger idGen = new AtomicInteger(1);

    /**
     * Default constructor.
     */
    public ItemController() {
        //Demo Items.
        items.put(1, new Item(idGen.getAndIncrement(), "test_1", "test_1"));
        items.put(2, new Item(idGen.getAndIncrement(), "test_2", "test_2"));
    }

    /**
     * Get home page.
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String home() {
        return "menu";
    }

    /**
     * Get Page with view Item by Id.
     *
     * @param id of Item.
     * @return If Item exist then get single item page else find error page.
     */
    @RequestMapping(value = "/menu/get_single_item", method = RequestMethod.GET)
    public String getById(@RequestParam(value = "id") int id, ModelMap model) {

        model.addAttribute("item", items.get(id));

        return "single_item";
    }

    /**
     * Get all Items page.
     *
     * @return all Items list.
     */
    @RequestMapping(value = "/menu/get_all_items", method = RequestMethod.GET)
    public String getAllItems(ModelMap model) {

        model.addAttribute("items", items.values());

        return "all_items";
    }

    /**
     * Get page for addition single Item.
     */
    @RequestMapping(value = "/menu/add_item_page", method = RequestMethod.GET)
    public String addItem() {
        return "add_item";
    }

    /**
     * Action addition the new Item to repo.
     *
     * @return page with all items.
     */
    @RequestMapping(value = "/menu/add_item", method = RequestMethod.POST)
    public String add(@RequestParam(value = "name") final String name,
                      @RequestParam(value = "description") final String desc,
                      ModelMap model) {

        final int id = idGen.getAndIncrement();

        items.put(id, new Item(id, name, desc));

        return getAllItems(model);
    }

    /**
     * Delete Item from memory action.
     *
     * @param id of Item for delete.
     * @return all Items page.
     */
    @RequestMapping(value = "/menu/delete_item", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") int id, ModelMap model) {

        items.remove(id);

        return getAllItems(model);
    }

    /**
     * Get page for update single Item.
     *
     * @param id Item for update.
     */
    @RequestMapping(value = "/menu/update_item_page", method = RequestMethod.GET)
    public String updateItemPage(@RequestParam(value = "id") final int id,
                                 final ModelMap model) {

        model.addAttribute("item", items.get(id));

        return "update_item";
    }

    /**
     * Update Item action.
     *
     * @param item new state for Item.
     * @return page with all items list.
     */
    @RequestMapping(value = "/menu/update_item", method = RequestMethod.POST)
    public String update(@ModelAttribute("item") Item item, ModelMap model) {

        items.replace(item.getId(),item);

        return getAllItems(model);
    }
}
