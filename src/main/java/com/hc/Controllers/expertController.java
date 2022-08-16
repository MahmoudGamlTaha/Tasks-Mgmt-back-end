package com.hc.Controllers;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.engine.jdbc.NonContextualLobCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.managers.EmsCountryCodeService;
import com.hc.managers.EmsExpertService;
import com.hc.managers.EmsFinancialRequestService;
import com.hc.managers.EmsGovernorateCodeService;
import com.hc.managers.EmsTaskCommentService;
import com.hc.managers.EmsTaskService;
import com.hc.model.EmsExpert;
import com.hc.model.EmsFinancialRequest;
import com.hc.model.EmsGovernorateCode;
import com.hc.model.EmsTask;
import com.hc.model.EmsTaskComment;
import com.hc.model.EmsTaskPK;
import com.hc.model.EmsTaskStatusCode;
import com.hc.model.GeneralResponse;
import com.hc.repositories.EmsExpertRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Expert")
@RequiredArgsConstructor
public class expertController {
private final EmsExpertService emsExpertService;
private final EmsTaskService emsTaskService;
private final EmsFinancialRequestService emsFinancialRequestService;
private final EmsTaskCommentService emsTaskCommentService;


    @GetMapping("/getExpert")
	public ResponseEntity<EmsExpert> getall(@RequestParam("ExpertId") Long ExpertID) {
		
        EmsExpert e=	emsExpertService.getExpert(ExpertID);
         try {
        e.setImageDecode(new String(e.getRecentPhotoFile()));
         }
         catch(Exception ex) {
        	 ex.printStackTrace();
         }
			return new ResponseEntity<>(e, HttpStatus.OK);		
	}
    @GetMapping("/getAllExpert")
   	public ResponseEntity<List<EmsExpert>> getall() {
   		
    	List<EmsExpert> e=	emsExpertService.getAllExperts();
   			return new ResponseEntity<>(e, HttpStatus.OK);		
   	}
    
    @PostMapping("/AddExpert")
   	public ResponseEntity<GeneralResponse> AddComplaint(@RequestBody EmsExpert exprt) {
   	
    	 GeneralResponse res=new GeneralResponse();
			
     	  try{
     		  emsExpertService.AddNewExpert(exprt);
     		 res.setStatusCode("0");
  			res.setStatusMessage("Success");
     	  }catch (Exception e) {
     		  e.printStackTrace();
     		 res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Add New Expert");
		}
      	return new ResponseEntity<>(res, HttpStatus.OK);		

   	}
    
   
    @GetMapping("/deleteExpert")
   	public ResponseEntity<GeneralResponse> deleteExpert(@RequestParam("ExpertId") Long ExpertID) {
   		
    	 GeneralResponse res=new GeneralResponse();
			
    	  try{
    		  emsExpertService.DeleteExpert(ExpertID);
    		 res.setStatusCode("0");
 			res.setStatusMessage("Success");
    	  }catch (Exception e) {
    		  e.printStackTrace();
    		 res.setStatusCode("-1");
 			res.setStatusMessage("Failed To Delete Expert");
		}
     	return new ResponseEntity<>(res, HttpStatus.OK);	
     	}
    
    
    @GetMapping("/getallTasks")
	public ResponseEntity<List<EmsTask>> getallSubmittedTasks(@RequestParam("ExpertId") Long ExpertID,
			@RequestParam("ProjectId") Long ProjectId) {
		
			
			return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
	}
    @GetMapping("/getallTasksPerProject")
   	public ResponseEntity<List<EmsTask>> getallTasksPerProject(@RequestParam("ExpertId") Long ExpertID,
   			@RequestParam("ProjectId") Long ProjectId) {
   		
   			
   			return new ResponseEntity<>(emsTaskService.GetProjectTasks(ExpertID,ProjectId), HttpStatus.OK);		
   	}
    
    
    @GetMapping("/getallReadyTasks")
   	public ResponseEntity<List<EmsTask>> getallReadyTasks(@RequestParam("ExpertId") Long ExpertID) {
   			
   			return new ResponseEntity<>(emsTaskService.GetExpertReadyTasks(ExpertID,null), HttpStatus.OK);		
   	}
    
