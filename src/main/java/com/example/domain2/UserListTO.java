package com.example.domain2;

import com.example.domain.UserTO;
import lombok.Data;

import java.util.List;

@Data
public class UserListTO extends BaseTO {

    private List<UserTO> userList;
    private Boolean hasMore;


}
