package com.crs.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 将获取的参数封装成一个JavaBean
 * @outhor RS
 * @create 2021-04-27 16:10
 */
public class BeanUtils {
    //public static void populate(Object bean,Map map)

//    public static void populate(Object bean, Map map) throws ReflectiveOperationException {
//        //通过JavaBean对象来获取对应的字节码对象
//        Class clazz = bean.getClass();
//        //获取Map中所有的key
//        Set keys = map.keySet();
//        for (Object key : keys) {
//            try {
//                //根据key来获取对应的Field对象
//                Field f = clazz.getDeclaredField(key.toString());
//                //根据key来获取Map中对应的value
//                Object value = map.get(key);
//                f.setAccessible(true);
//                f.set(bean, value);
//            } catch(NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static<T> T populate(Class<T> cls ,Map<String, Object> map) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        T obj = null;

        //1、用类反射new出对象
        obj = cls.newInstance();

        //2 再用类反射对新new的对象设置属性值(必须遵守Java设置规范)--即通过setter方法设置
        //2.1遍历出所有该类声明的属性
        Field flds[] = cls.getDeclaredFields();//getDeclaredFields()返回Class中所有的字段，包括私有字段；
        for(Field fld:flds){
            //获取该fld对象所代表的属性名
            String fldName = fld.getName();
            //根据属性名，到map中去读取数据，只有数据非空才需要给该属性设置值
            Object value = map.get(fldName);
            if(value==null){//如果map中不存在对应的属性数据，我们在这里给出提示信息
                System.out.println(fldName+"的数据为空");
            }else{
                //如果map中存在对应的属性数据，则由属性名得出它的setter方法的名字
                String mothodName = "set"+fldName.substring(0, 1).toUpperCase()+fldName.substring(1);

                //根据方法名和参数的数据类型(其实就是属性的类型)，获得Method对象
                Class<?> paramTypes[] = new Class[1];
                paramTypes[0] = fld.getType();
                Method method = cls.getDeclaredMethod(mothodName, paramTypes);

                //调用该method对象所代表的方法
                Object args[] = new Object[1];
                args[0]=value;
                method.invoke(obj, args);
            }
        }
        return obj;
    }
}

