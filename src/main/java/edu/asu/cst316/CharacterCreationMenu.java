package main.java.edu.asu.cst316;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.gui.*;
import org.newdawn.slick.Color;

import java.awt.Font;

import main.java.edu.asu.cst316.player.*;



public class CharacterCreationMenu extends BasicGameState{
	public String mouse = "";
	public Image background;
	public UnicodeFont font;
	public TextField careerName;
	public Player entrP;
	
	public CharacterCreationMenu(int state){
	}
	
	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/charCreationInt.png");
		Font font = new Font("Verdana", Font.PLAIN, 24);
		TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
		//font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC,26));
		careerName = new TextField(gc, trueTypeFont, 330, 210, 290, 45);
		careerName.setBackgroundColor(new Color(20, 25, 34));
		careerName.setTextColor(new Color(234, 226, 217));
		
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
		careerName.render(gc, g);
		careerName.setFocus(true);
		g.drawString("Venture 1", 330, 300);
		g.drawString("Venture 2", 330, 350);
		g.drawString("Venture 3", 330, 405);
		g.drawString("Select Business Venture", 50, 300);

	}

	//@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		// TODO Auto-generated method stub
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;
		
		
		//create text fields and combo boxes to get info
		
		//back button
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 22 &&
				xPosition < 172 &&
				yPosition < 64 &&
				yPosition > 18)
		{
			sbg.enterState(0);
		}
		/*next button
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 621 &&
				xPosition < 773 &&
				yPosition < 64 &&
				yPosition > 18)
		{
			//to do: run a character/player constructor with info from comboboxes and 
			//text fields
			sbg.enterState(2);
		}*/
		
		//venture 1
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 330 &&
				xPosition < 415 &&
				yPosition < 300 &&
				yPosition > 285){
			entrP = new Player(careerName.getText(), "venture 1", 10000, 50000, 4);
			sbg.enterState(2);			
		}
		//venture 2
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 330 &&
				xPosition < 415 &&
				yPosition < 245 &&
				yPosition > 230){
			entrP = new Player(careerName.getText(), "venture 1", 15000, 50000, 6);
			sbg.enterState(2);			
		}
		//venture 3
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 330 &&
				xPosition < 415 &&
				yPosition < 190 &&
				yPosition > 175){
			entrP = new Player(careerName.getText(), "venture 1", 20000, 50000, 8);
			sbg.enterState(2);			
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	

}
