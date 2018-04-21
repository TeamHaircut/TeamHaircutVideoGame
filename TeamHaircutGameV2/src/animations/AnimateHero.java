//	www.teamhaircut.org
package animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import states.HeroState;

public class AnimateHero {
	
	public static Animation getHeroAni(Animation HeroAni) throws SlickException {

	   	switch(HeroState.getIndex()) {
	   	case HeroState.DAMIAN:
	   		switch(HeroState.getAction()) {
	   		case HeroState.ACTION_NONE:
	   			switch(HeroState.getDirection()) {
	   			case HeroState.LEFT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHnoneRs");
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
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHwalkRs");
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
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DHjumpRs");
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
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSnoneRs");
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
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSwalkRs");
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
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpLn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpLb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpLs");
	   					break;
	   				}
	   				break;
	   			case HeroState.RIGHT:
	   				switch(HeroState.getEffect()) {
	   				case HeroState.EFFECT_NONE:
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpRn");
	   					break;
	   				case HeroState.EFFECT_BIGMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpRb");
	   					break;
	   				case HeroState.EFFECT_STARMAN:
	   					HeroAni = AnimationLoader.getAniMap().get("DSjumpRs");
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
}//[end AnimateHero]