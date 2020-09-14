package kosta.mvc.controller;

import kosta.mvc.model.dto.Customer;
import kosta.mvc.model.service.CustomerService;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;

public class CustomerController {
	static CustomerService customerService = new CustomerService();
 /**
  * ·Î±×ÀÎ
  * */
	public static void login(String userId, String userPwd) {
		try {
			Customer customer = customerService.login(userId, userPwd);
			MenuView.printUserMenu(userId);
			//MenuView.menu();
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
}
