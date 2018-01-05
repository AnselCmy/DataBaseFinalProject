import com.db.project.dao.AttendLogDao;
import com.db.project.dao.EmployeeDao;
import com.db.project.entity.AttendLogEntity;
import com.db.project.entity.EmployeeEntity;

import java.sql.Date;
import java.util.List;
import java.util.Random;

public class Log {
    public static void main(String[] args) {      //本程序：向AttendLog表插入数据
        int month = 1, day = 1;
        String dateString;
        Random random = new Random();
        String aeNo;
        int randomInt;
        EmployeeDao dao = new EmployeeDao();
        AttendLogDao attendDao = new AttendLogDao();
        List<EmployeeEntity> list = dao.query();
        Date date = Date.valueOf("2017-1-1");
        System.out.println(date.toString());
        System.out.println(list.size());
        for(int days = 0; days < 365; days++) {
            dateString = "2017-";
            dateString += String.valueOf(month);
            dateString += '-';
            dateString += String.valueOf(day);
            for(int ee = 0; ee < list.size(); ee++) {
                randomInt = random.nextInt(90);
                if(randomInt == 0) {
                    aeNo = "0";
                    aeNo += String.valueOf(random.nextInt(6));
                    date = Date.valueOf(dateString);
//                    System.out.println(list.get(ee).geteNo() + " " +  date.toString() + " " + aeNo);  //验证数据
                    attendDao.add(new AttendLogEntity(list.get(ee).geteNo(), date, aeNo));  //向AttednLog添加记录
                }
            }
            day++;
            if((day == 29 && month == 2 ) ||
                    (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) ||
                    (day == 32 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
                    ) {
                month++;
                day = 1;
            }
        }
    }
}
