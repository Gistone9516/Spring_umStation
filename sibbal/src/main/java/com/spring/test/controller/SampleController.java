package com.spring.test.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test.domain.ResponseVO;
import com.spring.test.domain.client_testVO;
import com.spring.test.domain.couponVO;
import com.spring.test.domain.rental_logVO;
import com.spring.test.domain.rental_umVO;
import com.spring.test.domain.seqVO;
import com.spring.test.domain.stationVO;
import com.spring.test.domain.userVO;
import com.spring.test.persistence.couponDAO;
import com.spring.test.persistence.rentalDAO;
import com.spring.test.persistence.stationDAO;
import com.spring.test.persistence.userDAO;
import com.spring.test.controller.ControllerAssistance;
import com.spring.test.controller.Serial;


//��Ʈ�ѷ�
@Controller
public class SampleController {
	
	//�α׸� ������
	private static final Logger logger = 
		LoggerFactory.getLogger(SampleController.class);
	@Inject
	private userDAO userdao;
	@Inject
	private rentalDAO rendao;
	@Inject
	private stationDAO statdao;
	@Inject
	private couponDAO coudao; 
	
	Serial ser = new Serial("COM10");

	//private ControllerAssistance ca = new ControllerAssistance(userdao, rendao, statdao);

		
		
		//������� ��� �����͸� ����
			@RequestMapping("doTEST")
			public @ResponseBody ResponseVO dotest(@RequestBody client_testVO ct) {
				System.out.println(ct.station_num + "/" + ct.station_num + "/" + ct.state);
				//sample date ����
				ResponseVO res = new ResponseVO();
				
				res.setall("600");

				logger.info("doC ȣ���");
				
				return res;
			}
			
			@RequestMapping("doMtest")
			public void doMtest() {
				//sample date ����
				doS1O();

				logger.info("doMtest ȣ���");

			}
		
			//������� ��� �����͸� ����
			@RequestMapping("doTT")
			public @ResponseBody userVO doTT(String statUm, String umCode, String user_id) {
				//sample date ����
				ResponseVO res = new ResponseVO();
				userVO u = new userVO();
				u.setuser_id("gaga");
				
				BOR_protocol(statUm, umCode, user_id);
				RE_normal_protocol(statUm, umCode, user_id);
				RE_wrong_protocol(statUm, umCode, user_id);
				RE_Old_protocol(statUm, user_id);
				
				res.setall("601");

				logger.info("doC ȣ���");
				
				return u;
			}

