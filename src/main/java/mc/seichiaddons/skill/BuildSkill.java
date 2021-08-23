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

    public static void resetMode() {
    	skillMode = Mode.OnDisable;
    }

    public static void setSkillByChat(String receivedMsg) {
		if(receivedMsg.equals(CONFIG.MSG.ONDISABLESKILL)) {
			BuildSkill.skillMode = Mode.OnDisable;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONUPPERSKILL)) {
			BuildSkill.skillMode = Mode.OnUpper;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONLOWERSKILL)) {
			BuildSkill.skillMode = Mode.OnLower;
			return;
		}
	}
}

