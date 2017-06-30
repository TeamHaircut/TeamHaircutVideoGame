package animations;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import arrays.HeroArrays;

public class AnimationLoader {
	
	
	public static Map<String, Animation> aniMap;
	

	public static Map<String, Animation> getAniMap() throws SlickException {
		aniMap = new HashMap<String,Animation>();
		aniMap.put("HeroAnimation", new Animation());
		
		aniMap.put("DHnoneLn", new CustomAnimation(HeroArrays.getDHnoneLn(),1000).getAni());
		aniMap.put("DHnoneLb", new CustomAnimation(HeroArrays.getDHnoneLb(),1000).getAni());
		aniMap.put("DHnoneLs", new CustomAnimation(HeroArrays.getDHnoneLs(),200).getAni());
		
		aniMap.put("DHnoneRn", new CustomAnimation(HeroArrays.getDHnoneRn(),1000).getAni());
		aniMap.put("DHnoneRb", new CustomAnimation(HeroArrays.getDHnoneRb(),1000).getAni());
		aniMap.put("DHnoneRs", new CustomAnimation(HeroArrays.getDHnoneRs(),200).getAni());
		
		aniMap.put("DHwalkLn", new CustomAnimation(HeroArrays.getDHwalkLn(),200).getAni());
		aniMap.put("DHwalkLb", new CustomAnimation(HeroArrays.getDHwalkLb(),200).getAni());
		aniMap.put("DHwalkLs", new CustomAnimation(HeroArrays.getDHwalkLs(),200).getAni());
		
		aniMap.put("DHwalkRn", new CustomAnimation(HeroArrays.getDHwalkRn(),200).getAni());
		aniMap.put("DHwalkRb", new CustomAnimation(HeroArrays.getDHwalkRb(),200).getAni());
		aniMap.put("DHwalkRs", new CustomAnimation(HeroArrays.getDHwalkRs(),200).getAni());
		
		aniMap.put("DHjumpLn", new CustomAnimation(HeroArrays.getDHjumpLn(),1000).getAni());
		aniMap.put("DHjumpLb", new CustomAnimation(HeroArrays.getDHjumpLb(),1000).getAni());
		aniMap.put("DHjumpLs", new CustomAnimation(HeroArrays.getDHjumpLs(),200).getAni());
		
		aniMap.put("DHjumpRn", new CustomAnimation(HeroArrays.getDHjumpRn(),1000).getAni());
		aniMap.put("DHjumpRb", new CustomAnimation(HeroArrays.getDHjumpRb(),1000).getAni());
		aniMap.put("DHjumpRs", new CustomAnimation(HeroArrays.getDHjumpRs(),200).getAni());
		
		//
		
		aniMap.put("DSnoneLn", new CustomAnimation(HeroArrays.getDSnoneLn(),1000).getAni());
		aniMap.put("DSnoneLb", new CustomAnimation(HeroArrays.getDSnoneLb(),1000).getAni());
		aniMap.put("DSnoneLs", new CustomAnimation(HeroArrays.getDSnoneLs(),200).getAni());
		
		aniMap.put("DSnoneRn", new CustomAnimation(HeroArrays.getDSnoneRn(),1000).getAni());
		aniMap.put("DSnoneRb", new CustomAnimation(HeroArrays.getDSnoneRb(),1000).getAni());
		aniMap.put("DSnoneRs", new CustomAnimation(HeroArrays.getDSnoneRs(),200).getAni());
		
		aniMap.put("DSwalkLn", new CustomAnimation(HeroArrays.getDSwalkLn(),200).getAni());
		aniMap.put("DSwalkLb", new CustomAnimation(HeroArrays.getDSwalkLb(),200).getAni());
		aniMap.put("DSwalkLs", new CustomAnimation(HeroArrays.getDSwalkLs(),200).getAni());
		
		aniMap.put("DSwalkRn", new CustomAnimation(HeroArrays.getDSwalkRn(),200).getAni());
		aniMap.put("DSwalkRb", new CustomAnimation(HeroArrays.getDSwalkRb(),200).getAni());
		aniMap.put("DSwalkRs", new CustomAnimation(HeroArrays.getDSwalkRs(),200).getAni());
		
		aniMap.put("DSjumpLn", new CustomAnimation(HeroArrays.getDSjumpLn(),1000).getAni());
		aniMap.put("DSjumpLb", new CustomAnimation(HeroArrays.getDSjumpLb(),1000).getAni());
		aniMap.put("DSjumpLs", new CustomAnimation(HeroArrays.getDSjumpLs(),200).getAni());
		
		aniMap.put("DSjumpRn", new CustomAnimation(HeroArrays.getDSjumpRn(),1000).getAni());
		aniMap.put("DSjumpRb", new CustomAnimation(HeroArrays.getDSjumpRb(),1000).getAni());
		aniMap.put("DSjumpRs", new CustomAnimation(HeroArrays.getDSjumpRs(),200).getAni());
		return aniMap;
	}

	public static void setAniMap(Map<String, Animation> aniMap) {
		AnimationLoader.aniMap = aniMap;
	}

}