			public void doS1O() {
				String str = "Servo1//";

				int c;
				char[] a = str.toCharArray();
				
				try{
					for(int i = 0; a[i] != 0; i++){
						c = a[i];
						try{ser.out.write(c);}
						catch(IOException io){ io.printStackTrace();}
					}
				}catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}
			}
		
		//������� ��� �����͸� ����
		@RequestMapping("doC")
		public @ResponseBody userVO doJSON() {
			//sample date ����
			ResponseVO res = new ResponseVO();
			userVO u = new userVO();
			u.setuser_id("gaga");
			
			res.setall("603");

			logger.info("doC ȣ���");
			//ser.serialPort.close();
			return u;
		}
		
		//ProductVO�� json ������ ���·� ��ȯ
		@RequestMapping("/doJOIN") //ȸ������. id, name, pw, hp, birth �Է¹���
		public @ResponseBody ResponseVO doJOIN(
				@RequestBody userVO voaa) {
			
			logger.info("doJOIN ȣ���");
			userVO vo = new userVO();
			userVO c_vo = new userVO();
			ResponseVO res = new ResponseVO();
			
			c_vo = userdao.selectID(voaa.getuser_id());
			try{
				if(c_vo.getuser_id().equals("")){} //id�� �������� ���� ��� Null����
				else{ //id�� ������ ��� Id�ߺ� ����
					res.setall("400");
				}
			}catch(NullPointerException e){
				vo.setuser_id(voaa.getuser_id()); //�ߺ��� ���� �ʾƾ� ��
				vo.setuser_name(voaa.getuser_name());
				vo.setuser_pw(voaa.getuser_pw());
				vo.setuser_hp(voaa.getuser_hp());
				Date from = new Date(System.currentTimeMillis());
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String to = transFormat.format(from);
				vo.setuser_birth(to); //�ӽ�
				userdao.insertUser(vo);
				res.setall("200");
			}
			
			System.out.println(res.gettype());
			
			return res;
		}
		
		@RequestMapping("/doLOGIN") //�α���. ID �����Ѱ�? �׷��ٸ� PW�� ��ġ�Ѱ�?
		public @ResponseBody ResponseVO doLOGIN(
				@RequestBody userVO voaa) {
			userVO vo = new userVO();
			ResponseVO res = new ResponseVO();
			logger.info("doLOGIN ȣ���");
			
			vo = userdao.selectID(voaa.getuser_id());
			try{
				if(vo.getuser_id().equals("")){}
				else{
					if(vo.getuser_pw().equals(voaa.getuser_pw())){
						res.setall("201");
					}else{
						res.setall("401");
					}
				}
			}catch(NullPointerException e){res.setall("402");}
			
			System.out.println(res.gettype());
			
			return res;
		}
		
		@RequestMapping("/doIDstate") //�ش� ID �뿩���� //name, date
		public @ResponseBody List<userVO> doIDstate(
				@RequestBody userVO user) {
			
			List<userVO> L_user = new ArrayList<userVO>();
			
			System.out.println(user.getuser_id());
			
			ResponseVO res = new ResponseVO();
			logger.info("doIDstate ȣ���");
			
			L_user.add(userdao.selectIDstate(user.getuser_id()));
			
			System.out.println(L_user.get(0).getuser_name());
			System.out.println(L_user.get(0).getuser_rental());
			
			
			return L_user;
		}
		
		
