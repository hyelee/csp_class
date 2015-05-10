package kr.ac.shinan.csp;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MemberManager {
	public static TeamMember addMember(String name, String hak, String num,
			String email, String kakao, String leader, String gitid) {
		PersistenceManager pm = MyPersistenceManger.getManager();
		TeamMember m = new TeamMember(name, hak, num, email, kakao, leader,
				gitid);
		pm.makePersistent(m);

		return m;
	}

	public static TeamMember getMember(Long key) {
		PersistenceManager pm = MyPersistenceManger.getManager();
		TeamMember m = pm.getObjectById(TeamMember.class, key);
		
		return m;
	}

	public static void updateMember(TeamMember newMember,TeamMember original) {
	
		
		PersistenceManager pm = MyPersistenceManger.getManager();

		
		original.setName(newMember.getName());
		original.setHak(newMember.getHak());
		original.setNum(newMember.getNum());
		original.setEmail(newMember.getEmail());
		original.setKakao(newMember.getKakao());
		original.setLeader(newMember.getLeader());
		original.setGitid(newMember.getGitid());

		pm.close();
			
	}
public static void updateMember2(TeamMember newMember,Long key) {
	
		
		PersistenceManager pm = MyPersistenceManger.getManager();
		TeamMember original = MemberManager.getMember(key);
		
		original.setName(newMember.getName());
		original.setHak(newMember.getHak());
		original.setNum(newMember.getNum());
		original.setEmail(newMember.getEmail());
		original.setKakao(newMember.getKakao());
		original.setLeader(newMember.getLeader());
		original.setGitid(newMember.getGitid());

		pm.close();
			
	}

	public static void deleteMember(Long key) {
		PersistenceManager tm = MyPersistenceManger.getManager();
		TeamMember m = MemberManager.getMember(key);
		tm.deletePersistent(m);

	}

	public static List<TeamMember> getMemberByName(String name) {
		PersistenceManager pm = MyPersistenceManger.getManager();
		Query qry = pm.newQuery(TeamMember.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");

		List<TeamMember> memberList = (List<TeamMember>) qry.execute(name);

		return memberList;
	}

	public static List<TeamMember> getAllMembers() {
		PersistenceManager pm = MyPersistenceManger.getManager();
		Query qry = pm.newQuery(TeamMember.class);
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();
		pm.close();

		return memberList;
	}

}
