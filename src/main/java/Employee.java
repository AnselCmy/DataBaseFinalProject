import com.db.project.dao.DepartmentDao;
import com.db.project.dao.EmployeeDao;
import com.db.project.entity.DepartmentEntity;
import com.db.project.entity.EmployeeEntity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Random;

public class Employee {
    public static void main(String[] args) {
        /* Employee表发生变化，该程序失效 */
//        try {
//            int[] countTable = {41, 50, 57, 49, 44, 39, 40, 34, 51, 33};   //存储每个数组的人数
//            int temp;
//            String[] sexTable = {"男", "女"};
//            String[] telTable = {"188", "152", "133", "181", "159", "138", "130", "131", "132", "182", "186"};
//            String eNo = "";
//            String eId = "";
//            String eName = "";
//            int eAge;
//            String eSex = "";
//            Date eEntryDate;
//            String date;
//            String dNo = "";
//            String posNo = "";
//            int count = 0;
//            int year;
//            File file = new File("/home/brunon/桌面/name.txt");
//            FileReader in = new FileReader(file);
//            int rd = in.read();
//            Random r = new Random();
//            while(rd != -1) {
//                if((char)rd == '、') {
//                    eNo = String.valueOf(r.nextInt(18)+2000) + "00";
//                    temp = r.nextInt(10);
//
//                    dNo = "00" + temp;
//
//                    eNo += String.valueOf(temp);
//                    if(countTable[temp] >= 10 && countTable[temp] <100) {
//                        eNo += "0";
//                    }
//                    else if(countTable[temp] >= 0 && countTable[temp] <10) {
//                        eNo += "00";
//                    }
//                    eNo += String.valueOf(countTable[temp]);
//                    countTable[temp]++;
//
//                    year = r.nextInt(36) + 1960;
//                    eId = String.valueOf(r.nextInt(900000) + 100000) + String.valueOf(year);
//                    temp = r.nextInt(12)+1;
//                    if(temp < 10) {
//                        eId += "0";
//                    }
//                    eId += String.valueOf(temp);
//                    temp = r.nextInt(30)+1;
//                    if(temp < 10) {
//                        eId += "0";
//                    }
//                    eId += String.valueOf(temp);
//                    temp = r.nextInt(10000);
//                    if(temp >= 0 && temp < 10) {
//                        eId += "000";
//                    }
//                    else if(temp >= 10 && temp < 100) {
//                        eId += "00";
//                    }
//                    else if(temp >= 100 && temp <1000) {
//                        eId += "0";
//                    }
//                    eId += String.valueOf(temp);
//
//                    eAge = 2018-year;
//
//                    eSex = sexTable[r.nextInt(2)];
//
//                    date = String.valueOf(r.nextInt(18) + 2000) + "-";
//                    temp = r.nextInt(12)+1;
//                    if(temp < 10) {
//                        date += "0";
//                    }
//                    date += String.valueOf(temp);
//                    date += "-";
//                    temp = r.nextInt(30)+1;
//                    if(temp < 10) {
//                        date += "0";
//                    }
//                    date += String.valueOf(temp);
//                    eEntryDate = Date.valueOf(date);
//                    posNo = String.valueOf(r.nextInt(6));
//
//                    EmployeeDao dao = new EmployeeDao();
//                    if(count >300)
//                        dao.add(new EmployeeEntity(eNo, eId, eName,  eAge, eSex, eEntryDate, dNo, posNo));
//                    else
//                        System.out.println(eNo + " " + eId +" " + eName + " " + eAge + " " + eSex + " "  + date + " " + dNo + " " + posNo);
//                    eName = "";
//                    count++;
//                    rd = in.read();
//                    continue;
//                }
//                eName += (char)rd;
//                rd = in.read();
//            }
//            System.out.println(count);
//        }
//        catch (IOException e) {
//            System.out.println(e.toString());
//        }
    }
}
