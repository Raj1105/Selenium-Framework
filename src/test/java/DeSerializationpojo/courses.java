package DeSerializationpojo;

import java.util.List;

public class courses {
	public List<webAuto> webAutomation;
	public List<webAuto> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAuto> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<api> getApi() {
		return api;
	}
	public void setApi(List<api> api) {
		this.api = api;
	}
	public List<mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobile> mobile) {
		this.mobile = mobile;
	}
	public List<api> api;
	public List<mobile> mobile;

	
}
