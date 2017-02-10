/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
class OwnerPage extends Frame implements ActionListener {
    Label date, from, to, proid, dis, sup, wel;
    TextField fromt, tot, proidt, dist, supt;
    TextArea display;
    Button revenue, profit, vdis, sdis, debt,new_login;

    OwnerPage() {
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        setLayout(new GridLayout(10, 1, 5, 5));
        setSize(1000, 1000);
        setLocation(400, 100);
        setVisible(true);
        Font fonto = new Font("Times New Roman", Font.BOLD, 15);
        Font fonto1 = new Font("Times New Roman", Font.BOLD, 30);

        //Welcome heading//
        Panel top = new Panel(new FlowLayout());
        wel = new Label("WELCOME OWNER");
        wel.setFont(fonto1);

        //Display//
        Panel disp = new Panel(new FlowLayout());
        display = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
        display.setFont(fonto);
        display.setBackground(Color.LIGHT_GRAY);

        //Date label field//
        Panel pdate = new Panel(new FlowLayout(FlowLayout.LEFT));
        date= new Label("Date (yyyy-mm-dd)");
        date.setFont(fonto);

        //from_to_field//
        Panel date_text = new Panel(new GridLayout(1, 4, 5, 5));
        Panel date_text1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel date_text2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel date_text3 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel date_text4 = new Panel(new FlowLayout(FlowLayout.LEFT));
        from = new Label("From:");
        from.setFont(fonto);
        fromt = new TextField(12);
        to = new Label("To:");
        to.setFont(fonto);
        tot = new TextField(12);

        //revenue_profit_button//
        Panel rev_pro = new Panel(new GridLayout(1, 4, 5, 5));
        Panel rev_pro1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel rev_pro2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel rev_pro3 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel rev_pro4 = new Panel(new FlowLayout(FlowLayout.LEFT));
        revenue = new Button("REVENUE");
        revenue.setFont(fonto);
        revenue.addActionListener(this);
        profit = new Button("PROFIT");
        profit.setFont(fonto);
        profit.addActionListener(this);

        //product_field//
        Panel pro = new Panel(new GridLayout(1, 4, 5, 5));
        Panel pro1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pro2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        proid = new Label("Product ID:");
        proid.setFont(fonto);
        proidt = new TextField(15);
        proidt.setFont(fonto);

        //discount_field//
        Panel pdis = new Panel(new GridLayout(1, 4, 5, 5));
        Panel pdis1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pdis2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        dis = new Label("Discount:");
        dis.setFont(fonto);
        dist = new TextField(18);

        //view_discount and set discount button//
        Panel vdis_sdis = new Panel(new GridLayout(1, 4, 5, 5));
        Panel vdis_sdis1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel vdis_sdis2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        vdis = new Button("VIEW DISCOUNT");
        vdis.setFont(fonto);
        vdis.addActionListener(this);
        sdis = new Button("SET DISCOUNT");
        sdis.setFont(fonto);
        sdis.addActionListener(this);

        //supplier field//
        Panel psup = new Panel(new GridLayout(1, 4, 5, 5));
        Panel psup1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel psup2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        sup = new Label("Supplier ID:");
        supt = new TextField(18);
        sup.setFont(fonto);

        //debt_button//
        Panel pdebt = new Panel(new GridLayout(1, 4, 5, 5));
        Panel pdebt1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pdebt2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        debt = new Button("DEBT");
        debt.setFont(fonto);
        debt.addActionListener(this);
        new_login=new Button("CREATE NEW LOGIN");
        new_login.setFont(fonto);
        new_login.addActionListener(this);

        //*******************************************//
        
        top.add(wel);
        add(top);

        disp.add(display);
        add(disp);
        
        pdate.add(date);
        add(pdate);

        date_text1.add(from);
        date_text2.add(fromt);
        date_text3.add(to);
        date_text4.add(tot);
        date_text.add(date_text1);
        date_text.add(date_text2);
        date_text.add(date_text3);
        date_text.add(date_text4);
        add(date_text);

        rev_pro1.add(new Label(" "));
        rev_pro2.add(revenue);
        rev_pro3.add(profit);
        rev_pro4.add(new Label(" "));
        rev_pro.add(rev_pro1);
        rev_pro.add(rev_pro2);
        rev_pro.add(rev_pro3);
        rev_pro.add(rev_pro4);
        add(rev_pro);

        pro1.add(proid);
        pro2.add(proidt);
        pro.add(pro1);
        pro.add(pro2);
        pro.add(new Label(" "));
        pro.add(new Label(" "));
        add(pro);

        pdis1.add(dis);
        pdis2.add(dist);
        pdis.add(pdis1);
        pdis.add(pdis2);
        pdis.add(new Label(" "));
        pdis.add(new Label(" "));
        add(pdis);

        vdis_sdis1.add(vdis);
        vdis_sdis2.add(sdis);
        vdis_sdis.add(new Label(" "));
        vdis_sdis.add(vdis_sdis1);
        vdis_sdis.add(vdis_sdis2);
        vdis_sdis.add(new Label(" "));
        add(vdis_sdis);

        psup1.add(sup);
        psup2.add(supt);
        psup.add(psup1);
        psup.add(psup2);
        psup.add(new Label(" "));
        psup.add(new Label(" "));
        add(psup);

        pdebt1.add(debt);
        pdebt2.add(new_login);
        pdebt.add(new Label(" "));
        pdebt.add(pdebt1);
        pdebt.add(new Label(" "));
        pdebt.add(pdebt2);
        add(pdebt);
        fromt.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(revenue)) {
            try {
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=null;
                if(fromt.getText().equals("")&&tot.getText().equals("")){
                    rs=d.displayRecords("select sum(total) as rev from store_management_system.cust_tran");
                    try {
                        if(rs.next())
                            display.setText("Total lifetime revenue from store is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(fromt.getText().equals("")){
                    rs=d.displayRecords("select sum(total) as rev from store_management_system.cust_tran where date(c_date) between '0001-01-01' and '"+tot.getText()+"'");
                    try {
                        if(rs.next())
                            display.setText("Total revenue from store opening till "+tot.getText()+" is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(tot.getText().equals("")){
                    rs=d.displayRecords("select sum(total) as rev from store_management_system.cust_tran where date(c_date) between '"+fromt.getText()+"' and curdate()");
                    try {
                        if(rs.next())
                            display.setText("Total revenue from "+fromt.getText()+" till now is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                rs=d.displayRecords("select sum(total) as rev from store_management_system.cust_tran where date(c_date) between '"+fromt.getText()+"' and '"+tot.getText()+"'");
                try {
                    if(rs.next())
                        display.setText("Total revenue between "+fromt.getText()+" to "+tot.getText()+" is: "+rs.getString("rev"));
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                d.endDb();
                fromt.setText("");
                tot.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(profit)) {
            try {
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=null;
                if(fromt.getText().equals("")&&tot.getText().equals("")){
                    rs=d.displayRecords("select sum(profit) as rev from store_management_system.cust_tran");
                    try {
                        if(rs.next())
                            display.setText("Total lifetime profit from store is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(fromt.getText().equals("")){
                    rs=d.displayRecords("select sum(profit) as rev from store_management_system.cust_tran where date(c_date) between '0001-01-01' and '"+tot.getText()+"'");
                    try {
                        if(rs.next())
                            display.setText("Total profit from store opening till "+tot.getText()+" is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(tot.getText().equals("")){
                    rs=d.displayRecords("select sum(profit) as rev from store_management_system.cust_tran where date(c_date) between '"+fromt.getText()+"' and curdate()");
                    try {
                        if(rs.next())
                            display.setText("Total profit from "+fromt.getText()+" till now is: "+rs.getString("rev"));
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                rs=d.displayRecords("select sum(profit) as rev from store_management_system.cust_tran where date(c_date) between '"+fromt.getText()+"' and '"+tot.getText()+"'");
                try {
                    if(rs.next())
                        display.setText("Total profit between "+fromt.getText()+" to "+tot.getText()+" is: "+rs.getString("rev"));
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                d.endDb();
                fromt.setText("");
                tot.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(vdis)) {
            try {
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=null;
                display.setText("");
                if(proidt.getText().equals("")){
                    rs=d.displayRecords("select P_ID,Discount from Prod_in_store where Discount>0");
                    try {
                        while(rs.next()){
                            display.append("PID: "+rs.getString("P_ID")+"   Discount: "+rs.getString("Discount")+"%\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    rs=d.displayRecords("select Discount from Prod_in_store where P_ID='"+proidt.getText()+"'");
                    try {
                        if(rs.next()){
                            display.append("PID: "+proidt.getText()+"   Discount: "+rs.getString("Discount")+"%\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                proidt.setText("");
                dist.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(sdis)) {
            try {
                Databases d=new Databases();
                d.startDb();
                if(!(proidt.getText().isEmpty()||dist.getText().isEmpty())){
                    d.changeRecords("update store_management_system.Prod_in_store set Discount="+dist.getText()+" where P_ID='"+proidt.getText()+"'");
                }
                proidt.setText("");
                dist.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource().equals(debt)) {
            try {
                display.setText("");
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=null;
                if(supt.getText().isEmpty()){
                    rs=d.displayRecords("select s_id, sum(credit) as cred from store_management_system.sup_tran group by s_id");
                    try {
                        while(rs.next()){
                            display.append("SID: "+rs.getString("s_id")+"  Credit: "+rs.getInt("cred")+"\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    rs=d.displayRecords("select sum(credit) as cred from store_management_system.sup_tran where s_id='"+supt.getText()+"'");
                    try {
                        if(rs.next()){
                            display.append("SID: "+supt.getText()+"  Credit: "+rs.getInt("cred")+"\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                d.endDb();
                supt.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OwnerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource().equals(new_login)){
            NewLoginPage nlp=new NewLoginPage();
        }
    }
}
