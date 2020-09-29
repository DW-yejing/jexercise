package com.yejing.exercise.bean;

import com.yejing.exercise.model.User;
import com.yejing.exercise.model.UserDto;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.DebuggingClassWriter;
import org.aspectj.util.SoftHashMap;
import org.junit.Test;

public class BeanTest {
    @Test
    public void test1(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\workspace_exercise\\exercise\\clz");
        User user1 = new User("yejing", "18", "1");
        UserDto userDto1 = new UserDto();
        BeanCopier beanCopier = BeanCopier.create(User.class, UserDto.class, false);
        beanCopier.copy(user1, userDto1, null);
        System.out.println(userDto1);
    }
}
