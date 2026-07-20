package dev.samalombo.MagicFridgeAI.controller;

import dev.samalombo.MagicFridgeAI.dto.FooditemDTO;
import dev.samalombo.MagicFridgeAI.service.FooditemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/food")
public class FooditemController {

    private FooditemService service;

    public FooditemController(FooditemService fooditemService) {
        this.service = fooditemService;
    }

    // Boas vindas
    @GetMapping("/boasVindas")
    public String boasVindas (){
        return "Bem vindo ao Magic Fridge AI";
    }

    //POST
    @PostMapping("/criar")
    @Operation(summary = "Cadastrar um novo alimento", description = "Rota adiciona alemento e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Alimento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do alimento")
    })
    public ResponseEntity<String> criarFood(@RequestBody FooditemDTO food) {
        FooditemDTO novoFood = service.criar(food);
        return  ResponseEntity.status(HttpStatus.CREATED).
                body("Alimento criado com sucesso: " + novoFood.getNome() + "(ID): " + novoFood.getId());
    }

    //GET


    //UPDATE

    //DELETE


}

