/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaplonoop;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class DataMgr {
    List<Citizen> citizens;
    
    private static DataMgr instance = null;
    
    private DataMgr() {
        citizens = new ArrayList<>();
    }
    
    public synchronized static DataMgr getInstance() {
        if(instance == null) {
            instance = new DataMgr();
        }
        return instance;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
