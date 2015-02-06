package asu.edu.cst316;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
	
	
	
	public static final String gamename = "Game of Life";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int main = 2;
	
	public Game(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Instructions(play));
		this.addState(new GameMain(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(main).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args){
		
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(800, 600, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}