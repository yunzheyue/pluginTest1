package com.example.androidstudiotest4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.home.TestEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        foo1();
        foo2();
    }

    private void foo2() {

    }

    private void foo1() {
        Class c1=null;
        try {
             c1 = Class.forName("com.example.home.TestEntity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Field nameField = c1.getDeclaredField("name");
//            取消封装，特别是可以取消私有字段的访问限制
            nameField.setAccessible(true);
            Object o = c1.newInstance();


            Method test = c1.getDeclaredMethod("test");
            test.invoke(null);


            Constructor constructor = c1.getConstructor();
            Object o1 = constructor.newInstance();
            Log.e("TAG", "o1=="+o1);


            Field sex = c1.getSuperclass().getDeclaredField("sex");
            sex.setAccessible(true);
            sex.set(o,true);
            Log.e("TAG", "o==="+sex.get(o));


            Field[] declaredFields = c1.getDeclaredFields();
            for(int i = 0; i < declaredFields.length; i++) {


            }


//            第二个参数是可变参数，表示参数的类型
            Method setNameF = c1.getDeclaredMethod("setName", String.class);
            setNameF.invoke(o,"小妹");
            Log.e("TAG", "o==="+o.toString());


//            设置属性值
            nameField.set(o,"大美");
            Object nameStr = nameField.get(o);

            String name = nameField.getName();
            Log.e("TAG", "name=="+name);
            int modifiers = nameField.getModifiers();

            String modifier = Modifier.toString(modifiers);
            Log.e("TAG", "modifier=="+modifier);

            Log.e("TAG", "Modifier.isPrivate(modifiers)=="+Modifier.isPrivate(modifiers));

            Log.e("TAG", "nameStr=="+nameStr+ "  o==="+o.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Object o = c1.newInstance();
            TestEntity t1= (TestEntity) o;
            t1.setName("啦啦啦");
            Log.e("TAG", "t1==="+t1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor1 = c1.getConstructor(String.class, int.class);
            Object o1 = constructor1.newInstance("水水", 12);
            TestEntity t3= (TestEntity) o1;
            Log.e("TAG", "t3==="+t3);

        } catch (Exception e) {
            e.printStackTrace();
        }


        Class c2 = TestEntity.class;

        try {
            Object o = c2.newInstance();
            TestEntity t2= (TestEntity) o;
            t2.setName("啦啦啦111");
            Log.e("TAG", "t2==="+t2);
        } catch (Exception e) {
            e.printStackTrace();
        }



        Class c3 = new TestEntity().getClass();

        Log.e("TAG", "c1==="+c1+"   c2==="+c2+"  c3==="+c3);

    }

    public void startNext(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    public void finishThis(View view) {
        finish();
    }

    public void startNext3(View view) {

        //不同包中隐式跳转
        Intent intent = new Intent();
//        在打包后，所有的文件都会主文件中，因此包名只有一个，就是app的包名。
//        第二个参数是类的路径，这个就是填类所在的文件路径就可以了
//        intent.setClassName("com.example.androidstudiotest4","com.example.home.Main3Activity");
//        intent.setComponent(new ComponentName("com.example.androidstudiotest4","com.example.home.Main3Activity"));

        startActivity(intent);
    }
}
