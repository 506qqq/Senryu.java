package mc.seichiaddons.skill.render;

import java.util.Arrays;
import java.util.Objects;

import mc.seichiaddons.resource.CONFIG;
import mc.seichiaddons.skill.BuildSkill;
import mc.seichiaddons.util.FacingUtil;
import mc.seichiaddons.util.PlayerUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BuildSkillRenderer{
	private static final Item stick = Item.getItemById(CONFIG.stickItemID);
	public static boolean isRenderEnable = false;
	public static boolean isTargetSlab = false;
	
	public static int drawBlockCount;
	public static BlockPos drawBasisPos;

	public static void resetState() {
		isRenderEnable = false;
		isTargetSlab = false;
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
		ItemStack is = player.getHeldItemMainhand();
		if(Objects.isNull(is)) {
			resetState();
			return;
		}
		int id = Item.getIdFromItem(is.getItem());
		if(!isBuildSkillTargetBlockId(id)) {
			resetState();
			return;
		};
		EnumFacing ef = FacingUtil.getPlayerFacingAt();
		drawBasisPos = calcStartCoordinate(ef);
		drawBlockCount = calcDrawBlockCount(ef, drawBasisPos);
		if(drawBlockCount < 1) isRenderEnable = false;
		else isRenderEnable = true;
		
		int[] slabIds = CONFIG.buildSkillTargetSlabId;
		if(Arrays.binarySearch(slabIds, id) >= 0) isTargetSlab = true;
		else isTargetSlab = false;
	}

	private static BlockPos calcStartCoordinate(EnumFacing dir) {
		BlockPos bp = PlayerUtil.getPlayerBlockPos();
		if(dir == EnumFacing.DOWN) {
			int lx = bp.getX();
			int ly = (int)Math.floor(Minecraft.getMinecraft().player.posY);
			int lz = bp.getZ();
			bp = new BlockPos(lx, ly, lz);
		}
        return bp;
	}
	
	
	private static int calcDrawBlockCount(EnumFacing ef, BlockPos bp) {
		if(BuildSkill.isDestructionEnable) {
			if(BuildSkill.isMineStackEnable) 
				return Math.min(15, calcLengthToFacingAtOnBreak(ef, bp));
			else 
				return Math.min(PlayerUtil.countBlocksPlayerHoldingOn(), 
						(Math.min(15, calcLengthToFacingAtOnBreak(ef, bp))));
		}
		else {
			if(BuildSkill.isMineStackEnable) 
				return Math.min(15, PlayerUtil.calcLengthToFacingAt(ef, bp));
			else 
				return Math.min(PlayerUtil.countBlocksPlayerHoldingOn(), 
						(Math.min(15, PlayerUtil.calcLengthToFacingAt(ef, bp))));
		}
	}
	
	private static boolean isBuildSkillTargetBlockId(int n) {
		int[] arr = CONFIG.buildSkillTargetBlockId;
		return Arrays.binarySearch(arr, n) >= 0;
	}
	
	
	//クソクソクソクソクソクソクソクソクソ
	private static int calcLengthToFacingAtOnBreak(EnumFacing dir, BlockPos pos) {
		int[] targetId = CONFIG.buildSkillDestructionTargetBlockId;
		World world = Minecraft.getMinecraft().world;
		IBlockState ibs;
		Item item;
		int res;
		for(res = 0; res < 15; res++) {
			pos = pos.offset(dir);
			ibs = world.getBlockState(pos);
			item = Item.getItemFromBlock(ibs.getBlock());
			if(!ibs.getBlock().isAir(ibs, world, pos)) {
				if(!(Arrays.binarySearch(targetId, Item.getIdFromItem(item)) >= 0))
					break;
			}
		}
		return res;
		
	}
}
