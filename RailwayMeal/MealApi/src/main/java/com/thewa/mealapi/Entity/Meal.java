package com.thewa.mealapi.Entity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
   @Getter private long pnr;
   private String mealType = "North Indian";
   private boolean premium = false;
   private String mealTime = "Lunch";
   
   public Meal(long pnr) {
	  super();
	  this.pnr = pnr;
   }
}