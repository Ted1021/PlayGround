package com.study.tedkim.sms_receiver;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tedkim on 2017. 5. 31..
 */

public class MsgArchive {

    static final int MAX = 20;

    ArrayList<String> senders = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> contents = new ArrayList<>();

    public MsgArchive(){

        initSenders();
        initDates();
        initContents();
    }

    public void initSenders() {

        for(int i=0; i<MAX; i++){

            String digit = "010-";
            Random rnd = new Random();

            for(int j=0; j<8; j++){

                if(j==4)
                    digit += "-";

                digit += rnd.nextInt(9);
            }
            senders.add(digit);
        }

    }

    public void initDates() {

        for(int i=0; i<20; i++){
            dates.add("2017-05-31");
        }

    }

    public void initContents() {

        for(int i=0; i<20; i++){

            String content="";

            switch(i%5){

                case 0:

                    content = "Android 는 여러가지의 DBMS 중에 SQLite 를 지원한다.\n" +
                            "\n" +
                            "SQLiteOpenHelper 라고 하는 클래스를 이용하면 Android 내에서\n" +
                            "\n" +
                            "JAVA 코드 뿐만아니라 Query 문을 이용해 Database 를 관리 할 수 있다.\n" +
                            "\n" +
                            "SQLiteOpenHelper 클래스는 다음과 같은 메소드들을 Abstract 하고 있다.";

                    break;

                case 1:

                    content = "OnCreate()\n" +
                            "\n" +
                            ": App 내에 최초의 Database 를 생성한다.\n" +
                            "\n" +
                            "OnUpgrade()\n" +
                            "\n" +
                            ": App 내에 있는 데이터베이스의 Version 을 체크 할 수 있고,\n" +
                            "\n" +
                            "데이터베이스나 특정 테이블의 수정작업을 진행 할 수 있다.\n" +
                            "\n" +
                            "OnOpen()\n" +
                            "\n" +
                            ": 데이터베이스에 접근하려 할 때 자동적으로 실행이 되는 메서드이다.";

                    break;

                case 2:

                    content = "추가 사항) 왜 Helper 를 사용해야 하는가??\n" +
                            "\n" +
                            "SQLiteOpenHelper 가 없어도 SQLiteDatabse 를 이용해 DB 를 제어 할 수 있다.\n" +
                            "\n" +
                            "하지만 SQLiteDatabase 의 경우, DB 를 생성하거나 관리하기 위한 openOrCreateDatabase() 메소드가\n" +
                            "\n" +
                            "오직 Activity 에서만 사용해야한다는 단점이 있다.\n" +
                            "\n" +
                            "SQLiteOpenHelper 는 이러한 DB 의 생성과 관리를 외부 클래스에서 간편하게 정리 할 수 있도록 도와준다.";

                    break;

                case 3:

                    content = "SQLiteOpenHelper 클래스 생성\n" +
                            "\n" +
                            ": 새롭게 생성할 Database 의 이름, 테이블, 버전정보 등 을 OnCreate() 와 OnUpgrade() 를 이용해 정의 해야 한다.";

                    break;

                case 4:

                    content = "getReadableDatabase(), getWritableDatabase()\n" +
                            "\n" +
                            ": SQLiteOpenHelper 에서 제공하는 getReadableDatabase(), getWritableDatabase() 를 이용해 Query 를\n" +
                            "\n" +
                            "Android 내에서 직접 제어 할 수 있다.\n" +
                            "\n" +
                            ": 위의 두 메소드를 이용하는 대표적인 로직인 Insert 구문 과 Select 구문 을 구현해 본다.";

                    break;
            }

            contents.add(content);
        }
    }
}