    @GetMapping("/getallFinancialRequest")
   	public ResponseEntity<List<EmsFinancialRequest>> getallFinancialRequest(@RequestParam("ExpertId") Long ExpertID) {
   			
   			return new ResponseEntity<>(emsFinancialRequestService.getAllFinancial(ExpertID), HttpStatus.OK);		
   	}
    
    @PostMapping("/AddComplaint")
   	public ResponseEntity<GeneralResponse> AddComplaint(@RequestBody EmsFinancialRequest Req) {
   	
    	 GeneralResponse res=new GeneralResponse();
			
     	  try{
     		  emsFinancialRequestService.AddComplaint(Req);
     		 res.setStatusCode("0");
  			res.setStatusMessage("Success");
     	  }catch (Exception e) {
     		  e.printStackTrace();
     		 res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Accept Task");
		}
     	  
     
 	
      	return new ResponseEntity<>(res, HttpStatus.OK);		

   	}
    
    @GetMapping("/AddFinancialReq")
   	public ResponseEntity<GeneralResponse> AddFinancialReq(@RequestParam("ExpertId") Long ExpertID,@RequestParam("Price") BigDecimal Price) {
   	
    	 GeneralResponse res=new GeneralResponse();
			
     	  try{
     		  emsFinancialRequestService.AddNewFinancial(ExpertID,Price);
     		 res.setStatusCode("0");
  			res.setStatusMessage("Success");
     	  }catch (Exception e) {
     		  e.printStackTrace();
     		 res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Accept Task");
		}
     	  
     
 	
      	return new ResponseEntity<>(res, HttpStatus.OK);		

   	}
    
    
    @GetMapping("/acceptTask")
	public ResponseEntity<GeneralResponse> acceptTask(@RequestParam("ExpertId") Long ExpertID,
			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
	    GeneralResponse res=new GeneralResponse();
			
    	boolean b=emsTaskService.AcceptTask(TaskId, ProjectId);
    	if(b) {
			res.setStatusCode("0");
			res.setStatusMessage("Success");
		}
		else {
			res.setStatusCode("-1");
			res.setStatusMessage("Failed To Accept Task");
		}
      	return new ResponseEntity<>(res, HttpStatus.OK);		

			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
	}
    
    @GetMapping("/acceptTaskFromAdmin")
	public ResponseEntity<GeneralResponse> acceptTaskFromAdmin(@RequestParam("ExpertId") Long ExpertID,
			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
	    GeneralResponse res=new GeneralResponse();
			
    	boolean b=emsTaskService.AcceptTaskFromAdmin(TaskId, ProjectId);
    	if(b) {
			res.setStatusCode("0");
			res.setStatusMessage("Success");
		}
		else {
			res.setStatusCode("-1");
			res.setStatusMessage("Failed To Accept Task");
		}
      	return new ResponseEntity<>(res, HttpStatus.OK);		

			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
	}
    
    
    @GetMapping("/rejectTaskFromAdmin")
	public ResponseEntity<GeneralResponse> rejectTaskFromAdmin(@RequestParam("ExpertId") Long ExpertID,
			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
	    GeneralResponse res=new GeneralResponse();
			
    	boolean b=emsTaskService.RejectTaskFromAdmin(TaskId, ProjectId);
    	if(b) {
			res.setStatusCode("0");
			res.setStatusMessage("Success");
		}
		else {
			res.setStatusCode("-1");
			res.setStatusMessage("Failed To Accept Task");
		}
      	return new ResponseEntity<>(res, HttpStatus.OK);		

			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
	}
    
    
    @GetMapping("/AcceptRevisionFromAdmin")
	public ResponseEntity<GeneralResponse> AcceptRevisionFromAdmin(@RequestParam("ExpertId") Long ExpertID,
			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
	    GeneralResponse res=new GeneralResponse();
			
    	boolean b=emsTaskService.AcceptTaskRevision(TaskId, ProjectId);
    	if(b) {
			res.setStatusCode("0");
			res.setStatusMessage("Success");
		}
		else {
			res.setStatusCode("-1");
			res.setStatusMessage("Failed To Accept Task");
		}
      	return new ResponseEntity<>(res, HttpStatus.OK);		

			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
	}
    
