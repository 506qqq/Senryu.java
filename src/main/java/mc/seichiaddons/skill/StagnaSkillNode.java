package mc.seichiaddons.skill;

public class StagnaSkillNode{
	protected String skillName;
	protected int breakRangeXZ;
	protected int breakRangeY;
	
	public StagnaSkillNode(String name, int XZ, int Y) {
		skillName = name;
		breakRangeXZ = XZ;
		breakRangeY = Y;
	}
	
	public StagnaSkillNode(StagnaSkillNode s) {
		skillName = s.skillName;
		breakRangeXZ = s.breakRangeXZ;
		breakRangeY = s.breakRangeY;
	}
	
	public StagnaSkillNode() {
		this.clear();
	}
	
	public void clear() {
		skillName = "Empty";
		breakRangeXZ = 0;
		breakRangeY = 0;
	}
	
	public boolean isEmpty() {
		return skillName == "Empty";
	}
	
	public boolean isNotNull() {
		return this != null;
	}
	public String chatMsgOnEnable() {
		return this.skillName + " ON";
	}
	public String chatMsgOnDisable() {
		return this.skillName + " OFF";
	}

}