package com.example.schoolmanagement_01.core;

import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConstants {

      /**
       * classRoomDTOS
       */
    public  static final  ArrayList<ClassRoomDTO> classRoomDTOS = new ArrayList<ClassRoomDTO>(){{
          add(new ClassRoomDTO(1,"0601","6/1")) ;
          add(new ClassRoomDTO(2,"0602","6/2")) ;
          add(new ClassRoomDTO(3,"0603","6/3")) ;
          add(new ClassRoomDTO(4,"0604","6/4")) ;
          add(new ClassRoomDTO(6,"0701","7/1")) ;
          add(new ClassRoomDTO(7,"0702","7/2")) ;
          add(new ClassRoomDTO(8,"0703","7/3")) ;
          add(new ClassRoomDTO(9,"0704","7/4")) ;
          add(new ClassRoomDTO(9,"0801","8/1")) ;
          add(new ClassRoomDTO(9,"0802","8/2")) ;
          add(new ClassRoomDTO(9,"0803","8/3")) ;
          add(new ClassRoomDTO(9,"0804","8/4")) ;
          add(new ClassRoomDTO(9,"0901","9/1")) ;
          add(new ClassRoomDTO(9,"0902","9/2")) ;
          add(new ClassRoomDTO(9,"0903","9/3")) ;
          add(new ClassRoomDTO(9,"0904","9/4")) ;
    }};
      public  static final  ArrayList<String> listClassRoom = new ArrayList<String>(){{
            for (ClassRoomDTO classRoomDTO : classRoomDTOS){
                  add(classRoomDTO.getClassName());
            }
      }};

      public static final List<String> listClassSang = new ArrayList<String>(){{
            add("6/1");
            add("6/2");
            add("6/3");
            add("6/4");
            add("9/1");
            add("9/2");
            add("9/3");
            add("9/4");
      }};
      public static final List<String> listClassChieu = new ArrayList<String>(){{
            add("7/1");
            add("7/2");
            add("7/3");
            add("7/4");
            add("8/1");
            add("8/2");
            add("8/3");
            add("8/4");
      }};
      /**
       * listRuleDTO
       */
    public  static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>(){{
          add(new RuleDTO(1,0,"Chuy??n c???n",2));
          add(new RuleDTO(2,1,"Ngh?? h???c kh??ng ph??p",-2));
          add(new RuleDTO(3,1,"??i tr??? ho???c ngh?? h???c c?? ph??p",-1));

          add(new RuleDTO(4,0,"H???c t???p",4));
          add(new RuleDTO(5,4,"Kh??ng thu???c b??i",-2));
          add(new RuleDTO(6,4,"Kh??ng chu???n b??? b??i ?????y ?????",-2));
          add(new RuleDTO(7,4,"Truy gi??? ?????u b??i b??? ra kh???i l???p",-2));

          add(new RuleDTO(8,0,"K??? lu???t",5));
          add(new RuleDTO(9,8,"Kh??ng x???p h??ng",-2));
          add(new RuleDTO(10,8,"Kh??ng v??n ngh???",-2));
          add(new RuleDTO(11,8,"Ch???y xe trong s??n tr?????ng",-2));
          add(new RuleDTO(12,8,"G??y g??? ????nh nhau",-5));
          add(new RuleDTO(13,8,"V?? l??? v???i th???y c??, ng?????i l???n",-5));
          add(new RuleDTO(14,8,"L???p ???n, m???t tr???t t???",-5));
          add(new RuleDTO(15,8,"N??i t???c ch???i th???",-2));

          add(new RuleDTO(16,0,"V??? sinh",5));
          add(new RuleDTO(17,16,"Kh??ng v??? sinh l???p",-5));
          add(new RuleDTO(18,16,"Kh??ng tham gia lao ?????ng",-2));

    }};

      /**
       * listWeek
       */
    public static final List<String> listWeek = new ArrayList<String>(){{
          add("1");
          add("2");
          add("3");
          add("4");
          add("5");
          add("6");
          add("7");
          add("8");
          add("9");
          add("10");
          add("11");
          add("12");
          add("13");
          add("14");
          add("15");
          add("16");
          add("17");
          add("18");
          add("19");
          add("20");
          add("21");
          add("22");
          add("23");
          add("24");
          add("25");
          add("26");
    }};
      public static final Map<Integer, CalculatorMinusMap> calculatorMinusMap = new HashMap<Integer, CalculatorMinusMap>(){{
            put(2,new CalculatorMinusMap(-2,1));
            put(3,new CalculatorMinusMap(-1,1));

            put(5,new CalculatorMinusMap(-2,4));
            put(6,new CalculatorMinusMap(-2,4));
            put(7,new CalculatorMinusMap(-2,4));

            put(9,new CalculatorMinusMap(-2,8));
            put(10,new CalculatorMinusMap(-2,8));
            put(11,new CalculatorMinusMap(-2,8));
            put(12,new CalculatorMinusMap(-5,8));
            put(13,new CalculatorMinusMap(-5,8));
            put(14,new CalculatorMinusMap(-5,8));
            put(15,new CalculatorMinusMap(-2,8));

            put(17,new CalculatorMinusMap(-5,16));
            put(18,new CalculatorMinusMap(-2,16));
      }};

      public static final List<String> listSession = new ArrayList<String>(){{
            add("S??ng");
            add("Chi???u");
      }};










//      public  static final  ArrayList<String> classRoomName = new ArrayList<String>(){{
//            "6/1"
//            ,"6/2"
//            ,"6/3"
//            ,"6/4"
//            ,"7/1"
//            ,"7/2"
//            ,"7/3"
//            ,"7/4"
//            ,"8/1"
//            ,"8/2"
//            ,"8/3"
//            ,"8/4"
//            ,"9/1"
//            ,"9/2"
//            ,"9/3"
//            ,"9/4"
//      }};

}
