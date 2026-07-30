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
@RequestMapping("food")
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
    @GetMapping("/listar")
    public ResponseEntity<List<FooditemDTO>> listarFood(){
        List<FooditemDTO> food = service.listarTodos();
        return ResponseEntity.ok(food);
    }


    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o alimento por ID", description = "Rota lista o alimento pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alimento encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Alimento não encontrado")
    })
public ResponseEntity<?> listarAlimentoPorId(@PathVariable Long id){
    FooditemDTO food = service.listarPorId(id);
    if (food !=null){
        return ResponseEntity.ok(food);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Alimento com o ID: " + id + " não foi encontrado nos nossos registros");
    }
}




//UPDATE
@PatchMapping("/alterar/{id}")
@Operation(summary = "Altera o alimento por ID", description = "Rota altera um alimento pelo seu ID")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alimento alterado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Alimento não encontrado, não foi possivel alterar")
})
public ResponseEntity<?> alterarNinjaPorId(
        @Parameter(description = "Usuario manda o id no caminho da requisição")
        @PathVariable Long id,
        @Parameter(description = "Usuario manda os dados do alimento a ser atualizado no corpo da requisição ")
        @RequestBody FooditemDTO alimentoAtualizado) {
    FooditemDTO food = service.atualizar(id, alimentoAtualizado);
    if (food != null){
        return ResponseEntity.ok(food);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O Alimento com ID " + id + " não foi encontrado");
    }
}

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <String> deletarAlimentoPorId(@PathVariable Long id){
        if (service.listarPorId(id) != null){
            service.deletarPorId(id);
            return ResponseEntity.ok("Alimento com o ID " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Alimento com o id " + id + " não foi encontrado");
        }
    }


}

