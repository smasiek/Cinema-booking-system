package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame implements ActionListener, MouseListener {

    private JLabel bSingUp, lLogin, lPassword, lEmail, lName, lSurname, lAge, lPhone, background, lWrongData, test;
    private JTextField tLogin, tEmail, tName, tSurname, tAge, tPhone;
    private ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
    private ImageIcon iZarejestrujHover = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_hover.png");
    private ImageIcon iZarejestrujClicked = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_clicked.png");
    private JPasswordField fPassword;
    private Login login;
    private String regex = "^(.+)@(.+).(.+)$";
    private Pattern pattern;
    private BufferedImage bi;
    int x = 107, y= 300, width = (835-80)/2, height = 50; // x=80, 935, y = 260
    public Register(){
        setSize(1920,1080); // inicjalizownie okna
        setTitle("Register"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lLogin = new JLabel("Login: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "login"
            lLogin.setFont(font.deriveFont(Font.BOLD, 50f));
            lLogin.setBounds(x,y,width,height+5);
            lLogin.setBackground(Color.white);
            lLogin.setForeground(Color.black);
            add(lLogin);

            lPassword = new JLabel("Hasło: "); // inicjalizownie oraz ustawianie tekstu "hasło"
            lPassword.setFont(font.deriveFont(Font.BOLD, 50f));
            lPassword.setBounds(x+width+50,y,width,height);
            lPassword.setBackground(Color.white);
            lPassword.setForeground(Color.black);
            add(lPassword);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tLogin = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania loginu
        tLogin.setBounds(x, y+height+20, width, height);
        tLogin.addActionListener(this);
        add(tLogin);

        fPassword = new JPasswordField(); // inicjalizownie oraz ustawianie pola do wpisania hasla
        fPassword.setBounds(x+width+50,y+height+20,width,height);
        fPassword.addActionListener(this);
        add(fPassword);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lEmail = new JLabel("E-mail: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "email"
            lEmail.setFont(font.deriveFont(Font.BOLD, 50f));
            lEmail.setBounds(x, y+2*(height+20), width*2+2*20, height);
            lEmail.setForeground(Color.black);
            add(lEmail);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        pattern = Pattern.compile(regex);
        tEmail = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania e-maila
        tEmail.setBounds(x,y+3*(height+20),width*2+50,height);
        tEmail.addActionListener(this);
        add(tEmail);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lName = new JLabel("Imie: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "imie"
            lName.setFont(font.deriveFont(Font.BOLD, 50f));
            lName.setBounds(x,y+4*(height+20),width,height);
            lName.setForeground(Color.black);
            add(lName);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tName = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania imienia
        tName.setBounds(x,y+5*(height+20),width,height);
        tName.addActionListener(this);
        add(tName);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lSurname = new JLabel("Nazwisko: "); // inicjalizownie oraz ustawianie tekstu "nazwisko"
            lSurname.setFont(font.deriveFont(Font.BOLD, 50f));
            lSurname.setBounds(x+width+50,y+4*(height+20),width,height);
            lSurname.setForeground(Color.black);
            add(lSurname);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tSurname = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania nazwiska
        tSurname.setBounds(x+width+50,y+5*(height+20),width,height);
        tSurname.addActionListener(this);
        add(tSurname);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lAge = new JLabel("Wiek",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "wiek"
            lAge.setFont(font.deriveFont(Font.BOLD, 50f));
            lAge.setBounds(x,y+6*(height+20),width,height);
            lAge.setForeground(Color.black);
            add(lAge);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tAge = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania wieku
        tAge.setBounds(x,y+7*(height+20),width,height);
        tAge.addActionListener(this);
        add(tAge);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lPhone = new JLabel("Nr telefonu: "); // inicjalizownie oraz ustawianie tekstu "telefon"
            lPhone.setFont(font.deriveFont(Font.BOLD, 50f));
            lPhone.setBounds(x+width+50,y+6*(height+20),width,height);
            lPhone.setForeground(Color.black);
            add(lPhone);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tPhone = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tPhone.setBounds(x+width+50,y+7*(height+20),width,height);
        tPhone.addActionListener(this);
        add(tPhone);

        bSingUp=new JLabel();
        bSingUp.setIcon(iZarejestrujZielone);
        bSingUp.setBounds(x+190,y+8*(height+20)+20,428,140);
        bSingUp.setBorder(null);
        bSingUp.addMouseListener(this);
        add(bSingUp);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            test = new JLabel("Kliknięcie sie powiodło");
            test.setFont(font.deriveFont(Font.BOLD, 50f));
            test.setBounds(x+(width/2),y-height,500,height);
            test.setForeground(Color.RED);
            add(test);
            test.setVisible(false);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lWrongData = new JLabel("Złe dane",JLabel.CENTER);
            lWrongData.setFont(font.deriveFont(Font.BOLD, 50f));
            lWrongData.setBounds(x+(width/2)+25,y-(height*4-25),width,height);
            lWrongData.setVisible(false);
            add(lWrongData);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Rejestracjav2.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }
    public Register(Login login){
        this();
        this.login = login;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Object p = e.getSource();

        } catch (RuntimeException err) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Object p = e.getSource();
            if ( p == bSingUp || p == tPhone) { // proba przypisania wpisanych tekstow w polu do zmiennych
                //moze klasa w przyszlosci?
                String l = tLogin.getText();
                String ps = fPassword.getText();
                String em = tEmail.getText();
                Matcher matcher = pattern.matcher(em);
                if(!matcher.matches()){
                    throw new RuntimeException("zly email");
                }
                String name = tName.getText();
                String surname = tSurname.getText();
                String _age = tAge.getText();
                int age = Integer.parseInt(_age);
                String _phone = tPhone.getText();
                int phone = Integer.parseInt(_phone);
                if(l == null || ps == null || name == null || surname == null || age == 0 || phone == 0 ){
                    throw new RuntimeException("Brak danych");
                }
                //send to check
                BazaDanych baza = new BazaDanych();
                List<Uzytkownicy> uzyt = baza.selectUzytkownicy();
                for(Uzytkownicy c: uzyt){
                    if(l.equals(c.getLogin()) || em.equals(c.getEmail())){
                        throw new RuntimeException("Brak danych");
                    }
                }
                if(!baza.insertUzytkownicy(l, ps, em, name, surname, age, phone)){
                    throw new RuntimeException("zle dane");
                }
                login.setVisible(true);
                dispose();
            }
        } catch (RuntimeException err) {
            System.out.println(err);
            lWrongData.setForeground(Color.red);
            lWrongData.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujClicked);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }
    }
}
