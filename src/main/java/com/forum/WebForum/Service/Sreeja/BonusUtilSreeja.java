package com.forum.WebForum.Service.Sreeja;




import com.forum.WebForum.model.DistributorDataNovus;
import com.forum.WebForum.model.OrderNovus;
import com.forum.WebForum.model.PercentagePropsNovus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

public class BonusUtilSreeja {
    public static Map<String, Integer> propertyMap = new HashMap<>();
    public static Map<Long, DistributorDataNovus> distMap = new HashMap<Long, DistributorDataNovus>();
    public static List<OrderNovus> orderlist = new ArrayList<>();


    public static PercentagePropsNovus writingProperties(PercentagePropsNovus application) {
        Properties p = new Properties();
        try {

            OutputStream output = new FileOutputStream("NovusProperies.properties");

            String type = "sponser.";
            p.setProperty(type.concat("1"), application.getLev1());
            p.setProperty(type.concat("2"), application.getLev2());
            p.setProperty(type.concat("3"), application.getLev3());
            p.setProperty(type.concat("4"), application.getLev4());
            p.setProperty(type.concat("5"), application.getLev5());
            p.store(output, null);
            retrivProperties();
        } catch (Exception e) {
            e.getMessage();
        }
        return application;
    }


    public static Map<String, Integer> retrivProperties() {
        BonusUtilSreeja.propertyMap.clear();
        try {
            Properties p = new Properties();
            System.out.println("Entered in Retriving properties file");
            FileInputStream input = new FileInputStream("NovusProperies.properties");
            p.load(input);
            Enumeration keys = p.propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                BonusUtilSreeja.propertyMap.put(key, Integer.parseInt(p.getProperty(key)));
            }
            input.close();
            return BonusUtilSreeja.propertyMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BonusUtilSreeja.propertyMap;
    }

    public static DistributorDataNovus getDistDetails(Long id) {
        return BonusUtilSreeja.distMap.get(BonusUtilSreeja.distMap.get(id).getSponserId());
    }
}
