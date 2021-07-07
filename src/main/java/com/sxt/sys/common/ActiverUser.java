package com.sxt.sys.common;

import java.io.Serializable;
import java.util.List;

import com.sxt.sys.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser implements Serializable {

	private User user;
	
	private List<String> roles;
	
	private List<String> permissions;
}
