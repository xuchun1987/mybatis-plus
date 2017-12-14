package sand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import sand.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @ResultType(User.class)
    @Select(" SELECT * FROM lsys_user WHERE statue=#{state}")
    List<User> selectUserList(Pagination page, Integer state);

}
