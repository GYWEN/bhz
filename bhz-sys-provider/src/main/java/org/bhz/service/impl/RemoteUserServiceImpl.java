package org.bhz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.bhz.service.RemoteUserService;

/**
 * <Description> <br>;
 *
 * @author gyw<br>
 * @version 1.0<br>
 * @taskId
 * @CreateDate 2019/5/31
 * @see org.bhz.service.impl<br>
 * @since V7.3<br>
 */
@Service
public class RemoteUserServiceImpl implements RemoteUserService {
    @Override
    public String userService(String userName) {
        return "this is good";
    }
}
