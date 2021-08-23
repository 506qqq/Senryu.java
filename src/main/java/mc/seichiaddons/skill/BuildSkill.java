package mc.seichiaddons.skill;

import mc.seichiaddons.resource.CONFIG;

//建築スキル判定系
public class BuildSkill {
	public static enum Mode{
		OnUpper, OnLower, OnDisable
	};
    private static Mode skillMode;

    public static Mode getCurrentMode() {
    	return skillMode;
    }

    private static String getServerMsgOnDisable() {
    	return CONFIG.MSG.ONDISABLESKILL;
    }

    private static String getServerMsgOnUpper() {
    	return CONFIG.MSG.ONUPPERSKILL;
    }

    private static String getServerMsgOnLower() {
    	return CONFIG.MSG.ONLOWERSKILL;
    }

    public static void resetMode() {
    	skillMode = Mode.OnDisable;
    }

    public static void setSkillByChat(String receivedMsg) {
		if(receivedMsg.equals(BuildSkill.getServerMsgOnDisable())) {
			BuildSkill.skillMode = Mode.OnDisable;
			return;
		}
		if(receivedMsg.equals(BuildSkill.getServerMsgOnUpper())) {
			BuildSkill.skillMode = Mode.OnUpper;
			return;
		}
		if(receivedMsg.equals(BuildSkill.getServerMsgOnLower())) {
			BuildSkill.skillMode = Mode.OnLower;
			return;
		}
	}
}

