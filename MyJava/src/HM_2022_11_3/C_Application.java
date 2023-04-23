package HM_2022_11_3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class C_Application {
    public static void main (String[] args){
        int[] startDate = new int[5];
        int[] endDate = new int[5];
        long year, month, day;
        for(int i = 0; i < 5; i++){
            startDate[i] = Integer.parseInt(args[i]);    //Get Start date form main args
        }
        for(int i = 5; i < 10; i++){
            endDate[i-5] = Integer.parseInt(args[i]);   //Get End date from main args
        }
        LocalDateTime dateStart = LocalDateTime.of(startDate[0],startDate[1],
                                                    startDate[2],startDate[3],startDate[4]);
        LocalDateTime dateEnd = LocalDateTime.of(endDate[0],endDate[1],endDate[2],
                                                                    endDate[3],endDate[4]);
        year = dateStart.until(dateEnd,ChronoUnit.YEARS);
        month = dateStart.until(dateEnd,ChronoUnit.MONTHS);
        day = dateStart.until(dateEnd,ChronoUnit.DAYS);
        System.out.println(args[0]+"-"+args[1]+"-"+args[2] + "  和 "+ args[5]+"-"+
                                                        args[6]+"-"+args[7] +"相差：");
        System.out.println(year + "年");
        System.out.println(month + "月");
        System.out.println(day + "日");
    }
}





