package sand.service.db2;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sand.entity.User;
import sand.mapper.UserMapper;

import java.util.List;

@Service
public class Db2UserService {


    @Autowired
    private UserMapper userMapper;

    public List<User> selectPage(Page<User> page, Integer state){

        return userMapper.selectPage(page,new EntityWrapper<User>().eq("statue", 0));
    }

    public Page<User> selectUsers(Page<User> page, Integer state){
        page.setRecords(userMapper.selectUserList(page,state));
        return page;
    }
}
