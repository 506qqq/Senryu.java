package mc.seichiaddons.resource;

import mc.seichiaddons.SeichiAddons;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;


@Config(modid = SeichiAddons.MODID, type = Type.INSTANCE, name = "SeichiAdd-ons")
public class CONFIG {
	@Comment({
		"\n" +
		"*****************************************\n" + 
		"ファイル削除で元のファイルが生成されます。\n" +
		"*****************************************\n" +
		"\n"})
	
	
    public static int stickItemID = 280;
	public static int PARTICLECYCLETICK = 16;
	public static int LinkCommandTextLengthLimit = 20;
	
	public static MSGTEXT MSG = new MSGTEXT();
	public static LINKTXT LINKS = new LINKTXT();
	
	@Comment({"↓書き換える際は、かならず数字が昇順になるようにしてください。"})
	public static int[] buildSkillTargetBlockId = {1, 2, 3, 4, 5, 12, 13, 14, 15, 16, 17, 20, 21, 22, 24, 35,
			41, 42, 44, 45, 47, 48, 49, 56, 57, 73, 79, 80, 82, 85, 87, 88, 89, 95, 98, 102, 110, 112, 113, 121, 126, 129, 133,
			139, 153, 155, 159, 160, 162, 165, 168, 169, 172, 173, 174, 179, 182, 188, 189, 190, 191, 192, 201, 202, 205, 206,
			214, 215, 216, 251, 252};
	
	@Comment({"↓書き換える際は、かならず数字が昇順になるようにしてください。↓に追記した場合は、上にも同様に記載してください。"})
	public static int[] buildSkillTargetSlabId = {44, 126, 182, 205};
	@Comment({"↓書き換える際は、かならず数字が昇順になるようにしてください。"})
	public static int[] buildSkillDestructionTargetBlockId = {8, 9, 10, 11, 31, 32, 37, 38, 39, 40, 50, 78, 106, 175};
	
	public static String[] stagnaSkillName = {"エクスプロージョン", "ミラージュ・フレア", "ドッ・カーン", 
			"ギガンティック・ボム", "ブリリアント・デトネーション", "レムリア・インパクト", "エターナル・ヴァイス"};
	public static int[] stagnaSkillBreakRangeXZ = {3, 5, 7, 9, 11, 13, 7, 11, 15};
	public static int[] stagnaSkillBreakRangeY = {3, 3, 5, 7, 9, 11, 7, 11, 15};

	public static String[] assaultSkillName = {"アサルト・アーマー", "ホワイト・ブレス", "アブソリュート・ゼロ",
												"ダイヤモンド・ダスト", "ヴェンダー・ブリザード"};
	public static int[] assaultSkillBreakRangeXYZ = {11, 7, 11, 15, 15};
	public static boolean[] assaultIsClotSkill = {false, true, true, true, true};
	
	public static class MSGTEXT {
		@Comment({"建築スキルのメッセージ"})
		public String ONDISABLESKILL = "直列設置: OFF";
		public String ONUPPERSKILL = "直列設置: 上側";
		public String ONLOWERSKILL = "直列設置: 下側";
		public String ONHALFBOTH = "ハーフブロック設定 ：両方";
		public String ONHALFUPPER = "ハーフブロック設定 ：上側";
		public String ONHALFLOWER = "ハーフブロック設定 ：下側";
		public String ONBREAKERENABLE = "破壊設定 ：ON";
		public String ONBREAKERDISABLE = "破壊設定 ：OFF";
		public String ONMINESTACKENABLE = "マインスタック優先設定 ：ON";
		public String ONMINESTACKDISABLE = "マインスタック優先設定 ：OFF";
		
	}
	public static class LINKTXT {
		public String NAME = "link";
		public String USAGE = "/link [keywords]";
		public String MESSAGE_HELP = "usage: /link <keyword>";
		public String[] COMMAND_ALIASES = {"url", "urls", "li"};
		public String[] KEYWORDS = {"hp", "rule", "map", "seichi", "build",
				"public", "command", "qanda", "form", "discord", "youtube", "twitter",
				"reportform", "formreport", "tuuhou", "24", "huguai", "formhuguai", "bug",
				"goiken", "formgoiken", "iken", "aidea", "idea", "formidea",
				"townycommand", "commandtowny", "townyguide",
				"rankseichi", "seichirank", "buildrank" , "rankbuild", "kentikurank",
				"loginrank", "ranklogin", "roguinrank", "voterank", "rankvote", "touhyourank",
				"votejp", "jp", "voteorg", "org"
				};
		
