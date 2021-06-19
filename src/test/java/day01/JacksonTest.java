package day01;

import com.fasterxml.jackson.databind.ObjectMapper;
import day01.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {
    @Test
    public void test1() throws Exception {
//        1创建Person对象
        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(12);
        p.setGender("男");

//        2创建Jackson的核心对象， ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
//        3转换
        String s = mapper.writeValueAsString(p);
        System.out.println(s);

        mapper.writeValue(new File("src/main/a.txt"),p);
        mapper.writeValue(new FileWriter("b.txt"),p);
    }

    @Test
    public void test2() throws Exception {
//        1创建Person对象
        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(12);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
    }

    @Test
    public void test3() throws Exception {
//        1创建Person对象
        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(12);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("zhangsan");
        p1.setAge(12);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("zhangsan");
        p2.setAge(12);
        p2.setGender("男");
        p2.setBirthday(new Date());

        List<Person> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
    }
    @Test
    public void test4() throws Exception {
        Map<String,Object> map = new HashMap<>();

        map.put("name","zhangsan");
        map.put("age",12);
        map.put("gender","男");

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }


//    json字符串转java对象
    @Test
    public void test5() throws Exception {

//        String str = "{\"gender\":\"男\", \"name\":\"zhangsan\",\"age\":12}";
        String str = "";

        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(str, Person.class);
        System.out.println(person);
    }
}
