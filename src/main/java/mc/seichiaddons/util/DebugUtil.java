package mc.seichiaddons.util;

import net.minecraft.util.math.BlockPos;

public class DebugUtil {
	public static void printBlockPos(BlockPos bp) {
		System.out.println("x," + bp.getX() + " y," + bp.getY() + "z," + bp.getZ() + "\n");
	}
}
