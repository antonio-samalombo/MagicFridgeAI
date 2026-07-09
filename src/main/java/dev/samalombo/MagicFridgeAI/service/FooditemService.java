package dev.samalombo.MagicFridgeAI.service;

import dev.samalombo.MagicFridgeAI.dto.FooditemDTO;
import dev.samalombo.MagicFridgeAI.mapper.FooditemMapper;
import dev.samalombo.MagicFridgeAI.model.Fooditem;
import org.springframework.stereotype.Service;
import dev.samalombo.MagicFridgeAI.repository.FooditemRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FooditemService {

    private final FooditemRepository foodRepository;
    private final FooditemMapper foodMapper;

    public FooditemService(FooditemRepository foodRepository, FooditemMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    // Criar
    public FooditemDTO criar(FooditemDTO fooditemDTO){
        Fooditem food = foodMapper.map(fooditemDTO);
        food = foodRepository.save(food);
        return foodMapper.map(food);
    }


   // listar
    public List<FooditemDTO> listarTodos(){
        List<Fooditem> food = foodRepository.findAll();
        return food.stream()
                .map(foodMapper::map)
                .collect(Collectors.toList());
    }


    // listar por ID
    public FooditemDTO listarPorId(Long id){
        Optional<Fooditem> foodPorId = foodRepository.findById(id);
        return foodPorId.map(foodMapper::map).orElse(null);
    }



    // atualizar
    public FooditemDTO atualizar(Long id, FooditemDTO fooditemDTO){
        Optional<Fooditem> foodExistente = foodRepository.findById(id);

        if (foodExistente.isPresent()){
            Fooditem foodAtualizado = foodMapper.map(fooditemDTO);
            foodAtualizado.setId(id);
            Fooditem foodSalvo = foodRepository.save(foodAtualizado);
            return foodMapper.map(foodSalvo);
        }
        return null;
    }


    // deletar
    public void deletarPorId(Long id){
        foodRepository.deleteById(id);
    }

}
