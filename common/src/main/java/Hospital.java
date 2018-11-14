package edu.uconn.cse2102.project.common;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Hospital
{
    public static List<Hospital> load()
    {
        Reader reader = new BufferedReader(
            new InputStreamReader(
                    Hospital.class.getResourceAsStream("/HGI.csv")
            )
        );

        CsvToBean<Hospital> csvToBean = new CsvToBeanBuilder<Hospital>(reader)
            .withType(Hospital.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

        List<Hospital> hospitals = csvToBean.parse();
        return hospitals;
    }

    @CsvBindByName(column = "Provider Id", required = true)
    private String id;

    @CsvBindByName(column = "Hospital Name", required = true)
    private String name;
    
    @CsvBindByName(column = "State", required = true)
    private String state;
    
    
    
    @CsvBindByName(column = "Mortality national comparison", required=true)
    private String Mortality;
    
    @CsvBindByName(column = "Patient experience national comparison", required=true)
    private String Experience;
    
    @CsvBindByName(column = "Timeliness of care national comparison", required=true)
    private String Timeliness;
   
    // Getters
    public String getId()
    {
        return id;
    }
    
    public String getState(){
        return state;
    }
    
    public String getExperience(){
        return Experience;
    }
    public String getMortality(){
        return Mortality;
    }
    public String getTimeliness(){
        return Timeliness;
    }    
    public String getName()
    {
        return name;
    }
    

    // Setters
    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setState(String state){
        this.state = state;
    }
  
    public void setExperience(String Experience){
        this.Experience = Experience;
    }
    public void setMortality(String Mortality){
        this.Mortality = Mortality;
    }
    public void setTimeliness(String Timeliness){
        this.Timeliness = Timeliness;
    }
}
