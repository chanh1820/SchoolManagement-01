package com.example.schoolmanagement_01.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UltilService {
    public static List<RuleDTO> getRules(List<RuleDTO> list,Integer parentId) {
        List<RuleDTO> listParent = new ArrayList<>();
        if (list != null) {
            for (RuleDTO ruleDTO : list) {
                if (ruleDTO.getParentId() == parentId) {
                    listParent.add(ruleDTO);
                }
            }
        }
        return listParent;
    }

    public static Bitmap StringToBitMap(String image){
        try{
            byte [] encodeByte= Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
    public static String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] arr=baos.toByteArray();
        String result=Base64.encodeToString(arr, Base64.DEFAULT);
        return result;
    }
}
