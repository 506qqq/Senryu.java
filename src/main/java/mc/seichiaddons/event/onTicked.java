package mc.seichiaddons.event;

import java.util.Objects;

import mc.seichiaddons.SeichiAddons;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

@EventBusSubscriber
public class onTicked {
    
    @SubscribeEvent
    public static void Ticked(ClientTickEvent event) {
           if(Objects.isNull(Minecraft.getMinecraft().world)) {
        	   SeichiAddons.resetSkillState();
        	   return;
           }
           if(Objects.isNull(Minecraft.getMinecraft().player)) {
        	   return;
           }
    }
}
