package com.recheck.service.impl;

import com.recheck.entity.People;
import com.recheck.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        People people = peopleMapper.getPeopleByUserName(username);
        if (people == null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<String> permissions = peopleMapper.selectPermissionsByUserId(people.getId());
        List<String> roles = peopleMapper.selectAllRolesByUserId(people.getId());
        StringBuffer sb = new StringBuffer();
        for(String role : roles){
            sb.append("ROLE_" + role + ",");
        }
        for (String permission:permissions) {
            sb.append(permission + ",");
        }
        String roleAndPermission = sb.toString().substring(0, sb.toString().length() - 1);

        UserDetails userDetails = new User(people.getUsername(), people.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(roleAndPermission));
        return userDetails;
    }
}
