package MissionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Bill;
import Entities.Employee;
import Entities.Mission;
import Entities.MissionRequest;
import Entities.Project;
import MissionService.Interface.IMissionServiceRemote;

@LocalBean
@Stateless
public class MissionServiceImpl implements IMissionServiceRemote {

	@PersistenceContext
	EntityManager em;

	
	@Override
	public int addMission(Mission mission) {
		//Project pro = em.find(Project.class, p.getId());
		//Bill bill = em.find(Bill.class, b.getId());	
		em.persist(mission);
	//	mission.setProject(pro);
	//	mission.setBill(bill);
		return mission.getId();
	}
	
	@Override
	public void addBill(Bill resto,Bill heb,Bill trans) {
		if(resto!=null)em.persist(resto);
		if(heb!=null)em.persist(heb);
		if(trans!=null)em.persist(trans);
		
	}

	@Override
	public int addMissionRequest(MissionRequest missionr, int idMission,Employee e) {
		Mission miss = em.find(Mission.class,idMission);
		//Employee e = em.find(Employee.class, emp.getId());
		//Bill bill = em.find(Bill.class, b.getId());	
		missionr.setMission(miss);
		if (miss.getMissionsRequests()==null)
		{
			miss.setMissionsRequests(new HashSet<MissionRequest>());
		}
		miss.getMissionsRequests().add(missionr);
		em.persist(missionr);
		
		missionr.setEmployee(e);
		return missionr.getId();
	}
	
	@Override
	public void deleteMissionById(int missionId) {
		Mission  mission =em.find(Mission.class, missionId);
		em.remove(mission);
		
	}

	@Override
	public void updateMission(Mission mission) {

		Mission miss = em.find(Mission.class, mission.getId());
		miss.setTitle(mission.getTitle());
		miss.setDateD(mission.getDateD());
		miss.setDateF(mission.getDateF());
		miss.setMaxExpense(mission.getMaxExpense());
		miss.setLocation(mission.getLocation());
		miss.setType(mission.getType());
		
		
	}

	@Override
	public void valideMission(int missionId) {
		Mission  mission =em.find(Mission.class, missionId);
		mission.setValide(1);
		
	}


	@Override
	public List<Mission> getAllMissions() {
		List<Mission> mission = em.createQuery("Select e from Mission e ",
				Mission.class).getResultList();
				return mission;
	}
	
	@Override
	public List<MissionRequest> getAllMissionsRequest() {
		List<MissionRequest> missionRequest = em.createQuery("Select e from MissionRequest e WHERE affect=0",
				MissionRequest.class).getResultList();
				return missionRequest;
	}
	
	@Override
	public List<Mission> getAllMissionsValide() {
		List<Mission> mission = em.createQuery("Select e from Mission e WHERE valide=1",
				Mission.class).getResultList();
				return mission;
	}
	

	
	@Override
	public List<Mission> getAllMissionsNonValide() {
		List<Mission> mission = em.createQuery("Select e from Mission e WHERE valide=0",
				Mission.class).getResultList();
				return mission;
	}
	
	@Override
	public List<Project> getAllProjects() {
		List<Project> project = em.createQuery("Select e from Project e",
				Project.class).getResultList();
				return project;
	}
	
	@Override
	public Mission getMissionById(int id) {
		TypedQuery<Mission> query = 
				em.createQuery("select u from Mission u WHERE u.id=:id ", Mission.class); 
		query.setParameter("id", id); 
		Mission mission = null; 
		try { 			
			mission = query.getSingleResult(); }
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return mission;
	}

	@Override
	public void affecterEmployeAMission(int employeeId, int missionId, int missionReqId) {
		Mission mission=em.find(Mission.class, missionId);
		MissionRequest missionR=em.find(MissionRequest.class, missionReqId);
		Employee emp=em.find(Employee.class, employeeId);
		mission.getEmployes().add(emp);
		
		
		Mission missionManagedEntity = em.find(Mission.class, missionId );
		Employee employeManagedEntity = em.find(Employee.class, employeeId);

		if(employeManagedEntity.getMissions() == null){
			List<Mission> missions = new ArrayList<>();
			missions.add(missionManagedEntity);
			employeManagedEntity.setMissions(missions);
		}else{
			employeManagedEntity.getMissions().add(missionManagedEntity);
			missionR.setAffect(1);
			
		}
		
	}
	
	
/*	@Override
	public List<Mission> getMissionsByProject(int projectId) 
	{
		Project projectManagedEntity = em.find(Project.class, projectId);
		//System.out.println("projectManagedEntity.getSprints().size() : " + projectManagedEntity.getMissions().size());
		//System.out.println("projectManagedEntity.getProjects().get(0).getDescription() : " + projectManagedEntity.getMissions().get(0).getDescription());
		//return projectManagedEntity.getMissions(); 
		
		
		List<Mission> mission = em.createQuery("Select e from Mission e WHERE e.id_project="+projectId, Mission.class).getResultList();
				return mission;
	} */
	@Override
	public List<Mission> getMissionsByProject(int projectId) 
	{
		Project projectManagedEntity = em.find(Project.class, projectId);
		System.out.println("userManagedEntity.getProjects().size() : " + projectManagedEntity.getMissions().size());
		System.out.println("userManagedEntity.getProjects().get(0).getDescription() : " + projectManagedEntity.getMissions().get(0).getTitle());

		return projectManagedEntity.getMissions().stream().sorted((a,b)->{ return a.getDateD().compareTo(b.getDateD());}).collect(Collectors.toList()); 
	}
}
