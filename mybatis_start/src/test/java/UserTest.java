import model.Person;
import utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class UserTest {

    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 3;
        String userName = "cxy";
        int age = 25;
        String mobilePhone = "18756956629";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{
            Person person = sqlSession.selectOne("queryById",id);

            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }
}