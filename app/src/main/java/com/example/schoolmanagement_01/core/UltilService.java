package com.example.schoolmanagement_01.core;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;


import com.example.schoolmanagement_01.core.dto.CalculatorMinusMap;
import com.example.schoolmanagement_01.core.dto.PointDTO;
import com.example.schoolmanagement_01.core.dto.ReportDTO;
import com.example.schoolmanagement_01.core.dto.RuleDTO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UltilService {

    public static List<RuleDTO> getRules(List<RuleDTO> list, Integer parentId) {
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

    public static Bitmap StringToBitMap(String image) {
        try {
            byte[] encodeByte = Base64.decode(image, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] arr = baos.toByteArray();
        String result = Base64.encodeToString(arr, Base64.DEFAULT);
        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param pointDTO
     * @return
     */
    public static Float calculatorDiemXepLoaiTietHoc(PointDTO pointDTO) {
        if (Objects.isNull(pointDTO) || !(pointDTO != null)) {
            return Float.parseFloat("0");
        }
        Integer a = pointDTO.getPointA();
        Integer b = pointDTO.getPointB();
        Integer c = pointDTO.getPointC();
        Integer d = pointDTO.getPointD();
        Log.e("float",(float)(a * 10 + b * 5 + c * 0 + d * (-5)) / (a + b + c + d)+"");
        return (float)(a * 10 + b * 5 + c * 0 + d * (-5)) / (a + b + c + d);
    }

    public static Integer calculatorDiemThiDuaForClass(List<ReportDTO> reportDTOList) {
        if(reportDTOList.isEmpty()|| Objects.isNull(reportDTOList)){
            return 16;
        }
        boolean isMinusChuyenCan = true;
        boolean isMinusHocTap = true;
        boolean isMinusKyLuat = true;
        boolean isMinusVeSinh = true;

        CalculatorMinusMap calculatorMinus;
        Integer score = 16;
        Map<Integer, CalculatorMinusMap> calculatorMinusMap = DBConstants.calculatorMinusMap;
        for (ReportDTO reportDTO : reportDTOList) {
            int ruleId = reportDTO.getRuleId();
            Log.e("ruleId",ruleId+"");
            calculatorMinus = calculatorMinusMap.get(ruleId);
            score = score + calculatorMinus.getMinus();
            switch (calculatorMinus.getIdRuleParent()) {
                case 1:
                    if (isMinusChuyenCan) {
                        score = score - 2;
                        isMinusChuyenCan = false;
                    }
                    break;
                case 4:
                    if (isMinusHocTap) {
                        score = score - 4;
                        isMinusHocTap = false;
                    }
                    break;
                case 8:
                    if (isMinusKyLuat) {
                        score = score - 5;
                        isMinusKyLuat = false;
                    }
                    break;
                case 16:
                    if (isMinusVeSinh) {
                        score = score - 5;
                        isMinusVeSinh = false;
                    }
                    break;
                default:
                    break;
            }
        }
        return score;
    }
    public static void reverseArrayFloat(float[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            float temp = data[left];
            data[left]  = data[right];
            data[right] = temp;
        }
    }



}
