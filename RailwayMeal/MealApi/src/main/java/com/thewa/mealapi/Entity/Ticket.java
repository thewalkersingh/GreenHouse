package com.thewa.mealapi.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
   @Min(1)
   private long pnr;
   @Size(min = 3, max = 20)
   private String name;
   private long age;
   private String birth;
   private Meal meal;
}