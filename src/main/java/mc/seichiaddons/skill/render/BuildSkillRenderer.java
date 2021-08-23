package mc.seichiaddons.skill.render;

import mc.seichiaddons.resource.CONFIG;
import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.util.FacingUtil;
import mc.seichiaddons.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class BuildSkillRenderer{
	private static final Item stick = Item.getItemById(CONFIG.stickItemID);
	public static boolean isRenderEnable = false;

	public static int drawBlockCount;

	public static void resetState() {
		isRenderEnable = false;
		drawBlockCount = 0;
	}

	public static void updateRenderState() {
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		if (BuildSkill.getCurrentMode() == BuildSkill.Mode.OnDisable) {
			resetState();
			return;
		}
		if (!player.getHeldItemOffhand().getItem().equals(stick)) {
			resetState();
			return;
		}

		EnumFacing ef = FacingUtil.getPlayerFacingAt();
		BlockPos bp = calcStartCoordinate(ef);
		drawBlockCount = PlayerUtil.calcLengthToFacingAt(ef, bp);
		isRenderEnable = true;
	}

	private static BlockPos calcStartCoordinate(EnumFacing dir) {
		BlockPos bp = PlayerUtil.getPlayerBlockPos();
    	if(FacingUtil.isHorizontal(dir)) {
    		if(BuildSkill.getCurrentMode() ==  BuildSkill.Mode.OnLower) {
    			bp = bp.offset(EnumFacing.DOWN);
    		}
    	}
        return bp;
	}
}
