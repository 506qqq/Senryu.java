package mc.seichiaddons.event;

import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.skill.state.SeichiSkillStateContainer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class onReceivedChat {
    @SubscribeEvent
    public static void getChatMessage(ClientChatReceivedEvent event)  {
    	String receivedMsg = new String(event.getMessage().getUnformattedText());
    	BuildSkill.setSkillByChat(receivedMsg);
    	SeichiSkillStateContainer.setSkillByChat(receivedMsg);
    }
}
