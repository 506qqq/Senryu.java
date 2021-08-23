package mc.seichiaddons.event;

import org.lwjgl.opengl.GL11;

import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.skill.render.BuildSkillRenderer;
import mc.seichiaddons.util.FacingUtil;
import mc.seichiaddons.util.PlayerUtil;
import mc.seichiaddons.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class onRenderWorld {
	@SubscribeEvent
	public static void RenderWorld(RenderWorldLastEvent e) {
		renderWorld();
		return;
	}

    private static void renderWorld() {
    	BuildSkillRenderer.updateRenderState();
    	BufferBuilder bb = Tessellator.getInstance().getBuffer();
    	BlockPos bp = PlayerUtil.getPlayerBlockPos();
    	double pX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double pY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double pZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;

        RenderUtil.glbegin();
        GlStateManager.translate(bp.getX() - pX, bp.getY() - pY, bp.getZ() - pZ);
        bb.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);
        
        if(BuildSkillRenderer.isRenderEnable)
        	renderBuildSkill(bb);
        //if(AssaultSkillRenderStateContainer.isRenderEnable())
        //	renderAssaultSkill(bb);
        
    	Tessellator.getInstance().draw();
    	RenderUtil.glend();
    	return;
    }

    private static void renderBuildSkill(BufferBuilder bb) {
		int loop = BuildSkillRenderer.drawBlockCount;
		EnumFacing la = FacingUtil.getPlayerFacingAt();
    	int x = 0, y = 0, z = 0;
    	if(FacingUtil.isHorizontal(la)) {
    		if(BuildSkill.getCurrentMode() == BuildSkill.Mode.OnLower) y--;
    	}
    	if(la == EnumFacing.DOWN) {
    		y--;
    	}
    	for(int i = 0; i < loop; i++) {
    		switch(la) {
    			case SOUTH	:z++;	break;
    			case NORTH	:z--;	break;
    			case EAST	:x++;	break;
    			case WEST	:x--;	break;
    			case UP		:y++;	break;
    			case DOWN	:y--;	break;
    		}
    		RenderUtil.selectCuboid(new Vec3d(x, y, z), new Vec3d(x+1, y+1, z+1), bb, 255, 255, 255);
    	}
    }
    /*
    private static void renderAssaultSkill(BufferBuilder bb) {
    	Vec3d min = AssaultSkillRenderStateContainer.getMinPos();
    	Vec3d max = AssaultSkillRenderStateContainer.getMaxPos();
    	RenderUtil.selectCuboid(min, max, bb, 255, 0, 0);
    	return;
    }
    
    private static void renderStagnaSkill(BufferBuilder bb) {
    }
    */
}
