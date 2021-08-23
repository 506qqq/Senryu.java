package mc.seichiaddons.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlayerUtil {
	public static BlockPos getPlayerBlockPos() {
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		int pX = (int)(Math.round((player.posX)-0.5D));
    	int pY = (int)Math.floor(player.posY+1.6D);
    	int pZ = (int)(Math.round((player.posZ)-0.5D));
        return new BlockPos(pX, pY, pZ);
	}

	public static int calcLengthToFacingAt(EnumFacing dir, BlockPos pos) {
		World world = Minecraft.getMinecraft().world;
		if(dir == EnumFacing.DOWN) {
			pos = pos.offset(EnumFacing.DOWN);
		}
		IBlockState ibs;
		int res;
		for(res = 0; res < 15; res++) {
			pos = pos.offset(dir);
			ibs = world.getBlockState(pos);
			if(!ibs.getBlock().isAir(ibs, world, pos)) {
				break;
			}
		}
		return res;
	}

	public static boolean playerIsOnSeichiServer() {
		return true;
	}
}
