package MissionService.Interface;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import Entities.Bill;
import Entities.Mission;
import Entities.MissionRequest;
import Entities.Project;
@Remote
public interface IMissionServiceRemote {
	public int addMission(Mission mission);
	public void deleteMissionById(int missionId);
	public void updateMission(Mission mission);
	public void valideMission(int missionId);
	public List<Mission> getAllMissions();
	public void affecterEmployeAMission(int employeeId, int missionId, int missionReqId);
	public List<Project> getAllProjects();
	//public List<Mission> getMissionsByProject(int projectId) ;
	public List<Mission> getAllMissionsValide();
	public List<MissionRequest> getAllMissionsRequest();
	public List<Mission> getAllMissionsNonValide();

}
