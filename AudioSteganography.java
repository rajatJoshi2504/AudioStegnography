import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

public class AudioSteganography extends JFrame {
	public static int embedJIFX = 0;
	public static int embedJIFY = 0;
	public static int extractJIFX = 600;
	public static int extractJIFY = 0;
	private JMenuItem AboutMenuItem;
	private JMenu ActionMenu;
	private JMenuItem EmbedMenuItem;
	private JButton EmbedWizardButton;
	private JMenuItem ExitMenuItem;
	private JMenuItem ExtractMenuItem;
	private JButton ExtractWizardButton;
	private JMenu HelpMenu;
	private JMenuBar MainMenuMar;
	private JButton jButton1;
	private JDesktopPane jdp;
	private JLabel wallpaperLabel;

	public AudioSteganography() {
		this.initComponents();
		this.setExtendedState(this.getExtendedState() | 6);
		this.setResizable(true);
		this.setTitle("Audio Steganography");
		ImageIcon icon = new ImageIcon("/images/fevicon.jpg");
		this.setIconImage(icon.getImage());
	}

	private void initComponents() {
		this.jdp = new JDesktopPane();
		this.wallpaperLabel = new JLabel();
		this.EmbedWizardButton = new JButton();
		this.ExtractWizardButton = new JButton();
		this.jButton1 = new JButton();
		this.MainMenuMar = new JMenuBar();
		this.ActionMenu = new JMenu();
		this.EmbedMenuItem = new JMenuItem();
		this.ExtractMenuItem = new JMenuItem();
		this.ExitMenuItem = new JMenuItem();
		this.HelpMenu = new JMenu();
		this.AboutMenuItem = new JMenuItem();
		this.setDefaultCloseOperation(3);
		this.setCursor(new Cursor(0));
		this.jdp.setBackground(new Color(255, 255, 255));
		this.wallpaperLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/wallpaper.jpg")));
		this.wallpaperLabel.setBounds(0, 0, 670, 250);
		this.jdp.add((Component) this.wallpaperLabel, JLayeredPane.DEFAULT_LAYER);
		this.EmbedWizardButton.setFont(new Font("Tahoma", 0, 14));
		this.EmbedWizardButton.setIcon(new ImageIcon(this.getClass().getResource("/images/embed.png")));
		this.EmbedWizardButton.setText("Embed Text To Audio");
		this.EmbedWizardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.EmbedWizardButtonActionPerformed(evt);
			}
		});
		this.ExtractWizardButton.setFont(new Font("Tahoma", 0, 14));
		this.ExtractWizardButton.setIcon(new ImageIcon(this.getClass().getResource("/images/extract.png")));
		this.ExtractWizardButton.setText("Extract Text From Audio");
		this.ExtractWizardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.ExtractWizardButtonActionPerformed(evt);
			}
		});
		this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/images/exit.png")));
		this.jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.jButton1ActionPerformed(evt);
			}
		});
		this.ActionMenu.setIcon(new ImageIcon(this.getClass().getResource("/images/action.png")));
		this.ActionMenu.setMnemonic('A');
		this.ActionMenu.setText("Action");
		this.ActionMenu.setFont(new Font("Segoe UI", 0, 14));
		this.EmbedMenuItem.setAccelerator(KeyStroke.getKeyStroke(69, 2));
		this.EmbedMenuItem.setFont(new Font("Segoe UI", 0, 14));
		this.EmbedMenuItem.setIcon(new ImageIcon(this.getClass().getResource("/images/embed.png")));
		this.EmbedMenuItem.setText("Embed Text To Audio");
		this.EmbedMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.EmbedMenuItemActionPerformed(evt);
			}
		});
		this.ActionMenu.add(this.EmbedMenuItem);
		this.ExtractMenuItem.setAccelerator(KeyStroke.getKeyStroke(88, 2));
		this.ExtractMenuItem.setFont(new Font("Segoe UI", 0, 14));
		this.ExtractMenuItem.setIcon(new ImageIcon(this.getClass().getResource("/images/extract.png")));
		this.ExtractMenuItem.setText("Extract Text From Audio");
		this.ExtractMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.ExtractMenuItemActionPerformed(evt);
			}
		});
		this.ActionMenu.add(this.ExtractMenuItem);
		this.ExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(115, 8));
		this.ExitMenuItem.setFont(new Font("Segoe UI", 0, 14));
		this.ExitMenuItem.setIcon(new ImageIcon(this.getClass().getResource("/images/exit.png")));
		this.ExitMenuItem.setText("Exit");
		this.ExitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.ExitMenuItemActionPerformed(evt);
			}
		});
		this.ActionMenu.add(this.ExitMenuItem);
		this.MainMenuMar.add(this.ActionMenu);
		this.HelpMenu.setIcon(new ImageIcon(this.getClass().getResource("/images/help.png")));
		this.HelpMenu.setMnemonic('H');
		this.HelpMenu.setText("Help");
		this.HelpMenu.setFont(new Font("Segoe UI", 0, 14));
		this.HelpMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.HelpMenuActionPerformed(evt);
			}
		});
		this.AboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(65, 2));
		this.AboutMenuItem.setFont(new Font("Segoe UI", 0, 14));
		this.AboutMenuItem.setIcon(new ImageIcon(this.getClass().getResource("/images/about.png")));
		this.AboutMenuItem.setText("About");
		this.AboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				AudioSteganography.this.AboutMenuItemActionPerformed(evt);
			}
		});
		this.HelpMenu.add(this.AboutMenuItem);
		this.MainMenuMar.add(this.HelpMenu);
		this.setJMenuBar(this.MainMenuMar);
		GroupLayout layout = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jdp)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(this.EmbedWizardButton, -2, 228, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.ExtractWizardButton, -2, 223, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 331, 32767)
						.addComponent(this.jButton1, -2, 30, -2).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(this.jdp, -1, 408, 32767)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.EmbedWizardButton).addComponent(this.ExtractWizardButton))
								.addComponent(this.jButton1, -2, 30, -2))
						.addGap(18, 18, 18)));
		this.pack();
	}

	private void HelpMenuActionPerformed(ActionEvent evt) {
	}

	private void AboutMenuItemActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Audio Steganography \nCreated by : Amit,Avantika,Rajat", "About", 1);
	}

	private void ExitMenuItemActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void EmbedMenuItemActionPerformed(ActionEvent evt) {
		EmbedJIF embedJIF = new EmbedJIF();
		this.jdp.add(embedJIF);
		embedJIF.show();
	}

	private void EmbedWizardButtonActionPerformed(ActionEvent evt) {
		EmbedJIF embedJIF = new EmbedJIF();
		this.jdp.add(embedJIF);
		embedJIF.show();
	}

	private void ExtractMenuItemActionPerformed(ActionEvent evt) {
		ExtractJIF extractJIF = new ExtractJIF();
		this.jdp.add(extractJIF);
		extractJIF.show();
	}

	private void ExtractWizardButtonActionPerformed(ActionEvent evt) {
		ExtractJIF extractJIF = new ExtractJIF();
		this.jdp.add(extractJIF);
		extractJIF.show();
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
}
