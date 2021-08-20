package BankApp;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;
/**
 *
 * @author Howard Wu
 */
public class Mypage extends javax.swing.JFrame {
String user;
    /**
     * Creates new form Mypage
     */
    boolean isFound = false;
    int ln;
    public Mypage(String Id) {
        initComponents();
        this.user= Id;
        txtstaffname.setText(Id);
        txtstaffname.setEnabled(false);
        this.setTitle("Main Page");
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText(simpleformat.format(cal.getTime()));
        txtdate.setEnabled(false);
    }
   
    public void addWdata(String time, String type,String accid, String camount, String wamount, String newamount){
        try{
            int tid =0;
            FileWriter fw = new FileWriter("withdrawltransaction.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            try{
                ln = 0;
                RandomAccessFile raf = new RandomAccessFile("withdrawtransaction.txt", "rw");
                for(int i=0; raf.readLine()!=null; i++){
                    ln++;
                }
           
            }catch (FileNotFoundException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ln<2){
                tid=1;
                pw.println(tid+","+time+","+accid+","+type+","+camount+","+wamount+","+newamount);
            JOptionPane.showMessageDialog(null, "Transaction ID is "+ tid);
            pw.flush();
            pw.close();
            }else{
            File f= new File("withdrawltransaction.txt");
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String temp= s.nextLine();
                String[]Data = temp.split(",");
                if(!s.hasNext()){
                    tid = Integer.parseInt(Data[0]);
                }
            }
            s.close();
            tid++;

            pw.println(tid+","+time+","+accid+","+type+","+camount+","+wamount+","+newamount);
            JOptionPane.showMessageDialog(null, "Transaction ID is "+ tid);
            int option = JOptionPane.showConfirmDialog(this, "Do you want a receipt?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
            pw.flush();
            pw.close();
            }
        }catch(IOException ex){
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addTdata(String time, String bankid, String fullname, String acctype, String tamount,String newamount, String bankid1, String fullname1, String acctype1, String newamount1){
        String ttype = "Transfer";
         try{
            int tid =0;
            FileWriter fw = new FileWriter("transferrecord.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            try{
                ln = 0;
                RandomAccessFile raf = new RandomAccessFile("transferrecord.txt", "rw");
                for(int i=0; raf.readLine()!=null; i++){
                    ln++;
                }
            }catch (FileNotFoundException ex){
                Logger.getLogger(Mypage.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex){
                Logger.getLogger(Mypage.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ln<1){
                tid=1;
                String transid = String.valueOf(tid);
                pw.println(tid+"|"+time+"|"+bankid+"|"+fullname+"|"+acctype+"|"+tamount+"|"+bankid1+"|"+fullname1+"|"+acctype1);
            JOptionPane.showMessageDialog(null, "Transaction ID is "+ tid);
            int option = JOptionPane.showConfirmDialog(this, "Do you want a receipt?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option==JOptionPane.YES_OPTION){
                    DWReceipt tcep = new  DWReceipt(ttype,transid,time,acctype,bankid,tamount,bankid1,fullname1,acctype1,fullname);
                    //(String ttype, String transid, String time, String type, String accountid, String newamount, String toaccid, String toreceiver, String acctype, String transname)
                    tcep.show();
                }
            pw.flush();
            pw.close();
            }else{
            File f= new File("transferrecord.txt");
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String temp= s.nextLine();
                String[]Data = temp.split("|");
                if(!s.hasNext()){
                    tid = Integer.parseInt(Data[0]);
                }
            }
            s.close();
            tid++;
            String transid = String.valueOf(tid);
            pw.println(tid+"|"+time+"|"+bankid+"|"+fullname+"|"+acctype+"|"+tamount+"|"+newamount+"|"+bankid1+"|"+fullname1+"|"+acctype1+"|"+newamount1);
            JOptionPane.showMessageDialog(null, "Transaction ID is "+ tid);
            int option = JOptionPane.showConfirmDialog(this, "Do you want a receipt?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option==JOptionPane.YES_OPTION){
                    //(String ttype, String transid, String time, String type, String accountid, String newamount, String toaccid, String toreceiver, String acctype, String transname)
                    DWReceipt tcep = new DWReceipt(ttype, transid, time,acctype, bankid, tamount, bankid1,fullname1,acctype1,fullname);
                    tcep.show();
                }
            pw.flush();
            pw.close();
            }
        }catch(IOException ex){
        Logger.getLogger(Mypage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtstaffname = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtaccounttype = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtic = new javax.swing.JTextField();
        txtgender = new javax.swing.JTextField();
        txtreligion = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtamountavailable = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        currentbalance = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        withdrawlamount = new javax.swing.JTextField();
        acctype = new javax.swing.JComboBox<>();
        withdrawlbtn = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtcurrentbalance = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtdptname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        dptamount = new javax.swing.JTextField();
        dptacctype = new javax.swing.JComboBox<>();
        dptbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        frname = new javax.swing.JTextField();
        frcurrentbalance = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Toacctype = new javax.swing.JComboBox<>();
        toid = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        toname = new javax.swing.JTextField();
        tocurrentbalance = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        toacctype = new javax.swing.JComboBox<>();
        tosearch = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        transferamount = new javax.swing.JTextField();
        Transferbtn = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel14.setText("jLabel14");

        jLabel22.setText("Address.");

        jLabel23.setText("Address.");

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("ARKBANK Berhad  is a Malaysian universal bank, with key operating \"home markets\" of Malaysia");

        jLabel41.setText(" According to the 2020 Brand Finance report, Maybank is Malaysia's most valuable bank brand");

        jLabel27.setText("From.");

        jButton9.setForeground(new java.awt.Color(153, 153, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/search.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton12.setForeground(new java.awt.Color(153, 153, 153));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/search.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/Ark Bank.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date:");

        txtstaffname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtstaffname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstaffnameActionPerformed(evt);
            }
        });

        txtdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Name.");

        jLabel6.setText("Account Type.");

        jLabel7.setText("Address.");

        jLabel9.setText("Mykad No./ Passport No.");

        jLabel10.setText("Gender.");

        jLabel11.setText("Religion.");

        jLabel12.setText("Mobile.");

        savebtn.setBackground(new java.awt.Color(0, 153, 51));
        savebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/Bank Label.png"))); // NOI18N

        jLabel20.setText("Email.");

        jLabel21.setText("Amount Available.");

        jLabel24.setText("Password.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpassword)
                            .addComponent(txtaccounttype, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtname)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(124, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtic, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(txtgender)
                            .addComponent(txtreligion)
                            .addComponent(txtmobile)
                            .addComponent(txtemail)
                            .addComponent(txtamountavailable)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(82, 82, 82))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addComponent(txtreligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaccounttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtamountavailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savebtn)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Profile", jPanel1);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel33.setText("Name.");

        jLabel34.setText("Withdrawl Amount.");

        jLabel35.setText("Account Type.");

        jLabel36.setText("Current Balance.");

        withdrawlamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawlamountActionPerformed(evt);
            }
        });

        acctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Saving", "Current" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel34)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(currentbalance)
                    .addComponent(withdrawlamount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acctype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(acctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(currentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(withdrawlamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        withdrawlbtn.setBackground(new java.awt.Color(0, 153, 51));
        withdrawlbtn.setText("Withdrawl");
        withdrawlbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawlbtnActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Warning !", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel15.setText("“Current Account (Min)= RM 500");

        jLabel26.setText("“Saving  Account (Min)= RM 100");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(withdrawlbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(withdrawlbtn)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Withdrawl", jPanel5);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel16.setText("Name.");

        jLabel19.setText("Deposit Amount.");

        jLabel17.setText("Account Type.");

        jLabel18.setText("Current Balance.");

        dptamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dptamountActionPerformed(evt);
            }
        });

        dptacctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Saving", "Current" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel19)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdptname, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txtcurrentbalance)
                    .addComponent(dptamount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dptacctype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtdptname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(dptacctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtcurrentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(dptamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        dptbtn.setBackground(new java.awt.Color(0, 153, 51));
        dptbtn.setText("Deposit");
        dptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dptbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dptbtn)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Deposit", jPanel2);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("To.(Account ID)");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Details(From)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel30.setText("AccountType.");

        jLabel31.setText("Current Balance.");

        jLabel29.setText("Name.");

        Toacctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Saving", "Current", " " }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(frcurrentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Toacctype, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(frname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(Toacctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(frcurrentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Account Details(To)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel52.setText("AccountType.");

        jLabel53.setText("Current Balance.");

        jLabel54.setText("Name.");

        toacctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Current", "Saving" }));
        toacctype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toacctypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tocurrentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toacctype, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(toname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(toacctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(tocurrentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tosearch.setForeground(new java.awt.Color(153, 153, 153));
        tosearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/search.png"))); // NOI18N
        tosearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tosearchActionPerformed(evt);
            }
        });

        jLabel55.setText("Transfer Amount:");

        Transferbtn.setBackground(new java.awt.Color(0, 153, 51));
        Transferbtn.setText("Transfer");
        Transferbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferbtnActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText(">>");

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Warning !", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel32.setText("“Current Account (Min)= RM 500");

        jLabel59.setText("“Saving  Account (Min)= RM 100");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(toid, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tosearch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferamount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Transferbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel50)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel56)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(toid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tosearch))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(transferamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Transferbtn))
                .addGap(69, 69, 69))
        );

        jTabbedPane1.addTab("Transfer", jPanel3);

        jPanel7.setForeground(new java.awt.Color(102, 102, 102));

        jLabel25.setBackground(new java.awt.Color(255, 153, 0));
        jLabel25.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ARKBANK- Malaysia");

        jLabel43.setText("Founder: Howard Wu Jian Hao");

        jLabel44.setText("Founded: October 28, 1968");

        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("ARKBANK Berhad  is a Malaysian universal bank, with key operating \"home markets\" of Malaysia");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText(" According to the 2020 Brand Finance report, Maybank is Malaysia's most valuable bank brand");

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("the fourth top brand in Asean and ranked 70th in the world’s most valuable bank brands.");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addGap(15, 15, 15))
        );

