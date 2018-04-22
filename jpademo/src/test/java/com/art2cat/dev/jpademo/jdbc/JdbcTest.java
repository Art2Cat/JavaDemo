package com.art2cat.dev.jpademo.jdbc;

import com.art2cat.dev.jpademo.configurations.AppConfigs;
import com.art2cat.dev.jpademo.models.Member;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * PACKAGE_NAME
 *
 * @author rorschach
 * @date 4/11/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigs.class)
public class JdbcTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void getAllMember() {
        String sql = "select * from member";
        List<Member> members = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getInt("member_id"));
            member.setName(rs.getString("name"));
            member.setSalary(rs.getInt("salary"));
            member.setBirthday(rs.getDate("birthday"));
            return member;
        });
        if (members != null && !members.isEmpty()) {
            members.forEach(m -> System.out.println(m.getName() + ": " + m.getBirthday()));
        }
    }
    
    @Test
    public void getAllSalary() {
        String sql = "select name, salary from member";
        
        List<Member> members = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setName(rs.getString("name"));
            member.setSalary(rs.getInt("salary"));
            return member;
        });
        if (members != null && !members.isEmpty()) {
            members.forEach(m -> System.out.println(m.getName() + ": " + m.getSalary()));
        }
    }
    
}
