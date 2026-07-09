package dev.samalombo.MagicFridgeAI.controller;

import dev.samalombo.MagicFridgeAI.model.Fooditem;
import dev.samalombo.MagicFridgeAI.service.FooditemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FooditemController {

    private FooditemService service;

    public FooditemController(FooditemService fooditemService) {
        this.Service = fooditemService;
    }

    //POST
    public ResponseEntity<Fooditem> criar(@RequestBody Fooditem fooditem){
        Fooditem salvo = service.salvar(fooditem);
        return ResponseEntity.ok(salvo);
    }

    //GET


    //UPDATE

    //DELETE


}

