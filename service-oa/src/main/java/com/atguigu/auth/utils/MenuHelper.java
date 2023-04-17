package com.atguigu.auth.utils;

import com.atguigu.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {

    //所有递归方法建菜单
    public static List<SysMenu> buildTree(List<SysMenu> sysMenusList) {
        //创建list集合,用于最终数据
        List<SysMenu> trees = new ArrayList<>();
        //把所有菜单数据进行遍历
        for(SysMenu sysMenu:sysMenusList){
            //递归入口进入
            //parentId=0 是入口
            if(sysMenu.getParentId().longValue()==0){
                trees.add(getChildren(sysMenu,sysMenusList));
            }
        }
        return trees;
    }

    private static SysMenu getChildren(SysMenu sysMenu, List<SysMenu> sysMenusList) {
        sysMenu.setChildren(new ArrayList<SysMenu>());
        //遍历所有菜单数据,判断id和parentId对应关系
        for(SysMenu it:sysMenusList){
            if (sysMenu.getId().longValue() == it.getParentId().longValue()) {
                if(sysMenu.getChildren() == null){
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(getChildren(it, sysMenusList));
            }
        }
        return sysMenu;
    }




}