    @GetMapping("/ReturnToExpertFromAdmin")
   	public ResponseEntity<GeneralResponse> ReturnToExpertFromAdmin(@RequestParam("ExpertId") Long ExpertID,
   			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
   	    GeneralResponse res=new GeneralResponse();
   			
       	boolean b=emsTaskService.ReturnTaskToExpert(TaskId, ProjectId);
       	if(b) {
   			res.setStatusCode("0");
   			res.setStatusMessage("Success");
   		}
   		else {
   			res.setStatusCode("-1");
   			res.setStatusMessage("Failed To Accept Task");
   		}
         	return new ResponseEntity<>(res, HttpStatus.OK);		

   			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
   	}
    
    
    @GetMapping("/getTaskDetails")
   	public ResponseEntity<EmsTask> getTaskDetails(@RequestParam("TaskId") Long TaskId,
   			@RequestParam("ProjectId") Long ProjectId) {
   	    GeneralResponse res=new GeneralResponse();
   			
    	return new ResponseEntity<EmsTask>(emsTaskService.getEmsTask(TaskId, ProjectId), HttpStatus.OK);		

   			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
   	}
    
    @GetMapping("/rejectTask")
  	public ResponseEntity<GeneralResponse> rejectTask(@RequestParam("ExpertId") Long ExpertID,
  			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
  	    GeneralResponse res=new GeneralResponse();
  			
      	boolean b=emsTaskService.RejectTask(TaskId, ProjectId);
      	if(b) {
  			res.setStatusCode("0");
  			res.setStatusMessage("Success");
  		}
  		else {
  			res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Reject Task");
  		}
        	return new ResponseEntity<>(res, HttpStatus.OK);		

  			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
  	}
    
    @GetMapping("/startTask")
  	public ResponseEntity<GeneralResponse> startTask(@RequestParam("ExpertId") Long ExpertID,
  			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId) {
  	    GeneralResponse res=new GeneralResponse();
  			
      	boolean b=emsTaskService.StartTask(TaskId, ProjectId);
      	if(b) {
  			res.setStatusCode("0");
  			res.setStatusMessage("Success");
  		}
  		else {
  			res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Start Task");
  		}
        	return new ResponseEntity<>(res, HttpStatus.OK);		

  			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
  	}

    
    @GetMapping("/completeTask")
  	public ResponseEntity<GeneralResponse> completeTask(
  			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId,@RequestParam("ActualHours") BigDecimal ActualHours,@RequestParam("ActualMinutes") BigDecimal ActualMinutes) {
  	    GeneralResponse res=new GeneralResponse();
  			
      	boolean b=emsTaskService.CompleteTask(TaskId, ProjectId,ActualHours,ActualMinutes);
      	if(b) {
  			res.setStatusCode("0");
  			res.setStatusMessage("Success");
  		}
  		else {
  			res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Complete Task");
  		}
        	return new ResponseEntity<>(res, HttpStatus.OK);		

  			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
  	}
 
    @GetMapping("/PauseTask")
  	public ResponseEntity<GeneralResponse> PauseTask(
  			@RequestParam("ProjectId") Long ProjectId,@RequestParam("TaskId") Long TaskId,@RequestParam("ActualHours") BigDecimal ActualHours,@RequestParam("ActualMinutes") BigDecimal ActualMinutes) {
  	    GeneralResponse res=new GeneralResponse();
  			
      	boolean b=emsTaskService.PauseTask(TaskId, ProjectId,ActualHours,ActualMinutes);
      	if(b) {
  			res.setStatusCode("0");
  			res.setStatusMessage("Success");
  		}
  		else {
  			res.setStatusCode("-1");
  			res.setStatusMessage("Failed To Complete Task");
  		}
        	return new ResponseEntity<>(res, HttpStatus.OK);		

  			//return new ResponseEntity<>(emsTaskService.GetExpertProjects(ExpertID,ProjectId), HttpStatus.OK);		
  	}
    
    @PostMapping("/AddNewTask")
	public ResponseEntity<GeneralResponse> AddNewTask(@RequestParam("ExpertId") Long ExpertID,@RequestBody EmsTask InsertedTask) {
    	
    	EmsExpert tm=emsExpertService.getExpert(ExpertID);
    	InsertedTask.setEmsExpert(tm);
    	//EmsTaskStatusCode tmpS=new EmsTaskStatusCode();
      	//tmpS.setTaskStatusId(1);
      	//InsertedTask.setEmsTaskStatusCode(tmpS);
      	
    	EmsTask tmp=   emsTaskService.AddTask(InsertedTask);
    	
    	    GeneralResponse res=new GeneralResponse();
			if(tmp!=null) {
				res.setStatusCode("0");
				res.setStatusMessage("Success");
			}
			else {
				res.setStatusCode("-1");
				res.setStatusMessage("Failed To Insert New Record");
			}
			return new ResponseEntity<>(res, HttpStatus.OK);		
	}
    
