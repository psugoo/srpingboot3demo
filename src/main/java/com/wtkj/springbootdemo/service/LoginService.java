package com.wtkj.springbootdemo.service;

import com.wtkj.springbootdemo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyan
 * @since 2023年03月21日
 */
public interface LoginService extends IService<SysUser> {

    public SysUser login(String username, String password);

}
