/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class StockPage extends Frame implements ActionListener {
    Label wel,sid,pid1,qty1,wday,mfd,exp,cp,mrp,amt,pid2,qty2;
    TextField sidt,pid1t,pid2t,qty1t,wdayt,mfdt,expt,cpt,mrpt,amtt,qty2t,asupt;
    Button asup,apro,aitem,finl,req,shift,warn_days,asup1;
    TextArea disp;
    int tranid,total;

    StockPage() {
        MyWindowAdapter win=new MyWindowAdapter(this);
        addWindowListener(win);
        
        setLayout(new BorderLayout(5, 5));
        setSize(1000, 1000);
        setLocation(400, 100);
        setVisible(true);
        Font fontk = new Font("Times New Roman", Font.BOLD, 15);
        Font fontk1 = new Font("Times New Roman", Font.BOLD, 30);
        
        //North Border//
        Panel pnorth= new Panel(new GridLayout(2,1,5,5));
        
        //heading//
        Panel head= new Panel(new FlowLayout());
        wel = new Label("STOCK MANAGEMENT");
        wel.setFont(fontk1);
        
        //add suplier and add product button//
        Panel nor_but= new Panel(new GridLayout(1,4,5,5));
        Panel nor_but1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel nor_but2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel nor_but3 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel nor_but4 = new Panel(new FlowLayout(FlowLayout.LEFT));
        //add suplier button//
        asup = new Button("ADD SUPPLIER");
        asup.addActionListener(this);
        asup.setFont(fontk);
        //add product button//
        apro = new Button("ADD PRODUCT");
        apro.setFont(fontk);
        apro.addActionListener(this);
        //verify supplier button//
        asup1=new Button("VERIFY SUPPLIER");
        asup1.setFont(fontk);
        asup1.addActionListener(this);
        //verify textfield//
        asupt=new TextField(20);
        
        //Center Border/
        Panel pcenter= new Panel(new GridLayout(1,2,5,5));
        
        //add item components//
        Panel panel= new Panel(new GridLayout(11,1,5,5));
        
        //Product ID field//
        Panel p_id= new Panel(new GridLayout(1,2,5,5));
        Panel p_id1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel p_id2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        pid1 = new Label("Product ID:");
        pid1.setFont(fontk);
        pid1t=new TextField(20);
        
        //quantity field//
        Panel qty= new Panel(new GridLayout(1,2,5,5));
        Panel qty_1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel qty_2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        qty1 = new Label("Quantity:");
        qty1.setFont(fontk);
        qty1t=new TextField(20);
        
        //warn days field//
        Panel warning= new Panel(new GridLayout(1,2,5,5));
        Panel warning1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel warning2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        wday= new Label("Warn Days:");
        wday.setFont(fontk);
        wdayt=new TextField(20);
        
        //mfd field//
        Panel pmfd= new Panel(new GridLayout(1,2,5,5));
        Panel pmfd1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pmfd2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        mfd= new Label("MFD:");
        mfd.setFont(fontk);
        mfdt=new TextField(20);
        
        //exp field//
        Panel pexp= new Panel(new GridLayout(1,2,5,5));
        Panel pexp1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pexp2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        exp= new Label("Expiry:");
        exp.setFont(fontk);
        expt=new TextField(20);
        
        //cp field//
        Panel pcp= new Panel(new GridLayout(1,2,5,5));
        Panel pcp1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pcp2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        cp= new Label("CP:");
        cp.setFont(fontk);
        cpt=new TextField(20);
        
        //mrp field//
        Panel pmrp= new Panel(new GridLayout(1,2,5,5));
        Panel pmrp1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pmrp2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        mrp= new Label("MRP:");
        mrp.setFont(fontk);
        mrpt=new TextField(20);
        
        //Add item button//
        Panel pitem= new Panel(new GridLayout(1,2,5,5));
        Panel pitem1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        aitem=new Button("ADD ITEM");
        aitem.setFont(fontk);
        aitem.addActionListener(this);
        
        //sid field//
        Panel psid= new Panel(new GridLayout(1,2,5,5));
        Panel psid1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel psid2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        sid= new Label("Mobile No:");
        sid.setFont(fontk);
        sidt=new TextField(20);
        
        //amount paid field//
        Panel pamt= new Panel(new GridLayout(1,2,5,5));
        Panel pamt1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pamt2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        amt= new Label("Amount Paid:");
        amt.setFont(fontk);
        amtt=new TextField(20);
        
        //final button//
        Panel pfinl= new Panel(new GridLayout(1,2,5,5));
        Panel pfinl1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        finl=new Button("FINAL");
        finl.addActionListener(this);
        finl.setFont(fontk);
        
        //display area//
        disp=new TextArea("",5,5,TextArea.SCROLLBARS_NONE);
        disp.setFont(fontk);
        disp.setBackground(Color.LIGHT_GRAY);
        
        //south Border//
        Panel psouth= new Panel(new GridLayout(3,2,5,5));
        
        //product id south field//
        Panel ppid= new Panel(new GridLayout(1,2,5,5));
        Panel ppid1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel ppid2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        pid2 = new Label("Product ID:");
        pid2.setFont(fontk);
        pid2t=new TextField(20);
        
         //requirement button//
        Panel preq= new Panel(new GridLayout(1,2,5,5));
        Panel preq1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        req=new Button("REQUIREMENT");
        req.addActionListener(this);
        req.setFont(fontk);
        
        //quantity south field//
        Panel pqty= new Panel(new GridLayout(1,2,5,5));
        Panel pqty1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel pqty2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        qty2 = new Label("Quantity:");
        qty2.setFont(fontk);
        qty2t=new TextField(20);
        
        //warn days button//
        Panel pwarn_days= new Panel(new GridLayout(1,2,5,5));
        Panel pwarn_days1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        warn_days=new Button("WARNED ITEM");
        warn_days.addActionListener(this);
        warn_days.setFont(fontk);
        
        //shift button//
        Panel pshift= new Panel(new GridLayout(1,2,5,5));
        Panel pshift1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        shift=new Button("SHIFT");
        shift.addActionListener(this);
        shift.setFont(fontk);
        
        //*************************************************//
        
        head.add(wel);
        pnorth.add(head);
        
        nor_but1.add(asup);
        nor_but2.add(apro);
        nor_but3.add(asup1);
        nor_but4.add(asupt);
        nor_but.add(nor_but1);
        nor_but.add(nor_but2);
        nor_but.add(nor_but3);
        nor_but.add(nor_but4);
        pnorth.add(nor_but);
        
        p_id1.add(pid1);
        p_id2.add(pid1t);
        p_id.add(p_id1);
        p_id.add(p_id2);        
        panel.add(p_id);
        
        qty_1.add(qty1);
        qty_2.add(qty1t);
        qty.add(qty_1);
        qty.add(qty_2);
        panel.add(qty);
        
        warning1.add(wday);
        warning2.add(wdayt);
        warning.add(warning1);
        warning.add(warning2);        
        panel.add(warning);
        
        pmfd1.add(mfd);
        pmfd2.add(mfdt);
        pmfd.add(pmfd1);
        pmfd.add(pmfd2);        
        panel.add(pmfd);
        
        pexp1.add(exp);
        pexp2.add(expt);
        pexp.add(pexp1);
        pexp.add(pexp2);        
        panel.add(pexp);
        
        pcp1.add(cp);
        pcp2.add(cpt);
        pcp.add(pcp1);
        pcp.add(pcp2);        
        panel.add(pcp);
        
        pmrp1.add(mrp);
        pmrp2.add(mrpt);
        pmrp.add(pmrp1);
        pmrp.add(pmrp2);        
        panel.add(pmrp);
        
        pitem1.add(aitem);
        pitem.add(new Label(" "));
        pitem.add(pitem1);        
        panel.add(pitem);
        
        psid1.add(sid);
        psid2.add(sidt);
        psid.add(psid1);
        psid.add(psid2);        
        panel.add(psid);
        
        pamt1.add(amt);
        pamt2.add(amtt);
        pamt.add(pamt1);
        pamt.add(pamt2);        
        panel.add(pamt);
        
        pfinl1.add(finl);
        pfinl.add(new Label(" "));
        pfinl.add(pfinl1);        
        panel.add(pfinl);
        
        pcenter.add(panel);
        
        pcenter.add(disp);
        
        ppid1.add(pid2);
        ppid2.add(pid2t);
        ppid.add(ppid1);
        ppid.add(ppid2);        
        psouth.add(ppid);
        
        preq.add(new Label(" "));
        preq1.add(req);
        preq.add(preq1);        
        psouth.add(preq);
        
        pqty1.add(qty2);
        pqty2.add(qty2t);
        pqty.add(pqty1);
        pqty.add(pqty2);        
        psouth.add(pqty);
        
        pwarn_days.add(new Label(" "));
        pwarn_days1.add(warn_days);
        pwarn_days.add(pwarn_days1);        
        psouth.add(pwarn_days);
        
        pshift.add(new Label(" "));
        pshift1.add(shift);
        pshift.add(pshift1);        
        psouth.add(pshift);
        
        add(psouth,BorderLayout.SOUTH);
        
        add(pcenter,BorderLayout.CENTER);
        
        add(pnorth,BorderLayout.NORTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(asup)){
            AddSupplierPage asp=new AddSupplierPage(sidt,"");
        }
        else if(e.getSource().equals(apro)){
            AddItemPage aip=new AddItemPage();
        }
        else if(e.getSource().equals(aitem)){
            try {
                String dis=pid1t.getText()+"  "+qty1t.getText()+"  "+(Integer.parseInt(cpt.getText())*Integer.parseInt(qty1t.getText()))+"\n";
                disp.append(dis);
                Databases d=new Databases();
                d.startDb();
                d.changeRecords("insert into store_management_system.Prod_in_stock values ('"+pid1t.getText()+"','"+mfdt.getText()+"','"+expt.getText()+"',"+cpt.getText()+","+mrpt.getText()+","+qty1t.getText()+","+wdayt.getText()+");");
                total+=Integer.parseInt(cpt.getText())*Integer.parseInt(qty1t.getText());
                d.changeRecords("insert into store_management_system.sup_tran_prod values('"+pid1t.getText()+"',"+tranid+","+qty1t.getText()+");");
                d.endDb();
                
                pid1t.setText("");
                qty1t.setText("");
                wdayt.setText("");
                mfdt.setText("");
                expt.setText("");
                cpt.setText("");
                mrpt.setText("");
                pid1t.requestFocus();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(finl)){
            try {
                Databases d=new Databases();
                d.startDb();
                d.changeRecords("update store_management_system.sup_tran set amount="+total+",credit="+(total-Integer.parseInt(amtt.getText()))+" where tran_id="+tranid);
                d.endDb();
                disp.append("Total:  "+total);
                asupt.setText("");
                sidt.setText("");
                amtt.setText("");
                asupt.requestFocus();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(req)){
            try {
                disp.setText("");
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select * from store_management_system.product where ID not in (select P_ID from store_management_system.Prod_in_stock)");
                try {
                    while(rs.next())
                    {
                        disp.append("PID: "+rs.getString("ID")+"  Name: "+rs.getString("p_Name")+"  Company: "+rs.getString("Company")+"\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                d.endDb();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(shift)){
            try {
                int qt=0;
                Databases d1=new Databases();
                try {
                    d1.startDb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet rs=d1.displayRecords("select * from store_management_system.Prod_in_stock where P_ID='"+pid2t.getText()+"';");
                if(rs.next())
                    qt=rs.getInt("QTY");
                
                Databases d=new Databases();
                try {
                    d.startDb();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(qt-Integer.parseInt(qty2t.getText())>0)
                d.changeRecords("update store_management_system.Prod_in_stock set QTY=QTY-"+qty2t.getText()+" where P_ID='"+pid2t.getText()+"';");
                else
                    d.changeRecords("delete from store_management_system.Prod_in_store where P_ID='"+pid2t.getText()+"';");
                
                d.changeRecords("insert into store_management_system.Prod_in_store values ('"+pid2t.getText()+"','"+rs.getString("MFD")+"','"+rs.getString("EXP")+"',"+rs.getInt("CP")+","+rs.getInt("MRP")+","+qty2t.getText()+","+rs.getInt("WarnDays")+",0);");
                d.endDb();
                d1.endDb();
                
                disp.setText(qty2t.getText()+" quantity of product: "+pid2t.getText()+" shifted");
                pid2t.setText("");
                qty2t.setText("");
                asupt.requestFocus();
               
            } catch (SQLException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(warn_days)){
            try {
                disp.setText("");
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select ps.P_ID,ps.EXP,p.p_name,p.company from store_management_system.Prod_in_stock ps,store_management_system.product p where (CURDATE() between DATE_SUB(ps.EXP,INTERVAL ps.WarnDays DAY) and ps.EXP) and (ps.P_ID=p.ID)");
                try {
                    while(rs.next()){
                        disp.append("PID: "+rs.getString("P_ID")+"  Name: "+rs.getString("p.p_name")+"  Company: "+rs.getString("p.company")+"  Expiry date: "+rs.getString("EXP")+"\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                d.endDb();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //verify supplier//
        else if(e.getSource().equals(asup1)){
            try {
                disp.setText("");
                String a=asupt.getText();
                total=0;
                Databases d=new Databases();
                d.startDb();
                ResultSet rs=d.displayRecords("select *from store_management_system.supplier where Id='"+a+"';");
                try {
                    if(rs.next()){
                        sidt.setText(a);
                        d.endDb();
                    }
                    else{
                        d.endDb();
                        AddSupplierPage asp=new AddSupplierPage(sidt,a);
                    }
                        d=new Databases();
                        d.startDb();
                        d.changeRecords("insert into store_management_system.sup_tran (amount,credit,s_id) values (0,0,'"+a+"');");
                        d.endDb();
                        d=new Databases();
                        d.startDb();
                        rs=d.displayRecords("select max(tran_id) as tran from store_management_system.sup_tran;");
                        if(rs.next())
                        tranid=rs.getInt("tran");
                        d.endDb();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StockPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
