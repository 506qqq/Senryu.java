package mc.seichiaddons.skill;


import java.util.ArrayList;
import java.util.List;

import mc.seichiaddons.resource.CONFIG;

//非アサルトスキル = stagnaSkill

public class SeichiSkill{
	private static List<StagnaSkillNode> stagnaList;
	private static List<AssaultSkillNode> assaultList;

	public static StagnaSkillNode currentStagna;
	private static AssaultSkillNode currentAssault;

	private final static String MsgOnDisableAssaultSkill = "アサルトスキルがOFFになりました";

	static {
		stagnaList = new ArrayList<>();
		assaultList = new ArrayList<>();
		currentStagna = new StagnaSkillNode();
		currentAssault = new AssaultSkillNode();
		loadConfig();
	}

	public static void clearSkill() {
		currentStagna.clear();
		currentAssault.clear();
		return;
	}

	public static void setSkillByChat(String chatMsg) {
		for(final StagnaSkillNode s: stagnaList) {
			if(s.chatMsgOnEnable().equals(chatMsg)) {
				currentStagna = new StagnaSkillNode(s);
			}
			if(s.chatMsgOnDisable().equals(chatMsg)) {
				currentStagna.clear();
			}
		}
		for(final AssaultSkillNode a: assaultList) {
			if(a.chatMsgOnEnable().equals(chatMsg)) {
				currentAssault = new AssaultSkillNode(a);
			}
			if(a.chatMsgOnDisable().equals(chatMsg)) {
				currentAssault.clear();
			}
			if(MsgOnDisableAssaultSkill.equals(chatMsg)) {
				currentAssault.clear();
			}
		}
		return;
	}

	private static void loadConfig() {
		String[] sName = CONFIG.stagnaSkillName;
		int[] sRangeXZ = CONFIG.stagnaSkillBreakRangeXZ;
		int[] sRangeY = CONFIG.stagnaSkillBreakRangeY;

		String[] aName = CONFIG.assaultSkillName;
		int[] aRangeXYZ = CONFIG.assaultSkillBreakRangeXYZ;
		boolean[] aIsClot = CONFIG.assaultIsClotSkill;

		for(int i = 0; i < sName.length; i++) {
			stagnaList.add(new StagnaSkillNode(sName[i], sRangeXZ[i], sRangeY[i]));
		}
		for(int i = 0; i < aName.length; i++) {
			assaultList.add(new AssaultSkillNode(aName[i], aRangeXYZ[i], aIsClot[i]));
		}
		return;
	}

	public static boolean isAssaultDisable() {
		return currentAssault.isEmpty();
	}

	public static boolean isStagnaDisable() {
		return currentStagna.isEmpty();
	}

	public static boolean isEnable() {
		return !(currentAssault.isEmpty() && currentStagna.isEmpty());
	}

	public static int getAssaultSkillBreakRangeLen() {
		return currentAssault.getBreakRangeLen();
	}

	public static boolean isAssaultSkillClot() {
		return currentAssault.isClotSkill;
	}
}
