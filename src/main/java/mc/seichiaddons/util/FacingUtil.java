package mc.seichiaddons.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumFacing;

public class FacingUtil {
	public static EnumFacing getPlayerFacingAt() {
		EntityPlayerSP player = Minecraft.getMinecraft().player;
    	byte Yaw = (byte)((int)(Math.floor((player.rotationYaw / 90.0D) + 0.5D)) & 3);
    	float pitch = player.rotationPitch;
    	if(pitch > 45.0f) {
    		return EnumFacing.DOWN;
    	}
    	else if(pitch < -45.0f) {
    		return EnumFacing.UP;
    	}
    	else {
    		switch(Yaw) {//横向き
    		case 0:
    			return EnumFacing.SOUTH;
    		case 1:
    			return EnumFacing.WEST;
    		case 2:
    			return EnumFacing.NORTH;
    		case 3:
    			return EnumFacing.EAST;
    		}
    	}
    	return null;
	}

	public static boolean isHorizontal(EnumFacing ef) {
		return ef != EnumFacing.UP && ef != EnumFacing.DOWN;
	}
}
