import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class lexical_analyzer extends javax.swing.JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public lexical_analyzer() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        import_btn = new javax.swing.JButton();
        scan_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lexical Analyzer");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        import_btn.setText("Import input file");
        import_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_btnActionPerformed(evt);
            }
        });

        scan_btn.setText("Scan And View Tokens");
        scan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scan_btnActionPerformed(evt);
            }
        });

        text_area1.setColumns(20);
        text_area1.setRows(5);
        jScrollPane1.setViewportView(text_area1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setShowGrid(true);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(import_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scan_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(import_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(scan_btn)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("ConvertToTryWithResources")
    private void scan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scan_btnActionPerformed

        String filePath = ".\\output.txt";
        try {
        FileReader reader= new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);
        String firstLine = br.readLine().trim();                            // get the first line
        String[] columnsName = firstLine.split("/////");                   // get the columns name from the first line
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setColumnIdentifiers(columnsName);                          // set columns name to the jtable model
        Object[] tableLines = br.lines().toArray();   
        for(int i = 0; i < tableLines.length; i++){  
        String line = tableLines[i].toString().trim();                   // get lines from txt file
        String[] dataRow = line.split("/////");                          // extratct data from lines
        model.addRow(dataRow);                                          // set data to jtable model
        }
        br.close();
        } 
        catch (IOException ex) {
        System.out.println("error !!");
        }
    }//GEN-LAST:event_scan_btnActionPerformed

    @SuppressWarnings("ConvertToTryWithResources")
    private void import_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_btnActionPerformed

        String filePath = ".\\lexicalinput.txt";
        File file = new File(filePath);
       try{
           FileReader reader= new FileReader(filePath);
           BufferedReader br = new BufferedReader(reader);
           text_area1.read(br, null);
           br.close();
           text_area1.requestFocus();
       } 
       catch(IOException e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_import_btnActionPerformed

    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) throws  IOException, Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lexical_analyzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           lexical();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new lexical_analyzer().setVisible(true);
            }
        });
    }
    @SuppressWarnings("Convert2Diamond")
    static String identiferRegularExperssion = "^[a-zA-Z_]+[a-zA-Z0-9_]*";
    static String digit = "([0-9]+)||(0.[0-9]+)||([0-9]+.0)";
    static String Output="\"[a-zA-Z]+\"";
    static String token;
    static Scanner inputCode;
    static String Filename = "lexicalinput.txt";
    
    
    static ArrayList<String>  keywords = new ArrayList<String>();
    static ArrayList<String>  symbols = new ArrayList<String>();
    static ArrayList<String>  Operation = new ArrayList<String>();
    static ArrayList<String>  logialOP = new ArrayList<String>();

   
    @SuppressWarnings({"unchecked", "ConvertToTryWithResources"})
    public static void lexical() throws Exception {
        
        keywords.add("if");keywords.add("else");keywords.add("elseif");
        keywords.add("for");keywords.add("while");keywords.add("do");
        keywords.add("return");keywords.add("public");keywords.add("privet");
        keywords.add("protect");keywords.add("package");keywords.add("new");
        keywords.add("int");keywords.add("double");keywords.add("float");
        keywords.add("static");keywords.add("const");keywords.add("char");
        keywords.add("goto");keywords.add("boolean");keywords.add("long");
        keywords.add("void");keywords.add("this");keywords.add("try");
        keywords.add("catch");keywords.add("true");keywords.add("print");
        keywords.add("enter");keywords.add("auto"); keywords.add("break");
        keywords.add("case");keywords.add("continue");keywords.add("default");
        keywords.add("do");keywords.add("extern");keywords.add("Scanner");
        keywords.add("register");keywords.add("short");keywords.add("signed");
        keywords.add("sizeof");keywords.add("main");keywords.add("println"); 
        keywords.add("static");keywords.add("float");keywords.add("switch");
        keywords.add("typedef");keywords.add("unsigned");keywords.add("volatile");
        keywords.add("union");keywords.add("while");keywords.add("args");
        keywords.add("String");keywords.add("System");keywords.add("out");
        keywords.add("class");keywords.add("util");keywords.add("File");
        keywords.add("import");keywords.add("new");keywords.add("true");
        keywords.add("false");
        
      
        symbols.add("!");symbols.add("&");symbols.add("^");symbols.add("%");
        symbols.add("$");symbols.add("#");symbols.add("@");symbols.add("?");
        symbols.add("~");symbols.add("(");symbols.add(")");symbols.add("{"); 
        symbols.add("}");symbols.add(";");symbols.add(",");symbols.add("'");
        symbols.add(".");
        
       
        Operation.add("+");Operation.add("-");Operation.add("*");
        Operation.add("/");Operation.add("=");

        logialOP.add("||");logialOP.add("&&");logialOP.add("==");logialOP.add("<");
        logialOP.add("<=");logialOP.add(">=");logialOP.add(">");
        

        String tokenCategory;
        int line = 1;
        try {
            FileWriter f = new FileWriter(".\\output.txt");
            BufferedWriter wrr= new BufferedWriter(f);
            wrr.write("Lexeme  /////  Token\n");
            wrr.close();
            
            inputCode = new Scanner(new File(Filename));
            while (inputCode.hasNext()) {
                token = inputCode.next();
                if (keywords.contains(token)) {
                    tokenCategory = "Keyword";
                } else if (symbols.contains(token)) {
                    tokenCategory = "Symbol";
                } else if (Operation.contains(token)) {
                    tokenCategory = "Operator";
                } else if (logialOP.contains(token)) {
                    tokenCategory = "Logical Operator";
                } else if (Pattern.matches(identiferRegularExperssion, token)) {
                    tokenCategory = "Identifier";
                } else if (Pattern.matches(digit, token)) {
                    tokenCategory = "Digit";
                } else if (Pattern.matches(Output, token)) {
                    tokenCategory = "Output to the user";
                } else {
                    tokenCategory = "There an error in token !!! in line :" + line;
                }
                
                FileWriter file = new FileWriter(".\\output.txt", true);
                BufferedWriter wr= new BufferedWriter(file);
                wr.write(token +"  /////  " + tokenCategory);
                wr.newLine();
                wr.close();

                if (token.endsWith(";")) {
                     line++; }
                 }} 
                catch (IOException e) {
                System.out.println("File code not found !!");
                }}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton import_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton scan_btn;
    private javax.swing.JTextArea text_area1;
    // End of variables declaration//GEN-END:variables

    private static class Buffereader {

        public Buffereader() {
        }
    }

    private static class TextFileDataToJTable {

        public TextFileDataToJTable() {
        }
    }
}