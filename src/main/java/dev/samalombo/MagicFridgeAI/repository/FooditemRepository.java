package dev.samalombo.MagicFridgeAI.repository;

import dev.samalombo.MagicFridgeAI.model.Fooditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooditemRepository extends JpaRepository <Fooditem, Long> {
}
