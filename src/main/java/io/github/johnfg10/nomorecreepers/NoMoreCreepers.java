package io.github.johnfg10.nomorecreepers;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

@Plugin(
        id = "nomorecreepers",
        name = "NoMoreCreepers",
        version = "1.0.0",
        description = "Simply disables creeper explosions"
)
public class NoMoreCreepers {
    @Listener
    public void onEntitySpawnEvent(SpawnEntityEvent event){
        for (Entity entity : event.getEntities()) {
            if (entity.getType().equals(EntityTypes.CREEPER)){
                if (entity instanceof Creeper){
                    Creeper creeper = (Creeper) entity;
                    creeper.explosionRadius().setTo(0);
                }
            }
        }
    }
}
