package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImage;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion() {
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentación");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("¡Buenas! Soy Sergio, oprime los botones de abajo", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco sobre mí...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",
                        Font.PLAIN, 20), Color.BLACK));
        panelDatos.setBackground(Color.GRAY);
        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miFoto.setBackground(Color.ORANGE);
        miHobby = new JButton("Este es mi hobbie");
        miHobby.addMouseListener(escucha);
        miHobby.setBackground(Color.ORANGE);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);
        misExpectativas.setBackground(Color.ORANGE);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.setBackground(Color.GRAY);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textoExpectativas = new JTextArea(8, 24);

    }

    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {

            if ((e.getComponent() == miFoto) && (e.getClickCount() == 1)) {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/EsteSoyYo.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            if ((e.getComponent() == miHobby) && (e.getClickCount() == 2)) {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/MiHobbie.jpg"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if ((e.getComponent() == misExpectativas) && (e.getKeyChar() == KeyEvent.VK_M)) {
                panelDatos.removeAll();
                textoExpectativas.setFont(new Font("SansSerif", Font.BOLD, 22));
                textoExpectativas.setLineWrap(true);
                textoExpectativas.setBackground(null);
                textoExpectativas.setWrapStyleWord(true);
                textoExpectativas.setEditable(false);
                textoExpectativas.setText(
                        "Ya tengo cierta experiencia con el lenguaje de programación Java, " +
                                "debido a que lo trabajé durante mis ultimos dos años en el " +
                                "colegio, con este curso espero aprender más sobre este lenguaje, " +
                                "determinar que soluciones se pueden generar gracias a este tipo de " +
                                "programación y lo más importante, divertirme mientras aprendo :).");
                panelDatos.add(textoExpectativas);
                image = new ImageIcon(getClass().getResource("/recursos/Miyamura.png"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);

                revalidate();
                repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }
}