package mc.seichiaddons.skill;

import mc.seichiaddons.resource.CONFIG;

//建築スキル判定系
public class BuildSkill {
	public static enum Mode{
		OnUpper, OnLower, OnDisable
	};
	
	public static enum HalfMode {
		Upper, Lower, Both
	};
	
	public static boolean isMineStackEnable;
	public static boolean isDestructionEnable;
	public static HalfMode halfBlockMode;
    private static Mode skillMode;
    
    static {
    	resetMode();	
    }
    
    public static Mode getCurrentMode() {
    	return skillMode;
    }

    public static void resetMode() {
    	skillMode = Mode.OnDisable;
    	isMineStackEnable = false;
    	isDestructionEnable = false;
    	halfBlockMode = HalfMode.Upper;
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
		if(receivedMsg.equals(CONFIG.MSG.ONMINESTACKENABLE)) {
			isMineStackEnable = true;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONMINESTACKDISABLE)) {
			isMineStackEnable = false;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONBREAKERENABLE)) {
			isDestructionEnable = true;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONBREAKERDISABLE)) {
			isDestructionEnable = false;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONHALFBOTH)) {
			halfBlockMode = HalfMode.Both;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONHALFUPPER)) {
			halfBlockMode = HalfMode.Upper;
			return;
		}
		if(receivedMsg.equals(CONFIG.MSG.ONHALFLOWER)) {
			halfBlockMode = HalfMode.Lower;
			return;
		}
	}
}