//		@RequestMapping("/doFIND") //ȸ��ã��
//		public @ResponseBody ResponseVO doFIND(
//				String tag, String id, String name, String pw) { //ã�� ��Ʈ����� �ִٸ� �߰�
//			userVO vo = new userVO();
//			ResponseVO res = new ResponseVO();
//			vo = userdao.selectID(id);
//			
//			try{
//				if(vo.getuser_id().equals("")){} //id ����.
//				else{
//					try{
//						if(vo.getuser_name().equals("")){} //�ش� id, name ���� ����
//						else{res.setall("400", "FIND", "ID Wrong question");}
//						
//					}catch(NullPointerException a){res.setall("200", "FIND", "Success");
//													res.setvalue( vo.getuser_id() + "," + vo.getuser_pw());}
//				}
//			}catch(NullPointerException e){res.setall("400", "FIND", "ID does not exist");}
//
//			return res;
//		}
		
		@RequestMapping("/doSE") //�����̼� ��ȣ�� stationDB�� �����Ѱ�?
		public @ResponseBody ResponseVO doSE(
				@RequestBody stationVO stat) {
			stationVO vo = new stationVO();
			ResponseVO res = new ResponseVO();
			
			vo = statdao.selectStation(stat.getstation_num());
			
			try{  
				if(vo.getstation_num().equals("")){}
				
				else{res.setall("202");}
			}catch(NullPointerException e){res.setall("403");}

			return res;
		}
		
		@RequestMapping("/doStatAll") //
		public @ResponseBody List<stationVO> doStatAll() {
			
			stationVO vo = new stationVO();
			ResponseVO res = new ResponseVO();
			
			List<stationVO> statList = new ArrayList<stationVO>();
	
			try{
				statList = statdao.selectStationAll(vo);
			}catch(Exception e) {System.out.println(e);}

			return statList;
		}
		
		@RequestMapping("/doCoupID") //
		public @ResponseBody List<couponVO> doCoupID(
				@RequestBody couponVO cou) {
			
			ResponseVO res = new ResponseVO();
			
			List<couponVO> couList = new ArrayList<couponVO>();
	
			try{
				couList = coudao.selectCoupon(cou.getuser_id());
			}catch(Exception e) {System.out.println(e);}

			return couList;
		}
		
		
		@RequestMapping("/doRENT") //�뿩 �ý���. 
		public @ResponseBody ResponseVO doBOR(
				@RequestBody seqVO seq) { 
			ResponseVO res = new ResponseVO();
			System.out.println(seq.getstation_num());
			System.out.println(seq.getrental_umCode());
			System.out.println(seq.getstate());
			System.out.println(seq.getuser_id());
			
			if(seq.getstate().equals("rent")){
				switch(BOR_protocol(seq.getstation_num(), seq.getrental_umCode(), seq.getuser_id())){
				case "400": res.setall("405"); break;
				case "401": res.setall("404"); break;
				case "200": res.setall("203"); doS1O(); 
				break;
				}
			}
			else{res.setall("406");}
			
			return res;
		} 
		
		@RequestMapping("/doRE") //�ݳ� �ý���. 
		public @ResponseBody ResponseVO doRe(
				@RequestBody seqVO seq) {
			ResponseVO res = new ResponseVO();
			
			System.out.println(seq.getstation_num());
			System.out.println(seq.getrental_umCode());
			System.out.println(seq.getstate());
			System.out.println(seq.getuser_id());

			if(seq.getstate().equals("normalReturn")){
				switch(RE_normal_protocol(seq.getstation_num(), seq.getrental_umCode(), seq.getuser_id())){
				case "400": res.setall("407"); break;
				case "401": res.setall("404"); break;
				case "200": res.setall("204"); 
				doS1O(); 
				break;
				}
			}
			else if(seq.getstate().equals("wrongReturn")){
				switch(RE_wrong_protocol(seq.getstation_num(), seq.getrental_umCode(), seq.getuser_id())){
				case "400": res.setall("407"); break;
				case "401": res.setall("404"); break;
				case "200": res.setall("205"); 
				doS1O(); 
				break;
				}
			}
			else if(seq.getstate().equals("OldUm")){
				switch(RE_Old_protocol(seq.getstation_num(), seq.getuser_id())){
				case "400": res.setall("407"); break;
				case "401": res.setall("404"); break;
				case "200": res.setall("206"); 
				doS1O(); 
				break;
				}
			}
			else{res.setall("408");}

			return res;
		}
		
		
		
		public String BOR_protocol(String statNum, String umCode, String id){
			userVO user = new userVO();
			stationVO stat = new stationVO();
			rental_umVO um = new rental_umVO();
			
			user = userdao.selectUser(id);
			stat = statdao.selectStation(statNum);
			try{um = rendao.selectUm(umCode);}catch(NullPointerException e){return "401";}
			
			
			//Station DB
			int haveUm = stat.getStation_haveUm(); //�����̼ǿ� ����� �����ϴ��� üũ
			if(haveUm < 1){return "400";}
			stat.setStation_haveUm(--haveUm); //��� �ϳ� ��
			statdao.updateHaveUm(stat); //station DB ������Ʈ
			
			
			//User DB
			user.setuser_id(id); 
			user.setuser_umCode(umCode);
			Date from = new Date(System.currentTimeMillis());
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			String to = transFormat.format(from);
			user.setuser_rental(to);
			userdao.updateUserRental(user);
			
			//rental_um DB
			um.setrental_date(to);
			um.setuser_id(id);
			rendao.updateUm(um);
			
			//rental_log DB
			rendao.insertUmlog(log_Generators(um, id, "BOR"));
			
			return "200";	
		}
		public String RE_normal_protocol(String statNum, String umCode, String id){

			userVO user = new userVO();
			stationVO stat = new stationVO();
			rental_umVO um = new rental_umVO();
		
			user = userdao.selectUser(id);
			stat = statdao.selectStation(statNum);
			try{um = rendao.selectUm(umCode);}catch(NullPointerException e){return "401";}

			//Station DB
			int haveUm = stat.getStation_haveUm(); //�����̼ǿ� ������ �� �ִ��� üũ
			if(haveUm > 9){return "400";}
			stat.setStation_haveUm(++haveUm); //��� �ϳ� ���ϱ�
			statdao.updateHaveUm(stat); //��� DB ������Ʈ
			
			
			//User DB
			user.setuser_id(id); 
			user.setuser_umCode("");
			user.setuser_rental(null);
			userdao.updateUserRental(user);
			
			//rental_um DB
			um.setrental_date(null);
			um.setuser_id("");	
			um.setrental_statCode(statNum);
			rendao.updateUm(um);
			
			//rental_log DB
			rendao.insertUmlog(log_Generators(um, id, "RE_normal"));
				

			return "200";
		}
		
		public String RE_wrong_protocol(String statNum, String umCode, String id){

			userVO user = new userVO();
			stationVO stat = new stationVO();
			rental_umVO um = new rental_umVO();
			
			user = userdao.selectUser(id);
			stat = statdao.selectStation(statNum);
			try{um = rendao.selectUm(umCode);}catch(NullPointerException e){return "401";} 

				//Station DB
				int haveUm = stat.getStation_haveUm(); //�����̼ǿ� ������ �� �ִ��� üũ
				if(haveUm > 9){return "400";}
				stat.setStation_haveUm(++haveUm); //��� �ϳ� ���ϱ�
				statdao.updateHaveUm(stat); //��� DB ������Ʈ
				
				
				//User DB
				user.setuser_id(id); 
				user.setuser_umCode(""); 
				user.setuser_rental(null);
				userdao.updateUserRental(user);
				
				//rental_um DB
				um.setrental_date(null);
				um.setuser_id(""); //���� id�� ������ ��, rental_date�� ������ ������� �� ����
				um.setrental_statCode(statNum);
				rendao.updateUm(um);
				
				//rental_log DB
				rendao.insertUmlog(log_Generators(um, id, "RE_wrong"));
				

			return "200";
		}
		
		public String RE_Old_protocol(String statNum, String id){

			userVO user = new userVO();
			stationVO stat = new stationVO();
			rental_umVO um = new rental_umVO();
			
			
			user = userdao.selectUser(id);
			stat = statdao.selectStation(statNum);
			//um = rendao.selectUm(umCode); 

				//Station DB
				int haveUm = stat.getStation_haveUm(); //�����̼ǿ� ������ �� �ִ��� üũ
				if(haveUm > 9){return "400";}
				stat.setStation_haveUm(++haveUm); //��� �ϳ� ���ϱ�
				statdao.updateHaveUm(stat); //��� DB ������Ʈ
				
				
				//User DB
				user.setuser_id(id); 
				user.setuser_umCode(""); 
				user.setuser_ap((1+user.getuser_ap()));
				user.setuser_lp((1+user.getuser_lp()));
				user.setuser_rental(null);
				userdao.updateUserRental(user);
				
				//rental_um DB
				um.setrental_umCode("");
				//rental_log DB
				rendao.insertUmlog(log_Generators(um, id, "RE_Old"));
				

			return "200";
		}
		
		public rental_logVO log_Generators(rental_umVO um, String id, String state){
			rental_logVO log = new rental_logVO();
			rental_logVO log_i = new rental_logVO();
			
			int num;
			Random random = new Random();
			random.setSeed(System.currentTimeMillis());
			while(true){
				do{
					 num= random.nextInt(1000000);
					}while(num < 100000);
				try{
					log = rendao.selectUmlog(Integer.toString(num));
					if(log.getrental_num().equals("")){}
					else{continue;}
				}catch(NullPointerException e){}
					break;
			}
			
			Date from = new Date(System.currentTimeMillis());
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			String to = transFormat.format(from);
			
			log_i.setrental_num(Integer.toString(num));
			log_i.setrental_umCode(um.getrental_umCode());
			log_i.setuser_id(id);
			log_i.setrental_date(to);
			log_i.setrental_state(state);
			
			return log_i;
		}
		
		



}