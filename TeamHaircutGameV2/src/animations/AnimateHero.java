package animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import states.HeroState;

public class AnimateHero {
	
	private static Animation HeroAni;
	
	
public static Animation getHeroAni() throws SlickException {
	
	
	
	switch(HeroState.getIndex()) {
	case HeroState.DAMIAN:
		switch(HeroState.getAction()) {
		case HeroState.ACTION_NONE:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHnoneRs");
					break;
				}
				break;
			}
			break;
		case HeroState.ACTION_WALK:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHwalkRs");
					break;
				}
				break;
			}
			break;
		case HeroState.ACTION_JUMP:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDHjumpRs");
					break;
				}
				break;
			}
			break;
		}
		break;
	case HeroState.DAN:
		switch(HeroState.getAction()) {
		case HeroState.ACTION_NONE:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSnoneRs");
					break;
				}
				break;
			}
			break;
		case HeroState.ACTION_WALK:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSwalkRs");
					break;
				}
				break;
			}
			break;
		case HeroState.ACTION_JUMP:
			switch(HeroState.getDirection()) {
			case HeroState.LEFT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpLn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpLb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpLs");
					break;
				}
				break;
			case HeroState.RIGHT:
				switch(HeroState.getEffect()) {
				case HeroState.EFFECT_NONE:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpRn");
					break;
				case HeroState.EFFECT_BIGMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpRb");
					break;
				case HeroState.EFFECT_STARMAN:
					HeroAni = AnimationLoader.getAniMap().get("getDSjumpRs");
					break;
				}
				break;
			}
			break;
		}
		break;
	}
	
	
	return HeroAni;
}


}
