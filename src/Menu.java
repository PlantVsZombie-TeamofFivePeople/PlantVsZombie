import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.Clip;
import java.awt.event.MouseEvent;
public class Menu extends JPanel {
    /**
     * Creates new form Menu
     */
    private final Image bgImage;
    private final SoundEffect menuBgm = new SoundEffect("./src/bgms/menuBgm.wav");
    private Image AdventureImage;
    private final Image AdventureShadow;
    static GameChooseSeed gw;

    public Menu() {
        initComponents();
        setSize(1012, 785);
        menuBgm.prepare();
        menuBgm.player.loop(Clip.LOOP_CONTINUOUSLY);
        bgImage = new ImageIcon(this.getClass().getResource("images/resources/images/interface/Surface.jpg")).getImage();
        AdventureImage = new ImageIcon(this.getClass().getResource(
                    "images\\resources\\images\\interface\\Adventure_Default.png")).getImage();
        AdventureShadow = new ImageIcon((this.getClass().getResource(
                    "images\\resources\\images\\interface\\SelectorScreen_Shadow_Adventure.png"))).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
        g.drawImage(AdventureShadow, 523, 103, 392, 160, null);
        g.drawImage(AdventureImage, 520, 100, 380, 150, null);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        setPreferredSize(new java.awt.Dimension(1012, 785));

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel1MousePressed(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 105, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        GroupLayout.SequentialGroup SGroup1 = layout.createSequentialGroup()
                .addContainerGap(523, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        GroupLayout.SequentialGroup SGroup2 = layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, SGroup1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(SGroup2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(MouseEvent event) {
        getGraphics().drawImage(bgImage, 0, 0, null);
        getGraphics().drawImage(AdventureShadow, 523, 103, 392, 160, null);
        getGraphics().drawImage(AdventureImage, 527, 107, 380, 150, null);
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        paintComponent(getGraphics());
        menuBgm.player.stop();
        Controler.gw.dispose();
        gw = new GameChooseSeed();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(MouseEvent evt) {
        AdventureImage = new ImageIcon(this.getClass().getResource(
                "images\\resources\\images\\interface\\Adventure_Highlight.png")).getImage();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        repaint();
    }

    private void jPanel1MouseExited(MouseEvent evt) {
        AdventureImage = new ImageIcon(this.getClass().getResource(
                "images\\resources\\images\\interface\\Adventure_Default.png")).getImage();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        repaint();
    }

    private javax.swing.JPanel jPanel1;//Adventure Mode
}
