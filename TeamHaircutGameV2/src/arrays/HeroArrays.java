//	www.teamhaircut.org
package arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import strings.HeroStrings;

public class HeroArrays {
	
	public static Image[] DHnoneLn;
	public static Image[] DHnoneLb;
	public static Image[] DHnoneLs;
	
	public static Image[] DHnoneRn;
	public static Image[] DHnoneRb;
	public static Image[] DHnoneRs;
	
	public static Image[] DHwalkLn;
	public static Image[] DHwalkLb;
	public static Image[] DHwalkLs;
	
	public static Image[] DHwalkRn;
	public static Image[] DHwalkRb;
	public static Image[] DHwalkRs;
	
	public static Image[] DHjumpLn;
	public static Image[] DHjumpLb;
	public static Image[] DHjumpLs;
	
	public static Image[] DHjumpRn;
	public static Image[] DHjumpRb;
	public static Image[] DHjumpRs;
	
	public static Image[] DSnoneLn;
	public static Image[] DSnoneLb;
	public static Image[] DSnoneLs;
	
	public static Image[] DSnoneRn;
	public static Image[] DSnoneRb;
	public static Image[] DSnoneRs;
	
	public static Image[] DSwalkLn;
	public static Image[] DSwalkLb;
	public static Image[] DSwalkLs;
	
	public static Image[] DSwalkRn;
	public static Image[] DSwalkRb;
	public static Image[] DSwalkRs;
	
	public static Image[] DSjumpLn;
	public static Image[] DSjumpLb;
	public static Image[] DSjumpLs;
	
	public static Image[] DSjumpRn;
	public static Image[] DSjumpRb;
	public static Image[] DSjumpRs;
	
	public static Image[] getDHnoneLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_L_N)
				};
	}
	
	public static Image[] getDHnoneLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_L_B)
				};
	}
	
	public static Image[] getDHnoneLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_L_N),
				new Image(HeroStrings.DH_NONE_L_S)
				};
	}
	
	public static Image[] getDHnoneRn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_R_N)
				};
	}
	
	public static Image[] getDHnoneRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_R_B)
				};
	}
	
	public static Image[] getDHnoneRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_NONE_R_N),
				new Image(HeroStrings.DH_NONE_R_S)
				};
	}
	
	public static Image[] getDHwalkLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_WALK_L_N),
				new Image(HeroStrings.DH_NONE_L_N)
				};
	}
	
	public static Image[] getDHwalkLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_WALK_L_B),
				new Image(HeroStrings.DH_NONE_L_B)
				};
	}
	
	public static Image[] getDHwalkLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_WALK_L_N),
				new Image(HeroStrings.DH_NONE_L_S)
				};
	}
	
	public static Image[] getDHwalkRn() throws SlickException {
		DHwalkRn = new Image[]{ 
				new Image(HeroStrings.DH_WALK_R_N),
				new Image(HeroStrings.DH_NONE_R_N)
				};
		return DHwalkRn;
	}
	
	public static Image[] getDHwalkRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_WALK_R_B),
				new Image(HeroStrings.DH_NONE_R_B)
				};
	}
	
	public static Image[] getDHwalkRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_WALK_R_N),
				new Image(HeroStrings.DH_NONE_R_S)
				};
	}
	
	public static Image[] getDHjumpLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_L_N)
				};
	}
	
	public static Image[] getDHjumpLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_L_B)
				};
	}
	
	public static Image[] getDHjumpLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_L_N),
				new Image(HeroStrings.DH_JUMP_L_S)
				};
	}
	
	public static Image[] getDHjumpRn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_R_N)
				};
	}
	
	public static Image[] getDHjumpRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_R_B)
				};
	}
	
	public static Image[] getDHjumpRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DH_JUMP_R_N),
				new Image(HeroStrings.DH_JUMP_R_S)
				};
	}
	
	public static Image[] getDSnoneLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_L_N)
				};
	}
	
	public static Image[] getDSnoneLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_L_B)
				};
	}
	
	public static Image[] getDSnoneLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_L_N),
				new Image(HeroStrings.DS_NONE_L_S)
				};
	}
	
	public static Image[] getDSnoneRn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_R_N)
				};
	}
	
	public static Image[] getDSnoneRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_R_B)
				};
	}
	
	public static Image[] getDSnoneRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_NONE_R_N),
				new Image(HeroStrings.DS_NONE_R_S)
				};
	}
	
	public static Image[] getDSwalkLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_L_N),
				new Image(HeroStrings.DS_NONE_L_N)
				};
	}
	
	public static Image[] getDSwalkLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_L_B),
				new Image(HeroStrings.DS_NONE_L_B)
				};
	}
	
	public static Image[] getDSwalkLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_L_N),
				new Image(HeroStrings.DS_NONE_L_S)
				};
	}
	
	public static Image[] getDSwalkRn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_R_N),
				new Image(HeroStrings.DS_NONE_R_N)
				};
	}
	
	public static Image[] getDSwalkRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_R_B),
				new Image(HeroStrings.DS_NONE_R_B)
				};
	}
	
	public static Image[] getDSwalkRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_WALK_R_N),
				new Image(HeroStrings.DS_NONE_R_S)
				};
	}
	
	public static Image[] getDSjumpLn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_L_N)
				};
	}
	
	public static Image[] getDSjumpLb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_L_B)
				};
	}
	
	public static Image[] getDSjumpLs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_L_N),
				new Image(HeroStrings.DS_JUMP_L_S)
				};
	}
	
	public static Image[] getDSjumpRn() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_R_N)
				};
	}
	
	public static Image[] getDSjumpRb() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_R_B)
				};
	}
	
	public static Image[] getDSjumpRs() throws SlickException {
		return new Image[]{ 
				new Image(HeroStrings.DS_JUMP_R_N),
				new Image(HeroStrings.DS_JUMP_R_S)
				};
	}
}//[end HeroArrays]