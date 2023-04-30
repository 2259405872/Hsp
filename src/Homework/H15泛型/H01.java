package Homework.H15泛型;

import org.junit.jupiter.api.Test;

import java.util.*;

public class H01 {
}

class DAO<T>{
    private final Map<String,T> map=new HashMap<>();

    public void save(String id,T entity){
        boolean b=true;

        for (String str: map.keySet()) {
            if (str.equals(id)) {
                b = false;
                break;
            }
        }

        if (b) {
            map.put(id,entity);
        }else{
            throw new RuntimeException("id已存在添加失败");
        }
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        boolean b=false;

        for (String str: map.keySet()) {
            if (str.equals(id)) {
                b = true;
                break;
            }
        }

        if (b) {
            map.put(id,entity);
        }else{
            throw new RuntimeException("id不存在添加失败");
        }
    }

    @Test
    public List<T> list(){
        return new ArrayList<>(map.values());
    }

    public void delete(String id){
        map.remove(id);
    }


}

class User{
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }
}