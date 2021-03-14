import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileFilter;

public class EmbedJIF
extends JInternalFrame {
    public String inputAudioFileName;
    public String inputAudioFileDirectory;
    public String inputAudioFileString;
    public static String inputTextFileString;
    public String inputPasswordString;
    public String outputAudioFileString;
    private Audio audio;
    public String inputTextAreaString;
    public static int embedJIFNo;
    private int pEmbedJIFNo;
    public File tempFile;
    private JSeparator HSeparator;
    private JButton clearButton;
    private JButton encryptAudioFileButton;
    private JButton finishEButton;
    private JFileChooser inputAudioChooser;
    private JButton inputAudioFileButton;
    private JLabel inputAudioFileLabel;
    private JScrollPane inputScrollPane;
    private JTextArea inputTextArea;
    private JFileChooser inputTextChooser;
    private JButton inputTextFileButton;
    private JLabel inputTextFileLabel;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel outputAudioFileLabel;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton playButton;
    private ButtonGroup radioButtonGroup;
    private JButton stopButton;
    private JRadioButton textFileRadioButton;
    private JRadioButton writeTextRadioButton;

    public EmbedJIF() {
        this.initComponents();
        ImageIcon icon = new ImageIcon("images/embed.png");
        this.setFrameIcon(icon);
        this.finishEButton.setEnabled(false);
        this.stopButton.setEnabled(false);
        this.playButton.setEnabled(false);
        this.inputTextFileButton.setEnabled(false);
        this.setLocation(AudioSteganography.embedJIFX, AudioSteganography.embedJIFY);
        AudioSteganography.embedJIFX += 20;
        AudioSteganography.embedJIFY += 25;
        this.pEmbedJIFNo = embedJIFNo++;
    }

    private void initComponents() {
        this.inputAudioChooser = new JFileChooser();
        this.inputTextChooser = new JFileChooser();
        this.radioButtonGroup = new ButtonGroup();
        this.inputAudioFileButton = new JButton();
        this.inputAudioFileLabel = new JLabel();
        this.inputTextFileButton = new JButton();
        this.inputTextFileLabel = new JLabel();
        this.passwordTextField = new JTextField();
        this.passwordLabel = new JLabel();
        this.clearButton = new JButton();
        this.encryptAudioFileButton = new JButton();
        this.finishEButton = new JButton();
        this.HSeparator = new JSeparator();
        this.playButton = new JButton();
        this.stopButton = new JButton();
        this.inputScrollPane = new JScrollPane();
        this.inputTextArea = new JTextArea();
        this.textFileRadioButton = new JRadioButton();
        this.writeTextRadioButton = new JRadioButton();
        this.jSeparator1 = new JSeparator();
        this.jSeparator2 = new JSeparator();
        this.outputAudioFileLabel = new JLabel();
        this.inputAudioChooser.setFileFilter(new MyAudioFileFilter());
        this.inputTextChooser.setFileFilter(new MyTextFileFilter());
        this.setClosable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setTitle("Encrypt Audio File (Embed Text To Audio File)");
        this.setPreferredSize(new Dimension(600, 475));
        this.addInternalFrameListener(new InternalFrameListener(){

            @Override
            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent evt) {
                EmbedJIF.this.formInternalFrameClosed(evt);
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            @Override
            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.inputAudioFileButton.setFont(new Font("Tahoma", 0, 14));
        this.inputAudioFileButton.setIcon(new ImageIcon(this.getClass().getResource("/images/audio.png")));
        this.inputAudioFileButton.setText("Input Audiio File (.au)");
        this.inputAudioFileButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.inputAudioFileButtonActionPerformed(evt);
            }
        });
        this.inputAudioFileLabel.setFont(new Font("Tahoma", 0, 12));
        this.inputAudioFileLabel.setText("File Not Choosen");
        this.inputTextFileButton.setFont(new Font("Tahoma", 0, 14));
        this.inputTextFileButton.setIcon(new ImageIcon(this.getClass().getResource("/images/textFile.png")));
        this.inputTextFileButton.setText("Input Text File (.txt)");
        this.inputTextFileButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.inputTextFileButtonActionPerformed(evt);
            }
        });
        this.inputTextFileLabel.setFont(new Font("Tahoma", 0, 12));
        this.inputTextFileLabel.setText("File Not Choosen");
        this.passwordTextField.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.passwordTextFieldActionPerformed(evt);
            }
        });
        this.passwordLabel.setFont(new Font("Tahoma", 0, 12));
        this.passwordLabel.setText("Password To Encrypt");
        this.clearButton.setText("Clear");
        this.clearButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.clearButtonActionPerformed(evt);
            }
        });
        this.encryptAudioFileButton.setFont(new Font("Tahoma", 0, 14));
        this.encryptAudioFileButton.setIcon(new ImageIcon(this.getClass().getResource("/images/embed.png")));
        this.encryptAudioFileButton.setText("Encrypt Audio File");
        this.encryptAudioFileButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                EmbedJIF.this.encryptAudioFileButtonMouseClicked(evt);
            }
        });
        this.encryptAudioFileButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.encryptAudioFileButtonActionPerformed(evt);
            }
        });
        this.finishEButton.setFont(new Font("Tahoma", 0, 14));
        this.finishEButton.setIcon(new ImageIcon(this.getClass().getResource("/images/finish.png")));
        this.finishEButton.setText("Finish");
        this.finishEButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.finishEButtonActionPerformed(evt);
            }
        });
        this.playButton.setIcon(new ImageIcon(this.getClass().getResource("/images/play.png")));
        this.playButton.setText("Play");
        this.playButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.playButtonActionPerformed(evt);
            }
        });
        this.stopButton.setIcon(new ImageIcon(this.getClass().getResource("/images/stop.png")));
        this.stopButton.setText("Stop");
        this.stopButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.stopButtonActionPerformed(evt);
            }
        });
        this.inputTextArea.setColumns(20);
        this.inputTextArea.setRows(5);
        this.inputScrollPane.setViewportView(this.inputTextArea);
        this.radioButtonGroup.add(this.textFileRadioButton);
        this.textFileRadioButton.setFont(new Font("Tahoma", 0, 14));
        this.textFileRadioButton.setText("Text File");
        this.textFileRadioButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.textFileRadioButtonActionPerformed(evt);
            }
        });
        this.radioButtonGroup.add(this.writeTextRadioButton);
        this.writeTextRadioButton.setFont(new Font("Tahoma", 0, 14));
        this.writeTextRadioButton.setSelected(true);
        this.writeTextRadioButton.setText("Write Text");
        this.writeTextRadioButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                EmbedJIF.this.writeTextRadioButtonActionPerformed(evt);
            }
        });
        this.outputAudioFileLabel.setText("Output Audio File Location");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.writeTextRadioButton).addGap(139, 139, 139).addComponent(this.textFileRadioButton)).addGroup(layout.createSequentialGroup().addComponent(this.inputAudioFileButton, -2, 204, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.inputAudioFileLabel).addGroup(layout.createSequentialGroup().addComponent(this.playButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.stopButton)))).addGroup(layout.createSequentialGroup().addComponent(this.encryptAudioFileButton, -2, 195, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.finishEButton, -2, 195, -2).addComponent(this.outputAudioFileLabel))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.clearButton).addComponent(this.passwordTextField, -2, 204, -2)).addGap(18, 18, 18).addComponent(this.passwordLabel))).addGap(0, 166, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.inputScrollPane, -2, 204, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.inputTextFileButton).addComponent(this.inputTextFileLabel)).addContainerGap()))).addComponent(this.jSeparator1).addComponent(this.HSeparator).addComponent(this.jSeparator2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.inputAudioFileLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.playButton).addComponent(this.stopButton))).addComponent(this.inputAudioFileButton, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.writeTextRadioButton).addComponent(this.textFileRadioButton)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.inputTextFileButton).addGap(18, 18, 18).addComponent(this.inputTextFileLabel)).addComponent(this.inputScrollPane, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.passwordTextField, -2, 25, -2).addComponent(this.passwordLabel)).addGap(9, 9, 9).addComponent(this.clearButton).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.HSeparator, -2, 18, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.outputAudioFileLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.finishEButton, -2, 40, -2)).addComponent(this.encryptAudioFileButton, -1, -1, 32767)).addContainerGap(65, 32767)));
        this.pack();
    }

    private void passwordTextFieldActionPerformed(ActionEvent evt) {
    }

    private void inputAudioFileButtonActionPerformed(ActionEvent evt) {
        int returnVal = this.inputAudioChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = this.inputAudioChooser.getSelectedFile();
            this.inputAudioFileName = file.getName();
            this.inputAudioFileDirectory = file.getParent();
            this.inputAudioFileString = file.getAbsolutePath();
            this.inputAudioFileLabel.setText(this.inputAudioFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
        this.playButton.setEnabled(true);
    }

    private void inputTextFileButtonActionPerformed(ActionEvent evt) {
        int returnVal = this.inputTextChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = this.inputTextChooser.getSelectedFile();
            inputTextFileString = file.getAbsolutePath();
            this.inputTextFileLabel.setText(inputTextFileString);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void clearButtonActionPerformed(ActionEvent evt) {
        this.passwordTextField.setText("");
    }

    private void encryptAudioFileButtonActionPerformed(ActionEvent evt) {
        this.inputPasswordString = this.passwordTextField.getText();
        this.inputTextAreaString = this.inputTextArea.getText();
        Boolean encryptOrNot = null;
        Boolean txtS = this.writeTextRadioButton.isSelected();
        if (txtS.booleanValue()) {
            if (this.inputTextAreaString.equals("")) {
                encryptOrNot = false;
            } else {
                encryptOrNot = true;
                try {
                    this.tempFile = File.createTempFile("AudioSteganographypyTemp" + this.pEmbedJIFNo, ".txt");
                }
                catch (IOException ex) {
                    Logger.getLogger(EmbedJIF.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter output = null;
                try {
                    output = new BufferedWriter(new FileWriter(this.tempFile));
                    output.write(this.inputTextAreaString);
                    output.close();
                }
                catch (IOException ex) {
                    Logger.getLogger(EmbedJIF.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            encryptOrNot = inputTextFileString != null ? Boolean.valueOf(true) : Boolean.valueOf(false);
        }
        System.out.println("Audio : " + this.inputAudioFileString + "\nAudioDIR : " + this.inputAudioFileDirectory + "\nFileName : " + this.inputAudioFileName + "\nTextFile : " + inputTextFileString + "\nPassword : " + this.inputPasswordString + "\n" + "Output AudioFile : " + this.outputAudioFileString);
        if (this.inputAudioFileString != null && encryptOrNot.booleanValue() && !this.inputPasswordString.equals("")) {
            this.encryptAudioFileButton.setEnabled(false);
            this.outputAudioFileString = this.inputAudioFileDirectory.concat("/Encrypted-" + this.inputAudioFileName);
            if (txtS.booleanValue()) {
                inputTextFileString = this.tempFile.getAbsolutePath();
                System.out.println("\nTemp Automatic : " + inputTextFileString);
            }
            this.outputAudioFileLabel.setText(this.outputAudioFileString);
            Stego e = new Stego(this.inputAudioFileString, inputTextFileString, this.outputAudioFileString, this.inputPasswordString.toCharArray());
            e.encode();
            this.finishEButton.setEnabled(true);
            try {
                this.tempFile.deleteOnExit();
            }
            catch (Exception ex) {}
        } else {
            JOptionPane.showMessageDialog(this, "1. Select Audio File\n2. Write Text or Select Text File\n3. Enter Password.", "Opps ! Something is missing !", 0);
        }
    }

    private void encryptAudioFileButtonMouseClicked(MouseEvent evt) {
    }

    private void finishEButtonActionPerformed(ActionEvent evt) {
        try {
            this.tempFile.deleteOnExit();
        }
        catch (Exception ex) {
            // empty catch block
        }
        this.dispose();
    }

    private void playButtonActionPerformed(ActionEvent evt) {
        try {
            this.stopButton.setEnabled(true);
            this.playButton.setEnabled(false);
            this.audio = new Audio(this.inputAudioFileString);
            this.audio.play();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(EmbedJIF.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(EmbedJIF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void stopButtonActionPerformed(ActionEvent evt) {
        try {
            this.audio.stop();
        }
        catch (Exception ex) {
            // empty catch block
        }
        this.playButton.setEnabled(true);
        this.stopButton.setEnabled(false);
    }

    private void formInternalFrameClosed(InternalFrameEvent evt) {
        try {
            this.audio.stop();
            this.tempFile.deleteOnExit();
        }
        catch (Exception ex) {
            // empty catch block
        }
    }

    private void textFileRadioButtonActionPerformed(ActionEvent evt) {
        this.inputTextArea.setEnabled(false);
        this.inputTextFileButton.setEnabled(true);
    }

    private void writeTextRadioButtonActionPerformed(ActionEvent evt) {
        this.inputTextArea.setEnabled(true);
        this.inputTextFileButton.setEnabled(false);
    }

    static {
        embedJIFNo = 1;
    }

}