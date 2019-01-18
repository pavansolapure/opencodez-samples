package com.opencodez.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String id;
	private String name;
	private String email;
}
