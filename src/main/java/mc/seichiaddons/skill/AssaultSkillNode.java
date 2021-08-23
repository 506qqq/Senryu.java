package mc.seichiaddons.skill;

public class AssaultSkillNode extends StagnaSkillNode {
	public boolean isClotSkill;
	public AssaultSkillNode(String name, int XYZ, boolean b) {
		super(name, XYZ, XYZ);
		isClotSkill = b;
	}
	
	public AssaultSkillNode(AssaultSkillNode a) {
		super(a.skillName, a.breakRangeXZ, a.breakRangeY);
		this.isClotSkill = a.isClotSkill;
	}
	
	public AssaultSkillNode() {
		super();
		isClotSkill = false;
	}

	public int getBreakRangeLen() {
		return this.breakRangeXZ;
	}
	
	@Override
	public String chatMsgOnEnable() {
		return "アサルトスキル：" + this.skillName + " ON";	
	}
	
	@Override
	public String chatMsgOnDisable() {
		return "アサルトスキル：" + this.skillName + " OFF";
	}
}