		public String[] URLS = {
				"https://www.seichi.network/gigantic",
				"https://www.seichi.network/rule",
				"https://www.seichi.network/map",
				"https://www.seichi.network/seichi",
				"https://www.seichi.network/build",
				"https://www.seichi.network/public",
				"https://www.seichi.network/command",
				"https://www.seichi.network/qanda",
				"https://www.seichi.network/access",
				"https://redmine.seichi.click/projects/public/wiki/Official_Discord_Documents",
				"https://www.youtube.com/channel/UCRa1dzpugnk83WH6VW5e-og",
				"https://twitter.com/seichiclick",
				"https://docs.google.com/forms/d/e/1FAIpQLSfK9DQkUCD2qs8zATUuYIC3JuV3MyXRVCYjMb5g4g_hBUusSA/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSfK9DQkUCD2qs8zATUuYIC3JuV3MyXRVCYjMb5g4g_hBUusSA/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSfK9DQkUCD2qs8zATUuYIC3JuV3MyXRVCYjMb5g4g_hBUusSA/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSfK9DQkUCD2qs8zATUuYIC3JuV3MyXRVCYjMb5g4g_hBUusSA/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSdn9fTTs55c-oGLT3c68KVTGvfUjTK-W_cdataU7_XyzqcBRg/viewform",
				"https://docs.google.com/forms/d/e/1FAIpQLSdn9fTTs55c-oGLT3c68KVTGvfUjTK-W_cdataU7_XyzqcBRg/viewform",
				"https://docs.google.com/forms/d/e/1FAIpQLSdn9fTTs55c-oGLT3c68KVTGvfUjTK-W_cdataU7_XyzqcBRg/viewform",
				"https://docs.google.com/forms/d/e/1FAIpQLSctLrByNvAiQop2lha9Mxn-D5p1OUaOf8JKQJCyAdggGBbzpg/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSctLrByNvAiQop2lha9Mxn-D5p1OUaOf8JKQJCyAdggGBbzpg/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLSctLrByNvAiQop2lha9Mxn-D5p1OUaOf8JKQJCyAdggGBbzpg/viewform?c=0&w=1",
				"https://docs.google.com/forms/d/e/1FAIpQLScB-XAHWnYePUpljd6swUfJTn6NJJNn74HgkqifxM7I3oxIMA/viewform",
				"https://docs.google.com/forms/d/e/1FAIpQLScB-XAHWnYePUpljd6swUfJTn6NJJNn74HgkqifxM7I3oxIMA/viewform",
				"https://docs.google.com/forms/d/e/1FAIpQLScB-XAHWnYePUpljd6swUfJTn6NJJNn74HgkqifxM7I3oxIMA/viewform",
				"https://www.seichi.network/townyguide",
				"https://www.seichi.network/townycommand",
				"https://www.seichi.network/townycommand",
				"https://ranking-gigantic.seichi.click/#page=1&type=break&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=break&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=build&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=build&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=build&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=playtime&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=playtime&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=playtime&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=vote&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=vote&duration=total",
				"https://ranking-gigantic.seichi.click/#page=1&type=vote&duration=total",
				"https://minecraft.jp/servers/play.seichi.click",
				"https://minecraft.jp/servers/play.seichi.click",
				"https://minecraftservers.org/vote/575658",
				"https://minecraftservers.org/vote/575658"
		};
		
		public String[] DESCS = {
				"HP[トップ]",
				"HP[ルール]",
				"HP[マップ]",
				"HP[整地タブ]",
				"HP[建築タブ]",
				"HP[公共施設]",
				"HP[コマンド]",
				"HP[Q&A]",
				"HP[お問い合わせ]",
				"公式Discord利用の手引き",
				"公式Youtubeチャンネル",
				"公式ツイッター",
				"通報フォーム",
				"通報フォーム",
				"通報フォーム",
				"通報フォーム",
				"不具合フォーム",
				"不具合フォーム",
				"不具合フォーム",
				"ご意見ご感想フォーム",
				"ご意見ご感想フォーム",
				"ご意見ご感想フォーム",
				"アイデアフォーム",
				"アイデアフォーム",
				"アイデアフォーム",
				"Towny初心者ガイド",
				"Townyコマンド",
				"Townyコマンド",
				"ランキング[整地量/総合]",
				"ランキング[整地量/総合]",
				"ランキング[建築量/総合]",
				"ランキング[建築量/総合]",
				"ランキング[建築量/総合]",
				"ランキング[ログイン/総合]",
				"ランキング[ログイン/総合]",
				"ランキング[ログイン/総合]",
				"ランキング[投票/総合]",
				"ランキング[投票/総合]",
				"ランキング[投票/総合]",
				"投票[jp]",
				"投票[jp]",
				"投票[org]",
				"投票[org]"
		};
		
		public String MESSAGE_BEGINSHOWRESULT = "§l------ 検索結果[%s] ------";
		public String MESSAGE_FINISHSHOWRESULT = "§l------------------------";
		public String MESSAGE_NOTFOUNDRESULT = "見つかりませんでした";
		
	}

}
