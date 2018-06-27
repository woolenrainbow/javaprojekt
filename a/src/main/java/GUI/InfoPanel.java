package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.EdgedBalloonStyle;

public class InfoPanel extends JPanel implements Callable<Void> {
	private JLabel fromLab = null;
	private JLabel toLab = null;
	private JLabel fromInfo = null;
	private JLabel toInfo = null;
	private int WIDTH = 0;
	private int HEIGHT = 0;
	private Messenger messenger = null;
	public InfoPanel(int width, int height, Messenger messenger) {
		this.WIDTH = width / 4;
		this.HEIGHT = (int) (height / 1.5);
		this.messenger = messenger;
		setPreferredSize(new Dimension(width, height));
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		setLayout(layout);
		fromLab = new JLabel("Od: ");
		fromLab.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		fromLab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		fromLab.setOpaque(true);
		fromLab.setBackground(Color.LIGHT_GRAY);
		toLab = new JLabel("Do: ");
		toLab.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		toLab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toLab.setOpaque(true);
		toLab.setBackground(Color.LIGHT_GRAY);
		add(fromLab);
		add(toLab);
		fromInfo = new JLabel("brak wartości");
		BalloonTip fromLabBalloon = new BalloonTip(fromLab, fromInfo, new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
		fromLabBalloon.setVisible(false);
		fromLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fromLabBalloon.setVisible(true);
			    }
		});
		fromLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				fromLabBalloon.setVisible(false);
			    }
		});
		toInfo = new JLabel("brak wartości");
		BalloonTip toLabBalloon = new BalloonTip(toLab, toInfo, new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
		toLabBalloon.setVisible(false);
		toLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				toLabBalloon.setVisible(true);
			    }
		});
		toLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				toLabBalloon.setVisible(false);
			    }
		});
	}
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		if(messenger.getCode() == Messenger.SET_RANGE) {
			fromLab.setText("Od: " + messenger.getMessage().split(" ")[0]);
			fromInfo.setText(messenger.getMessage().split(" ")[0]);
			toLab.setText("Do: " + messenger.getMessage().split(" ")[1]);
			toInfo.setText(messenger.getMessage().split(" ")[1]);
		}
		return null;
	} 
}