package edu.uconn.cse2102.project.role1;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
import edu.uconn.cse2102.project.common.Hospital;
import edu.uconn.cse2102.project.common.Comments;


import com.opencsv.CSVWriter;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

//import edu.uconn.cse2102.project.role1.Hospital;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Main extends JFrame implements ActionListener
{
        //Initializers citizen objects
        String citizen;
        String citizen_ss;
        String citizen_comment;
        ArrayList<String> citizendata = new ArrayList<String>(4);
        ArrayList<JFrame> frames = new ArrayList<JFrame>(4);
        
        
       
        
        //JLabels
        JLabel Title = new JLabel("Hospital General System");
        JLabel FullName_l = new JLabel("Enter your name");
        JLabel Social_Security_l = new JLabel("Enter your Social Security Number");
        
        JLabel title_c = new JLabel("Make a comment");
        JLabel title_thanks = new JLabel("Thank you for participating! You can exit this window ");
      
        //User fields
        JTextField FullName = new JTextField(50);
        JTextField Social_Security = new JTextField(50);
        JTextArea textbox_c = new JTextArea(10,10);
     
        //Legislator fields
        JLabel Welcome_back = new JLabel("Welcome back legislator!");
        JPasswordField keycode = new JPasswordField(50);
        
        //Frames
        JFrame frame = new JFrame("Hospital General System ");
        JFrame frame2 = new JFrame("(HGI ADMIN) Welcome Back legislator! ");
      
        JFrame frame3 = new JFrame("Comment Section");
        JFrame frame4 = new JFrame("Make a comment");
        JFrame frame5 = new JFrame("Thank you page");
        
        
        
        JFrame frame6 = new JFrame("Survey Data from the Public");
        JFrame frame8 = new JFrame("About HGS");
        JFrame frame9 = new JFrame("Edit Profile");
        JFrame frame10 = new JFrame("Change Password");
        
        
        
        
        //Survey frame
        JFrame frame7 = new JFrame("Taking the survey");
        
 
       //List of all Panels 
        JPanel panel = new JPanel(new GridBagLayout());
        JPanel panel_l = new JPanel(new GridBagLayout());
        JPanel panel_comment = new JPanel(new GridBagLayout());
        JPanel panel_make_comment = new JPanel(new GridBagLayout());
        JPanel nav_container = new JPanel(new GridBagLayout());
        JPanel container_l = new  JPanel (new GridBagLayout());
        JPanel survey_panel = new JPanel(new GridBagLayout());

        JPanel panel_thank_you = new JPanel();
        JPanel panel_survey_ = new JPanel();
        
        //Buttons
        JButton Submit = new JButton("Confirm");
        JButton Submit_l = new JButton("Confirm");
        JButton Submit_make_comment = new JButton("Confirm");
        JButton Submit_survey = new JButton("Submit");
        
        JButton Submit_legislator = new JButton("Are you a legislator");
        JButton back_btn = new JButton("Back");
        
        //Buttons for the Legislator 
        JButton Comment_Section_btn = new JButton("Comments");
        JButton Logout = new JButton("Logout");
        
        JTextArea data = new JTextArea(512,512);
        JTextArea comment_data = new JTextArea(512,512);
        
        
        //Menu Properties
       JMenuBar menuBar = new JMenuBar();
       JMenu menu = new JMenu("HGI");
       JMenu Comment_menu = new JMenu("Comments");
       JMenu Profile_menu = new JMenu("Profile");
       
       
       JMenuItem Loggout = new JMenuItem("Logout"); 
       JMenuItem comments = new JMenuItem("Comments");
       JMenuItem About = new JMenuItem("About");
       JMenuItem Home = new JMenuItem("Home");
       
       JMenuItem change_pass = new JMenuItem("Password Change");
       JMenuItem Edit_profile = new JMenuItem("Edit Profile");
       
       
       //Getting the time now 
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
       LocalDateTime now = LocalDateTime.now();  
       
       public String String_Array_Sample = "../common/build/resources/main/comments.csv";
          

 //Methods      
//Getting the basic information. 
public void user_start(){
        frame.setSize(1024, 1024);
        frame.setBackground(Color.GRAY);
      
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        //Grid on the panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);
        
        //add components to the panel 
        
        //adding in the title 
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(Title, constraints);
        
        //adding in the fullName
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(FullName_l, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(FullName, constraints);
        
        //adding in the social security
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(Social_Security_l, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(Social_Security, constraints);
        
        //adding in the button
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(Submit, constraints);
        
        //adding in the button
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(Submit_legislator, constraints);
        Submit_legislator.addActionListener(this);
        
        add(panel);
        pack();
        setLocationRelativeTo(null);
        
       
        panel.setBackground(Color.GRAY);
        panel.setSize(1024, 1024);
        
        Submit.addActionListener(this);
        frame.add(panel);      
      } 
//Frame legislator 
public void legislator_start(){
      Font font = new Font("Times New Roman", Font.BOLD, 36);
      Welcome_back.setFont(font);
                
        
     Welcome_back.setForeground(Color.BLACK);
        
    
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.anchor = GridBagConstraints.WEST;
      constraints.insets = new Insets(10,10,10,10);
      
      //adding in components 
      constraints.gridx = 0;
      constraints.gridy = 0;
      panel_l.add(Welcome_back, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 1;
      panel_l.add(keycode, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 2;
      panel_l.add(Submit_l, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 3;
      panel_l.add(back_btn, constraints);
      Submit_l.addActionListener(this);
      back_btn.addActionListener(this);
      
      add(panel_l);
      setLocationRelativeTo(null);
      pack();
      
      
      frame2.add(panel_l);
      
      
      frame2.setBackground(Color.DARK_GRAY);
      frame2.setSize(1024, 512);
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame2.setVisible(true);
      
      
      }
//User can make a comment 
public void make_comment_section() {
    
    frame4.setSize(1024, 1024);
    frame4.setVisible(true);
    frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
         
          
    GridBagConstraints constraints = new GridBagConstraints();
    
    constraints.anchor = GridBagConstraints.WEST;
    constraints.insets = new Insets(10,10,10,10);
    
    //adding in components
    constraints.gridx = 0;
    constraints.gridy = 0;
    panel_make_comment.add(title_c, constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 1;
    panel_make_comment.add(textbox_c, constraints);
    
   
    constraints.gridx = 0;
    constraints.gridy = 2;
    panel_make_comment.add(Submit_make_comment, constraints);
    
  
    
    add(panel_make_comment);
    
    setLocationRelativeTo(null);
    Submit_make_comment.addActionListener(this);
    
    
    frame4.add(panel_make_comment);
      
   
    }

public void write(){

       
            List<Comments> csvComments = new ArrayList<Comments>();
            System.out.print(csvComments);
            citizen_comment = textbox_c.getText();
            
            try (
                Writer writer = Files.newBufferedWriter(Paths.get(String_Array_Sample));
                
                CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
                ){
                String COMMA_DELIMITER = ",";
            
            String NEW_LINE_SEPARATOR = "\n";
            String[] FILE_HEADER = {"ID","Full_Name","SS","Comment","Time"};
            csvWriter.writeNext(FILE_HEADER);
            csvWriter.writeNext(new String[]{"test2","test2","test2","test2","test2"});
            
            
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
    
           
            
            System.out.println("Done");

}         
//Button actions Performed 
public void actionPerformed(ActionEvent e){
    
          if(e.getSource() == Submit_l){
           System.out.print("Pressed");
          char[] legislator_password = keycode.getPassword();
          char[] c_pass = {'1','2','3','4'};
          
          
          if(Arrays.equals(legislator_password,c_pass))
          {
              RunSurveydata_();
              frames.add(frame3);
              frames.add(frame8);
              frames.add(frame9);
              frames.add(frame10);
              
              frame2.setVisible(false);       
          }else{
              System.out.print("Fail!");     
          }
          }
          if(e.getSource() == back_btn){
              frame2.setVisible(false);
              user_start();       
          }
          if(e.getSource() == Submit){
              citizen = FullName.getText();
              citizen_ss = Social_Security.getText();
                
              System.out.print("Success!");
             
              make_comment_section();
              
              frame.setVisible(false);
          }
          if(e.getSource() == Submit_make_comment){   
          System.out.print("Success");
          
          thank_you_page();
          write();
          frame4.setVisible(false);
          }
          
          if(e.getSource() == Loggout){
          
          frame6.setVisible(false);
          legislator_start();
          }
          if(e.getSource() == comments){
          start_comment_section();
          frame6.setVisible(false);
          
          }
          if(e.getSource() == Submit_legislator){
              legislator_start();
              frame.setVisible(false);

          }
          if(e.getSource() == About){
              about_page();
              frame6.setVisible(false);
          }
          if(e.getSource() == change_pass){
              change_password_page();
              frame6.setVisible(false);
          
          }
          if(e.getSource() == Edit_profile){
              edit_profile();
              frame6.setVisible(false);
              
          }
          if(e.getSource() == Home){
              legislator_start();
              
              
          }
          
      }
//List of comments 
public JPanel listofComments(){
    List<Comments> csvComments = Comments.load();
    System.out.print(csvComments);
    
    for(Comments comm: csvComments){
       
        JLabel id = new JLabel("Id: " + comm.getId() +  "\n");
        comment_data.append("Id: "  + comm.getId() +  "\n"); 
        survey_panel.add(id);
        System.out.print("Id: "  +  comm.getId() + "\n");
        
        //comment_panel.add(id);
        JLabel name = new JLabel("Full Name: " + comm.getFull_Name() +  "\n");
        comment_data.append("Full_Name: "  + comm.getFull_Name() +  "\n");
        survey_panel.add(name);
        System.out.print("Full_Name: " +  comm.getFull_Name() + "\n");
        
       // comment_panel.add(name);
        JLabel s_s = new JLabel("SS: " + comm.getSS() +  "\n");
        comment_data.append("SS: "  + comm.getSS() +  "\n");
        System.out.print("SS:" + comm.getSS() + "\n" );
        survey_panel.add(s_s);
        
        JLabel comment = new JLabel("Comment: " + comm.getComment() +  "\n");
        comment_data.append("Comment: "  + comm.getComment() +  "\n");
        System.out.print("Comment:" + comm.getComment() + "\n" );
        survey_panel.add(comment);
        //comment_panel.add(comment);
        
        JLabel time = new JLabel("Time: " + comm.getTime() +  "\n");
        comment_data.append("Time: "  + comm.getTime() +  "\n");
        System.out.print("Time:" + comm.getTime() + "\n" );
        survey_panel.add(time);
        
        JLabel newLine = new JLabel("\n" + "=================" + "\n");
        comment_data.append("\n" + "=================" + "\n");
       // comment_panel.add(time);
        
        
            System.out.println("\n" + "=================" + "\n");
           
                }
return survey_panel;
    
    

}
public JPanel ListOfData(){
  
        JPanel Hospital_data = new JPanel();
        
        List<Hospital> csvHospitals = Hospital.load();

        for (Hospital hosp: csvHospitals)
        {
            JLabel id = new JLabel("Id: " +  "\n" + hosp.getId());
            Hospital_data.add(id);
            data.append("Id: "  + hosp.getId() +  "\n");
            System.out.println("Id: " + hosp.getId());
            
            JLabel name = new JLabel("Name: \n" + hosp.getName());
            Hospital_data.add(name);
            data.append("Name: "  + hosp.getName() +  "\n");
            System.out.println("Name: " + hosp.getName());
           
            /*JLabel County = new JLabel("County: " + hosp.getCounty());
            Hospital_data.add(County);
            System.out.println("County: " + hosp.getCounty());*/
            
            JLabel Experience = new JLabel("Experience:  "+  hosp.getExperience() +  "\n");
            Hospital_data.add(Experience);
            data.append("Experience:  " +  hosp.getExperience() +  "\n");
            System.out.println("Experience: " + hosp.getExperience());
            
                
            
            JLabel Mortality = new JLabel("Mortality: " + hosp.getMortality());
            Hospital_data.add(Mortality);
            data.append("Mortality: " + hosp.getMortality() +  "\n");
            System.out.println("Mortality: " + hosp.getMortality());
            
            JLabel Timeliness = new JLabel("Timelines:" + hosp.getTimeliness());
            Hospital_data.add(Timeliness);
            data.append("Timeliness: "  +  hosp.getTimeliness() +  "\n");
            System.out.println("Timeliness: " + hosp.getTimeliness());
            
            JLabel newLine = new JLabel("=================" );
            Hospital_data.add(newLine);
            data.append("\n" + "================="+ "\n");
            System.out.println("=================");
        }
        
    return Hospital_data;
}
private void start_comment_section() {
        frame3.setJMenuBar(menuBar);
        JPanel panel_c =  listofComments();
         JScrollPane pane = new JScrollPane(panel_c,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        frame3.add(comment_data); 
        
        frame3.setSize(1024, 1024);
        frame3.setVisible(true);
       
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }

//Thank you page 
private void thank_you_page()   {
         

  
        //To change body of generated methods, choose Tools | Templates.
       frame5.setSize(1024, 1024);
       frame5.setBackground(Color.black);
       panel_thank_you.add(title_thanks);
       frame5.add(panel_thank_you);
       
       frame5.setVisible(true);
       frame5.setDefaultCloseOperation(EXIT_ON_CLOSE);
       citizendata.add(citizen);
       citizendata.add(citizen_ss);
       citizendata.add(textbox_c.getText());
       citizendata.add("test");
       System.out.print(citizendata);

    }


//Run Survey Data, running to get all the input from the CVS This brings to the menu of the homescreen
private void RunSurveydata_(){
    //Menu 
       About.addActionListener(this);
       comments.addActionListener(this);
       Loggout.addActionListener(this);
       Edit_profile.addActionListener(this);
       change_pass.addActionListener(this);
       Home.addActionListener(this);
       
      
       
       menuBar.add(menu);
       menuBar.add(Profile_menu);
       menuBar.add(Comment_menu);
       
     
       menu.add(Home);
      //I have to fix the frames.
       for(int i = 0; i <= frames.size(); i++){
           
       
       }
       Comment_menu.add(comments);
       Profile_menu.add(Edit_profile);
       Profile_menu.add(change_pass);
       
       menu.add(About);
       menu.add(Loggout);
       
       
       
       
       frame6.setJMenuBar(menuBar);
       
       
       
       
       
       

    //We are going to customize the homepage 
    panel_survey_= ListOfData();
    JPanel Main = new JPanel();
    Main.setSize(1024, 1024);
    
    // frame6.add(legislator_customization_home_page());
    JScrollPane pane = new JScrollPane(data,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    frame6.add(pane);
    frame6.setSize(1024, 1024);
    frame6.setBackground(Color.white);
    frame6.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame6.setVisible(true);
    
    frame6.setLocationRelativeTo(null);
    }
//About page 
public void about_page(){
    frame8.setJMenuBar(menuBar);
    
    frame8.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame8.setSize(1024,1024);
    frame8.setVisible(true);
}
//edit page 
public void edit_profile(){
    frame9.setJMenuBar(menuBar);
    
    frame9.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame9.setSize(1024,1024);
    frame9.setVisible(true);
}
//password change
public void change_password_page(){
    frame10.setJMenuBar(menuBar);
   
    frame10.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame10.setSize(1024,1024);
    frame10.setVisible(true);
}


public void TestCase(String Comment, String URL, String Data,  String User_Data,String Fields){
    int counter = 5;
    switch(counter) {
        case 1:
            if (Comment.length() > 150 ){
                System.out.print("Failure" + counter + "Check your system");
            
            }
        System.out.print("Case 1: Success");
        case 2:
            if(String_Array_Sample.isEmpty()){
                System.out.print("Failure" + counter + "Check your system");
            
            }
       System.out.print("Case 2: Success");
        case 3:
            if(Data.isEmpty()){
                System.out.print("Failure" + counter + "Check your system");
            
            }
        System.out.print("Case 3: Success");    
        case 4:
            if(User_Data.isEmpty()){
                System.out.print("Failure" + counter + "Check your system");
            
            }
        System.out.print("Case 4: Success");   
        case 5:
            if (Fields.isEmpty()){
                System.out.print("Failure" + counter + "Check your system");
            
            }
        System.out.print("Case 5: Success");   
        default:
            System.out.print("All success!");
            
    
    }
    
    
    System.out.print("Failure" + counter + "Check your system");
    
}




    public static void main(String[] args)
    {
        
     Main test = new Main();
     test.legislator_start();
    // test.user_start();
     //test.start_comment_section();
    }


}

