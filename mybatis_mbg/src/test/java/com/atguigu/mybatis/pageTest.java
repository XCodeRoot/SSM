package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.istack.internal.Nullable;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class pageTest {

/*
    PageInfo{
    pageNum=3, pageSize=4, size=4,
    startRow=9, endRow=12, total=27,
    pages=7,
    list=Page{
        count=true, pageNum=3, pageSize=4,
        startRow=8, endRow=12, total=27,
        pages=7,
        reasonable=false, pageSizeZero=false
        }
        [Emp{
            empId=22, empName='a', age=null, gender='null', deptId=null
            }, Emp{empId=23, empName='a', age=null, gender='null', deptId=null
            }, Emp{empId=24, empName='a', age=null, gender='null', deptId=null
            }, Emp{empId=25, empName='a', age=null, gender='null', deptId=null}],

             prePage=2, nextPage=4, isFirstPage=false,
             isLastPage=false, hasPreviousPage=true, hasNextPage=true,
             navigatePages=5, navigateFirstPage=1, navigateLastPage=5,
             navigatepageNums=[1, 2, 3, 4, 5]}
*/


    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询之前 开启分页功能
        Page<Object> page = PageHelper.startPage(3, 4);// ( pageNum 你要访问第几页 , pageSize 设置每页多少条数据 )
        List<Emp> emps = mapper.selectByExample(null);

        //查询后 ,可以获取分页相关的数据
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 7);//这个就是传给页面 , 进行页码跳转,分页导航 所需要的全部信息

        emps.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}


