package cn.chunhuitech.www.api.common.util;

import cn.chunhuitech.www.core.common.annotation.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
public class ValidUtils {
    public static  <T> void validNotNull(T t) throws IllegalAccessException {
        List<Field> fields = new ArrayList<>() ;
        Class tempClass = t.getClass();
        while (tempClass != null) {
            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        for(Field field:fields){
            NotNull notNull=field.getAnnotation(NotNull.class);
            if(notNull!=null){
                String message=notNull.message();
                field.setAccessible(true);
                Object value=field.get(t);
                if(value==null){
                    if(message.length()==0){
                        message="field ["+field.getName()+"] is null";
                    }
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }

    public static  <T> void validNotNullEx(T t, String validFields) throws IllegalAccessException {
        List<String> fieldList = new ArrayList<String>();
        if (validFields.length() > 0 ){
            String[] fieldArray = validFields.split(",");
            for (String fieldName: fieldArray) {
                fieldList.add(fieldName);
            }
        }
        List<Field> fields = new ArrayList<>() ;
        Class tempClass = t.getClass();
        while (tempClass != null) {
            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        for(Field field:fields){
            for (String fieldName : fieldList){
                if (field.getName().equals(fieldName)){
                    String message= "";
                    field.setAccessible(true);
                    Object value=field.get(t);
                    if(value==null){
                        if(message.length()==0){
                            message="field ["+field.getName()+"] is null";
                        }
                        throw new IllegalArgumentException(message);
                    }
                }
            }
        }
    }
}
