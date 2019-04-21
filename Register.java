package mybean.data;

public class Register {

		String usr;
		String passwd;
		String email;
		String phone;
		String backNews;


		public void setUsr(String new_usr) {
        		usr=new_usr;
    	}
    	public void setPasswd(String new_passwd) {
	        	passwd=new_passwd;
    	}
		public void setEmail(String new_email) {
				email=new_email;
		}
		public void setPhone(String new_phone) {
				phone=new_phone;
		}
		public void setBackNews(String new_backNews) {
				backNews=new_backNews;
		}

    	public String getUsr() {
        		return usr;
    	}
    	public String getPasswrd() {
        		return passwd;
    	}
	  	public String getEmail() {
	      		return email;
	  	}
	  	public String getPhone() {
	      		return phone;
	  	}
		public String getBackNews() {
	      		return backNews;
	  	}

}
