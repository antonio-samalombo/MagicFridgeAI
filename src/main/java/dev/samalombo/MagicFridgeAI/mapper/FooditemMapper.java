package dev.samalombo.MagicFridgeAI.mapper;

import dev.samalombo.MagicFridgeAI.dto.FooditemDTO;
import dev.samalombo.MagicFridgeAI.model.Fooditem;
import org.springframework.stereotype.Component;

@Component
public class FooditemMapper {

    public Fooditem map(FooditemDTO fooditemDTO){

        Fooditem fooditem = new Fooditem();
        fooditem.setId(fooditemDTO.getId());
        fooditem.setNome(fooditemDTO.getNome());
        fooditem.setCategoria(fooditemDTO.getCategoria());
        fooditem.setQuantidade(fooditemDTO.getQuantidade());
        fooditem.setValidade(fooditemDTO.getValidade());

        return fooditem;
    }

    public FooditemDTO map(Fooditem fooditem){

        FooditemDTO fooditemDTO = new FooditemDTO();
        fooditem.setId(fooditem.getId());
        fooditem.setNome(fooditem.getNome());
        fooditem.setCategoria(fooditem.getCategoria());
        fooditem.setQuantidade(fooditem.getQuantidade());
        fooditem.setValidade(fooditem.getValidade());

        return fooditemDTO;
    }
}
