package mc.seichiaddons.event;

import org.lwjgl.opengl.GL11;

import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.skill.render.BuildSkillRenderer;
import mc.seichiaddons.util.FacingUtil;
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


        RenderUtil.glbegin();
        
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
    	BlockPos bp = BuildSkillRenderer.drawBasisPos;
    	double pX = Minecraft.getMinecraft().getRenderManager().viewerPosX;
        double pY = Minecraft.getMinecraft().getRenderManager().viewerPosY;
        double pZ = Minecraft.getMinecraft().getRenderManager().viewerPosZ;
    	GlStateManager.translate(bp.getX() - pX, bp.getY() - pY, bp.getZ() - pZ);
    	
		int loop = BuildSkillRenderer.drawBlockCount;
		EnumFacing la = FacingUtil.getPlayerFacingAt();
    	int x = 0, y = 0, z = 0;
    	if(FacingUtil.isHorizontal(la)) {
    		if(BuildSkill.getCurrentMode() == BuildSkill.Mode.OnLower) y--;
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
    		if(!BuildSkillRenderer.isTargetSlab) {
    			RenderUtil.selectCuboid(new Vec3d(x, y, z), new Vec3d(x+1, y+1, z+1), bb, 255, 255, 255);
    			continue;
    		}
    		Vec3d min, max;
    		switch(BuildSkill.halfBlockMode) {
    		case Upper:
    			min = new Vec3d(x, y+0.5, z);
    			max = new Vec3d(x+1, y+1, z+1);
    			RenderUtil.selectCuboid(min, max,  bb,  255,  255, 255);
    			break;
    		case Lower:
    			min = new Vec3d(x, y, z);
    			max = new Vec3d(x+1, y+0.5, z+1);
    			RenderUtil.selectCuboid(min, max, bb, 255, 255, 255);
    			break;
    		//ダサッ！
    		case Both:
    			min = new Vec3d(x, y+0.5, z);
    			max = new Vec3d(x+1, y+1, z+1);
    			RenderUtil.selectCuboid(min, max, bb, 255, 255, 255);
    			min = new Vec3d(x, y, z);
    			max = new Vec3d(x+1, y+0.5, z+1);
    			RenderUtil.selectCuboid(min, max, bb, 255, 255, 255);
    			break;
    		}
    		
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
