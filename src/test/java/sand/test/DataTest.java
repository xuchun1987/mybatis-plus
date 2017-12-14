package sand.test;

import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sand.SandRun;
import sand.config.DbContextHolder;
import sand.entity.User;
import sand.service.db1.Db1UserService;
import sand.service.db2.Db2UserService;

import java.util.List;

@SpringBootTest(classes= SandRun.class)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class DataTest {

    @Autowired
    private Db1UserService db1UserService;

    @Autowired
    private Db2UserService db2UserService;


    @Test
    public void test1(){

        Page page=new Page(1,3);

        db1UserService.selectUsers(page,0);
        List<User> list=page.getRecords();
        if(list!=null){
            for(User u:list){
                System.out.println("-----------username："+u.getUsername());
            }
        }
    }

    @Test
    public void test2(){

        Page page=new Page(1,3);

        List<User> list=db2UserService.selectPage(page,0);
        if(list!=null){
            for(User u:list){
                System.out.println("-----------username："+u.getUsername());
            }
        }

       /* Page page=new Page(1,3);

        List<User> list=db2UserService.selectPage(page,0);
        if(list!=null){
            for(User u:list){
                System.out.println("-----------username："+u.getUsername());
            }
        }*/
    }
}
