package com.github.relativobr.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;

@Setter
@Getter
@AllArgsConstructor
public class CollectorTechGeneric {

    Entity entity;
    MobTechGeneric mobTechGeneric;
    Integer getCharge;
    Integer maxCharge;

}