    @PostMapping("/AddNewChildTask")
  	public ResponseEntity<GeneralResponse> AddNewChildTask(
  			@RequestParam("ExpertId") Long ExpertID,@RequestParam("ParentProjectID") Long ParentProjectID,@RequestParam("ParentTaskId") Long ParentTaskId,
  			@RequestBody EmsTask InsertedTask) {
      	
    	EmsTaskPK parentTsk=new EmsTaskPK();
    	parentTsk.setProjectId(ParentProjectID);
    	parentTsk.setTaskId(ParentTaskId);
    	
      	EmsExpert tm=emsExpertService.getExpert(ExpertID);
      	InsertedTask.setEmsExpert(tm);
      	EmsTask par=new EmsTask();
      	par.setId(parentTsk);
      	InsertedTask.setEmsTask(par);
      	System.out.println("Before Add New Child Task");
      	//EmsTaskStatusCode tmpS=new EmsTaskStatusCode();
      	//tmpS.setTaskStatusId(3);
      	//InsertedTask.setEmsTaskStatusCode(tmpS);
      	EmsTask tmp=   emsTaskService.AddTask(InsertedTask);
    
      	    GeneralResponse res=new GeneralResponse();
  			if(tmp!=null) {
  				res.setStatusCode("0");
  				res.setStatusMessage("Success");
  			}
  			else {
  				res.setStatusCode("-1");
  				res.setStatusMessage("Failed To Insert New Record");
  			}
  			return new ResponseEntity<>(res, HttpStatus.OK);		
  	}
      
    
    @PostMapping("/AddNewTaskComment")
  	public ResponseEntity<GeneralResponse> AddNewTask(@RequestBody EmsTaskComment InsertedTaskComment) {
      	
      	boolean tmp=emsTaskCommentService.saveComment(InsertedTaskComment);
     
      	    GeneralResponse res=new GeneralResponse();
  			if(tmp) {
  				res.setStatusCode("0");
  				res.setStatusMessage("Success");
  			}
  			else {
  				res.setStatusCode("-1");
  				res.setStatusMessage("Failed To Insert New Record");
  			}
  			return new ResponseEntity<>(res, HttpStatus.OK);		
  	}
      
    
//    @GetMapping("/getallPendingApprovalTasks")
//	public ResponseEntity<EmsExpert> getallPendingApprovalTasks(@RequestParam("ExpertId") Long ExpertID,
//			@RequestParam("ProjectId") Long ProjectId) {
//		
//			
//			return new ResponseEntity<>(emsExpertService.getExpert(ExpertID), HttpStatus.OK);		
//	}
//    @GetMapping("/getallReadyTasks")
//	public ResponseEntity<EmsExpert> getallReadyTasks(@RequestParam("ExpertId") Long ExpertID
//			,@RequestParam("ProjectId") Long ProjectId) {
//		
//			
//			return new ResponseEntity<>(emsExpertService.getExpert(ExpertID), HttpStatus.OK);		
//	}
//    
//    
    @PostMapping("/UdateExpertMainInfo")
   	public ResponseEntity<EmsExpert> UdateExpertMainInfo(@RequestBody EmsExpert e) throws SerialException, SQLException {
    	  
    	//String Image=e.getImageDecode().split(",")[1];
    	//System.out.println("Image is "+Image);
    	//byte[] encoded = Base64.getEncoder().encode(Image.getBytes());

      //Blob c=  NonContextualLobCreator.INSTANCE.createBlob(encoded);
       //Blob b = new SerialBlob(Image.getBytes());

       //String base64Image = e.getNewPhotoClob();
//   	System.out.println("base 64"+base64Image);
//    	
    	try {
			emsExpertService.UpdateExpertImage(e.getImageDecode().getBytes(),e.getExpertId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//   		
    	return new ResponseEntity<>(emsExpertService.updateExpert(e), HttpStatus.OK);		
   	}
}
