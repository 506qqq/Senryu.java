package mc.seichiaddons;

import mc.seichiaddons.command.LinkCommand;
import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.skill.render.BuildSkillRenderer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "seichiaddons", version = "0.2", name = "SeichiAdd-ons")
@EventBusSubscriber
public class SeichiAddons {
    public static final String MODID = "seichiaddons";
    public static final String NAME = "SeichiAdd-ons";
    public static final String VERSION = "0.2";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new LinkCommand());
        resetSkillState();
    }

    public static void resetSkillState() {
   		BuildSkill.resetMode();
   		BuildSkillRenderer.resetState();
   		//SeichiSkillStateContainer.clearSkill();
   		//AssaultSkillRenderStateContainer.cancelRender();
    }
}