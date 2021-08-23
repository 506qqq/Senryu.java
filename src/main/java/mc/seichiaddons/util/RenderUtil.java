package mc.seichiaddons.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;

public class RenderUtil {
	public static void glbegin() {
    	GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.pushMatrix();
        GL11.glLineWidth(4F);
        return;
    }

    public static void glend() {
    	GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glPopAttrib();
        GlStateManager.popMatrix();
        return;
    }

    public static void selectCuboid(Vec3d min, Vec3d max, BufferBuilder bb, int R, int G, int B) {
        bb.pos(min.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, max.z).color(R, G, B, 200).endVertex();

        bb.pos(min.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, max.z).color(R, G, B, 200).endVertex();

        bb.pos(min.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, min.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, min.z).color(R, G, B, 200).endVertex();
        bb.pos(min.x, max.y, max.z).color(R, G, B, 200).endVertex();
        bb.pos(max.x, max.y, max.z).color(R, G, B, 200).endVertex();
        return;
    }
}
