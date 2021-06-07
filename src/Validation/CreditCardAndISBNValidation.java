
package Validation;

import java.awt.Color;
import javax.swing.JFrame;

/*
Class: GUIweek1
Description: GUI and validation app
Created: 21/10/2020.
Updated: 21/10/2020.
Authors: Asia Benyadilok
*/
public class CreditCardAndISBNValidation extends javax.swing.JFrame {

    /*
    initial method for GUI
    */
    public CreditCardAndISBNValidation() {
        initComponents();
        //clear up the text boxes and text area
        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea1.setText("");
        jLabel4.setText("");


    }
    
    //method: verifyISBNCode
    //parameters: String ISBNcode
    //Description: called when need to verify ISBN code
    public static boolean verifyISBNCode(String ISBNcode){
         //create array to store ISBN code
        int[] ISBNCodeList = new int[10];
        //boolean for verify if the ISBN code is valid or not
        boolean isValid = false;
        //replace all hyphen and white spaces with empty string
        ISBNcode = ISBNcode.replaceAll("\\-?","");
        ISBNcode = ISBNcode.replaceAll("\\s+","");
        //digit length
        int length = ISBNcode.length();
        //initial total value of weighted 10digits
        int total = 0;
        
        //check if the length equals to 10 digits or not
        if (length != 10)
        {
            isValid = false; 
        }
        else
        {
             try
                { 
                    for(int i=0;i<10;i++)
                    {
                        //parse string to integer and save it to the array
                        //if the string is not x at last digit
                        if (!String.valueOf(ISBNcode.charAt(i)).toLowerCase().equals("x"))
                        {
                            ISBNCodeList[i] = Integer.parseInt(String.valueOf(ISBNcode.charAt(i)));
                        }
                        else
                        {
                            //check if last digit equal to x or not
                            //change it to 10
                            ISBNCodeList[i] = 10;
                        }
                        if (i == 0)
                        {
                            //times 1 for the first integer 
                            total += ISBNCodeList[i];
                        }
                        else
                        {
                             //calculate total weighted by times it with position number
                             total += ISBNCodeList[i]*(i+1) ;    
                        }
                      
                    }
                    
                     //Checking the conditions of ISBN numbers
                     //total weighted mod by 11 need to be equal to 0
                     // or total weighted of 9 digits mod by 11 need to be equal to the last digit
                    if (total % 11 == 0 || (total-(10*ISBNCodeList[9]) % 11 == ISBNCodeList[9]))
                    {    
                        isValid = true;
                    }     
                }
                    
            //in case the input is empty or not integer 
            catch(Exception e)
                {
                     isValid = false; 
                }
        }
        
        //return validation value
        return isValid;
    }
    
    //method: verifyCreditCardNum
    //parameters: String cardNum
    //Description: called when need to verify creditcard number
    public static boolean verifyCreditCardNum(String cardNum){
        //boolean for verify if the credit card number is valid or not
        boolean isValid = false;
        //remove hyphens and white space
        cardNum = cardNum.replaceAll("\\-?","");
        cardNum = cardNum.replaceAll("\\s+","");
        //digit length
        int length = String.valueOf(cardNum).length();
        //create array to store the credit card number
        int[] cardNumList = new int[16];
        //initial total weighted
        int total = 0;

        //remove white spaces
        cardNum = cardNum.replaceAll("\\s+","");
        
        //check if the length is 16 digits or not 
        if (length != 16)
        {
            isValid = false;
        }
        else
        {
             try
                   { 
                       for(int i=1;i<16;i+=2)
                       {
                           //parse string to integer and save it to the list
                           cardNumList[i] = Integer.parseInt(String.valueOf(cardNum.charAt(i)));
                            //for every even position double it
                           cardNumList[i-1] = Integer.parseInt(String.valueOf(cardNum.charAt(i-1)))*2 ;
                            //if the value is greater than 10 minus it with 9
                               if (cardNumList[i-1] > 10)
                               {
                                   cardNumList[i-1] -= 9;
                               }
                           //calculate the total of all digit
                           total += (cardNumList[i]+cardNumList[i-1]);

                       }

                        //Checking the conditions of credit card number
                        //total value mod by 10 need to be equal to 0
                       if (total % 10 == 0 )
                       {    
                           isValid = true;
                       }     
                   }

             //in case input is empty or not integers
               catch(Exception e)
                   {
                        isValid = false; 
                   }
        }
     //return value of validation
     return isValid;
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jButton1.setText("Verify1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Verify2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Please enter ISBN code");

        jLabel2.setText("Please enter credit card number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("ISBN/Credit card VALIDATION");
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1))
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(clearButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel3)))
                        .addGap(0, 119, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(50, 50, 50)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    //method: verify1 button cilcked 
    //when verify ISBN button is clicked
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //call verify ISBN method
        boolean validation = verifyISBNCode(jTextField1.getText());
        //initail output message
        String outputMes;
        if (validation == true)
        {
            outputMes = "This ISBN code is valid";
            jLabel4.setText("VALID");
            jLabel4.setForeground(Color.GREEN);

        }
        else
        {
            outputMes = "This ISBN code is invalid";
             jLabel4.setText("INVALID");
             jLabel4.setForeground(Color.RED);
        }
        //set output message
        jTextArea1.setText(("\nInput ISBN code: "+jTextField1.getText()+"\n"+outputMes));
    }//GEN-LAST:event_jButton1MouseClicked
   
    //method: verify2 button cilcked 
    //when verify creditcard button is clicked
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //call verify credit card method
        boolean validation = verifyCreditCardNum(jTextField2.getText());
        //initail output message
        String outputMes;
        if (validation == true)
        {
            outputMes = "This credit card number is valid";
            jLabel4.setText("VALID");
            jLabel4.setForeground(Color.GREEN);
        }
        else
        {
            outputMes = "This credit card number is invalid";
            jLabel4.setText("INVALID");
            jLabel4.setForeground(Color.RED);
        }
        //set output message
        jTextArea1.setText("\nInput credit card: "+jTextField2.getText()+"\n"+outputMes);
    }//GEN-LAST:event_jButton2MouseClicked

    
    //method: clear button cilcked 
    //when clear all text 
    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        //clear all text
        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_clearButtonMouseClicked

    
    //main method
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreditCardAndISBNValidation jframe = new CreditCardAndISBNValidation();
                jframe.setVisible(true);
                //set app title
                jframe.setTitle("Validation App");
                jframe.setResizable(false);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