        jLabel38.setText("Customer service: 1-388-88-6688 ");

        jLabel45.setText("Headquaters: Kuala Lumpur");

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/Bank Label.png"))); // NOI18N

        jLabel46.setBackground(new java.awt.Color(102, 102, 102));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Thanks for your Service !");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel43))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel45))
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addGap(1066, 1066, 1066)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("About", jPanel7);

        txtid.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(102, 102, 102));
        txtid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(102, 102, 102));
        searchbtn.setForeground(new java.awt.Color(153, 153, 153));
        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BankApp/search.png"))); // NOI18N
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 153));
        jButton5.setText("Add-New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchbtn))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtstaffname)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtstaffname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
	txtname.setText("");
        txtic.setText("");
        txtreligion.setText("");
        txtmobile.setText("");
        txtaccounttype.setText("");
        txtaddress.setText("");
        txtgender.setText("");
        txtemail.setText("");
        txtamountavailable.setText("");
        txtdptname.setText("");
        dptacctype.setSelectedItem("");
        txtcurrentbalance.setText("");
        name.setText("");
        currentbalance.setText("");
        frname.setText("");
        Toacctype.setSelectedItem("");
        frcurrentbalance.setText("");
       
        isFound = false;

        txtname.setEnabled(false);
        txtic.setEnabled(false);
        txtaccounttype.setEnabled(false);
        txtic.setEnabled(false);
        txtgender.setEnabled(false);
        txtamountavailable.setEnabled(false);
        savebtn.setEnabled(true);
        txtdptname.setEnabled(false);
        dptacctype.setEnabled(false);
        txtcurrentbalance.setEnabled(false);
        name.setEnabled(false);
        currentbalance.setEnabled(false);
        frname.setEnabled(false);
        Toacctype.setEnabled(false);
        frcurrentbalance.setEnabled(false);
        acctype.setEnabled(false);

        String search_id = txtid.getText();

        if (search_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Account Number to search");
        } else {
            File file = new File("Customer.txt");

            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String accdata;
                Account user;

                while ((accdata = br.readLine()) != null) {
                    user = new Account(accdata);
                    if (user.getID().equals(search_id)) {
                        isFound = true;


                        txtname.setText(user.getName());
                        txtic.setText(user.getIC());
                        txtgender.setText(user.getGender());
                        txtreligion.setText(user.getReligion());
                        txtmobile.setText(user.getMobile());
                        txtemail.setText(user.getEmail());
                        txtaccounttype.setText(user.getAccountType());
                        txtamountavailable.setText(user.getDepositAmount());
                        txtaddress.setText(user.getAddress());
                        txtpassword.setText(user.getPassword());
                        txtdptname.setText(user.getName());
                        dptacctype.setSelectedItem(user.getAccountType());
                        txtcurrentbalance.setText(user.getDepositAmount());
                        name.setText(user.getName());
                        acctype.setSelectedItem(user.getAccountType());
                        currentbalance.setText(user.getDepositAmount());
                        frname.setText(user.getName());
                        Toacctype.setSelectedItem(user.getAccountType());
                        frcurrentbalance.setText(user.getDepositAmount());
            
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Account not found");
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {
               
            }
                
            } 
    }//GEN-LAST:event_searchbtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        NewAccount f = new NewAccount(user);
                f.show();
                dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtstaffnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstaffnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstaffnameActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void TransferbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferbtnActionPerformed
        String fullname = frname.getText();
        String bankid = txtid.getText();
        String acctype = (String)Toacctype.getSelectedItem();
        String transferamount1 = transferamount.getText();

        //  to
        String bankid2 = toid.getText();
        String fullname2 = toname.getText();
        String acctype2 = (String)toacctype.getSelectedItem();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        Date date = new Date();
        String time = df.format(date);
        ArrayList<Account> acclist = new ArrayList<>();
        ArrayList<Account2> acclist1 = new ArrayList<>();

        if(transferamount.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Fill In Transfer Amount!");
        }else{
            int transamount = Integer.parseInt(transferamount.getText());
            int fr = Integer.parseInt(frcurrentbalance.getText());
            int to = Integer.parseInt(tocurrentbalance.getText());
            int frnew = fr - transamount;
            int tonew = to + transamount;
            String fromnew = String.valueOf(frnew);
            String tnew = String.valueOf(tonew);
            if(acctype == "Saving"){
                if(frnew < 100){
                    JOptionPane.showMessageDialog(this, "Balance not enough!");
                }else{
                    File f = new File ("Customer.txt");
                    try{
                        try(FileReader r = new FileReader(f)){
                            BufferedReader br = new BufferedReader(r);
                            String data;
                            Account tacc;

                            while((data = br.readLine()) != null){
                                tacc = new Account(data);
                                if(tacc.getID().equals(bankid)){
                                    tacc.setDepositAmount(fromnew);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "New Balance Updated!");
                        }catch (IOException ex){

                        }
                        //                 addTdata(time,bankid,fullname,acctype,famount,fromnew,bankid2,fullname2,acctype2,tamount,tnew);
                        addTdata(time,bankid,fullname,acctype,transferamount1,fromnew,bankid2,fullname2,acctype2,tnew);
                    }catch (FileNotFoundException ex){

                    }catch (IOException ex){

                    }

                    if(acctype2 == "Saving"){
                        File sf = new File ("Customer.txt");
                        try{
                            try(FileReader r = new FileReader(sf)){
                                BufferedReader br = new BufferedReader(r);
                                String data;
                                Account2 tacc;

                                while((data = br.readLine()) != null){
                                    tacc = new Account2(data);
                                    if(tacc.getID().equals(bankid2)){
                                        tacc.setDepositAmount(tnew);
                                    }
                                    acclist1.add(tacc);
                                }
                            }
                            try(PrintWriter pw = new PrintWriter(new FileWriter(sf, false))){
                                acclist1.forEach((tacc) -> {
                                    pw.println(tacc.toString());
                                });
                                JOptionPane.showMessageDialog(this, "New Balance Updated!");

                            }catch(IOException ex){
                            }
                        }catch(FileNotFoundException ex){
                        }catch (IOException ex){
                        }
                    }else if(acctype2 == "Current"){
                        File cf = new File ("Customer.txt");
                        try{
                            try(FileReader r = new FileReader(cf)){
                                BufferedReader br = new BufferedReader(r);
                                String data;
                                Account2 tacc;

                                while((data = br.readLine()) != null){
                                    tacc = new Account2(data);
                                    if(tacc.getID().equals(bankid2)){
                                        tacc.setDepositAmount(tnew);
                                    }
                                    acclist1.add(tacc);
                                }
                            }
                            try(PrintWriter pw = new PrintWriter(new FileWriter(cf, false))){
                                acclist1.forEach((acc) -> {
                                    pw.println(acc.toString());
                                });
                                //

                            }catch (IOException ex){
                            }
                        }catch (FileNotFoundException ex){
                        }catch (IOException ex){
                        }
                    }
                }
            }else if(acctype == "Current"){
                if(frnew < 500){
                    JOptionPane.showMessageDialog(this, "Balance not enough!");
                }else{
                    File f = new File ("Customer.txt");
                    try{
                        try(FileReader r = new FileReader(f)){
                            BufferedReader br = new BufferedReader(r);
                            String data;
                            Account tacc;

                            while((data = br.readLine()) != null){
                                tacc = new Account(data);
                                if(tacc.getID().equals(bankid)){
                                    tacc.setDepositAmount(fromnew);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "New Balance Updated!");
                        }catch (IOException ex){

                        }addTdata(time,bankid,fullname,acctype,transferamount1,fromnew,bankid2,fullname2,acctype2,tnew);

                    }catch (FileNotFoundException ex){

                    }catch (IOException ex){

                    }

                    if(acctype2 == "Saving"){
                        File sf = new File ("Customer.txt");
                        try{
                            try(FileReader r = new FileReader(sf)){
                                BufferedReader br = new BufferedReader(r);
                                String data;
                                Account2 tacc;

                                while((data = br.readLine()) != null){
                                    tacc = new Account2(data);
                                    if(tacc.getID().equals(bankid2)){
                                        tacc.setDepositAmount(tnew);
                                    }
                                    acclist1.add(tacc);
                                }
                            }
                            try(PrintWriter pw = new PrintWriter(new FileWriter(sf, false))){
                                acclist1.forEach((acc) -> {
                                    pw.println(acc.toString());
                                });

                            }catch(FileNotFoundException ex){
                            }catch(IOException ex){
                            }
                        }catch (IOException ex){
                        }
                    }else if(acctype2 == "Current"){
                        File cf = new File ("Customer.txt");
                        try{
                            try(FileReader r = new FileReader(cf)){
                                BufferedReader br = new BufferedReader(r);
                                String data;
                                Account2 tacc;

                                while((data = br.readLine()) != null){
                                    tacc = new Account2(data);
                                    if(tacc.getID().equals(bankid2)){
                                        tacc.setDepositAmount(tnew);
                                    }
                                    acclist1.add(tacc);
                                }
                            }
                            try(PrintWriter pw = new PrintWriter(new FileWriter(cf, false))){
                                acclist1.forEach((acc) -> {
                                    pw.println(acc.toString());
                                });
                                JOptionPane.showMessageDialog(this, "New Balance Updated!");
                            }catch (IOException ex){
                            }
                        }catch (FileNotFoundException ex){
                        }catch (IOException ex){

                        }addTdata(time,bankid,fullname,acctype,transferamount1,fromnew,bankid2,fullname2,acctype2,tnew);
                    }}
                }
            }
    }//GEN-LAST:event_TransferbtnActionPerformed

    private void tosearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tosearchActionPerformed
        toname.setText("");
        toacctype.setSelectedItem("");
        tocurrentbalance.setText("");
        isFound = false;

        toname.setEnabled(false);
        tocurrentbalance.setEnabled(false);
        toacctype.setEnabled(false);

        String search_id = toid.getText();

        if (search_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Account Number to search");
        } else {
            File file = new File("Customer.txt");

            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String accdata;
                Account user;

                while ((accdata = br.readLine()) != null) {
                    user = new Account(accdata);
                    if (user.getID().equals(search_id)) {
                        isFound = true;
                        toname.setText(user.getName());
                        toacctype.setSelectedItem(user.getAccountType());
                        tocurrentbalance.setText(user.getDepositAmount());

                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Account not found");
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }

        }
    }//GEN-LAST:event_tosearchActionPerformed

    private void toacctypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toacctypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toacctypeActionPerformed

    private void dptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dptbtnActionPerformed
        String accid = txtid.getText();
        String type = (String)dptacctype.getSelectedItem();
        ArrayList<Account> acclist = new ArrayList<>();
        if(dptamount.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter an amount!");
        }else{
            int dptam = Integer.parseInt(dptamount.getText());
            int now = Integer.parseInt(txtcurrentbalance.getText());
            int totalamount = now + dptam;
            String total = String.valueOf(totalamount);
            if(type == "Saving"){
                if(totalamount < 0){
                    JOptionPane.showMessageDialog(this, "Services Unavailable!");
                }else{
                    File f = new File ("Customer.txt");

                    try{
                        try(FileReader fr = new FileReader(f)){
                            BufferedReader br = new BufferedReader(fr);
                            String accdata;
                            Account tacc;

                            while((accdata = br.readLine()) != null){
                                tacc = new Account(accdata);
                                if(tacc.getID().equals(accid)){
                                    tacc.setDepositAmount(total);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "Account Details Updated!");
                        }catch (IOException ex){
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                    }catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }

            }else if(type == "Current"){
                if(totalamount < 0){
                    JOptionPane.showMessageDialog(this, "Services Unavailable!");
                }else{
                    File f = new File ("Customer.txt");

                    try{
                        try(FileReader fr = new FileReader(f)){
                            BufferedReader br = new BufferedReader(fr);
                            String accdata;
                            Account tacc;

                            while((accdata = br.readLine()) != null){
                                tacc = new Account(accdata);
                                if(tacc.getID().equals(accid)){
                                    tacc.setDepositAmount(total);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "New Balance Updated!");
                        }catch (IOException ex){

                        }

                    }catch (FileNotFoundException ex){

                    }catch (IOException ex){

                    }
                }
            }

        }

    }//GEN-LAST:event_dptbtnActionPerformed

    private void dptamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dptamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dptamountActionPerformed

    private void withdrawlbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawlbtnActionPerformed
        String accid = txtid.getText();
        String type = (String)acctype.getSelectedItem();
        String wamount = withdrawlamount.getText();
        ArrayList<Account> acclist = new ArrayList<>();
        if(withdrawlamount.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter an amount!");
        }else{
            int with = Integer.parseInt(withdrawlamount.getText());
            int now = Integer.parseInt(currentbalance.getText());
            int newamount = now - with;
            String latestamount = String.valueOf(newamount);
            if(type == "Saving"){
                if(newamount < 100){
                    JOptionPane.showMessageDialog(this, "Balance not enough!");
                }else{
                    File f = new File ("Customer.txt");

                    try{
                        try(FileReader fr = new FileReader(f)){
                            BufferedReader br = new BufferedReader(fr);
                            String accdata;
                            Account tacc;

                            while((accdata = br.readLine()) != null){
                                tacc = new Account(accdata);
                                if(tacc.getID().equals(accid)){
                                    tacc.setDepositAmount(latestamount);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "Account Details Updated!");
                        }catch (IOException ex){
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                    }catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }

            }else if(type == "Current"){
                if(newamount < 500){
                    JOptionPane.showMessageDialog(this, "Balance not enough!");
                }else{
                    File f = new File ("Customer.txt");

                    try{
                        try(FileReader fr = new FileReader(f)){
                            BufferedReader br = new BufferedReader(fr);
                            String accdata;
                            Account tacc;

                            while((accdata = br.readLine()) != null){
                                tacc = new Account(accdata);
                                if(tacc.getID().equals(accid)){
                                    tacc.setDepositAmount(latestamount);
                                }
                                acclist.add(tacc);
                            }
                        }
                        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                            acclist.forEach((acc) -> {
                                pw.println(acc.toString());
                            });
                            JOptionPane.showMessageDialog(this, "New Balance Updated!");
                        }catch (IOException ex){

                        }

                    }catch (FileNotFoundException ex){

                    }catch (IOException ex){

                    }
                }
            }

        }

    }//GEN-LAST:event_withdrawlbtnActionPerformed

    private void withdrawlamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawlamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawlamountActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        String accid = txtid.getText();
        String addr = txtaddress.getText();
        String contact = txtmobile.getText();
        String email = txtemail.getText();
        String Religion = txtreligion.getText();
        String Password = txtpassword.getText();

        ArrayList<Account> acclist = new ArrayList<>();
        if (!isFound){
            JOptionPane.showMessageDialog(this, "Account does not exist");
        }else if (accid.isEmpty() || addr.isEmpty() || contact.isEmpty() || email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill up all the details!");
        }else{
            File f = new File ("customer.txt");

            try{
                try(FileReader fr = new FileReader(f)){
                    BufferedReader br = new BufferedReader(fr);
                    String accdata;
                    Account tacc;

                    while((accdata = br.readLine()) != null){
                        tacc = new Account(accdata);
                        if(tacc.getID().equals(accid)){
                            tacc.setAddress(addr);
                            tacc.setMobile(contact);
                            tacc.setEmail(email);
                            tacc.setReligion(Religion);
                            tacc.setPassword (Password);

                        }
                        acclist.add(tacc);
                    }
                }
                try (PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
                    acclist.forEach((acc) -> {
                        pw.println(acc.toString());
                    });
                    JOptionPane.showMessageDialog(this, "Account Details Updated!");
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }//GEN-LAST:event_savebtnActionPerformed
       
    /**
     * @param args the command line arguments
     */

        /* Create and display the form */

      


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Toacctype;
    private javax.swing.JButton Transferbtn;
    private javax.swing.JComboBox<String> acctype;
    private javax.swing.JTextField currentbalance;
    private javax.swing.JComboBox<String> dptacctype;
    private javax.swing.JTextField dptamount;
    private javax.swing.JButton dptbtn;
    private javax.swing.JTextField frcurrentbalance;
    private javax.swing.JTextField frname;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField name;
    private javax.swing.JButton savebtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JComboBox<String> toacctype;
    private javax.swing.JTextField tocurrentbalance;
    private javax.swing.JTextField toid;
    private javax.swing.JTextField toname;
    private javax.swing.JButton tosearch;
    private javax.swing.JTextField transferamount;
    private javax.swing.JTextField txtaccounttype;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtamountavailable;
    private javax.swing.JTextField txtcurrentbalance;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdptname;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtic;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtreligion;
    private javax.swing.JTextField txtstaffname;
    private javax.swing.JTextField withdrawlamount;
    private javax.swing.JButton withdrawlbtn;
    // End of variables declaration//GEN-END:variables
}
