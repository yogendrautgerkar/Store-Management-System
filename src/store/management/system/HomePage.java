/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;

import java.awt.*;
import java.awt.event.*;


 class HomePage extends Frame implements ActionListener {
    Font fonth;
    Button owner, bill, stock, store;
    Label hwel;
    //HomePage hg;
    
    HomePage() {
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setLocation(400, 100);
        setVisible(true);
        fonth = new Font("Times New Roman", Font.BOLD, 30);

        //heading//
        Panel pn = new Panel(new FlowLayout(FlowLayout.CENTER));
        hwel = new Label("WELCOME TO STORE MANAGEMENET SYSTEM");
        hwel.setFont(fonth);

        //buttons//
        Panel pc = new Panel(new GridLayout(2, 2, 30, 30));
        //owner button//
        owner = new Button("Owner");
        owner.setFont(fonth);
        owner.addActionListener(this);
        //bill button/
        bill = new Button("Bill");
        bill.setFont(fonth);
        bill.addActionListener(this);
        //store//
        store = new Button("Store");
        store.setFont(fonth);
        store.addActionListener(this);
        //stock//
        stock = new Button("Stock");
        stock.setFont(fonth);
        stock.addActionListener(this);
        
        /*coloring//
        owner.setBackground(Color.DARK_GRAY);
        bill.setBackground(Color.DARK_GRAY);
        store.setBackground(Color.DARK_GRAY);
        stock.setBackground(Color.DARK_GRAY);
        setBackground(Color.GRAY);*/

        //***************************************************//
        
        pc.add(owner);
        pc.add(bill);
        pc.add(store);
        pc.add(stock);
        add(pc, BorderLayout.CENTER);

        pn.add(hwel);
        add(pn, BorderLayout.NORTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(owner)) {
            LoginPage lo = new LoginPage('O',this);
        } else if (e.getSource().equals(bill)) {
            LoginPage lo = new LoginPage('B',this);
        } else if (e.getSource().equals(store)) {
            LoginPage lo = new LoginPage('M',this);
        } else if (e.getSource().equals(stock)) {
            LoginPage lo = new LoginPage('S',this);
        }
        
    }
}

