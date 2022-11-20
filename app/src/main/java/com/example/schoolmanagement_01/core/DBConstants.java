package com.example.schoolmanagement_01.core;

import com.example.schoolmanagement_01.core.dto.ClassRoomDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBConstants {

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

    public  static final List<RuleDTO> listRuleDTO = new ArrayList<RuleDTO>(){{
          add(new RuleDTO(1,0,"Chuyên cần",2));
          add(new RuleDTO(2,1,"Nghĩ học không phép",-2));
          add(new RuleDTO(3,1,"Đi trễ hoặc nghĩ học có phép",-1));

          add(new RuleDTO(4,0,"Học tập",4));
          add(new RuleDTO(5,4,"Không thuộc bài",-2));
          add(new RuleDTO(6,4,"Không chuẩn bị bài đầy đủ",-2));
          add(new RuleDTO(7,4,"Truy giờ đầu bài bỏ ra khỏi lớp",-2));

          add(new RuleDTO(8,0,"Kỷ luật",5));
          add(new RuleDTO(9,8,"Không xếp hàng",-2));
          add(new RuleDTO(10,8,"Không văn nghệ",-2));
          add(new RuleDTO(11,8,"Chạy xe trong sân trường",-2));
          add(new RuleDTO(12,8,"Gây gỗ đánh nhau",-5));
          add(new RuleDTO(13,8,"Vô lễ với thầy cô, người lớn",-5));
          add(new RuleDTO(14,8,"Lớp ồn, mất trật tự",-5));
          add(new RuleDTO(15,8,"Nói tục chửi thề",-2));

          add(new RuleDTO(16,0,"Vệ sinh",5));
          add(new RuleDTO(17,16,"Không vệ sinh lớp",-5));
          add(new RuleDTO(18,16,"Không tham gia lao động",-2));

    }};

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
