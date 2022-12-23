package com.Banco.app.backend.controllers;

import com.Banco.app.backend.Entities.Menu;
import com.Banco.app.backend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/{id}")
    public List<Menu> getMenusbyId(@PathVariable Integer id) {

        List<Menu> menu = menuRepository.findByRestaurante(id);

        return menu;

    }

    @PostMapping
    public Menu postMenus(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return menu;
    }


    @PutMapping("/{id}")
    public Menu putMenusbyId(@PathVariable Integer id, @RequestBody Menu menu) {

        Optional<Menu> menuCurrent = menuRepository.findById(id);

        if (menuCurrent.isPresent()) {

            Menu menuBnaco = menuCurrent.get();


            menuBnaco.setTipo(menu.getTipo());


            Banco.save(menuBnaco);

            return menuBnaco;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Menu deleteMenusbyId(@PathVariable Integer id) {

        Optional<Menu> menu = banco.findById(id);

        if (menu.isPresent()) {

            Menu menuBnaco = menu.get();

            banco.deleteById(id);

            return menuBnaco;
        }

        return null;

    }
}
