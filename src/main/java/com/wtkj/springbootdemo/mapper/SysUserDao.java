package com.wtkj.springbootdemo.mapper;

import com.wtkj.springbootdemo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author songyan
 * @since 2023年03月23日
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}
