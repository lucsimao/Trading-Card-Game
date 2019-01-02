package views;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;

import views.components.ElementView;
import views.components.HandView;

public class MainView extends GameView {

	public static final int EAST_BAR = 0;
	public static final int BACKGROUND = 1;
	public static final int BOTTOM = 2;
	
	private static final float coef_eastBar = 0.222f;
	
	
	private ArrayList<ElementView> elements;

	public MainView(int width, int height) {
		super(width, height);
		this.elements = new ArrayList<ElementView>();
	}

	public void addElement(ElementView view) {
		this.elements.add(view);
	}

	public void removeElement(ElementView view) {
		this.elements.remove(view);
	}

	public ElementView getElement(int index) {
		return this.elements.get(index);
	}

	@Override
	void tick(Set<String> teclas, double dt) {
		// TODO Auto-generated method stub

	}

	@Override
	void key(String tecla) {
		// TODO Auto-generated method stub

	}

	@Override
	void mouse(MouseEvent mouseEvent) {
		try {
			for (ElementView e : elements)
				e.clickAction(mouseEvent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	void draw(Screen screen) {
		for (ElementView view : elements) {
			view.drawItself(screen);
		}
	}

	@Override
	void move(MouseEvent mouseEvent) {
		try {
			for (ElementView e : elements)
				e.hoverAction(mouseEvent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addElement(ElementView element, int position) {
		switch (position)
		{
			case 0:
				element.setWidth(Math.round(getWidth()*coef_eastBar));
				element.setX(0);
				element.setY(0);
				element.setHeight(this.getHeight());
				break;
			case 1:
				element.setWidth(Math.round(getWidth()));
				element.setX(0);
				element.setY(0);
				element.setHeight(getHeight());
				break;
			case 2:
				element.setX( Math.round(900/144) + Math.round(900/3.13f) + 900*2/9/2 - Math.round(900/13.24f)/2);
				element.setY(Math.round(600 - Math.round(600/3.469f)*3/8));
				break;
		}

		addElement(element);		
	}

}
