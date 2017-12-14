package sand.service.db1;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import sand.entity.User;
import sand.mapper.UserMapper;

@Service
public class Db1UserService extends ServiceImpl<UserMapper, User> {




    public Page<User> selectUsers(Page<User> page, Integer state){
        page.setRecords(baseMapper.selectUserList(page,state));
        return page;
    }
}
