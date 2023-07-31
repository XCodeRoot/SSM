package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testMBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据主键id 来查询数据
        /*Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);*/

        //根据条件来查询 , 没有条件 , 就是查询所有
        /*List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);*/

        //根据条件查询 , 有条件 , 先创建 对应类的Example , 然后添加条件 , 再放进方法中,完成调用
        /*EmpExample example=new EmpExample();
        example.createCriteria().andAgeEqualTo(20).andGenderEqualTo("男");
        example.or().andEmpNameEqualTo("赵六");// 添加 or 条件
        List<Emp> emps = mapper.selectByExample(example);
        emps.forEach(System.out::println);*/

        //测试普通修改 和 选择性修改
        Emp emp=new Emp(1,"小黑",null,"女");
        //mapper.updateByPrimaryKey(emp);//如果这里 放的实体 的 某个属性是 null,则 会将表里的对应属性改为null
        mapper.updateByPrimaryKeySelective(emp);//如果这里 放的实体 的 某个属性是 null,则不会修改 表里对应的属性,相当于不使用占位符
    }
}
