package main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.net.httpserver.Authenticator.Result;
import com.sun.tools.javac.Main;

import admin.admin_login;
import menu.PosProgramFrame;
import menu.MenuPage;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// ------------------------------------------------------------------------------------------------

// 메인 화면

// ------------------------------------------------------------------------------------------------

public class main {

	private JFrame frame;
	private BufferedImage imag1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		initialize();
	}
	private void initialize() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/jsp0805";
		String id = "root";
		String password = "root";

		JButton btn1 = new JButton("구매하러가기");
		ImageIcon img1 = new ImageIcon("C:\\JAVA_LAB\\Pos_Project_final\\src\\main\\event.jpg");
		Image ch1 = img1.getImage();
		Image ch2 = ch1.getScaledInstance(409, 610, Image.SCALE_SMOOTH);

		frame = new JFrame();
		
		frame.setTitle("CU \uBB34\uC778 \uD3EC\uC2A4\uAE30");
		frame.setBounds(100, 100, 700, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("\uAD6C\uB9E4\uD558\uB7EC \uAC00\uAE30");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new menu.PosProgramFrame();
			}
		});

		btn1.setBounds(268, 728, 133, 23);

		frame.getContentPane().add(btn1);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(ch2));
		lblNewLabel.setBounds(138, 108, 409, 610);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("C:\\JAVA_LAB\\Pos_Project_final\\src\\main\\banner.PNG"));
		lblNewLabel_1.setBounds(92, 21, 512, 77);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);

			}
		}

