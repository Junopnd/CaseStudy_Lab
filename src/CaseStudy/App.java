package CaseStudy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class App extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
        setUndecorated(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 684, 515);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        
        
        JPanel panel = new JPanel();
        panel.setForeground(Color.BLACK);
        panel.setBackground(new Color(0, 139, 139));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setForeground(SystemColor.desktop);
        textField.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField.setBounds(314, 196, 321, 56);
        panel.add(textField);
        textField.setColumns(10);
        
        TextArea Result = new TextArea();
        Result.setFocusable(false);
        Result.setEditable(false);
        Result.setFont(new Font("Dialog", Font.BOLD, 20));
        Result.setBounds(28, 29, 607, 150);
        panel.add(Result);
        
        Button Semantic = new Button("Semantic");
        Semantic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String input=textField.getText();
                String result = "";
                                   
                System.out.println();
               
                
                if(input.startsWith("String")&&input.endsWith(";")) {        
                    
                    String[] string = input.split(" ");                        
                      
                    if(string.length >= 2&&input.contains("=")) {
                        
                        String val = input.substring(input.indexOf("=")).replaceAll("[=;]", "");
                                
                        String fullString = val.replaceAll("[^a-zA-Z0-9-\"]", "");                    
                        
                        if(fullString.startsWith("\"")&&val.endsWith("\"")||val.isBlank()) {
                            
                            result = "Semantically Correct!";
                                      
                        }else {
                            
                            result = "Semantically Incorrect!";
                            
                        }
              
                    }else {                      
                        
                        result = "Semantically Incorrect!";
                    }         
                    
                }else if(input.startsWith("int")&&input.endsWith(";")) {                   
                   
                    if(input.length()>=2&&input.contains("=")) {
                                                                 
                        String val = input.substring(input.indexOf("=")).replaceAll("[=;]", "");
                   
                        Scanner scan = new Scanner(val);
         
                   
                        if(scan.hasNextInt()) {
                        
                  
                            result = "Semantically Correct!";
                   
              
                        }else {
                        
                
                            result = "Semantically Incorrect!";
                
                        }         
                
                    }else if(!input.contains("=")) {
                        
                        result = "Semantically Correct!";
                        
                    }else {
                        
                        result = "Semantically Incorrect!";
                        
                    }
                }else if(input.contains("double")&&input.endsWith(";")) {
                    
                    if(input.length()>=2&&input.contains("=")) {
                        
                        String val = input.substring(input.indexOf("=")).replaceAll("[=;]", "");
                   
                        Scanner scan = new Scanner(val);      
                   
                        if(scan.hasNextDouble()) {
                        
                  
                            result = "Semantically Correct!";
                   
              
                        }else {
                        
                
                            result = "Semantically Incorrect!";
                
                        }         
                
                    }else if(!input.contains("=")) {
                        
                        result = "Semantically Correct!";
                        
                    }else {
                        
                        result = "Semantically Incorrect!";
                        
                    }
                }else if(input.contains("char")&&input.endsWith(";")) {
                       
                    String[] text = input.split(" ");
                            
                    if(text.length > 1) {
                        
                        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                        
                        String ch = text[1].replaceAll("[;]", "");   
                        
                        if(!checker(ch, numbers) == true && ch.length()==1) {
                            
                            result = "Semantically Correct!";
                            
                        }else {
                            
                            result = "Semantically Incorrect!";
                        }
                        
                    }else{
                        
                        result = "Semantically Incorrect!";
                                        
                    }
                        
               }else{
                   
                   result = "Semantically Incorrect!";
                             
               }
                
                Result.setText(result);
                
                Semantic.setEnabled(false);
                   
            }    
            
            public boolean checker(String value, String[] numbers) {
                
                boolean found = false;
                
                for(int i =0; i<numbers.length;i++) {       
                    
                    if(value.contains(numbers[i])) {
                        
                        found = true;
                        
                        break;
                        } 
                    
                }
                
                return found;
        }
                
            
        });
        Semantic.setForeground(Color.BLACK);
        Semantic.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Semantic.setEnabled(false);
        Semantic.setBackground(new Color(255, 165, 0));
        Semantic.setBounds(363, 419, 233, 56);
        panel.add(Semantic);
        
        Button Syntax = new Button("Syntax");
        Syntax.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    
                
                String syntax = "<data_type><identifier><assignment_operator><value><delimeter>";
                
                String tokens = Result.getText();
                
                
                String check = tokens.replaceAll("\\s", "").toLowerCase();
                
                if(check.equals(syntax)||check.equals("<data_type><identifier><delimeter>")) {
                    
                    Result.setText("Syntax is Correct!");
                    Syntax.setEnabled(false);
                    Semantic.setEnabled(true);
                    
                }else {
                    
                    Result.setText("Syntax is Error!");
                    Syntax.setEnabled(false);
                }
                
            }
        });
        Syntax.setForeground(Color.BLACK);
        Syntax.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Syntax.setEnabled(false);
        Syntax.setBackground(new Color(255, 165, 0));
        Syntax.setBounds(363, 352, 233, 56);
        panel.add(Syntax);
        
        Button Lexical = new Button("Lexical");
        Lexical.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                                                    
                    String output = textField.getText(); 
                    
                    String result = "";
                   
                    int count=0;     
                    int count2=0;   
                    int size=output.length(); 
                    
                    String[] ch = output.split(" ");        
                            
                    for(int x=0;size>x;x++) {                                                                                    
                            
                         if(count2==2) {
                             
                             String value = output.substring(output.indexOf("="));
                             
                             String val = value.replaceAll("[^a-zA-Z0-9]", "");                                                                            
                             
                             if(!val.isBlank()) {
                                 
                                 result+=("<value>");             
                                 count2 = -1;
                                
                                 if(value.endsWith(";")) {
                                    
                                    result+=("<delimeter>");
                                    count2 = -1;
                                   
                                 }else {
                                     
                                 }
                      
                             }else if(val.isBlank()&&value.endsWith(";")) {
                                 
                                 result+="<delimeter>";
                                 count2=-1;
                              
                            }
                             
                        }else if(ch.length>1&&count==1) {
                                 
                            result+=valueChecker(ch[1]);
                            count2=1;
                            count =-1;
                            
                        }else if(count2==1) {  
                                                                        
          
                            if(ch.length >= 2){                          
                                     
                                if(ch[1].contains("=")) {
                                    
                                    result+=("<assignment_operator>");
                                    count2 = 2;
                                    
                                }else if(ch[1].endsWith(";")){
                                    
                                    result+="<delimeter>";
                                    
                                    count2=-1;
                                  
                          
                                }else if(output.contains("=")&&ch.length > 2){                                 
              
                                    result+=("<assignment_operator>");
                                    count2 = 2;                                
                                    
                                }else if(output.contains(";")&&ch.length > 2) {
                                    
                                    result+="<delimeter>";
                                    count2=-1;
                                
                                    
                                }else {
                                    
                                    count2=-1;
                               
                                    
                                }
                                
                                }
                                                                     
                
                        }else if(output.startsWith("String")&&count==0||(output.startsWith("int")&&count==0||
                                (output.startsWith("double")&&count==0||(output.startsWith("char")&&count==0)))) {  
                                                                              
                                if(output.length()>0) {
                             
                                    result+=("<data_type>");
                                    count=1;
                                    
                                    
                                }else{
                                    
                                    result+=("<data_type>");
                                    
                                    if(output.endsWith(";")) {
                                        
                                        result+=("<delimeter>");
                                        
                                    }else {
                                        
                                    }
                                              
                                }    
                        }     
                    }
      
                        Result.setText(result);
                        Lexical.setEnabled(false);
                        Syntax.setEnabled(true);
                                
            }public String valueChecker(String str) {   
                                         
                String result ="";             
                String num = str.replaceAll("[^0-9]", "");
                              
                
                if(str.contains("=")||str.contains(";")||str.contains(num)) {
                    
                    if(str.startsWith("=")) {
                                              
                        result = "<assignment_operator>"; 
                                       
                    }else if(str.startsWith(";")) {
                        
                        result = "<delimeter>";
                        
                    }else if(str.equals(num)){
                        
                        result ="<value>";           
                        
                    }else {
                                        
                        result ="<identifier>";
                    }
                    
                }else {
                    
                    result ="<identifier>";
                    
                }
                return result;
                       
            }@SuppressWarnings("unused")
            public int count(String str) {

                   int count=0;

                   boolean word=false;
                   int endOfLine=str.length()-1;
                   char[] ch=str.toCharArray();

                   for (int i=0;i<ch.length;i++) {
                       
                      if(Character.isLetter(ch[i]) && i != endOfLine) {
                         
                         word = true;

                     }else if(!Character.isLetter(ch[i]) && word) {
                         
                         count++;
                         word = false;

                     }else if(Character.isLetter(ch[i]) && i == endOfLine) {
                         
                         count++;          
                     }
                     
                   }

                   return count;
            }
        } 
        
        );
      
        Lexical.setBackground(new Color(255, 165, 0));
        Lexical.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Lexical.setForeground(SystemColor.desktop);
        Lexical.setBounds(363, 285, 233, 56);
        panel.add(Lexical); 
        Lexical.setEnabled(false);
        
        Button select = new Button("Select File");
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource()==select) {    
 
                    JFileChooser file_upload = new JFileChooser();
                    
                    int file = file_upload.showOpenDialog(null);
                    
                    if(file ==JFileChooser.APPROVE_OPTION) {

                        File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
           
                        try {
                            
                            Scanner scan = new Scanner(new FileReader(file_path));
                     
                            if(scan.hasNext()) {
                                
                                String selectedFile = new String();
                                selectedFile = scan.nextLine();                      
                                
                                textField.setText(selectedFile);
                                                              
                                Lexical.setEnabled(true);
                                                                             
                            }else {
                                
                                Lexical.setEnabled(false);
                                
                            }
                            
                        } catch (FileNotFoundException e1) {
                           
                            e1.printStackTrace();
                        }
                 
                    }
                               
                }
                
            }
        });
        select.setForeground(new Color(0, 0, 0));
        select.setFont(new Font("Tahoma", Font.PLAIN, 25));
        select.setEnabled(true);
        select.setBackground(new Color(255, 165, 0));
        select.setBounds(28, 196, 233, 56);
        panel.add(select);
        
        Button Exit = new Button("Exit");
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
                
            }
        });
        Exit.setForeground(Color.BLACK);
        Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
        Exit.setEnabled(true);
        Exit.setBackground(new Color(255, 165, 0));
        Exit.setBounds(28, 437, 120, 37);
        panel.add(Exit);

        
    }
}
