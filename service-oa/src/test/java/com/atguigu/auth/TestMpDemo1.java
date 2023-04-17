package com.atguigu.auth;

import com.atguigu.auth.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {

    @Autowired
    private SysRoleMapper mapper;

    /*查询所有数据*/
    @Test
    public void getAll(){
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }

    /*新增数据*/
    @Test
    public void getAdd(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("roldes");
        sysRole.setDescription("角色管理员");

        int insert = mapper.insert(sysRole);
        System.out.println(sysRole.getId());
        System.out.println(insert);
    }

    /*修改数据*/
    @Test
    public void getupdate(){
        //根据id查询
        SysRole role = mapper.selectById(9);
        //设置修改值
        role.setRoleName("小米");
        //调用方法实现最终修改
        int rows = mapper.updateById(role);
        System.out.println(rows);

    }


    /*删除*/
    @Test
    public void getdeleteId(){
        mapper.deleteById(10);
    }

    /*批量删除*/
    @Test
    public void getdeleteAdd(){
        int deleteBatchIds = mapper.deleteBatchIds(Arrays.asList(3, 10));
        System.out.println(deleteBatchIds);
    }

    @Test
    public void testQuery1() {
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","总经理");
        //调用mp方法实现查询操作
        List<SysRole> list = mapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void testQuery2() {
        //LambdaQueryWrapper，调用方法封装条件
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"总经理");
        //调用mp方法实现查询操作
        List<SysRole> list = mapper.selectList(wrapper);
        System.out.println(list);
    }


}
