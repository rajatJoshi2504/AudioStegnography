import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

class Login extends JFrame implements ActionListener {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	JLabel l1, l2;
	JButton b1, b2;
	JTextField t1;
	JPasswordField pf;

	Login() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("/images/wallpaper.png");
		setIconImage(img);
		Icon icon1 = new ImageIcon("./images/wallpaper.png");
		Image myImage;
		try {
			ImageIcon myImageIcon = new ImageIcon(this.getClass().getResource("images/wallpaper.jpg"));
			JLabel i = new JLabel(myImageIcon);
			JPanel p;
			p = (JPanel) getContentPane();
			p.add(i);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLocation(225, 50);
		// setLocationRelativeTo(null);
		setSize(900, 600);
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		l1 = new JLabel("UserName");
		l2 = new JLabel("Password");
		t1 = new JTextField(10);
		AbstractAction action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					JButton button = (JButton) e.getSource();
					button.doClick();
				} else if (e.getSource() instanceof JComponent) {
					JComponent component = (JComponent) e.getSource();
					component.transferFocus();
				}
			}
		};

		t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
		t1.getActionMap().put("TransferFocus", action);

		pf = new JPasswordField(10);
		pf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
		pf.getActionMap().put("TransferFocus", action);
		ImageIcon ic = new ImageIcon("/images/about.png");
		b1 = new JButton("Login");

		b1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
		b1.getActionMap().put("TransferFocus", action);
		ImageIcon ic1 = new ImageIcon("/images/about.png");
		b2 = new JButton("Exit");
		b2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
		b2.getActionMap().put("TransferFocus", action);
		b1.addActionListener(this);
		b2.addActionListener(this);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p1.setBackground(new Color(255, 255, 225));
		p2.setBackground(new Color(255, 255, 225));
		p3.setBackground(new Color(255, 255, 225));
		p4.setBackground(new Color(255, 255, 225));
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(pf);
		p3.add(b1);
		p3.add(b2);
		p4.setLayout(new GridLayout(3, 1));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		add(p4);
		t1.requestFocus();
		// b1.requestFocus();
		// b1.requestFocusInWindow();
		validate();

	} // eof cons.

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			try {
				if (t1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Enter User Name");
					return;
				}
				if (pf.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Enter Password");
					return;
				}

				if (t1.getText().trim().equals("admin") && pf.getText().trim().equals("admin")) {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					EventQueue.invokeLater(new Runnable() {

						@Override
						public void run() {
							new AudioSteganography().setVisible(true);
						}
					});

				} else {
					JOptionPane.showMessageDialog(this, "Invalid Password");
				}

			} catch (Exception ex) {
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (ae.getSource() == b2)

		{
			dispose();
		}
	}

	public static void main(String args[]) {
		new Login();
	}

}