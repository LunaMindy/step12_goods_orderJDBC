package kosta.mvc.session;

import java.util.HashSet;
import java.util.Set;

public class SessionSet {//싱글톤

	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		set = new HashSet<>();
	}
	
	public static SessionSet getInstance() {
		return ss;//자기자신 생성 불러온다
	}
	
	
	/**
	 * 사용자 찾기
	 * */
	public Session get(String sessionId) {
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	//세션 객체들 반환
		public Set<Session> getSet(){
			return set;
		}
	
		/**
		 * 로그인 된 사용자 추가
		 * */
		public void add(Session session) {
			set.add(session);
		}
		
	/**
	 * 사용자 제거
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
	
	
}
