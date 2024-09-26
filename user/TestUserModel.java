package com.rays.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) {
		// testAdd();
		testUpdate();
		// testGet();
		// testDelete();
		// testAuth();
		// testSearch();

	}

	private static void testSearch() {

		UserDto dto = new UserDto();

		// dto.setFirstName("abc");

		UserModel model = new UserModel();

		List list = model.search(dto, 1, 2);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			dto = (UserDto) it.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}

	}

	private static void testAuth() {

		UserModel model = new UserModel();

		UserDto dto = model.authenticate("sagar@gmail.com", "123");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());
		} else {
			System.out.println("Authentication failed..!!");
		}

	}

	private static void testDelete() {

		UserDto dto = new UserDto();
		dto.setId(2);

		UserModel model = new UserModel();

		model.delete(dto);

	}

	private static void testGet() {

		UserModel model = new UserModel();

		UserDto dto = model.findByPk(1);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());

	}

	private static void testUpdate() {

		UserDto dto = new UserDto();
		dto.setId(1);
		dto.setFirstName("Aman");
		dto.setLastName("Soni");
		dto.setLoginId("Soni@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");

		UserModel model = new UserModel();

		model.update(dto);
	}

	public static void testAdd() {

		UserDto dto = new UserDto();
		// dto.setId(1);
		dto.setFirstName("Vinjal");
		dto.setLastName("Jain");
		dto.setLoginId("Shaym45@gmail.com");
		dto.setPassword("Shaym.123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		UserModel model = new UserModel();
		model.add(dto);

	}
}
