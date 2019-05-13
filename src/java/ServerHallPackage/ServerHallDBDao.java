package ServerHallPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
//import java.util.Date;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerHallDBDao {

    Properties p = new Properties();

    public ServerHallDBDao() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            p.load(new FileInputStream("C:\\Users\\andic\\OneDrive\\Dokument\\NetBeansProjects\\ServerHall\\src\\java\\ServerHallPackage\\settings.properties"));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerHallDBDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerHallDBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TempTable> getLatestTemperature() {

        List<TempTable> TempList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, temperature, date FROM serverhall.temperature ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int temperature = rs.getInt("temperature");
                Timestamp date = rs.getTimestamp("date");

                TempList.add(new TempTable(id, temperature, date));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TempList;
    }

    public List<EconsumptionTable> getLatestConsumption() {

        List<EconsumptionTable> EconsList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, econsumption, date FROM serverhall.econsumption ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int econsumption = rs.getInt("econsumption");
                Timestamp date = rs.getTimestamp("date");

                EconsList.add(new EconsumptionTable(id, econsumption, date));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return EconsList;
    }

    public List<EpriceTable> getEprice() {

        List<EpriceTable> EpriceList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, eprice, date FROM serverhall.eprice ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                int eprice = rs.getInt("eprice");
                Date date = rs.getDate("date");

                EpriceList.add(new EpriceTable(id, eprice, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EpriceList;

    }

    public void insertTemp(TempTable t) {

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO serverhall.temperature (temperature) VALUES (?)");

            stmt.setInt(1, t.getTemperature());

            int a = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEprice(EpriceTable t) {

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO serverhall.eprice (eprice) VALUES (?)");

            stmt.setInt(1, t.getEprice());

            int a = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AvgTemperature> RapportAvgMinMax() {

        List<AvgTemperature> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("select avg(temperature), max(temperature), min(temperature) from serverhall.temperature;");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int avgg = rs.getInt("avg(temperature)");
                int maxx = rs.getInt("max(temperature)");
                int minn = rs.getInt("min(temperature)");

                list.add(new AvgTemperature(avgg, maxx, minn));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<AvgEconsumption> RapportAvgEcons() {

        List<AvgEconsumption> econList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("select avg(econsumption), max(econsumption), min(econsumption), eprice.eprice from serverhall.econsumption, serverhall.eprice");
                    
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 
                 int avg = rs.getInt("avg(econsumption)");
                 int min = rs.getInt("min(econsumption)");
                 int max = rs.getInt("max(econsumption)");
                 int eprice = rs.getInt("eprice");
                 
                 econList.add(new AvgEconsumption(avg, min, max, eprice));
                         
             }
             
        } catch(Exception e){
            e.printStackTrace();
        }
        return econList;
    }

}
