package states;

import levels.Level_1_1;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameDriver extends StateBasedGame{
   
   private static final String GAMENAME = "Team Haircut: The Video Game";
   
   public GameDriver(String gameName){
      super(gameName);
      this.addState(new IntroState());
      this.addState(new TitleState());
      this.addState(new SelectState());
      this.addState(new StartState());
      this.addState(new GameOverState());
      
      
     // this.addState(new Level2());
      this.addState(new Level_1_1());
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(GameState.INTROSTATE).init(gc, this);
      this.getState(GameState.TITLESTATE).init(gc, this);
      this.getState(GameState.SELECTSTATE).init(gc, this);
      this.getState(GameState.STARTSTATE).init(gc, this);
      this.getState(GameState.GAMEOVERSTATE).init(gc, this);
      this.getState(GameState.LEVEL_1_1).init(gc, this);

      /*
       * use GameState.INTROSTATE, to start at beginning
       */
      //this.enterState(GameState.INTROSTATE);
      //this.enterState(GameState.TITLESTATE);
      //this.enterState(GameState.SELECTSTATE);
      this.enterState(GameState.LEVEL_1_1);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new GameDriver(GAMENAME));
//       ScreenResolution.setScreenHeight(480);
//       ScreenResolution.setScreenWidth(980);
//       appgc.setDisplayMode(980, 480, false);// old setting
//       appgc.setDisplayMode(1360, 768, true);//samsung
       
//       appgc.setDisplayMode(1920, 1080, true);//full hd 3840
         
         ScrRes.setHeight(appgc.getScreenHeight());
         ScrRes.setWidth(appgc.getScreenWidth());
         appgc.setDisplayMode(ScrRes.getWidth(), ScrRes.getHeight(), true);
         
//       alt-tab to exit fullscreen
         appgc.setFullscreen(true);
         appgc.setShowFPS(true);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}
