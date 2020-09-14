package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.CustomerDAO;
import kosta.mvc.model.dao.CustomerDAOImpl;
import kosta.mvc.model.dto.Customer;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class CustomerService {
	CustomerDAO customerDao = new CustomerDAOImpl();
	
	
  /**
   * 로그인
   * */
	public Customer login(String userId, String userPwd)throws NotFoundException , SQLException{
		Customer customer=customerDao.login(userId, userPwd);
		if(customer==null) {
			throw new NotFoundException("정보를 다시 확안해주세요.");
		}
		
		//로그인 된 정보 저장하기
		SessionSet sessionSet = SessionSet.getInstance();
		Session session = new Session(userId);
		sessionSet.add(session);
		
		return customer;
	}
}
