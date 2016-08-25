/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Vinicios
 */
public class GpxConverter {
    
    private ArrayList<String> fileToConvert = new ArrayList<String>();
    private ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
    private String header = "<gpx xmlns=\"http://www.topografix.com/GPX/1/1\"\n\t xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n\t xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\"\n\t version=\"1.1\"\n\t creator=\"GPX Converter\">";
    private String footer = "</gpx>";
    private String pathToSave;
    
    
    public GpxConverter(ArrayList<String> list,String pathToSave){
        list.remove(0);
        this.fileToConvert = list;
        this.pathToSave = pathToSave;        
        ArrayList<Waypoint> fileSplitted = splitFile(fileToConvert);
        ArrayList<String> file = mountGpxFile(fileSplitted);
        saveGpxFile(file);
    }
        
    private ArrayList<Waypoint> splitFile(ArrayList<String> fileToSplit){
        ArrayList<Waypoint> fileSplited = new ArrayList<Waypoint>();        
        for(int i=0;i<fileToSplit.size();i++){
            String[] parts = fileToSplit.get(i).split(",");
            Waypoint newWaypoint = new Waypoint();
            newWaypoint.setLatitude(parts[0]);
            newWaypoint.setLongitude(parts[1]);
            newWaypoint.setAltitude(parts[2]);
            newWaypoint.setName(parts[3]);
            fileSplited.add(newWaypoint);            
       }
       return fileSplited;       
    }
       
    private ArrayList<String> mountGpxFile(ArrayList<Waypoint> waypoints){
        ArrayList<String> file = new ArrayList<String>();
        file.add(header);        
        for(int i =0;i<waypoints.size();i++){
            file.add("<wpt lat=\""+waypoints.get(i).getLatitude()+"\" lon=\""+waypoints.get(i).getLongitude()+"\">\n\t<ele>"+waypoints.get(i).getAltitude()+"</ele>\n\t<name>"+waypoints.get(i).getName()+"</name>\n</wpt>");
        }
        file.add(footer);
        return file;
    }
    
    private void saveGpxFile(ArrayList<String> file){
        try{
            FileWriter fw = new FileWriter(this.pathToSave);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<file.size();i++){
                pw.println(file.get(i));
            }
            pw.close();
        }catch(Exception e){}
    }
    
}
