package com.wtkj.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wtkj.springbootdemo.entity.SysUser;
import com.wtkj.springbootdemo.mapper.SysUserDao;
import com.wtkj.springbootdemo.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wtkj.springbootdemo.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyan
 * @since 2023年03月21日
 */
@Service
public class LoginServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements LoginService {

    @Autowired
    private SysUserDao userDao;
    @Override
    public SysUser login(String username, String password) {

        SysUser user = new SysUser();

        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>();

        wrapper.eq("name", username);
        wrapper.eq("password", password);


//            wrapper.eq("is_able", 0);





        List<SysUser> user_list = userDao.selectList(wrapper);




        if(Assert.notNull(user_list)&&user_list.size()>0){
            user = user_list.get(0);
        }
        else{
            user =null;
        }

        return user;
    }
}
