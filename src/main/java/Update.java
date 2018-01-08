import com.db.project.dao.EmployeeDao;
import com.db.project.entity.EmployeeEntity;

import java.util.List;
import java.util.Random;

public class Update {
    public static void main(String[] args) {        //更新Employee电话号码信息
//        String[] telTable = {"188", "152", "133", "181", "158", "138", "130", "131", "132", "182", "186", "187"};
//        String tel = "";
        Random random = new Random();
//        EmployeeDao dao = new EmployeeDao();
//        List<EmployeeEntity> list = dao.query();
//        for(int i=444; i<list.size(); i++) {
//            tel = telTable[random.nextInt(12)];
//            for(int j=0; j<8; j++)
//                tel += String.valueOf(random.nextInt(10));
//            System.out.println(tel);
//            list.get(i).seteTel(tel);
//            dao.update(list.get(i));
//        }


//        String birth;                           //更新Employee出生年月日信息
//        EmployeeDao dao = new EmployeeDao();
//        List<EmployeeEntity> list = dao.query();
//        for(int i=435; i<list.size(); i++) {
//            birth = "";
//            for(int j=6; j<14; j++) {
//                birth += list.get(i).geteId().charAt(j);
//                if(j == 9 || j == 11)
//                    birth += '-';
//            }
//            Date d = Date.valueOf(birth);
//            list.get(i).seteBirth(d);
//            dao.update(list.get(i));
//        }

        EmployeeDao dao = new EmployeeDao();      //更新Employee入职时间信息，范围发生变化：2000~2017 改为 2000~2016
        String date, temp;
        List<EmployeeEntity> list = dao.opeation(EmployeeDao.Opeation.Query);
        System.out.println(list.get(0).geteName());
        for(int i=0; i<list.size(); i++) {
            date = list.get(i).geteEntryDate().toString();
            if(date.charAt(2) == '1' && date.charAt(3) == '7') {
                temp = date;
                date = "";
                for(int j=0; j<3; j++) {
                    date += temp.charAt(j);
                }
                date += String.valueOf(random.nextInt(7));
                for(int j=4; j<temp.length(); j++) {
                    date += temp.charAt(j);
                }
                System.out.println(date);
//                Date d = Date.valueOf(date);
//                list.get(i).seteEntryDate(d);
//                dao.update(list.get(i));
            }
        }
    }
}
